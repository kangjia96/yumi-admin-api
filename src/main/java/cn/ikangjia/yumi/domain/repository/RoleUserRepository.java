package cn.ikangjia.yumi.domain.repository;

import cn.ikangjia.yumi.domain.entity.RoleUserDO;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/8/12 21:38
 */
public interface RoleUserRepository {
    void deleteByRoleId(String roleId);

    void deleteByUserId(String userId);

    List<RoleUserDO> getByUserId(String userId);

    List<RoleUserDO> getByRoleId(String roleId);
}
