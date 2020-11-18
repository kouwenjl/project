package com.demo.spring.agent;

public class AgentTest {
    public String point(){
        System.out.println("com.demo.spring.agent.AgentTest:探针被调用");
        return "com.demo.spring.agent.AgentTest";
    }
}
