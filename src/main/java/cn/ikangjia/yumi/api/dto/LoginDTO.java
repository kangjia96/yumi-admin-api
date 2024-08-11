package cn.ikangjia.yumi.api.dto;

import lombok.Data;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/8/9 下午11:12
 */
@Data
public class LoginDTO {
    private String username;
    private String password;
    private String validCode;
}
