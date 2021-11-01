package com.css.platbase.moudles.rbac.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.css.platbase.moudles.rbac.entity.Group;
import com.css.platbase.moudles.rbac.entity.GroupUser;
import com.css.platbase.moudles.rbac.entity.User;
import com.css.platcommon.dto.BaseDTO;
import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : lin
 * @date : 11:14 2021/10/25
 */
@Data
public class UserDTO implements BaseDTO<User> {
    /**
     * 主键uuid
     */
    private String id;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 性别
     */
    private String sex;

    /**
     * 民族
     */
    private String nation;

    /**
     * 籍贯
     */
    private String nativePlace;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 手机
     */
    private String mobilePhone;

    /**
     * 状态
     */
    private String status;

    /**
     * 类型
     */
    private String type;

    /**
     * 序号
     */
    private Integer orderNum;

    /**
     * 创建人id
     */
    private String crtUser;

    /**
     * 创建人名字
     */
    private String crtName;

    /**
     * 创建时间
     */
    private Date crtTime;

    /**
     * 修改人id
     */
    private String updUser;

    /**
     * 修改人名字
     */
    private String updName;

    /**
     * 修改人时间
     */
    private Date updTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 部门
     *
     */
    private List<GroupDTO> departments;
    /**
     * 角色
     */
    private List<GroupDTO> roles;
    /**
     * 岗位
     */
    private List<GroupDTO> posts;
    /**
     * 自定义群组
     */
    private List<GroupDTO> customGroups;

    @Override
    public User convert() {
        User user=new User();
        BeanUtils.copyProperties(this,user);

        return user;
    }


}
