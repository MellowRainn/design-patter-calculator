package Calculator;

public class AdditionStrategy implements CalculationStrategy {
    @Override
    public double calculate(double value1, double value2) {
        return value1 + value2;
    }
}
