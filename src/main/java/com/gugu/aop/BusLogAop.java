package com.gugu.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.gugu.annotation.BusLog;
import com.gugu.dao.BusLogDao;
import com.gugu.model.BusLogBean;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
@Aspect
@Slf4j
public class BusLogAop implements Ordered {


    @Autowired
    private BusLogDao busLogDao;

    /**
     * 定义BusLogAop的切入点为标记@BusLog注解的方法
     */
    @Pointcut(value = "@annotation(com.gugu.annotation.BusLog)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        log.info("----BusAop 环绕通知 start");
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        //目标方法执行完成后，获取目标类、目标方法上的业务日志注解上的功能名称和功能描述
        Object target = proceedingJoinPoint.getTarget();
        Object[] args = proceedingJoinPoint.getArgs();
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        BusLog anno1 = target.getClass().getAnnotation(BusLog.class);
        BusLog anno2 = signature.getMethod().getAnnotation(BusLog.class);

        BusLogBean busLogBean = new BusLogBean();
        String logName = anno1.name();
        String logDescribe = anno2.describe();
        busLogBean.setBusName(logName);
        busLogBean.setBusDescribe(logDescribe);
        busLogBean.setOperPerson("fanfu");
        busLogBean.setOperTime(new Date());
        JsonMapper jsonMapper = new JsonMapper();
        String json = null;
        try {
            json = jsonMapper.writeValueAsString(args);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //把参数报文写入到文件中
        OutputStream outputStream = null;
        try {
            String paramFilePath = System.getProperty("user.dir") + File.separator + "111111.log";
            outputStream = new FileOutputStream(paramFilePath);
            outputStream.write(json.getBytes(StandardCharsets.UTF_8));
            busLogBean.setParamFile(paramFilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
//保存业务操作日志信息
        busLogDao.insert(busLogBean);
        log.info("----BusAop 环绕通知 end");
        return result;

    }

    @Override
    public int getOrder() {
        return 1;
    }
}
