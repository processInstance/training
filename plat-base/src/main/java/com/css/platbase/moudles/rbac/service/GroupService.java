package com.css.platbase.moudles.rbac.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.css.platbase.moudles.rbac.dto.GroupDTO;
import com.css.platbase.moudles.rbac.entity.Group;
import com.css.platbase.moudles.rbac.entity.User;
import com.css.platcommon.service.BaseService;

import java.util.List;
import java.util.Set;

/**
 * @author : lin
 * @date : 21:20 2021/8/31
 */
public interface GroupService extends BaseService<Group> {
    List<Group> treeSearch(Set<String> codeList);
    GroupDTO getDTOById(String id);
    IPage<GroupDTO> selectPageDto(Page<?> page, Wrapper<GroupDTO> queryWrapper);
    List<GroupDTO> selectPageDto(Wrapper<GroupDTO> queryWrapper);
}
