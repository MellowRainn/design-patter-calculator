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

    if (parts.length != 3) {
      System.out.println("Checking for the length of the equation");
      throw new InvalidStatementException("Incorrect number of fields", statement);
    }

    String commandString = parts[0];

    try {
      System.out.println("Parsing Double");
      value1 = Double.parseDouble(parts[1]);
      value2 = Double.parseDouble(parts[2]);
    } catch (NumberFormatException e) {
      throw new InvalidStatementException("Non-numeric data", statement, e);
    }

    @Override
    public String toString() {
        char opCode = compositeCalculator.getOpCode();
        return String.format("%.2f %c %.2f = %.2f", value1, opCode, value2, result);
    }

    CalcBase calculator = createCalculator();
    calculator.calculate();
    System.out.println("Getting result");
    result = calculator.getResult();
  }

  private void setCommandFromString(String commandString) {
    try {
      operation = OpCode.valueOf(commandString.toUpperCase());
    } catch (IllegalArgumentException e) {
      operation = null;
    }
  }

  private CalcBase createCalculator() {
    CalcBase calculator = null;
    switch (operation) {
      case ADDITION:
        System.out.println("Adding");
        calculator = new CalcAdder(value1, value2);
        break;
      case SUBTRACTION:
        System.out.println("Subtracting");
        calculator = new CalcSubtracter(value1, value2);
        break;
      case MULTIPLICATION:
        System.out.println("Multiplying");
        calculator = new CalcMultiplier(value1, value2);
        break;
      case DIVISION:
        System.out.println("Dividing");
        calculator = new CalcDivider(value1, value2);
        break;
    }
    System.out.println("Getting calculation");
    return calculator;
  }

  @Override
  public String toString() {
    char symbol = ' ';
    switch (operation) {
      case ADDITION:
        symbol = ADD_SYMBOL;
        break;
      case SUBTRACTION:
        symbol = MINUS_SYMBOL;
        break;
      case MULTIPLICATION:
        symbol = MULTIPLY_SYMBOL;
        break;
      case DIVISION:
        symbol = DIVIDE_SYMBOL;
        break;
    }

    StringBuilder sb = new StringBuilder(20);
    sb.append(value1);
    sb.append(' ');
    sb.append(symbol);
    sb.append(' ');
    sb.append(value2);
    sb.append(" = ");
    sb.append(result);

    return sb.toString();
  }
}
