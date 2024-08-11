package cn.ikangjia.yumi.service.impl;

import cn.ikangjia.yumi.api.dto.LoginDTO;
import cn.ikangjia.yumi.domain.entity.UserDO;
import cn.ikangjia.yumi.domain.mapper.UserMapper;
import cn.ikangjia.yumi.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/8/9 下午11:46
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    public final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public String login(LoginDTO loginDTO) {

        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        String validCode = loginDTO.getValidCode();

        if (!"1234".equals(validCode)){
            throw new RuntimeException("验证码错误");
        }

        QueryWrapper<UserDO> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username)
                .eq("status", 0);

        List<UserDO> userDOList = userMapper.selectList(wrapper);
        if (userDOList.isEmpty()) {
            throw new RuntimeException("用户不存在");
        }
        if (userDOList.size() > 1) {
            throw new RuntimeException("用户名重复，内部错误，请联系管理员");
        }
        UserDO userDO = userDOList.getFirst();
        if (!userDO.getPassword().equals(password)) {
            throw new RuntimeException("密码错误");
        }
        log.debug("登录成功[{}]", userDO);
        return "token123";
    }
}
