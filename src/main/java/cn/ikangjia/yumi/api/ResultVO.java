package cn.ikangjia.yumi.api;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/8/9 下午10:06
 */
@Data
public class ResultVO<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private T data;
    private int code;
    private String msg;

    public static final int SUCCESS = 0;
    public static final int ERROR = -1;

    public ResultVO() {}

    public ResultVO(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResultVO<T> success(T data) {
        return new ResultVO<>(SUCCESS, "", data);
    }

    public static <T> ResultVO<T> success() {
        return success(null);
    }

    public static <T> ResultVO<T> error(String msg) {
        return new ResultVO<>(-1, msg, null);
    }

    public static <T> ResultVO<T> error(int code, String msg) {
        return new ResultVO<>(code, msg, null);
    }
}
