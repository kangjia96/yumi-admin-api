package cn.ikangjia.yumi.service;

import cn.ikangjia.yumi.api.dto.LoginDTO;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/8/9 下午11:46
 */
public interface UserService {

    /**
     * 登录
     *
     * @param loginDTO 登录信息
     * @return token
     */
    String login(LoginDTO loginDTO);
}
