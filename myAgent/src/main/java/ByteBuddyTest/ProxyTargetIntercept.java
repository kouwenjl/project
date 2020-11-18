package ByteBuddyTest;

import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public class ProxyTargetIntercept {
    @RuntimeType
    public static Object invoke(@Origin Method method, @SuperCall Callable<?> callable) {
        try {
            System.out.println(method.getName());
            callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "目标方法实例获得拦截";
    }
}
