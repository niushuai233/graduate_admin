package cc.niushuai.graduate.config.log;

import java.lang.annotation.*;

/**
 * 系统日志注解
 *
 * @author niushuai
 * @date 2018年3月8日 上午10:19:56
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    String value() default "";
}
