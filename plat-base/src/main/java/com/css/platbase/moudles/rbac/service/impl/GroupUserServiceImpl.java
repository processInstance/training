package com.css.platbase.moudles.rbac.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.css.platbase.moudles.rbac.dto.GroupDTO;
import com.css.platbase.moudles.rbac.entity.GroupUser;
import com.css.platbase.moudles.rbac.mapper.GroupUserMapper;
import com.css.platbase.moudles.rbac.service.GroupUserService;
import com.css.platcommon.service.impl.BaseServiceImp;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : lin
 * @date : 11:03 2021/10/26
 */
@Service
public class GroupUserServiceImpl extends BaseServiceImp<GroupUserMapper, GroupUser> implements GroupUserService {

    @Override
    @Transactional
    public void bindUsers(String groupId, List<String> userIds) {
        /**
         * 获取旧关系
         * 对比得到要删的和要加的
         */
        List<GroupUser> oldGroupUserList = super.list(new QueryWrapper<GroupUser>().eq("group_id", groupId));
        List<GroupUser> delList = oldGroupUserList.stream().filter(groupUser -> {
            if (userIds.contains(groupUser.getUserId())) {
                userIds.remove(groupUser.getUserId());
                return false;
            } else
                return true;
        }).collect(Collectors.toList());

        super.removeByIds(delList);
        super.saveBatch(getGroupUser(userIds, groupId));
    }

    private List<GroupUser> getGroupUser(List<String> userIds, String groupId) {
        List<GroupUser> groupUserList = new ArrayList<GroupUser>();
        for (String userId : userIds) {
            groupUserList.add(new GroupUser(groupId, userId));
        }
        return groupUserList;
    }
}
