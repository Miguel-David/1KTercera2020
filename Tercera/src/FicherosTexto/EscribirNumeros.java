package FicherosTexto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirNumeros {
  public static void main(String[] args) {
    try(BufferedWriter writer= new BufferedWriter(new FileWriter("100Números",true))){
      for (int i = 0; i < 100; i++) {
        writer.write("" + i);

      }
    } catch (IOException e) {
      e.printStackTrace();


    }
  }
}