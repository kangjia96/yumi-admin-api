package cn.ikangjia.yumi.domain.repository.impl.impl;

import cn.ikangjia.yumi.domain.entity.RoleMenuDO;
import cn.ikangjia.yumi.domain.mapper.RoleMenuMapper;
import cn.ikangjia.yumi.domain.repository.RoleMenuRepository;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/8/12 21:47
 */
@Repository
public class RoleMenuRepositoryImpl implements RoleMenuRepository {

    private final RoleMenuMapper roleMenuMapper;

    public RoleMenuRepositoryImpl(RoleMenuMapper roleMenuMapper) {
        this.roleMenuMapper = roleMenuMapper;
    }

    @Override
    public void deleteByRoleId(String roleId) {
        QueryWrapper<RoleMenuDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id", roleId);
        roleMenuMapper.delete(queryWrapper);
    }

    @Override
    public void deleteByMenuId(String menuId) {
        QueryWrapper<RoleMenuDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("menu_id", menuId);
        roleMenuMapper.delete(queryWrapper);
    }

    @Override
    public List<RoleMenuDO> getByRoleIdBatch(List<String> roleIdList) {
        QueryWrapper<RoleMenuDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("role_id", roleIdList);
        return roleMenuMapper.selectList(queryWrapper);
    }

    @Override
    public List<RoleMenuDO> getByMenuId(String menuId) {
        QueryWrapper<RoleMenuDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("menu_id", menuId);
        return roleMenuMapper.selectList(queryWrapper);
    }
}
