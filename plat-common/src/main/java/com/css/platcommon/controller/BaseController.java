package com.css.platcommon.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
/**
 * @author : lin
 * @date : 20:32 2021/8/31
 */
public class BaseController<Biz extends IService,Entity> {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected Biz baseBiz;

    @RequestMapping(value = "",method = RequestMethod.POST)
    @ResponseBody
    public Result add(@RequestBody Entity entity){
        baseBiz.save(entity);
      //  return new ObjectRestResponse<Entity>();
        return Result.success();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Result get(@PathVariable String id){

        Object o = baseBiz.getById(id);
        return Result.success(o);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@RequestBody Entity entity){
        baseBiz.updateById(entity);
        return Result.success();
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Result remove(@PathVariable String id){
        baseBiz.removeById(id);
        return Result.success();
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ResponseBody
    public Result all(){
        return Result.success(baseBiz.list());
    }
   // todo page查询
//    @RequestMapping(value = "/page",method = RequestMethod.GET)
//    @ResponseBody
//    public TableResultResponse<Entity> list(@RequestParam Map<String, Object> params){
//        //查询列表数据
//        Query query = new Query(params);
//        return baseBiz.selectByQuery(query);
//        IPage<Entity> page(IPage<Entity> page, Wrapper<Entity> queryWrapper);
//    }
    //todo:baseController获取用户信息
//    public String getCurrentUserName(){
//        return BaseContextHandler.getUsername();
//    }
}
