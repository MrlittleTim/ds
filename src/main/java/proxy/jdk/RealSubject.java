package proxy.jdk;

/**
 * @author tim
 * @date 2024/6/20
 */

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject: Handling request.");
    }
}
