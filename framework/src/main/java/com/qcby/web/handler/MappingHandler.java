package com.qcby.web.handler;

import com.alibaba.fastjson.JSON;
import com.qcby.beans.BeanFactory;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MappingHandler {
    private String uri;
    private Method method;
    private Class<?> controller;
    private String[] args;
    private boolean isResponseBody;

    public MappingHandler(String uri,
                          Method method,
                          Class<?> controller,
                          String[] args, boolean isResponseBody) {
        this.uri = uri;
        this.method = method;
        this.controller = controller;
        this.args = args;
        this.isResponseBody = isResponseBody;
    }

    public boolean handler(ServletRequest req, ServletResponse res) throws IllegalAccessException, InstantiationException, InvocationTargetException, IOException {
        String reqURI = ((HttpServletRequest) (req)).getRequestURI();
        if(!this.uri.equals(reqURI))
            return false;

        //相等则调用Handler的resolveMappingHandler方法，实例化并返回
        Object[] parameters = new Object[args.length];
        for(int i = 0; i < args.length; i++) {
            parameters[i] = req.getParameter(args[i]);
        }

        Object ctl = BeanFactory.getBean(controller);
        Object response = method.invoke(ctl, parameters);
        if(isResponseBody) {
            String obj = JSON.toJSONString(response); //序列化
            res.getWriter().println(obj);
        } else {
            res.getWriter().println(response);
        }
        return true;
    }
}
