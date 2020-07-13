package com.qcby.web.mvc;

import java.lang.annotation.*;

//参数注解，添加在方法参数上
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface RequestParam {
    String value();
}
