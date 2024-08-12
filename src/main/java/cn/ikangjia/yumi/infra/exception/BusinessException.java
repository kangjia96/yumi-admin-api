package cn.ikangjia.yumi.infra.exception;

import cn.ikangjia.yumi.api.ErrorCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/8/12 下午3:04
 */
@Getter
@Setter
public class BusinessException extends RuntimeException{
    private ErrorCode errorCode;
    private Object[] params;

    public BusinessException(ErrorCode errorCode, Object... params) {
        super(errorCode.getMsg());
        this.errorCode = errorCode;
        this.params = params;
    }
}
