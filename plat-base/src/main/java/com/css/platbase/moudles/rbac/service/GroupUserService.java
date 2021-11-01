package com.css.platbase.moudles.rbac.service;

import com.css.platbase.moudles.rbac.entity.Group;
import com.css.platbase.moudles.rbac.entity.GroupUser;
import com.css.platcommon.service.BaseService;

import java.util.List;

/**
 * @author : lin
 * @date : 11:02 2021/10/26
 */
public interface GroupUserService   extends BaseService<GroupUser> {
    void bindUsers(String groupId, List<String> userIds);
}
