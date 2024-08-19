-- 一级菜单
insert into sys_menu
values ('01', '0', '首页', 1, 1, 'Dashboard', '/dashboard', 'Layout', null, '', '', 0, 1, 1, sysdate(), null);
insert into sys_menu
values ('02', '0', '审计', 2, 2, 'Audit', '/audit', 'Layout', null, '', '', 0, 1, 1, sysdate(), null);
insert into sys_menu
values ('03', '0', '系统管理', 2, 3, 'System', '/system', 'Layout', null, '', '', 0, 1, 1, sysdate(), null);
-- 二级菜单
insert into sys_menu
values ('100', '02', '操作日志', 1, 1, 'OpLog', '/audit/op-log', 'audit/op-log/index', '', 'audit:op-log:list', '', 0,
        0, 0, sysdate(), null);
insert into sys_menu
values ('201', '03', '用户管理', 1, 1, 'User', '/system/user', 'system/user/index', '', 'system:user:list', '', 0, 1, 1,
        sysdate(), null);
insert into sys_menu
values ('202', '03', '角色管理', 1, 2, 'Role', '/system/role', 'system/user/index', '', 'system:role:list', '', 0, 1, 1,
        sysdate(), null);
insert into sys_menu
values ('203', '03', '菜单管理', 1, 3, 'Menu', '/system/menu', 'system/user/index', '', 'system:menu:list', '', 0, 1, 1,
        sysdate(), null);
insert into sys_menu
values ('204', '03', '二级菜单', 2, 3, 'Level-2', '/system/level', 'ParentView', '', '', '', 0, 1, 1, sysdate(), null);

-- 三级菜单
insert into sys_menu
values ('1000', '204', '三级菜单1', 1, 2, 'Level-l', '/system/level/level2', 'system/level/level2/index', '',
        'system:level:level2:list', '', 0, 1, 1, sysdate(), null);
insert into sys_menu
values ('1001', '204', '三级菜单2', 1, 1, 'Level-ll', '/system/level/level1', 'system/user/level1/index', '',
        'system:level:level1:list', '', 0, 1, 1, sysdate(), null);


-- 用户管理按钮
insert into sys_menu
values ('10000', '201', '用户查询', 4, 1, '', '', '', '', 'system:user:query', '', 0, 1, 1, sysdate(), null);
insert into sys_menu
values ('10001', '201', '用户新增', 4, 2, '', '', '', '', 'system:user:add', '', 0, 1, 1, sysdate(), null);
insert into sys_menu
values ('10002', '201', '用户修改', 4, 3, '', '', '', '', 'system:user:edit', '', 0, 1, 1, sysdate(), null);
insert into sys_menu
values ('10003', '201', '用户删除', 4, 4, '', '', '', '', 'system:user:remove', '', 0, 1, 1, sysdate(), null);
insert into sys_menu
values ('10004', '201', '用户导出', 4, 5, '', '', '', '', 'system:user:export', '', 0, 1, 1, sysdate(), null);
insert into sys_menu
values ('10005', '201', '重置密码', 4, 6, '', '', '', '', 'system:user:resetPwd', '', 0, 1, 1, sysdate(), null);
