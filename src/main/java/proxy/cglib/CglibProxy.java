package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author tim
 * @date 2024/6/20
 */

// CGLIB代理类
public class CglibProxy implements MethodInterceptor {
    private Object realSubject;

    public CglibProxy(Object realSubject) {
        this.realSubject = realSubject;
    }

    public Object createProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(realSubject.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("Proxy: Logging before request.");
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("Proxy: Logging after request.");
        return result;
    }
}