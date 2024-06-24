package factory.method;

/**
 * @author tim
 * @date 2024/6/20
 */

public class AddFactory implements IFactory{
    @Override
    public Operation createOperation() {
        return new OperationAdd();
    }
}
