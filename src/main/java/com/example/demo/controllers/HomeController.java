package com.example.demo.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Value("${app.version}")
    private String appVersion;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss"); 
    
    @GetMapping
    @RequestMapping("/")
    public Map<String, String> getStatus() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Openshift switch app-version", appVersion + ", runninng  java " + System.getProperty("java.version") +  " as of " + dateFormat.format(new Date()));
        return map;
    }

    @GetMapping
    @RequestMapping("/hello")
    public String getHello() {
        return "Hello Openshift World using the switch app version : " + appVersion + ", runninng on java " + System.getProperty("java.version") +  " as of "  + dateFormat.format(new Date());
    }

}