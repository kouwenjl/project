package com.demo.spring.ByteBuddyTest;

public class MyIntercept {
    public Object invoke(Object argument) {
        return "你好:" + argument;
    }


}
