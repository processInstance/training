package com.css.platbase.moudles.rbac.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.css.platbase.moudles.rbac.dto.GroupDTO;
import com.css.platbase.moudles.rbac.entity.Group;
import com.css.platbase.moudles.rbac.mapper.GroupMapper;
import com.css.platbase.moudles.rbac.service.GroupService;
import com.css.platcommon.service.impl.BaseServiceImp;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author : lin
 * @date : 21:21 2021/8/31
 */
@Service
public class GroupServiceImpl extends BaseServiceImp<GroupMapper, Group> implements GroupService {

   public List<Group> treeSearch(Set<String> codeList){
        return this.baseMapper.treeSearch(codeList);
    }
   public GroupDTO getDTOById(String id){
       return this.baseMapper.getDTOById(id); }

    @Override
    public IPage<GroupDTO> selectPageDto(Page<?> page, Wrapper<GroupDTO> queryWrapper) {
        return  this.baseMapper.selectPageDto(page,queryWrapper);
    }
}
