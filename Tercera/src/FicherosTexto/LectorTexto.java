package FicherosTexto;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LectorTexto {
  public static void main(String[] args) throws IOException {
    try {
      List<String> personas= Files.readAllLines(Paths.get("personas.csv"));

      personas.forEach(System.out::println);
    } catch (IOException e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(null,"INSTALACIÓN CORRUPTA. FALTAN ARCHIVOS. REINSTALA DESDE GOOGLE PLAY");
      throw e;
    }


  }
}
