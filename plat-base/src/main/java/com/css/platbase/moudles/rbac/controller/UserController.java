package com.css.platbase.moudles.rbac.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.css.platbase.moudles.rbac.entity.User;
import com.css.platbase.moudles.rbac.service.UserService;
import com.css.platcommon.controller.BaseController;
import com.css.platcommon.controller.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController extends BaseController<UserService, User> {

    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params){
        IPage<User> page = baseBiz.queryPage(params);

        return Result.success(page);
    }
}
