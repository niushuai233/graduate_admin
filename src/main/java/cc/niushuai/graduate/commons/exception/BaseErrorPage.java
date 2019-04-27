package cc.niushuai.graduate.commons.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Author: niushuai
 * @Email: niushuai951101@gmail.com
 * @Description:
 * @Date: 2018/1/6 14:46
 */
@Slf4j
//@Controller
@RequestMapping("/error")
public class BaseErrorPage  implements ErrorController {


    @Override
    public String getErrorPath() {
        log.info("进入自定义错误页面");
        return "/errorpage/404";
    }

    @RequestMapping
    public String error() {
        return getErrorPath();
    }
}