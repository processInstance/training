package com.css.platbase.moudles.rbac.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : lin
 * @date : 10:23 2021/10/26
 */
@TableName(value ="plat_group_user")
@Data
public class GroupUser implements Serializable {
    /**
     * 主键id
     */
    @TableId(type= IdType.ASSIGN_UUID)
    private String id;
    private String groupId;
    private String userId;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    public GroupUser(String id ,String groupId,String userId){};

    public GroupUser(String groupId, String userId) {
        this.groupId = groupId;
        this.userId = userId;
    }
}
