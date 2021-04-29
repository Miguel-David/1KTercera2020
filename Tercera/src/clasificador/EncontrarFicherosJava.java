package clasificador;

import javax.swing.*;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncontrarFicherosJava {
  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(
              UIManager.getSystemLookAndFeelClassName());
    } catch(Exception e) {
      e.printStackTrace();
    }
    JFileChooser directorioAElegir = new JFileChooser();
    directorioAElegir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    int seleccion = directorioAElegir.showOpenDialog(null);
    if (seleccion == JFileChooser.CANCEL_OPTION || seleccion == JFileChooser.ERROR_OPTION) {
      return;
    }
    File directorioElegido = directorioAElegir.getSelectedFile();
    EncontrarFicherosJava.muestraFicherosJava(directorioElegido).forEach(System.out::println);
  }

  private static List<File> muestraFicherosJava(File dir) {
    double l=40;
    List<File> ficherosConJava = new ArrayList<>();
    FileFilter logFileFilter = file -> {
      if (file.getName().endsWith(".java")) {
        return true;
      } else if (file.isDirectory()) {
        ficherosConJava.addAll(muestraFicherosJava(file));
      }
      return false;
    };
    ficherosConJava.addAll(Arrays.asList(dir.listFiles(logFileFilter)));
    return ficherosConJava;
  }
}
