package Calculator;
import java.util.Scanner;

public class CalcHelper {
    private static final String SEPARATOR = " ";
    private double value1;
    private double value2;
    private double result;
    private CalcBase compositeCalculator;

    public void process(String statement) throws InvalidStatementException {
        String[] parts = statement.split(SEPARATOR);

        if (parts.length != 3) {
            throw new InvalidStatementException("Incorrect number of fields", statement);
        }

        String opCodeStr = parts[0];

        try {
            value1 = Double.parseDouble(parts[1]);
            value2 = Double.parseDouble(parts[2]);
        } catch (NumberFormatException e) {
            throw new InvalidStatementException("Non-numeric data", statement, e);
        }

        setCalculator(opCodeStr);
        compositeCalculator.calculate();
        result = compositeCalculator.getResult();
    }

    private void setCalculator(String opCodeStr) throws InvalidStatementException {
        switch (opCodeStr) {
            case "+":
                compositeCalculator = new CalcAdder(value1, value2);
                break;
            case "-":
                compositeCalculator = new CalcSubtracter(value1, value2);
                break;
            case "*":
                compositeCalculator = new CalcMultiplier(value1, value2);
                break;
            case "/":
                compositeCalculator = new CalcDivider(value1, value2);
                break;
            default:
                throw new InvalidStatementException("Invalid operation", opCodeStr);
        }
    }

    @Override
    public String toString() {
        char opCode = compositeCalculator.getOpCode();
        return String.format("%.2f %c %.2f = %.2f", value1, opCode, value2, result);
    }
}