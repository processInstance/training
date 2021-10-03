package com.css.platcommon.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * @author : lin
 * @date : 9:59 2021/9/1
 */
public interface BaseService<T> extends IService<T> {
    IPage<T> queryPage(Map<String, Object> params);
}
