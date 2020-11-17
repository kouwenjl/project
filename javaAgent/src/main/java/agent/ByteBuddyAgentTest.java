package com.demo.spring.agent;

import com.demo.spring.ByteBuddyTest.ProxyTargetIntercept;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

public class ByteBuddyAgentTest {
    public static void premain(String arguments, Instrumentation instrumentation) {
        System.out.println("java agent 启动中。。。");
        new AgentBuilder.Default().
                type(ElementMatchers.named("AgentTest"))
                .transform((builder, typeDescription, classLoader, javaModule) -> {
                    return builder.method(ElementMatchers.any())
                            .intercept(MethodDelegation.to(new ProxyTargetIntercept()));
                }).installOn(instrumentation);
    }
}
