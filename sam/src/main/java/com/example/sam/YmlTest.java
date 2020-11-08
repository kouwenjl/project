package com.example.sam;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Data
public class YmlTest {
    @Value("${jll}")
    private String jll;
    @PostConstruct
    public void dxs(){
        System.out.println("jll:"+jll);
    }



}
