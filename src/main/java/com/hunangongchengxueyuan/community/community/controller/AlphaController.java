package com.hunangongchengxueyuan.community.community.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/alpha")
public class AlphaController {
    @RequestMapping("hello")
    @ResponseBody
    public  String sayHello(){
        return  "Hello Spring Boot!";
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        //获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name+": "+value);
        }
        System.out.println(request.getParameter("code"));

        //返回响应数据
        response.setContentType("text/html; charset=utf-8");
        try (
            PrintWriter writer = response.getWriter();
        ) {
             writer.write("<h1>牛客网</h1>");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Get(){

    }
    @RequestMapping(path = "/student",method = RequestMethod.POST)
    @ResponseBody
    public String SaveStudent(String name, int age){
        System.out.println(name);
        System.out.println(age);
        return  "Successfully!";
    }

    //响应HTML数据
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name" ,"zhangshan");
        mav.addObject("age",30);
        mav.setViewName("/demo/view");
        return  mav;
    }

    @RequestMapping(path = "/school" , method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name", "湖南工程学院");
        model.addAttribute("age",70);
        return  "/demo/view";
    }

    //响应JSON数据（异步请求）
    //java对象 --> json字符串 --> js对象
    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    @ResponseBody
    public  Map<String, Object> getEmp(){
        Map<String,Object> emp = new HashMap<>() ;
        emp.put("name","湖南工程学院");
        emp.put("age",70);
        return  emp;
    }
}
