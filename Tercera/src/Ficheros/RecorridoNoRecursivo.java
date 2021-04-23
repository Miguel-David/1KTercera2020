package Ficheros;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecorridoNoRecursivo {
  public static void main(String[] args) {
    File directorio=new File("ficheros");
    listadoFicheros(directorio);
  }

  private static void listadoFicheros(File directorio) {
    List<File> lista=new ArrayList<>();
    lista.addAll(Arrays.asList(directorio.listFiles()));
    while(lista.size()!=0) {
      File f=lista.get(0);
      lista.remove(0);
      if(f.isFile()) System.out.println(f.getName());
      else {
        System.out.println("DIR " + f.getName());
        lista.addAll(Arrays.asList(f.listFiles()));
      }
    }
  }
}
