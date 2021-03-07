package com.example.demo.controller;


import com.example.demo.annotation.LoginAnno;
import com.example.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ControllerUse {


//    利用modelAndView定向到指定的html文件中
//    @GetMapping("/UserController/{id}") //获取路径值
//    public ModelAndView hello(@PathVariable("id") long id){
//        User user=new User();
//        user.setAge(19);
//        user.setName("niuyiq");
//        user.setId(id);
//        ModelAndView modelAndView=new ModelAndView("userTest");
//        modelAndView.addObject("user",user);
//        return modelAndView;
//    }

    @GetMapping("/test")
    public String showForm(User user){
        return "form";
    }

    @GetMapping("/results")
    public String results(){
        return "results";
    }

    @PostMapping("/test")
    public String checkUser(@Valid User user, BindingResult bindingResult, RedirectAttributes attr){
        if (bindingResult.hasErrors()){
            return "form";
        }
        attr.addFlashAttribute("user",user);
        return "results";
    }





}
