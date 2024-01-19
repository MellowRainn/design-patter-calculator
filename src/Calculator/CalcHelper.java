package Calculator;

public class CalcHelper {

  private static final char ADD_SYMBOL = '+';
  private static final char MINUS_SYMBOL = '-';
  private static final char MULTIPLY_SYMBOL = '*';
  private static final char DIVIDE_SYMBOL = '/';

  private OpCode operation;
  private double value1, value2, result;

  public void process(String statement) throws InvalidStatementException {
    String parts[] = statement.split(" ");

    if (parts.length != 3) {
      throw new InvalidStatementException("Incorrect number of fields", statement);
    }

    String commandString = parts[0];

    try {
      value1 = Double.parseDouble(parts[1]);
      value2 = Double.parseDouble(parts[2]);
    } catch (NumberFormatException e) {
      throw new InvalidStatementException("Non-numeric data", statement, e);
    }

    setCommandFromString(commandString);
    if (operation == null) {
      throw new InvalidStatementException("Invalid command", statement);
    }

    CalcBase calculator = createCalculator();
    calculator.calculate();
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
        calculator = new CalcAdder(value1, value2);
        break;
      case SUBTRACTION:
        calculator = new CalcSubtracter(value1, value2);
        break;
      case MULTIPLICATION:
        calculator = new CalcMultiplier(value1, value2);
        break;
      case DIVISION:
        calculator = new CalcDivider(value1, value2);
        break;
    }
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
