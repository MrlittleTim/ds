package proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author tim
 * @date 2024/6/20
 */

public class Client {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        Subject proxy = (Subject) Proxy.newProxyInstance(
                realSubject.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(),
                new DynamicProxyHandler(realSubject));
        proxy.request();
    }
}
