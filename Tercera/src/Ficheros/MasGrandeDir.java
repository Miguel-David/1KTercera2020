package Ficheros;


import javax.swing.*;
import java.io.File;

public class MasGrandeDir {
  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(
              UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {
      e.printStackTrace();
    }
    JFileChooser jFileChooser = new JFileChooser("./");
    jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    jFileChooser.showOpenDialog(null);

    File inicio = jFileChooser.getSelectedFile();
    System.out.println(mayorFicheroDir(inicio, ""));
  }

  public static String mayorFicheroDir(File directorio, String tab) {
    File[] archivosDir = directorio.listFiles();
    if (archivosDir.length < 1) return tab + "DIR " + directorio.getName() + " no tiene ficheros\n";
    String cola = "";
    File mayor = archivosDir[0];
    for (File f : archivosDir) {
      if (f.isDirectory()) {
        cola += mayorFicheroDir(f, tab + " ");
      } else if (f.isFile()) {
        if (mayor.length() < f.length()) mayor = f;
      }
    }

    String masGrande = mayor.isFile() ? "El mas grande es " + mayor.getName() + " pesando " + mayor.length() + " bytes" : "no tiene ficheros\n";
    return tab + "DIR " + directorio.getName() + " " + masGrande + "\n" + cola;
  }
}
