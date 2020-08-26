package com.ypk.common.config;

import com.ypk.common.annnotation.CmfzLogAnnotation;
import com.ypk.entity.CmfzAdmin;
import com.ypk.entity.CmfzLog;
import com.ypk.mapper.CmfzLogMapper;
import com.ypk.common.util.IPKit;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Configuration
@Aspect
public class LogAspect {
    @Autowired
    private CmfzLogMapper cmfzLogMapper;

    @After("@annotation(com.ypk.common.annnotation.CmfzLogAnnotation)")
    public void logAfter(JoinPoint joinPoint){
        CmfzLog cmfzLog=new CmfzLog();
        cmfzLog.setLogDate(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String request1 = IPKit.getIpAddrByRequest(request);
        cmfzLog.setLogIp(request1);
        CmfzAdmin admin = (CmfzAdmin) request.getSession().getAttribute("admin");
        if (admin == null){
            cmfzLog.setUsername("yangyy");
        }else {
            cmfzLog.setUsername(admin.getUsername());
        }
        //获取注解信息
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        CmfzLogAnnotation annotation = signature.getMethod().getAnnotation(CmfzLogAnnotation.class);
        cmfzLog.setLogContent(annotation.content());
        cmfzLog.setLogType(annotation.type());
        System.out.println(cmfzLog);
        cmfzLogMapper.insert(cmfzLog);
    }
}
