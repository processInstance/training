package com.css.platcommon.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : lin
 * @date : 15:21 2021/9/5
 */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 693976296278487397L;
    private int code = 0;
    private String msg;
    private T data;

    public Result() {
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, T data) {
        this.msg = msg;
        this.data = data;
    }

    public Result(String msg, T data) {
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> error(int code, String msg, T data) {
        return new Result<>(code, msg, data);
    }

    public static <T> Result<T> error(String msg, T data) {
        return new Result<>(1, msg, data);
    }

    public static <T> Result<T> success(String msg, T data) {
        return new Result<>(0, msg, data);
    }

    public static <T> Result<T> success() {
        return new Result<>(0, "success", null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(0, "success", data);
    }

    public static  Result<Map> success(IPage page) {
        Map hashMap = new HashMap();
        hashMap.put("total", page.getTotal());
        hashMap.put("size", page.getSize());
        hashMap.put("current", page.getCurrent());
        hashMap.put("records", page.getRecords());
        return new Result<Map>(0, "success", hashMap);
    }
}

