package cn.ikangjia.yumi.api;

import lombok.Getter;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/8/9 下午10:10
 */
@Getter
public enum UserEnum {
    USER_NOT_EXIST(10001, "用户不存在"),
    USER_PASSWORD_ERROR(10002, "用户密码错误"),
    USER_NOT_LOGIN(10003, "用户未登录"),
    USER_NOT_AUTH(10004, "用户未授权"),
    USER_NOT_PERMISSION(10005, "用户没有权限"),
    USER_NOT_ROLE(10006, "用户没有角色"),
    USER_NOT_ROLE_PERMISSION(10007, "用户没有角色权限"),
    ;

    private final int code;
    private final String msg;

    UserEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
