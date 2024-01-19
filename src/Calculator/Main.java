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
    writer.writeLine("Fill in any equation");
    String equations[] = {
            reader.readLine()
    };
  }


}