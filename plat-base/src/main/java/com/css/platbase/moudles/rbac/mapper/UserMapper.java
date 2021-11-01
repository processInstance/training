package com.css.platbase.moudles.rbac.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.css.platbase.moudles.rbac.dto.GroupDTO;
import com.css.platbase.moudles.rbac.dto.UserDTO;
import com.css.platbase.moudles.rbac.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 基础用户
 *
 * @author yuehua
 * @version 2021-08-31 13:45:07
 */
public interface UserMapper extends BaseMapper<User> {

    List<UserDTO> selectPageDto(@Param(Constants.WRAPPER) Wrapper<UserDTO> queryWrapper);
    IPage<User> selectPageUser(Page<?> page, @Param(Constants.WRAPPER) Wrapper<UserDTO> queryWrapper,@Param("groupId")String groupId);
    List<UserDTO> listUserByGroupId( @Param(Constants.WRAPPER) Wrapper<UserDTO> queryWrapper,@Param("groupId")String groupId);
}
