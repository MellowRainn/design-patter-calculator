package Calculator;

import io.ConsoleReader;
import io.ConsoleWriter;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    //  allows you to write stuff to the console.
    ConsoleWriter writer = new ConsoleWriter();

    //  allows you to read inputs in the console.
    ConsoleReader reader = new ConsoleReader();
  
   CalcConfig.getInstance().setPrecision(2);
  
   CalcHelper helper = new CalcHelper();

    writer.writeLine("Fill in any equation. Type 'exit' to quit.");


    while (true) {
      String statement = reader.readLine();

      if ("exit".equalsIgnoreCase(statement)) {
        break;
      }

      try {
        helper.process(statement);
        System.out.println(helper);
      } catch (InvalidStatementException e) {
        System.out.println(e.getMessage());
        if (e.getCause() != null) {
          System.out.println("Original Exception: " + e.getCause().getMessage());
        }
      }
    }
  }
}
