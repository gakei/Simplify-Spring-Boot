package com.qcby.starter;

import com.qcby.beans.BeanFactory;
import com.qcby.core.ClassScanner;
import com.qcby.web.handler.HandlerManager;
import com.qcby.web.server.TomcatServer;
import org.apache.catalina.LifecycleException;

import java.util.List;

//框架入口类
public class MiniApplication {
    public static void run(Class<?> cls,String[] args){
        System.out.println("Hello mini-spring application！");
        TomcatServer tomcatServer = new TomcatServer(args);
        try {
            tomcatServer.startServer();
            List<Class<?>> classList = ClassScanner.scanClasses(cls.getPackage().getName());
            BeanFactory.initBean(classList);
            classList.forEach(it-> System.out.println(it.getName()));
            HandlerManager.resolveMappingHandler(classList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}