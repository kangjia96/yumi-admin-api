package cn.ikangjia.yumi.infra.exception;

import cn.ikangjia.yumi.api.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/8/12 下午3:03
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理业务异常
     *
     * @param e 异常
     * @return 结果
     */
    @ExceptionHandler(BusinessException.class)
    public ResultVO<?> handleBusinessException(BusinessException e) {
        log.error("业务异常:{}", e.getMessage());
        return ResultVO.error(e.getErrorCode(), e.getParams());
    }

    /**
     * 兜底的系统异常
     *
     * @param e 异常
     * @return 结果
     */
    @ExceptionHandler(Exception.class)
    public ResultVO<?> handleException(Exception e) {
        log.error("系统异常:{}", e.getMessage());
        return ResultVO.error(e.getMessage());
    }
}
