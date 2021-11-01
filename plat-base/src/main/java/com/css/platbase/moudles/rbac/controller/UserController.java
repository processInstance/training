package com.css.platbase.moudles.rbac.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.css.platbase.moudles.rbac.dto.GroupDTO;
import com.css.platbase.moudles.rbac.dto.UserDTO;
import com.css.platbase.moudles.rbac.entity.User;
import com.css.platbase.moudles.rbac.service.UserService;
import com.css.platcommon.controller.BaseController;
import com.css.platcommon.controller.DTOController;
import com.css.platcommon.controller.Result;
import com.css.platcommon.utils.QueryUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController extends DTOController<UserService, UserDTO> {

    @Override
    public Result add(@RequestBody UserDTO dto) {
        this.baseBiz.addUser(dto);
        return Result.success();
    }

    @Override
    public Result update(@RequestBody UserDTO dto) {
        //user本身信息，更新即可。。
        //dept信息，查一下，对比是否一致
        this.baseBiz.updUser(dto);
        return Result.success();
    }
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam int size,int current,String orderProp,boolean orderAsc,String userName,String loginName,String parentId ){
        IPage<UserDTO> pageResult ;
        Page page= QueryUtil.getPage(size, current, null, false);
        QueryWrapper<UserDTO> queryWrapper= new QueryWrapper<UserDTO>();
        if(StringUtils.isNotEmpty(userName)){
            queryWrapper.like("a.user_name", userName);
        }
        if(StringUtils.isNotEmpty(loginName)){
            queryWrapper.like("a.login_name", loginName);
        }
//        if(StringUtils.isNotEmpty(parentId)){
//            queryWrapper.eq("platgroup.id", parentId);
//        }
        queryWrapper.eq("a.is_del",0 );
        pageResult= baseBiz.selectPageDto(page, queryWrapper,parentId,orderProp,orderAsc);

        return Result.success(pageResult);
    }
    @Override
    public Result get(@PathVariable String id) {

        return Result.success(baseBiz.getUserDTO(id));

    }
}
