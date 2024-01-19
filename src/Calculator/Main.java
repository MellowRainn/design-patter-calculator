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
  
  CalcHelper helper = new CalcHelper();

    writer.writeLine("Fill in any equation. Type 'exit' to quit.");

    //    examples:
//    "ADDITION 1.0", // Error: incorrect number of values
//    "ADDITION xx 25.0", // Error: non-numeric data
//    "ADDITIONX 0.0 0.0", // Error: invalid command
//    "DIVISION 100.0 50.0", // 100.0 / 50.0 = 2.0
//    "ADDITION 25.0 92.0", // 25.0 + 92.0 = 117.0
//    "SUBTRACTION 225.0 17.0", // 225.0 - 17.0 = 108.0
//    "MULTIPLICATION 11.0 3.0" // 11.0 x 3.0 = 33.0
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
