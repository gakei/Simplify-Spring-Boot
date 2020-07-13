package com.qcby.web.mvc;

import java.lang.annotation.*;

//映射注解，添加在方法上
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequestMapping {
    String value();
}
