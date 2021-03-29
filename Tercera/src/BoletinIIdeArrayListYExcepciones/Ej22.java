package BoletinIIdeArrayListYExcepciones;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ej22 {
  public static void main(String[] args) throws IOException {
    List<String> lineas= Files.readAllLines(Paths.get("Ej22.txt"));
    muestraSinCeros(lineas.get(0));
  }

  private static void muestraSinCeros(String s) {
    for (String cadena:s.split(" ")
         ) {
      if(!cadena.equals("0")){
        System.out.print(cadena+" ");
      }
    }

  }
}
