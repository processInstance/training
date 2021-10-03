package com.css.platcommon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.css.platcommon.service.BaseService;
import com.css.platcommon.utils.Query;

import java.util.Map;

/**
 * @author : lin
 * @date : 17:57 2021/9/5
 */
public class BaseServiceImp<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {
    @Override
    public IPage<T> queryPage(Map<String, Object> params) {
        IPage<T> page = this.page(
                new Query<T>().getPage(params),
                new QueryWrapper<T>()
        );

        return page;
    }
}
