package Ficheros;

import java.io.File;

public class MasEjemplosFile {
  public static void main(String[] args) {
    File directorioActual=new File(".");
    for (File fichero:directorioActual.listFiles()
         ) {
      System.out.println((fichero.isFile()?"Fichero   ":"Directorio  ")+fichero.getName());
    }
  }
}
