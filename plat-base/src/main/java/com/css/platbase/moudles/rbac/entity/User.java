package com.css.platbase.moudles.rbac.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 基础用户
 * @TableName plat_user
 */
@TableName(value ="plat_user")
@Data
public class User implements Serializable {
	/**
	 * 主键uuid
	 */
	@TableId(type=IdType.ASSIGN_UUID)
	private String id;

	/**
	 * 用户名称
	 */
	private String userName;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 登录名
	 */
	private String loginName;

	/**
	 * 密码盐
	 */
	private String salt;

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

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		User other = (User) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
				&& (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
				&& (this.getLoginName() == null ? other.getLoginName() == null : this.getLoginName().equals(other.getLoginName()))
				&& (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(other.getSalt()))
				&& (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
				&& (this.getNation() == null ? other.getNation() == null : this.getNation().equals(other.getNation()))
				&& (this.getNativePlace() == null ? other.getNativePlace() == null : this.getNativePlace().equals(other.getNativePlace()))
				&& (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
				&& (this.getIdCard() == null ? other.getIdCard() == null : this.getIdCard().equals(other.getIdCard()))
				&& (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()))
				&& (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
				&& (this.getMobilePhone() == null ? other.getMobilePhone() == null : this.getMobilePhone().equals(other.getMobilePhone()))
				&& (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
				&& (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
				&& (this.getOrderNum() == null ? other.getOrderNum() == null : this.getOrderNum().equals(other.getOrderNum()))
				&& (this.getCrtUser() == null ? other.getCrtUser() == null : this.getCrtUser().equals(other.getCrtUser()))
				&& (this.getCrtName() == null ? other.getCrtName() == null : this.getCrtName().equals(other.getCrtName()))
				&& (this.getCrtTime() == null ? other.getCrtTime() == null : this.getCrtTime().equals(other.getCrtTime()))
				&& (this.getUpdUser() == null ? other.getUpdUser() == null : this.getUpdUser().equals(other.getUpdUser()))
				&& (this.getUpdName() == null ? other.getUpdName() == null : this.getUpdName().equals(other.getUpdName()))
				&& (this.getUpdTime() == null ? other.getUpdTime() == null : this.getUpdTime().equals(other.getUpdTime()))
				&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
		result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
		result = prime * result + ((getLoginName() == null) ? 0 : getLoginName().hashCode());
		result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
		result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
		result = prime * result + ((getNation() == null) ? 0 : getNation().hashCode());
		result = prime * result + ((getNativePlace() == null) ? 0 : getNativePlace().hashCode());
		result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
		result = prime * result + ((getIdCard() == null) ? 0 : getIdCard().hashCode());
		result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
		result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
		result = prime * result + ((getMobilePhone() == null) ? 0 : getMobilePhone().hashCode());
		result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
		result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
		result = prime * result + ((getOrderNum() == null) ? 0 : getOrderNum().hashCode());
		result = prime * result + ((getCrtUser() == null) ? 0 : getCrtUser().hashCode());
		result = prime * result + ((getCrtName() == null) ? 0 : getCrtName().hashCode());
		result = prime * result + ((getCrtTime() == null) ? 0 : getCrtTime().hashCode());
		result = prime * result + ((getUpdUser() == null) ? 0 : getUpdUser().hashCode());
		result = prime * result + ((getUpdName() == null) ? 0 : getUpdName().hashCode());
		result = prime * result + ((getUpdTime() == null) ? 0 : getUpdTime().hashCode());
		result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", userName=").append(userName);
		sb.append(", password=").append(password);
		sb.append(", loginName=").append(loginName);
		sb.append(", salt=").append(salt);
		sb.append(", sex=").append(sex);
		sb.append(", nation=").append(nation);
		sb.append(", nativePlace=").append(nativePlace);
		sb.append(", birthday=").append(birthday);
		sb.append(", idCard=").append(idCard);
		sb.append(", telephone=").append(telephone);
		sb.append(", email=").append(email);
		sb.append(", mobilePhone=").append(mobilePhone);
		sb.append(", status=").append(status);
		sb.append(", type=").append(type);
		sb.append(", orderNum=").append(orderNum);
		sb.append(", crtUser=").append(crtUser);
		sb.append(", crtName=").append(crtName);
		sb.append(", crtTime=").append(crtTime);
		sb.append(", updUser=").append(updUser);
		sb.append(", updName=").append(updName);
		sb.append(", updTime=").append(updTime);
		sb.append(", remark=").append(remark);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
