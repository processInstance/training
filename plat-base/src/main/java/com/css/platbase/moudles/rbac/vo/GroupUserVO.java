package com.css.platbase.moudles.rbac.vo;

import lombok.Data;

import java.util.List;

/**
 * @author : lin
 * @date : 20:21 2021/10/28
 */
@Data
public class GroupUserVO {
    private String groupId;
    private List<String> userIds;
}
