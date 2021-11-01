package com.css.platbase.moudles.rbac.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.css.platbase.moudles.rbac.dto.GroupDTO;
import com.css.platbase.moudles.rbac.dto.UserDTO;
import com.css.platbase.moudles.rbac.entity.User;
import com.css.platcommon.service.BaseService;

import java.util.List;

/**
 * @author : lin
 * @date : 21:20 2021/8/31
 */
public interface UserService extends BaseService<User> {
boolean addUser(UserDTO userDTO);
    boolean updUser(UserDTO userDTO);
    UserDTO getUserDTO(String id);
    List<UserDTO> listUserDTO(Wrapper<UserDTO> queryWrapper);

    IPage<UserDTO> selectPageDto(Page<?> page, Wrapper<UserDTO> queryWrapper,String groupId, String orderProp,Boolean orderAsc);
    List<UserDTO> listUserByGroupId(String groupId);


}
