
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
create table css_plat_v1.plat_user
(
    id           varchar(50)  not null comment '主键uuid'
        primary key,
    user_name    varchar(50)  null comment '用户名称',
    password     varchar(50)  null comment '密码',
    login_name   varchar(50)  null comment '登录名',
    salt         varchar(50)  null comment '密码盐',
    sex          char         null comment '性别',
    nation       char(3)      null comment '民族',
    native_place varchar(50)  null comment '籍贯',
    birthday     date         null comment '生日',
    id_card      varchar(50)  null comment '身份证号',
    telephone    varchar(50)  null comment '联系电话',
    email        varchar(50)  null comment '电子邮箱',
    mobile_phone varchar(50)  null comment '手机',
    status       char         null comment '状态',
    type         char         null comment '类型',
    order_num    int          null comment '序号',
    crt_user     varchar(50)  null comment '创建人id',
    crt_name     varchar(50)  null comment '创建人名字',
    crt_time     datetime     null comment '创建时间',
    upd_user     varchar(50)  null comment '修改人id',
    upd_name     varchar(50)  null comment '修改人名字',
    upd_time     datetime     null comment '修改人时间',
    remark       varchar(255) null comment '备注'
)
    comment '基础用户';


Use css_plat_v1;
drop table if exists plat_group;

/*==============================================================*/
/* Table: plat_group                                            */
/*==============================================================*/
create table plat_group
(
    id                   varchar(50) not null,
    name                 varchar(255),
    type                 char(2),
    parent_id            varchar(50),
    code                 varchar(255),
    short_name           varchar(255),
    order_num            int,
    remark               varchar(255),
    is_del               int,
    path                 varchar(255),
    primary key (id)
);

alter table plat_group comment '组织，包括机构、角色、岗位、自定义分组';

alter table plat_group modify column id varchar(50) comment '主键id';

alter table plat_group modify column name varchar(255) comment '名称';

alter table plat_group modify column type char(2) comment '组织类型';

alter table plat_group modify column parent_id varchar(50) comment '父节点id';

alter table plat_group modify column code varchar(255) comment '组织编码';

alter table plat_group modify column short_name varchar(255) comment '简称';

alter table plat_group modify column order_num int comment '排序号';

alter table plat_group modify column remark varchar(255) comment '备注';

alter table plat_group modify column is_del int comment '删除标记';

alter table plat_group modify column path varchar(255) comment '父节点code路径';
