package Excepciones;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LectorPersonas {
  public static void main(String[] args) {
    List<String> lineas=new ArrayList<>();
    try {
      while(lineas.size()<2) {
        JFileChooser seleccionadorFichero = new JFileChooser("c:\\Users\\Miguel\\Desktop\\Programación");

        seleccionadorFichero.showOpenDialog(null);
        File f = seleccionadorFichero.getSelectedFile();
        System.out.println(f.getName());
        System.out.println("Se va a leer de " + f.getPath());
        lineas = Files.readAllLines(Paths.get(f.getPath()));
        if(lineas.size()<2){
          JOptionPane.showMessageDialog(null,"El fichero no contiene datos");
        }
      }
    } catch (IOException ioe){
      JOptionPane.showMessageDialog(null,"ERROR AL LEER EL FICHERO");
    }

  }
}
