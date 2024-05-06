package com.spring.demo.app1.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class TestController {

    // inject properties from props file
    @Value("${team.name}")
    private String teamName;

    @Value("${team.groupname}")
    private String teamGroup;

    @GetMapping("/")
    public String getResponse() {
        return "Hello World";
    }

    @GetMapping("/posts")
    public String posts() {
        return "list all posts new1 with value";
    }

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return teamName + "-" + "teamGroup";
    }

}
