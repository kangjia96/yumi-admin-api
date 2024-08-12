package cn.ikangjia.yumi.api.vo;

import lombok.Data;

import java.util.Set;

/**
 * 已登录的用户信息
 *
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/8/12 21:06
 */
@Data
public class LoginUserInfoVO {

    private UserVO user;
    private Set<String> roles;
    private Set<String> permissions;
}
