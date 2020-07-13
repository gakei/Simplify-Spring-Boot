package com.qcby.controller;

import com.qcby.beans.Autowired;
import com.qcby.beans.User;
import com.qcby.web.mvc.Controller;
import com.qcby.web.mvc.RequestMapping;
import com.qcby.web.mvc.RequestParam;
import com.qcby.web.mvc.ResponseBody;

/**
 * @author kevinlyz
 * @ClassName UserController
 * @Description 测试请求
 * @Date 2019-06-08 17:14
 **/
@Controller
@ResponseBody
public class UserController {

    @Autowired
    private User user;

    @RequestMapping("/test")
    public User test(@RequestParam("name") String name, @RequestParam("desc") String desc) {
        System.out.println("/test被访问了");
        user.setAge(1);
        user.setName("WHJ");
        return user;
    }
}

