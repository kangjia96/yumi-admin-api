package cn.ikangjia.yumi.api.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/8/9 下午11:17
 */
@Data
public class UserVO {
    private String id;
    private String username;
    private String password;

    private String nickname;
    private String avatar;
    private Integer gender;
    private String email;
    private String phone;
    private String desc;

    private Integer status;

    private Boolean admin;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
