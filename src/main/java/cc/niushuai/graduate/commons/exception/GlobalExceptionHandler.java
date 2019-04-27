package cc.niushuai.graduate.commons.exception;


import cc.niushuai.graduate.commons.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author niushuai
 * 统一异常处理
 * @date 2018/12/29
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(MyException.class)
    public ResultUtil handleMyException(HttpServletRequest req, MyException e) {
        ResultUtil result = new ResultUtil();
        result.put("code", e.getCode());
        result.put("msg", e.getMsg());
        result.put("detail", e.getMessage());
        result.put("url", req.getRequestURL().toString());

        return result;
    }
}
