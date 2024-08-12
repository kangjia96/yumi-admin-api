package cn.ikangjia.yumi.utils;

import cn.ikangjia.yumi.api.vo.route.MenuVO;
import cn.ikangjia.yumi.api.vo.route.Meta;
import cn.ikangjia.yumi.domain.entity.MenuDO;
import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.configurationprocessor.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/8/12 22:01
 */
public class TreeUtil {

    public static List<MenuVO> buildSubMenu(List<MenuDO> menuList, String id) {
        return getMenuVOS(menuList, id);
    }

    private static List<MenuVO> getMenuVOS(List<MenuDO> menuList, String id) {
        List<MenuDO> subMenus = menuList.stream()
                .filter(menu -> menu.getParentId().equals(id))
                .toList();

        List<MenuVO> subMenuVOs = new ArrayList<>();
        for (MenuDO menu : subMenus) {
            MenuVO vo = convertToMenuVO(menu);
            vo.setChildren(buildSubMenu(menuList, menu.getId()));
            subMenuVOs.add(vo);
        }

        return subMenuVOs;
    }

    public static List<MenuVO> buildMenuTree(List<MenuDO> menuList, String parentId) {
        // 从原始列表中筛选出所有父 ID等于给定父 ID 的项
        return getMenuVOS(menuList, parentId);
    }

    // 转换 MenuDO 到 MenuVO
    private static MenuVO convertToMenuVO(MenuDO menu) {
        // 假设 MenuVO 和 MenuDO 的字段一致，直接进行转换

        MenuVO menuVO = new MenuVO();
        menuVO.setName(menu.getName());
        menuVO.setPath(menu.getRoutePath());
        menuVO.setComponent(menu.getComponent());
        menuVO.setVisible(menu.getVisible());

        Meta meta = new Meta();
        meta.setTitle(menu.getName());
        meta.setIcon(menu.getIcon());
        meta.setKeepAlive(menu.getKeepAlive());
        meta.setLink(menu.getPerm());

        menuVO.setMeta(meta);

        return menuVO;
    }

}
