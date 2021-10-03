package com.css.trainmember.rpc;

import org.apache.catalina.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : lin
 * @date : 0:48 2021/8/18
 */
@FeignClient("plat-base")
public interface DemoFeignService {
    @RequestMapping("/base/getUser")
    public String demoGetUser();


    // 可以使用GetMapping组合注解,以前是不能使用的
    @GetMapping(value = "/get/{id}")
    // @PathVariable必须指定value,否则异常:PathVariable annotation was empty on param 0.
    public String get(@PathVariable("id") String id);

    @RequestMapping(value = "/getuser/{id}")
    public User getUser(@PathVariable("id") String id);

    // 调用远程的post方法,如果参数为复杂对象,就算指定了method=RequestMethod.GET,依然会使用post方式请求
    // 远程的方法是get的时候就会失败，错误消息: status 405 reading FeignTestClient#getUser2(User); content:{"timestamp":1511326531240,"status":405,"error":"Method Not Allowed","exception":"org.springframework.web.HttpRequestMethodNotSupportedException","message":"Request method 'POST' not supported","path":"/getuser2"}
    @RequestMapping(value = "/getuser2", method = RequestMethod.GET)
    public User getUser2(User user);

    // 调用远程的post方法,可以使用@RequestBody
    @RequestMapping(value = "/postuser")
    public User postUser(@RequestBody User user);

    // 调用远程的post方法,可以不使用@RequestBody
    @RequestMapping(value = "/postuser")
    public User postUser2(User user);

    // 调用远程的post方法,如果参数为复杂对象,就算指定了method=RequestMethod.GET,依然会使用post方式请求
    // 远程的方法也是post的，所以可以调用成功
    @RequestMapping(value = "/postuser", method = RequestMethod.GET)
    public User postUser3(User user);

    @GetMapping(value = "/listAll")
    List<User> listAll();
}
