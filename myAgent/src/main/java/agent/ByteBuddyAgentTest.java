package agent;


import ByteBuddyTest.ProxyTargetIntercept;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;


public class ByteBuddyAgentTest {
    public static void premain(String arguments, Instrumentation instrumentation) {
        System.out.println("java agent 启动中。。。");
        new AgentBuilder.Default()
                .type(ElementMatchers.nameStartsWith("com.demo.spring.agent"))
                .transform((builder, typeDescription, classLoader, javaModule) ->
                    builder.method(ElementMatchers.any())
                            .intercept(MethodDelegation.to(ProxyTargetIntercept.class))
                ).installOn(instrumentation);
        System.out.println("java agent 启动完毕。。。");
    }
}
