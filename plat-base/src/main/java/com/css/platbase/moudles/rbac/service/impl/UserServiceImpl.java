package com.css.platbase.moudles.rbac.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.css.platbase.moudles.rbac.dto.GroupDTO;
import com.css.platbase.moudles.rbac.dto.UserDTO;
import com.css.platbase.moudles.rbac.entity.GroupUser;
import com.css.platbase.moudles.rbac.entity.User;
import com.css.platbase.moudles.rbac.mapper.UserMapper;
import com.css.platbase.moudles.rbac.service.GroupUserService;
import com.css.platbase.moudles.rbac.service.UserService;
import com.css.platcommon.controller.Result;
import com.css.platcommon.service.impl.BaseServiceImp;
import com.css.platcommon.utils.CommonUtils;
import com.css.platcommon.utils.QueryUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author : lin
 * @date : 21:21 2021/8/31
 */
@Service
public class UserServiceImpl extends BaseServiceImp<UserMapper, User> implements UserService {
    @Autowired
    protected GroupUserService groupUserService;

    @Override
    @Transactional
    public boolean addUser(UserDTO userDTO) {
        String userId = UUID.randomUUID().toString().replace("-", "");
        List<GroupUser> groupUserList = getGroupUser(userDTO.getDepartments(), userId);
        groupUserService.saveBatch(groupUserList);
        User user = userDTO.convert();
        user.setId(userId);
        super.save(user);
        return true;
    }

    @Override
    @Transactional
    public boolean updUser(UserDTO userDTO) {
        //更新user本身
        //查询父级部门
        this.baseMapper.updateById(userDTO.convert());
        //删除原部门关联
        groupUserService.remove(new QueryWrapper<GroupUser>().eq("user_id", userDTO.getId()));
        //增加新的关联
        List<GroupDTO> newDepartments = userDTO.getDepartments();
        List<GroupUser> groupUserList = getGroupUser(newDepartments, userDTO.getId());
        groupUserService.saveBatch(groupUserList);

        return true;
    }

    @Override
    public UserDTO getUserDTO(String id) {

        List<UserDTO> userDTOList = this.baseMapper.selectPageDto(new QueryWrapper<UserDTO>().eq("a.id", id));
        return userDTOList.get(0);
    }

    @Override
    public List<UserDTO> listUserDTO(Wrapper<UserDTO> queryWrapper) {
        List<UserDTO> userDTOList = this.baseMapper.selectPageDto(queryWrapper);
        return userDTOList;


    }

    @Override
    public IPage<UserDTO> selectPageDto(Page<?> page, Wrapper<UserDTO> queryWrapper, String groupId, String orderProp, Boolean orderAsc) {

        //查出符合条件的user
        IPage<User> users = this.baseMapper.selectPageUser(page, queryWrapper, groupId);
        IPage<UserDTO> userDTOIPage = new Page<UserDTO>();
        userDTOIPage.setTotal(users.getTotal());
        userDTOIPage.setCurrent(users.getCurrent());
        userDTOIPage.setSize(users.getSize());
        if (users.getRecords().size() < 1) {
            userDTOIPage.setRecords(null);
            return userDTOIPage;
        }
        //
        List<String> userIds = users.getRecords().stream().map(user -> user.getId()).collect(Collectors.toList());

        QueryWrapper<UserDTO> userDTOQueryWrapper = new QueryWrapper<UserDTO>();

        userDTOQueryWrapper.in("a.id", userIds);
        if (StringUtils.isNotEmpty(orderProp))
            userDTOQueryWrapper.orderBy(true, orderAsc, "a." + CommonUtils.humpToLine(orderProp));
        List<UserDTO> userDTOList = this.baseMapper.selectPageDto(userDTOQueryWrapper);

        userDTOIPage.setRecords(userDTOList);
        return userDTOIPage;
    }

    @Override
    public List<UserDTO> listUserByGroupId(String groupId) {
        return this.baseMapper.listUserByGroupId(new QueryWrapper<>(), groupId);
    }

    private List<GroupUser> getGroupUser(List<GroupDTO> dtoList, String userId) {
        List<GroupUser> groupUserList = new ArrayList<GroupUser>();
        for (GroupDTO groupDTO : dtoList) {
            groupUserList.add(new GroupUser(groupDTO.getId(), userId));
        }
        return groupUserList;
    }
}
