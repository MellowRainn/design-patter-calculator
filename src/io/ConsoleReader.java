package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

  public String readLine() {
    try {
      return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    } catch (IOException var2) {
      return "Gibberish input detected";
    }
  }
}
