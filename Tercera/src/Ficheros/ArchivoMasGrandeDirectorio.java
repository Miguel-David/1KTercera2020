package Ficheros;

import javax.swing.*;
import java.io.File;

public class ArchivoMasGrandeDirectorio {
  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(
              UIManager.getSystemLookAndFeelClassName());
    } catch(Exception e) {
      e.printStackTrace();
    }

    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setCurrentDirectory(new File("..\\.."));
    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    int seleccion = fileChooser.showOpenDialog(null);
    if (seleccion == JFileChooser.CANCEL_OPTION || seleccion == JFileChooser.ERROR_OPTION) {
      return;
    }
    //Tengo directorio elegido
    File directorio = fileChooser.getSelectedFile();

    File[] listaFicheros = directorio.listFiles();
    System.out.println("En el directorio hay: " + listaFicheros.length);
    if (listaFicheros.length == 0) {
      JOptionPane.showMessageDialog(null, "Directorio Vacío. No hay máximo");
      return;
    }
    if (listaFicheros.length == 1) {
      JOptionPane.showMessageDialog(null, "Solo hay uno: " + listaFicheros[0].getName());
    }
    long ocupacionTotal = 0;
    File elQueMasOcupa = listaFicheros[0];
    for (File ficheroActual : listaFicheros
    ) {
      if(!ficheroActual.isFile()) continue;
      if (elQueMasOcupa.length() < ficheroActual.length()) {
        elQueMasOcupa = ficheroActual;
      }
      ocupacionTotal+=ficheroActual.length();
      System.out.println(ficheroActual.getTotalSpace());
    }

    double ratioOcupacion=(elQueMasOcupa.length()*100) / (double)ocupacionTotal;

    String salida="";
    salida+="El fichero que más ocupa es: "+elQueMasOcupa.getName();
    salida+="\nOcupando: "+elQueMasOcupa.length();
    salida+=String.format("\nY de un total de %d bytes ocupa un %.2f por ciento",ocupacionTotal,ratioOcupacion);
    JOptionPane.showMessageDialog(null,salida);
  }

}
