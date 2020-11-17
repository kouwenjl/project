package com.demo.spring.ByteBuddyTest;

import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotatingIntercept {
    @RuntimeType //自动返回方法对应的数据类型
    public Object intercept(@AllArguments Object[] argument, @Origin Method method){
        System.out.println("方法:"+method.getName()+",请求参数:"+ Arrays.toString(argument));
        return method.getName();
    }

}
