package org.springboot_study.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(value = MyException.class)
    public String myErrorHandler(RedirectAttributesModelMap modelMap, MyException myException){
        modelMap.addFlashAttribute("myException",myException);
        return "redirect:/myError";
    }
}
