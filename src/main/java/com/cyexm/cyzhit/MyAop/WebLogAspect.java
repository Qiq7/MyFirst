package com.cyexm.cyzhit.MyAop;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Component
@Aspect
public class WebLogAspect {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * com.cyexm.cyzhit.Controller.*.*(..))")
    public void WebLog() {}

    @Before("WebLog()")
    public void doBefore(JoinPoint joinPoint)
    {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("URL："+request.getRequestURI().toString());
        logger.info("Http_Method："+request.getMethod());
        logger.info("Ip："+request.getRemoteAddr());
        Enumeration<String> enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements())
        {
            String name = (String) enumeration.nextElement();
            logger.info("name:{},value:{}", name, request.getParameter(name));
        }
    }

    @AfterReturning(returning = "ret", pointcut = "WebLog()")
    public void doAfter(Object ret)
    {
        logger.info("RESPONSE : " + ret);
    }
}
