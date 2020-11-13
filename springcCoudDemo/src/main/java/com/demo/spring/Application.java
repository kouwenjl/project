package com.demo.spring;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Api("测试demo")
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
    @RequestMapping("/sessionTest")
    @ApiOperation(value = "获取demo", response = String.class)
    @ApiImplicitParams(@ApiImplicitParam(name = "测试", value = "sssp"))
    public String test() {
        return "sss";
    }
}
