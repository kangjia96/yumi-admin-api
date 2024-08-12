package cn.ikangjia.yumi.domain.repository;

import cn.ikangjia.yumi.domain.entity.RoleMenuDO;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/8/12 21:46
 */
public interface RoleMenuRepository {
    void deleteByRoleId(String roleId);

    void deleteByMenuId(String menuId);

    List<RoleMenuDO> getByRoleIdBatch(List<String> roleIdList);

    List<RoleMenuDO> getByMenuId(String menuId);
}
