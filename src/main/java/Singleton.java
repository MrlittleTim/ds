/**
 * @author tim
 * @date 2024/6/20
 */


public class Singleton {
    private Singleton() {
    }

    public static Singleton getInstance() {
        return InnerClass.INSTANCE;
    }

    private static class InnerClass {
        private final static Singleton INSTANCE = new Singleton();
    }
}



