package factory.method;

/**
 * @author tim
 * @date 2024/6/20
 */

public class OperationAdd extends Operation {
    @Override
    public double getResult() {
        return getNumA() + getNumB();
    }
}
