package com.qcby;

import com.qcby.starter.MiniApplication;

/**
 * @author kevinlyz
 * @ClassName Application
 * @Description TODO
 * @Date 2019-06-04 19:02
 **/
public class Application {
    public static void main(String[] args) {
        //测试打印
        System.out.println("Hello World!");
        //启动方法
        MiniApplication.run(Application.class,args);
    }
}
