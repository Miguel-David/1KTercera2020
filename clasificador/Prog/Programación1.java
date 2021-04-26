package recursividad;

import java.io.File;

public class RecorridoRecursivo {

  public static void main(String[] args) {
    File directorio=new File("ficheros");
    listadoFicheros(directorio);
  }

  private static void listadoFicheros(File directorio) {
    listadoFicheros(directorio,0);
  }


  private static void listadoFicheros(File directorio,int nivel) {

    for (File f:directorio.listFiles()) {
      for (int i = 0; i < nivel*2; i++) {
        System.out.print("   ");
      }
      if(f.isFile()){
        System.out.println(f.getName());
      }
      else {
        System.out.println("DIR "+f.getName());
        listadoFicheros(f,nivel+1);
      }
    }
  }
}
