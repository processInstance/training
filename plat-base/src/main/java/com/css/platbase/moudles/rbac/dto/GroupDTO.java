package com.css.platbase.moudles.rbac.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.css.platbase.moudles.rbac.entity.Group;
import com.css.platcommon.dto.BaseDTO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @author : lin
 * @date : 15:20 2021/9/7
 */
@Data
public class GroupDTO implements BaseDTO<Group> {
    /**
     * 主键id
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 组织类型
     * 1 部门
     * 2 角色
     * 3 岗位
     * 4 群组
     */
    private String type;

    /**
     * 父节点id
     */
    private Group parent;

    /**
     * 组织编码
     */
    private String code;

    /**
     * 简称
     */
    private String shortName;

    /**
     * 排序号
     */
    private Integer orderNum;

    /**
     * 备注
     */
    private String remark;

    /**
     * 父节点code路径
     */
    private String path;
    @Override
    public Group convert() {
        Group group=new Group();
        BeanUtils.copyProperties(this,group);
        group.setParentId(this.parent.getId());
        return group;
    }
}
