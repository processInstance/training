package com.css.platbase.moudles.rbac.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.css.platbase.moudles.rbac.dto.GroupDTO;
import com.css.platbase.moudles.rbac.dto.UserDTO;
import com.css.platbase.moudles.rbac.entity.Group;
import com.css.platbase.moudles.rbac.entity.GroupUser;
import com.css.platbase.moudles.rbac.service.GroupService;
import com.css.platbase.moudles.rbac.service.GroupUserService;
import com.css.platbase.moudles.rbac.service.UserService;
import com.css.platbase.moudles.rbac.vo.GroupUserVO;
import com.css.platcommon.controller.DTOController;
import com.css.platcommon.controller.Result;
import com.css.platcommon.utils.QueryUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("group")
public class GroupController extends DTOController<GroupService, GroupDTO> {
    @Autowired
    protected UserService userService;
    @Autowired
    protected GroupUserService groupUserService;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam int size, int current, String orderProp, boolean orderAsc, String name, String parentId, String type) {
        IPage<GroupDTO> pageResult;
        Page page = QueryUtil.getPage(size, current, orderProp, orderAsc);
        QueryWrapper<GroupDTO> queryWrapper = new QueryWrapper<GroupDTO>();
        if (StringUtils.isNotEmpty(name)) {
            queryWrapper.like("a.name", name);
        }
        if (StringUtils.isNotEmpty(parentId)) {
            queryWrapper.eq("a.parent_id", parentId);
        }
        if (StringUtils.isNotEmpty(type)) {
            queryWrapper.eq("a.type", type);
        }
        pageResult = baseBiz.selectPageDto(page, queryWrapper);
        return Result.success(pageResult);
    }

    @GetMapping(value = "/tree")
    @ResponseBody
    public Result tree(@RequestParam(required = false, defaultValue = "0") String nodeId, String type) {
        QueryWrapper<Group> queryWrapper = new QueryWrapper<Group>();
        queryWrapper.eq("parent_id", nodeId);
        if (StringUtils.isNotEmpty(type)) {
            queryWrapper.eq("type", type);
        }
        List<Group> lists = baseBiz.list(queryWrapper);
        return Result.success(lists);

    }

    public Result get(@PathVariable String id) {
        GroupDTO groupDTO = baseBiz.getDTOById(id);
        return Result.success(groupDTO);

    }

    /**
     * ??????????????????????????????????????????????????????
     *
     * @return
     */
    @GetMapping(value = "/tree/search")
    @ResponseBody
    public Result treeSearch(@RequestParam String nodeName) {
        //??????name?????????????????????
        //?????????????????????path
        //???????????????code????????????
        //????????????code????????????????????????

        List<Group> nodeList = baseBiz.list(new QueryWrapper<Group>().like("name", nodeName));
        Set<String> codeSet = new HashSet<String>();
        for (Group group : nodeList) {

            String path = group.getPath();
            List<String> pathCodes = Arrays.asList(path.split("/"));
            codeSet.addAll(pathCodes);
        }
        //todo ??????????????????
        List<Group> lists = this.baseBiz.treeSearch(codeSet);
        return Result.success(lists);

    }

    /**
     * ??????geoupId??????????????????????????????????????????
     */
    @GetMapping(value = "/tree/includedUser")
    @ResponseBody
    public Result getChildAndRelativeUser(@RequestParam(required = false, defaultValue = "0") String nodeId, String type) {
        QueryWrapper<Group> queryWrapper = new QueryWrapper<Group>();
        queryWrapper.eq("parent_id", nodeId);
        if (StringUtils.isNotEmpty(type)) {
            queryWrapper.eq("type", type);
        }
        List<Group> lists = baseBiz.list(queryWrapper);
        List<UserDTO> userDTOList = userService.listUserByGroupId(nodeId);
        HashMap map = new HashMap();
        map.put("users", userDTOList);
        map.put("groups", lists);
        return Result.success(map);

    }
    /**
     * ???????????????????????????????????????
     */
    @GetMapping(value = "/serachUserAndGroup")
    @ResponseBody
    public Result serachUserAndGroup(@RequestParam String keyword) {

        QueryWrapper<GroupDTO> queryWrapper = new QueryWrapper<GroupDTO>();
        queryWrapper.like("a.name", keyword);
        List<GroupDTO> lists = baseBiz.selectPageDto(queryWrapper);
        List<UserDTO> userDTOList = userService.listUserDTO(new QueryWrapper<UserDTO>().like("a.user_name",keyword));
        HashMap map = new HashMap();
        map.put("users", userDTOList);
        map.put("groups", lists);
        return Result.success(map);

    }
    /**
     * ??????geoupId?????????????????????
     */
    @GetMapping(value = "/user")
    @ResponseBody
    public Result getRelativeUser(@RequestParam(required = false, defaultValue = "0") String nodeId) {

        List<UserDTO> userDTOList = userService.listUserByGroupId(nodeId);

        return Result.success(userDTOList);

    }

    /**
     * ?????????????????????
     * 1,??????????????????????????????
     * 2?????????????????????
     */
    @RequestMapping(value = "/bindUser", method = RequestMethod.POST)
    @ResponseBody
    public Result bindUser(@RequestBody GroupUserVO groupUserVO) {
        groupUserService.bindUsers(groupUserVO.getGroupId(), groupUserVO.getUserIds());
        return Result.success();
    }
}
