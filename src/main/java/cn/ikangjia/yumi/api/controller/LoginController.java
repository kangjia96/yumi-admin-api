package cn.ikangjia.yumi.api.controller;

import cn.ikangjia.yumi.api.ResultVO;
import cn.ikangjia.yumi.api.dto.LoginDTO;
import cn.ikangjia.yumi.api.vo.LoginUserInfoVO;
import cn.ikangjia.yumi.api.vo.route.MenuVO;
import cn.ikangjia.yumi.domain.entity.MenuDO;
import cn.ikangjia.yumi.service.MenuService;
import cn.ikangjia.yumi.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/8/9 下午10:04
 */
@RestController
public class LoginController {
    private final UserService userService;
    private final MenuService menuService;

    public LoginController(UserService userService, MenuService menuService) {
        this.userService = userService;
        this.menuService = menuService;
    }

    @PostMapping("/login")
    public ResultVO<String> login(@RequestBody LoginDTO loginDTO) {
        return ResultVO.success(userService.login(loginDTO));
    }

    @PostMapping("/logout")
    public Boolean logout() {
        return true;
    }

    @GetMapping("/validCode")
    public String getValidCode() {
        return "1234";
    }

    @GetMapping("/global/info")
    public ResultVO<LoginUserInfoVO> getInfo() {
        return ResultVO.success(new LoginUserInfoVO());
    }

    @GetMapping("/global/routes")
    public ResultVO<List<MenuVO>> getAllRoutes() {
        // TODO 获取当前登录用户所有路由
        return ResultVO.success(menuService.getAllMenus());
    }
}
