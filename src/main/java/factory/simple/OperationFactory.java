package factory.simple;

/**
 * @author tim
 * @date 2024/6/20
 */

public class OperationFactory {
    public static Operation createOperate(String operate) {
        Operation operation = null;
        switch (operate) {
            case "+":
                operation = new OperationAdd();
                break;
        }
        return operation;
    }
}
