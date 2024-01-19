package Calculator;

public abstract class CalcBase {

  private double value1;
  private double value2;
  private char opCode;
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

  public char getOpCode() {
    return opCode;
  }

  public void setOpCode(char opCode) {
    this.opCode = opCode;
  }

  public double getResult() {
    return result;
  }

  public void setResult(double result) {
    this.result = result;
  }

  public CalcBase() {
  }

  ;

  public CalcBase(double value1, double value2) {
    this.value1 = value1;
    this.value2 = value2;
  }

  public abstract void calculate();

}
