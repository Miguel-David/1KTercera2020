package Ficheros;

import java.io.File;

public class DIRRecursivo {
  public static void main(String[] args) {
    File directorio=new File("..");
    System.out.println(devuelveListaFicheros(directorio));
  }

  private static String devuelveListaFicheros(File directorio) {
    return devuelveListaFicheros(directorio,0);
  }

  private static String devuelveListaFicheros(File p,int nivel) {
    String salida="";
    for(File f:p.listFiles()){
      for(int i=0;i<nivel;i++) salida+="| ";
      if(f.isFile()) salida+=f.getName()+"\n";
      else {
        salida+="DIRECTORIO: "+f.getName()+"\n";
        salida+=devuelveListaFicheros(f,nivel+1);
      }
    }
    return salida;
  }
}
