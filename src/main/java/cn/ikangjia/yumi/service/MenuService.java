package cn.ikangjia.yumi.service;

import cn.ikangjia.yumi.api.vo.route.MenuVO;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/8/12 21:11
 */
public interface MenuService {
    List<MenuVO> getAllMenus();
}
