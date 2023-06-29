package com.lj.controller;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class QuickController {

    public QuickController(){
        System.out.println("QuickController construct");
    }
    
    @RequestMapping("/originOb")
    public String originObj(HttpServletRequest request, HttpServletResponse response){
        System.out.println("request object: " + request);
        System.out.println("response object: " + response);
        return "index.jsp";
    }

    @RequestMapping("/show")
    public String show(){
        System.out.println("show running...");
        return "index.jsp";
    }

    @PostMapping("/postTest")
    public void postTest(@RequestBody String body){
        System.out.println(body);
    }

    @PostMapping("file")
    public String file(@RequestBody MultipartFile file){
        System.out.println(file);
        File localFile = new File("/home/monan/code/mine/java_study/spring_study/mvc_study/" + file.getOriginalFilename());
        try {
            file.transferTo(localFile);
            System.out.println("save successfully");
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        return "index.jsp";
    }

    @GetMapping("/pureString")
    @ResponseBody
    public String pureString(){
        return "This is a pure string ,not a file path.";
    }

    @GetMapping("/forward")
    public String forward(){
        return "forward:/index.jsp";
    }

    @GetMapping("redirect")
    public String redirect(){
        return "redirect:/index.jsp";
    }
}
