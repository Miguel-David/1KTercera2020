package Ficheros;

import java.io.File;

public class TamanyoDirectorio {
  public static void main(String[] args) {
    System.out.println(tamanyoDirectorio(new File("..")));
  }

  public static long tamanyoDirectorio(File file) {
    if(file.isFile()) return file.length();
    else {
      long total=0;
      for (File f:file.listFiles()) {
        total+=tamanyoDirectorio(f);
      }
      return total;
    }
  }
}
