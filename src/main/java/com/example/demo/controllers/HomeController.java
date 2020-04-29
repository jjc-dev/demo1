package com.example.demo.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Value("${app.version}")
    private String appVersion;
    private Locale locale = new Locale("en", "GB");
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
    
    @GetMapping
    @RequestMapping("/")
    public Map<String, String> getStatus() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("The Openshift app-version", appVersion + " " + dateFormat.format(new Date()));
        return map;
    }

    @GetMapping
    @RequestMapping("/hello")
    public String getHello() {
        return "Hello Openshift World: " + appVersion + " "  + dateFormat.format(new Date());
    }

}