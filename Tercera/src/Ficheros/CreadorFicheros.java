package Ficheros;

import java.io.File;
import java.io.IOException;

public class CreadorFicheros {
  public static final String DIR_BASE="ficheros";
  public static void main(String[] args) {
    //1. Mira si existe el directorio base
    File directorio=new File(DIR_BASE);
    //2. Si no existe, lo crea y seguimos en Ap4
    if(!directorio.exists()){
      System.out.println("El directorio no existe");
      System.out.println("Lo creamos");
      System.out.println(directorio.mkdir());
    } else {
      //3. Si existe, elimina todos los ficheros de ese directorio
      System.out.println("El directorio existe");
      File[] ficherosDentro=directorio.listFiles();
      System.out.println("Tiene " + ficherosDentro.length + " ficheros que borramos");
      for (File fichero:ficherosDentro) {
        fichero.delete();
      }
    }
    //4. Sabemos que está creado y vacio y creamos los ficheros
    for (int i = 1; i < 23; i++) {
      String nombreFicheroNuevo=""+i+"fichero.txt";
      File nuevoFichero=new File(directorio,nombreFicheroNuevo);
      try {
        nuevoFichero.createNewFile();
      } catch (IOException e) {
        System.out.println("OYE, al crear " + nombreFicheroNuevo + " Ha habido un problema");
        e.printStackTrace();
      }
    }
  }
}
