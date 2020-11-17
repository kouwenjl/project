package com.demo.spring.ByteBuddyTest;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.util.function.Function;

/**
 * @author dongXiaoSong
 * @description 字节码代理生成byteBuddy
 * @date 2020-11-17 11:39
 * @return
 * @throws
 */
public class ByteBuddyTest {
    private static ClassLoader classLoader = ByteBuddyTest.class.getClassLoader();

    public static void main(String[] args) throws Exception {
        //固定返回值
//        String testString= "hello word";
//        Class<?> test = new ByteBuddy()
//                .subclass(Object.class).method(ElementMatchers.named("toString"))
//                .intercept(FixedValue.value(testString))
//                .make().load(ByteBuddyTest.class.getClassLoader()).getLoaded();
//        assert test.newInstance().toString().equals(testString) : "比对失败" ;
//        //自定义拦截方法 自定义的类中的方法参数和返回值 必须和代理的一致
//        Class<? extends Function> custom = new ByteBuddy()
//                .subclass(java.util.function.Function.class)
//                .method(ElementMatchers.named("apply"))
//                .intercept(MethodDelegation.to(new MyIntercept()))
//                .make()
//                .load(classLoader)
//                .getLoaded();
//        System.out.println(custom.newInstance().apply("自定义方法拦截"));
        //注解拦截
//        Class<? extends Function> customAnnotation = new ByteBuddy()
//                .subclass(java.util.function.Function.class)
//                .method(ElementMatchers.named("apply"))
//                .intercept(MethodDelegation.to(new AnnotatingIntercept()))
//                .make()
//                .load(classLoader)
//                .getLoaded();
//        System.out.println(customAnnotation.newInstance().apply("自定义方法拦截"));
        //注解拦截 可以获取代理原目标对象
        Class<? extends Function> customAnnotation = new ByteBuddy()
                .subclass(Function.class)
                .method(ElementMatchers.named("apply"))
                .intercept(MethodDelegation.to(new ProxyTargetIntercept()))
                .make()
                .load(classLoader)
                .getLoaded();
        System.out.println(customAnnotation.newInstance().apply("原目标获得拦截"));

    }
}

