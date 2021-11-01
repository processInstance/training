package com.css.platbase.moudles.rbac.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.css.platbase.moudles.rbac.dto.GroupDTO;
import com.css.platbase.moudles.rbac.entity.Group;
import com.css.platbase.moudles.rbac.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * 基础用户
 *
 * @author yuehua
 * @version 2021-08-31 13:45:07
 */
public interface GroupMapper extends BaseMapper<Group> {
    List<Group> treeSearch(Set<String> codeList);

    GroupDTO getDTOById(String id);
    IPage<GroupDTO> selectPageDto(Page<?> page, @Param(Constants.WRAPPER)Wrapper<GroupDTO> queryWrapper);
    List<GroupDTO> selectPageDto(@Param(Constants.WRAPPER)Wrapper<GroupDTO> queryWrapper);
}
