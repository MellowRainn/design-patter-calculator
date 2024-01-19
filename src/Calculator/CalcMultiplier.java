package Calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalcMultiplier extends CalcBase {

  public CalcMultiplier(double value1, double value2) {
    super(value1, value2);
  }

  @Override
  public void calculate() {
    BigDecimal bd1 = new BigDecimal(Double.toString(getValue1()));
    BigDecimal bd2 = new BigDecimal(Double.toString(getValue2()));
    BigDecimal result = bd1.multiply(bd2);
    result = result.setScale(CalcConfig.getInstance().getPrecision(), RoundingMode.HALF_UP);
    setResult(result.doubleValue());
}
}