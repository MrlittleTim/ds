package factory.method;

/**
 * @author tim
 * @date 2024/6/20
 */

public class Main {
    public static void main(String[] args) {
        Operation operation = new OperationAdd();
        operation.setNumA(13);
        operation.setNumB(22);
        double result = operation.getResult();
        System.out.println(result);
    }
}
