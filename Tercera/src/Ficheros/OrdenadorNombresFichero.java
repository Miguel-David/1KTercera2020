package Ficheros;

import java.io.File;

public class OrdenadorNombresFichero {
  public static final String DIR_BASE="ficheros";

  public static void main(String[] args) {
    //1. Obtener todos los ficheros
    File directorio=new File(DIR_BASE);
    File[] todosFicheros=directorio.listFiles();
    //2. Para todos los ficheros
    for (File ficheroActual:todosFicheros) {
    //2.a Si la longitud es 13, está bien
    //2.b Si la longitud es 12, añadirle un 0 delante
      if(ficheroActual.getName().length()==12){
        String nuevoNombre="0"+ficheroActual.getName();
        File nuevoFichero=new File(directorio,nuevoNombre);
        ficheroActual.renameTo(nuevoFichero);
      }
    }
  }
}
