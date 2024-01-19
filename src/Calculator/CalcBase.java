package Calculator;


import java.util.ArrayList;
import java.util.List;

public abstract class CalcBase {

  private double value1;
  private double value2;
  private char opCode;
  private double result;
  private List<CalcBase> childCalculators = new ArrayList<>();


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


  public CalcBase(double value1, double value2) {
    this.value1 = value1;
    this.value2 = value2;
  }

  public abstract void calculate();

  public void add(CalcBase calculator) {
    childCalculators.add(calculator);
  }

  public void remove(CalcBase calculator) {
    childCalculators.remove(calculator);
  }

  public double calculateAll() {
    double result = 0;
    for (CalcBase calculator : childCalculators) {
      calculator.calculate();
      result += calculator.getResult();
    }
    return result;
  }
}
