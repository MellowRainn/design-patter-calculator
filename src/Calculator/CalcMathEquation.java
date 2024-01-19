package Calculator;

public class CalcMathEquation {

  private double value1;
  private double value2;
  private OpCode operation;
  private double result;

  public double getValue1() {
    return value1;
  }

  public void setValue1(double value1) {
    this.value1 = value1;
  }

  public double getValue2() {
    return value2;
  }

  public void setValue2(double value2) {
    this.value2 = value2;
  }

  public OpCode getOperation() {
    return operation;
  }

  public void setOperation(OpCode operation) {
    this.operation = operation;
  }

  public double getResult() {
    return result;
  }

  public CalcMathEquation(OpCode operation) {
    this.operation = operation;
  }

  public CalcMathEquation(OpCode operation, double value1, double value2) {
    this(operation);
    this.value1 = value1;
    this.value2 = value2;
  }

  public void execute(double value1, double value2) {
    this.value1 = value1;
    this.value2 = value2;
    execute();
  }

  public void execute(int value1, int value2) {
    this.value1 = value1;
    this.value2 = value2;
    execute();
    result = (int) result;
  }

  public void execute() {
    switch (operation) {
      case ADDITION:
        result = add();
        break;
      case SUBTRACTION:
        result = subtract();
        break;
      case MULTIPLICATION:
        result = multiply();
        break;
      case DIVISION:
        result = divide();
        break;
      default:
        result = 0; // or throw new IllegalArgumentException("Unknown operation");
        System.out.println("Unknown operation");
        break;
    }
  }

  private double add() {
    return value1 + value2;
  }

  private double subtract() {
    return value1 - value2;
  }

  private double multiply() {
    return value1 * value2;
  }

  private double divide() {
    if (value2 != 0) {
      return value1 / value2;
    } else {
      System.out.println("Cannot divide by 0");
      return 0;
    }
  }
}

