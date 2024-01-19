package Calculator;

public class CalcSubtracter extends CalcBase {
    public CalcSubtracter() {};
    public CalcSubtracter(double value1, double value2) {
        super(value1, value2);
    }

    @Override
    public void calculate() {
        double value = getValue1() - getValue2();
        setResult(value);
    }
}