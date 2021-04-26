package Ficheros;

import java.io.File;

public class JA {
  public static void main(String[] args) {
    File directorio=new File("..");
    tamanyo(directorio);
  }

  private static void tamanyo(File directorio){
    for (File f:directorio.listFiles()){
      if (f.isDirectory()){
        System.out.println("El directorio ocupa "+ f.getTotalSpace() + " bytes");
      }else{
        System.out.println("Archivo: " + f.getName());
      }
    }
  }
}
