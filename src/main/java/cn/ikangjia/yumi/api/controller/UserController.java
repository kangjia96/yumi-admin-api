package cn.ikangjia.yumi.api.controller;

import cn.ikangjia.yumi.api.vo.UserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/8/9 下午10:00
 */
@RestController
@RequestMapping("/system/user")
public class UserController {


    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") String id) {
        return "id:" + id;
    }

    @GetMapping
    public List<UserVO> getUserList() {
        return Arrays.asList(new UserVO(), new UserVO());
    }
}
