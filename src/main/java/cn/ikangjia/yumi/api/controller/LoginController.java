package cn.ikangjia.yumi.api.controller;

import cn.ikangjia.yumi.api.ResultVO;
import cn.ikangjia.yumi.api.dto.LoginDTO;
import cn.ikangjia.yumi.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/8/9 下午10:04
 */
@RestController
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
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
}
