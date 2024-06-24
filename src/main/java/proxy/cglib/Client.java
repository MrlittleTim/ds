package proxy.cglib;

/**
 * @author tim
 * @date 2024/6/20
 */

// 客户端
public class Client {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        CglibProxy cglibProxy = new CglibProxy(realSubject);
        RealSubject proxy = (RealSubject) cglibProxy.createProxy();
        proxy.request();
    }
}