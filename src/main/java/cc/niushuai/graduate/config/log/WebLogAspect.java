package cc.niushuai.graduate.config.log;

import cc.niushuai.graduate.commons.utils.ShiroUtils;
import cc.niushuai.graduate.entity.admin.SysLog;
import cc.niushuai.graduate.service.SysLogService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * @author niushuai
 * @date 2018/12/28
 */
@Slf4j
@Aspect
@Component
@Order(5)
public class WebLogAspect {

    @Autowired
    private SysLogService logService;

    @Pointcut("execution(public * cc.niushuai.graduate.controller..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        StringBuffer requestURL = request.getRequestURL();
        log.debug("URL : \t\t\t" + requestURL.toString());
        String method = request.getMethod();
        log.debug("Http_Method :  " + method);
        String remoteAddr = request.getRemoteAddr();
        log.debug("IP : \t\t\t" + remoteAddr);
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "()";
        log.debug("Class_Method : " + classMethod);
        Object[] pointArgs = joinPoint.getArgs();
        log.debug("Args : \t\t" + Arrays.toString(pointArgs));
        //获取方法日志注解
        String value = getControllerMethodDescription(joinPoint);
        log.debug("Log : \t\t\t" + value);

        if (!StringUtils.isEmpty(value)) {
            SysLog sysLog = new SysLog();
            sysLog.setCreateDate(new Date());
            sysLog.setIp(remoteAddr);
            sysLog.setMethod(classMethod);
            sysLog.setOperation(value);
            //请求的参数
            Object[] args = joinPoint.getArgs();
            String params = JSON.toJSONString(args[0]);
            sysLog.setParams(params);
            sysLog.setUsername(ShiroUtils.getUserName());
            logService.save(sysLog);
        }

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("RESPONSE : \t" + JSONObject.toJSONString(ret));

    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     * @author niushuai
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    Annotation annotation = method.getAnnotation(Log.class);
                    if (annotation != null) {
                        description = method.getAnnotation(Log.class).value();
                    }
                    break;
                }
            }
        }
        return description;
    }


}