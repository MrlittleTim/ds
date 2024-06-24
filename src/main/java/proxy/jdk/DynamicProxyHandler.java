package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author tim
 * @date 2024/6/20
 */

public class DynamicProxyHandler implements InvocationHandler {
    private Object realSubject;

    public DynamicProxyHandler(Object realSubject) {
        this.realSubject = realSubject;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy: Logging before request.");
        Object result = method.invoke(realSubject, args);
        System.out.println("Proxy: Logging after request.");
        return result;
    }
}
