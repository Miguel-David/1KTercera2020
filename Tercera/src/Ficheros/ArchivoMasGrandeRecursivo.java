package Ficheros;

import javax.swing.*;
import java.io.File;

public class ArchivoMasGrandeRecursivo {
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

    File directorio = directorioAElegir.getSelectedFile();
    sacaFicherosMasGrandes(directorio);

  }

  private static void sacaFicherosMasGrandes(File directorio) {
    File[] cantidadArchivos = directorio.listFiles();
    if (cantidadArchivos.length == 0) {
      System.out.println("Carpeta " + directorio.getName() + "sin archivos");
      return;
    }
    if (cantidadArchivos.length == 1) {
      if (cantidadArchivos[0].isDirectory()) {
        sacaFicherosMasGrandes(cantidadArchivos[0]);
        return;
      } else {
        System.out.println("El archivo más grande de la carpeta " + directorio.getName()
                + " es " + cantidadArchivos[0].getName());
        return;
      }
    } //Dudo que sea necesario

    File ficheroMasGrande = null;
    for (File f : cantidadArchivos) {
      if (f.isFile()) {
        ficheroMasGrande = f;
      }
    } //Equivalente a asignarle el último

    for (File f : cantidadArchivos) {
      //Mucho mejor un if else
      if (f.isDirectory()) sacaFicherosMasGrandes(f);
      else {
        if (f.length() > ficheroMasGrande.length()) {
          ficheroMasGrande = f;
        }
      }
    }
    System.out.println("El fichero mas grande de carpeta " + directorio.getName() + " es " + ficheroMasGrande.getName());
  }
}
