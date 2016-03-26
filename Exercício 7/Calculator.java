package ces22;

public class Calculator {

    public enum Operation {

        ADD, SUBTRACT, DIVIDE, MULTIPLY, RESULT
    };
    private double a;
    private Operation operation;

    public Calculator() {
        clear();
    }

    public void clear() {
        a = 0;
        operation = Operation.ADD;
    }

    public void changeOperation(Operation op) {
        operation = op;
    }

    public void changeNum(double b) throws IllegalArgumentException {
        double u = operationAns(b);
        a = u;
    }

    public String getAns() {
        String ans;
        int u = (int) a;
        if (Math.abs(a - u) < 10E-15) {
            ans = String.valueOf(u);
        } else {
            ans = String.valueOf(a);
        }
        return ans;
    }

    private double operationAns(double b) throws IllegalArgumentException {
        double ret = 0;
        if (operation == Operation.ADD || operation == Operation.RESULT) {
            ret = a + b;
        } else if (operation == Operation.SUBTRACT) {
            ret = a - b;
        } else if (operation == Operation.MULTIPLY) {
            ret = a * b;
        } else if (operation == Operation.DIVIDE) {
            //Verifica se houve divisão por zero
            if (b == 0) {
                if (a == 0) {
                    throw new IllegalArgumentException("Indeterminado");
                }
                throw new IllegalArgumentException("Infinito");
            } else {
                ret = a / b;
            }
        }
        return ret;
    }
}
