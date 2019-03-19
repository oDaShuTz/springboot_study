package org.springboot_study.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/hello")
    public String hello() throws MyException {
        throw new MyException("我的错误");
    }

    @RequestMapping("/myError")
    public String myError(@ModelAttribute MyException myException, Model model) {
        return "myError";
    }
}
