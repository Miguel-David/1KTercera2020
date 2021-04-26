package Ficheros;

import java.io.File;

public class DIRRecursivo {
  static long total=0;
  public static void main(String[] args) {
    File directorio=new File("..");
    tamanyo(directorio);
    System.out.println(total);
  }

  public static void tamanyo(File directorio) {
    for (File f:directorio.listFiles()) {
      if(f.isFile()) total+=f.length();
      else tamanyo(f);
    }
  }
}
