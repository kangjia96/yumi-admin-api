package cn.ikangjia.yumi.service.impl;

import cn.ikangjia.yumi.api.vo.route.MenuVO;
import cn.ikangjia.yumi.domain.entity.MenuDO;
import cn.ikangjia.yumi.domain.entity.RoleMenuDO;
import cn.ikangjia.yumi.domain.entity.RoleUserDO;
import cn.ikangjia.yumi.domain.mapper.MenuMapper;
import cn.ikangjia.yumi.domain.repository.RoleMenuRepository;
import cn.ikangjia.yumi.domain.repository.RoleUserRepository;
import cn.ikangjia.yumi.service.MenuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static cn.ikangjia.yumi.utils.TreeUtil.buildMenuTree;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/8/12 21:11
 */
@Slf4j
@Service
public class MenuServiceImpl implements MenuService {

    private final MenuMapper menuMapper;
    private final RoleMenuRepository roleMenuRepository;
    private final RoleUserRepository roleUserRepository;

    public MenuServiceImpl(MenuMapper menuMapper, RoleMenuRepository roleMenuRepository, RoleUserRepository roleUserRepository) {
        this.menuMapper = menuMapper;
        this.roleMenuRepository = roleMenuRepository;
        this.roleUserRepository = roleUserRepository;
    }


    @Override
    public List<MenuVO> getAllMenus() {
        QueryWrapper<MenuDO> wrapper = new QueryWrapper<>();
        String userId = "1";
        wrapper.eq("status", 0);
        wrapper.orderByAsc(List.of("parent_id", "order_num"));

        List<MenuDO> menuList;
        // 超级管理员直接获取所有菜单
        if ("1".equals(userId)) {
            menuList = menuMapper.selectList(wrapper);
        } else {
            // 用户 id 获取角色 id，角色 id 获取菜单 id
            List<String> roleIdList = roleUserRepository.getByUserId(userId)
                    .stream()
                    .map(RoleUserDO::getRoleId)
                    .toList();

            List<String> menuIdList = roleMenuRepository.getByRoleIdBatch(roleIdList)
                    .stream()
                    .map(RoleMenuDO::getMenuId)
                    .distinct()
                    .toList();

            wrapper.in("id", menuIdList);

            menuList = menuMapper.selectList(wrapper);
        }
        return buildMenuTree(menuList, "0");
    }
}
