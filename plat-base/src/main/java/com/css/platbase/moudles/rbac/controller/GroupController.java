package com.css.platbase.moudles.rbac.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.css.platbase.moudles.rbac.dto.GroupDTO;
import com.css.platbase.moudles.rbac.entity.Group;
import com.css.platbase.moudles.rbac.entity.User;
import com.css.platbase.moudles.rbac.service.GroupService;
import com.css.platbase.moudles.rbac.service.UserService;
import com.css.platcommon.controller.BaseController;
import com.css.platcommon.controller.DTOController;
import com.css.platcommon.controller.Result;
import com.css.platcommon.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("group")
public class GroupController extends DTOController<GroupService, GroupDTO> {

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        IPage<GroupDTO> page = baseBiz.selectPageDto(new Query<GroupDTO>().getPage(params),
                new QueryWrapper<GroupDTO>());

        return Result.success(page);
    }

    @GetMapping(value = "/tree")
    @ResponseBody
    public Result tree(@RequestParam(required = false, defaultValue = "0") String nodeId) {
        List<Group> lists = baseBiz.list(new QueryWrapper<Group>().eq("parent_id", nodeId));
        return Result.success(lists);

    }

    public Result get(@PathVariable String id) {
        GroupDTO groupDTO = baseBiz.getDTOById(id);
        return Result.success(groupDTO);

    }

    /**
     * 树查询，返回相关节点及其所有上级路径
     *
     * @return
     */
    @GetMapping(value = "/tree/search")
    @ResponseBody
    public Result treeSearch(@RequestParam String nodeName) {
        //查询name相关的所有节点
        //取出所有节点的path
        //取出所有的code，并去重
        //查询所有code对应节点的子节点

        List<Group> nodeList = baseBiz.list(new QueryWrapper<Group>().like("name", nodeName));
        Set<String> codeSet = new HashSet<String>();
        for (Group group : nodeList) {

            String path = group.getPath();
            List<String> pathCodes = Arrays.asList(path.split("/"));
            codeSet.addAll(pathCodes);
        }
        //todo 多了一个空格
        List<Group> lists = this.baseBiz.treeSearch(codeSet);
        return Result.success(lists);

    }
}
