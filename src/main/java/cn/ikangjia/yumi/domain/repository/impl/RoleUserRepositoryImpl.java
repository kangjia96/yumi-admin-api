package cn.ikangjia.yumi.domain.repository.impl;

import cn.ikangjia.yumi.domain.entity.RoleUserDO;
import cn.ikangjia.yumi.domain.mapper.RoleUserMapper;
import cn.ikangjia.yumi.domain.repository.RoleUserRepository;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/8/12 21:40
 */
@Repository
public class RoleUserRepositoryImpl implements RoleUserRepository {

    private final RoleUserMapper roleUserMapper;

    public RoleUserRepositoryImpl(RoleUserMapper roleUserMapper) {
        this.roleUserMapper = roleUserMapper;
    }

    @Override
    public void deleteByRoleId(String roleId) {
        QueryWrapper<RoleUserDO> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id", roleId);
        roleUserMapper.delete(wrapper);
    }

    @Override
    public void deleteByUserId(String userId) {
        QueryWrapper<RoleUserDO> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        roleUserMapper.delete(wrapper);
    }

    @Override
    public List<RoleUserDO> getByUserId(String userId) {
        QueryWrapper<RoleUserDO> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        return roleUserMapper.selectList(wrapper);
    }

    @Override
    public List<RoleUserDO> getByRoleId(String roleId) {
        QueryWrapper<RoleUserDO> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id", roleId);
        return roleUserMapper.selectList(wrapper);
    }
}
