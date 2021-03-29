package Excepciones;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Escribir {
  public static void main(String[] args) throws IOException {
    String[] prueba={"p"};
    Files.write(Paths.get("estoyAqui.txt"), Arrays.asList(prueba));
  }
}
