package Calculator;

public class CalcConfig {
    private static CalcConfig instance;
    private double defaultValue;
    private int precision;
  
  
    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }
    
    private CalcConfig() {
      // Private constructor to prevent instantiation
    }
  
    public static synchronized CalcConfig getInstance() {
      if (instance == null) {
        instance = new CalcConfig();
      }
      return instance;
    }
  
    public double getDefaultValue() {
      return defaultValue;
    }
  
    public void setDefaultValue(double defaultValue) {
      this.defaultValue = defaultValue;
    }
   
}
