package factory.simple;

/**
 * @author tim
 * @date 2024/6/20
 */

public class Main {
    public static void main(String[] args) {
        Operation operation = OperationFactory.createOperate("+");
        operation.setNumA(13);
        operation.setNumB(2);
        double result = operation.getResult();
        System.out.println(result);
    }
}
