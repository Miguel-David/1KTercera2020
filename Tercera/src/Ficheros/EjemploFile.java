package Ficheros;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class EjemploFile {
  public static void main(String[] args) throws IOException {
    File fichero=new File("C:\\txt\\ejemplo.txt");
    System.out.println(fichero.getName());
    System.out.println(fichero.getPath());
    fichero.createNewFile();
    System.out.println(fichero.getFreeSpace());
    System.out.println(fichero.getParent());
    for (int i = 0; i < 100; i++) {
      File directorio=fichero.getParentFile();
      String nombre="Fichero"+i+".txt";
      File nuevo=new File(directorio,nombre);
      nuevo.createNewFile();
    }
    System.out.println(fichero.getTotalSpace()+ " total");
    System.out.println(fichero.getUsableSpace()+ " usable");
    System.out.println(fichero.getFreeSpace()+ "libre");
    System.out.println(fichero.length()); //Lo que ocupa
    System.out.println(fichero.list());
    File directorioPadre=fichero.getParentFile();
    System.out.println(directorioPadre.listFiles().length);
    for (File f:directorioPadre.listFiles()
         ) {
      System.out.println(f.getName() + " ocupa " + f.length());
    }
    JFileChooser fileChooser = new JFileChooser();
    int seleccion = fileChooser.showOpenDialog(null);
  }
}
