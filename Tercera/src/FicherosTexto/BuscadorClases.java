package FicherosTexto;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BuscadorClases {
  private static final File directorio=new File("..");
  public static void main(String[] args) {
    //Encontrar todos los ficheros del directorio
    //Los ponemos en una lista
    //Esto nos lo aprendemos de memoria porque sale en el examen alguna variación
    //de este algoritmo recursivo.
    List<File> todosLosFicheros=recorre(directorio);

    //Nos quedamos con los .java
    List<File> soloJava=seleccionaPorExtension(todosLosFicheros,".java");
    //soloJava.forEach(System.out::println);

    //Para cada fichero .java, leemos todas las líneas
    //Quedándonos con las líneas que tengan la palabra class
    String salidaFinal="";
    for (File f:soloJava) {
      try {
        salidaFinal+="\n"+f.getCanonicalPath();
        //Otra línea a aprenderse de memoria
        List<String> lineasFichero= Files.readAllLines(f.toPath());
        for (String s:lineasFichero) {
          if(s.contains("public class ") || s.contains("class ")){
            salidaFinal+="\n     "+s.substring(0,s.length()-2);
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    //Imprimimos esas líneas
    System.out.println(salidaFinal);
  }

  private static List<File> seleccionaPorExtension(List<File> ficheros, String s) {
    List<File> salida=new ArrayList<>();
    for (File f:ficheros) {
      if(f.getName().endsWith(s)){
        salida.add(f);
      }
    }
    /* Forma bonica que si sale, bien, si no, con for each normal
    salida.forEach(f->{
      if(f.getName().endsWith(s)){
        salida.add(f);
      }
    });

     */
    return salida;
  }

  private static List<File> recorre(File directorio) {
    List<File> salida=new ArrayList<>();

    //Bien

    for (File f:directorio.listFiles()) {
      if(f.isDirectory()){
        //Llamada recursiva
        salida.addAll(recorre(f));
      } else {
        salida.add(f);
      }
    }
    return salida;
  }
}
