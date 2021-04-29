package FicherosTexto;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuscadorEnMemoria {
  private static final File directorio=new File("..");
  public static void main(String[] args) throws IOException {
    //Tener en una lista solo los .java
    List<File> ficherosJava=recorre(directorio,".java");
    ficherosJava.forEach(System.out::println);
    Map<File,List<String>> textoTodosLosFicherosJava=rellena(ficherosJava);
    Map<File,List<String>> lineasClassJava=new HashMap<>();

    textoTodosLosFicherosJava.forEach((f,lista)->{
      List<String> lineasClass=new ArrayList<>();
      for (String s:lista) {
        if(s.contains("class ")) {
          lineasClass.add(s);
        }
      }
      lineasClassJava.put(f,lineasClass);
    });
    lineasClassJava.forEach((f,lista)->{
      try {
        System.out.println(f.getCanonicalPath() + ":\n");
        lista.forEach(s->System.out.println("    "+s));
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
  }

  private static Map<File, List<String>> rellena(List<File> ficheros) throws IOException {
    //SAle en el examen mapas con listas
    Map<File,List<String>> salida=new HashMap<>();
    ficheros.forEach(f-> {
      try {
        salida.put(f,Files.readAllLines(f.toPath()));
      } catch (IOException e) {
        e.printStackTrace();
      }
    });

    return salida;
  }

  private static List<File> recorre(File directorio, String s) {
    List<File> salida=new ArrayList<>();
    for (File f:directorio.listFiles(f->f.isDirectory() || f.getName().endsWith(s))){
      if(f.isDirectory()){
        salida.addAll(recorre(f,s));
      } else {
        salida.add(f);
      }
    }
    return salida;
  }
}
