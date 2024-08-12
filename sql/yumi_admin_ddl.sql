create table if not exists audit_log
(
    id             char(32)                 not null comment '日志主键'
        primary key,
    title          varchar(50)   default '' null comment '模块标题',
    business_type  int           default 0  null comment '业务类型（0其它 1新增 2修改 3删除）',
    method         varchar(200)  default '' null comment '方法名称',
    request_method varchar(10)   default '' null comment '请求方式',
    op_type        int           default 0  null comment '操作类别（0其它 1后台用户 2手机端用户）',
    op_user        varchar(50)   default '' null comment '操作人员',
    op_url         varchar(255)  default '' null comment '请求URL',
    browser        varchar(100)             null comment '浏览器',
    os             varchar(100)             null comment '操作系统',
    op_ip          varchar(128)  default '' null comment '主机地址',
    op_location    varchar(255)  default '' null comment '操作地点',
    op_params      varchar(2000) default '' null comment '请求参数',
    json_result    varchar(2000) default '' null comment '返回参数',
    status         int           default 1  null comment '操作状态（1正常 0异常）',
    error_msg      varchar(2000) default '' null comment '错误消息',
    op_time        datetime                 null comment '操作时间',
    cost_time      bigint        default 0  null comment '消耗时间',
    create_time    datetime                 null comment '创建时间',
    update_time    datetime                 null comment '更新时间'
);

create table if not exists sys_menu
(
    id          char(32)                 not null comment '菜单 ID'
        primary key,
    parent_id   char(32)     default '0' null comment '父菜单 ID',
    name        varchar(50)              not null comment '菜单名称',
    menu_type   tinyint(1)               null comment '菜单类型（1-菜单 2-目录 3-外链 4-按钮）',
    `order_num` int          default 0   null comment '显示顺序',
    route_name  varchar(50)  default ''  null comment '路由名称',
    route_path  varchar(200) default ''  null comment '路由地址',
    component   varchar(255)             null comment '组件路径',
    icon        varchar(100) default '#' null comment '菜单图标',
    perm        varchar(100)             null comment '权限标识',
    params      text                     null comment '路由参数',
    keep_alive  int          default 1   null comment '是否缓存（1缓存 0不缓存）',
    visible     tinyint(1)   default 1   null comment '菜单状态（1显示 0隐藏）',
    status      tinyint(1)   default 1   null comment '菜单状态（1正常 0停用）',
    create_time datetime                 null comment '创建时间',
    update_time datetime                 null comment '更新时间'
);

create table if not exists sys_role
(
    id          char(32)     not null
        primary key,
    name        varchar(20)  not null comment '角色名',
    code        varchar(20)  not null comment '角色编码',
    `desc`      varchar(200) null comment '描述',
    status      tinyint      null comment '状态，1启用 0禁用',
    create_time datetime     null,
    update_time datetime     null
);

create table if not exists sys_role_menu
(
    id          char(32) not null
        primary key,
    role_id     char(32) not null comment '角色 ID',
    menu_id     char(32) not null comment '菜单 ID',
    create_time datetime null comment '创建时间',
    update_time datetime null comment '更新时间'
);

create table if not exists sys_role_user
(
    id          char(32) not null
        primary key,
    user_id     char(32) not null comment '用户 ID',
    role_id     char(32) not null comment '角色 ID',
    create_time datetime null comment '创建时间',
    update_time datetime null comment '更新时间'
);

create table if not exists sys_user
(
    id          char(32)     not null
        primary key,
    username    varchar(20)  not null comment '用户名',
    password    varchar(200) not null,
    nickname    varchar(20)  null comment '昵称',
    email       varchar(50)  null,
    phone       char(11)     null,
    gender      int          null comment '性别，0男 1女 2未知',
    avatar      varchar(200) null comment '头像地址',
    remark      varchar(200) null comment '描述',
    status      tinyint      null comment '状态，0启用 1禁用',
    create_time datetime     null,
    update_time datetime     null
);

