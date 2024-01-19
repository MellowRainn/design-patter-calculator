package Calculator;

public class CalcMultiplier extends CalcBase {
    public CalcMultiplier() {};
    public CalcMultiplier(double value1, double value2) {
        super(value1, value2);
    }

    @Override
    public void calculate() {
        double value = getValue1() * getValue2();
        setResult(value);
    }
}