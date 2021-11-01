
CREATE DATABASE css_plat_v1 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
Use css_plat_v1;
/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : ag_admin_v1

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 02/05/2019 21:40:27 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- -----
drop table if exists plat_user;

/*==============================================================*/
/* Table: plat_user                                             */
/*==============================================================*/
create table plat_user
(
    id                   varchar(50) not null comment '主键uuid',
    user_name            varchar(50),
    password             varchar(50),
    login_name           varchar(50),
    salt                 varchar(50),
    sex                  char(1),
    nation               char(3),
    native_place         varchar(50),
    birthday             date,
    id_card              varchar(50),
    telephone            varchar(50),
    email                varchar(50),
    mobile_phone         varchar(50),
    status               char(1),
    type                 char(1),
    order_num            int,
    crt_user             varchar(50),
    crt_name             varchar(50),
    crt_time             datetime,
    upd_user             varchar(50),
    upd_name             varchar(50),
    upd_time             datetime,
    remark               varchar(255),
    is_del               int default 0,
    primary key (id)
);

alter table plat_user comment '基础用户';

alter table plat_user modify column id varchar(50) comment '主键uuid';

alter table plat_user modify column user_name varchar(50) comment '用户名称';

alter table plat_user modify column password varchar(50) comment '密码';

alter table plat_user modify column login_name varchar(50) comment '登录名';

alter table plat_user modify column salt varchar(50) comment '密码盐';

alter table plat_user modify column sex char(1) comment '性别';

alter table plat_user modify column nation char(3) comment '民族';

alter table plat_user modify column native_place varchar(50) comment '籍贯';

alter table plat_user modify column birthday date comment '生日';

alter table plat_user modify column id_card varchar(50) comment '身份证号';

alter table plat_user modify column telephone varchar(50) comment '联系电话';

alter table plat_user modify column email varchar(50) comment '电子邮箱';

alter table plat_user modify column mobile_phone varchar(50) comment '手机';

alter table plat_user modify column status char(1) comment '状态';

alter table plat_user modify column type char(1) comment '类型';

alter table plat_user modify column order_num int comment '序号';

alter table plat_user modify column crt_user varchar(50) comment '创建人id';

alter table plat_user modify column crt_name varchar(50) comment '创建人名字';

alter table plat_user modify column crt_time datetime comment '创建时间';

alter table plat_user modify column upd_user varchar(50) comment '修改人id';

alter table plat_user modify column upd_name varchar(50) comment '修改人名字';

alter table plat_user modify column upd_time datetime comment '修改人时间';

alter table plat_user modify column remark varchar(255) comment '备注';

alter table plat_user modify column is_del int comment '删除标记';


Use css_plat_v1;

/*==============================================================*/
/* Table: plat_group                                            */
/*==============================================================*/
create table if not exists css_plat_v1.plat_group
(
    id varchar(50) not null comment '主键id'
        primary key,
    name varchar(255) null comment '名称',
    type char(2) null comment '组织类型',
    parent_id varchar(50) null comment '父节点id',
    code varchar(255) null comment '组织编码',
    short_name varchar(255) null comment '简称',
    order_num int null comment '排序号',
    remark varchar(255) null comment '备注',
    is_del int null comment '删除标记',
    path varchar(255) null comment '父节点code路径'
)
    comment '组织，包括机构、角色、岗位、自定义分组';
