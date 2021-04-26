package clasificador;

import java.io.File;
import java.util.*;

public class Clasificador {
  public static final File directorioBase=new File("clasificador");
  public static final int cantidadLetrasPrefijo=4;


  public static void main(String[] args) {
    //Obtenemos todos los ficheros (no los directorios)
    List<File> listaFicheros=devuelveFicheros(directorioBase);
    listaFicheros.forEach(file -> System.out.println(file.getName()));


    Map<File,List<File>> directoriosNuevosConFicheros=new HashMap<>();
    listaFicheros.forEach(file ->{
      String prefijoActual=file.getName().substring(0,cantidadLetrasPrefijo);
      File directorioNuevo=new File(directorioBase,prefijoActual);
      directoriosNuevosConFicheros.put(directorioNuevo,new ArrayList<>());
    });
    System.out.println("Prefijos localizados");
    directoriosNuevosConFicheros.keySet().forEach(file->System.out.println(file.getName()));
    //Creamos los directorios
    directoriosNuevosConFicheros.keySet().forEach(file -> file.mkdir());
    //Ponemos los ficheros en la entrada correspondiente
    for (File f:listaFicheros) {
      String prefijoActual=f.getName().substring(0,cantidadLetrasPrefijo);
      File directorioNuevo=new File(directorioBase,prefijoActual);
      directoriosNuevosConFicheros.get(directorioNuevo).add(f);
    }
    directoriosNuevosConFicheros.forEach((f,lista)->{
      System.out.println(f.getName() + " tiene " + lista.size() + " archivos");
    });
    //Cambio al directorio nuevo
    directoriosNuevosConFicheros.forEach((f,lista)->{
      for (File archivo:lista) {
        File destino=new File(f,archivo.getName());
        archivo.renameTo(destino);
      }
    });
    for (File f:directorioBase.listFiles()) {
      if(f.isDirectory() && f.listFiles().length==0){
        f.delete();
      }
    }
  }

  private static List<File> devuelveFicheros(File directorio) {
    //Estudiarlo para el examen
    List<File> ficheros=new ArrayList<>();
    for (File f:directorio.listFiles()) {
      if(f.isFile()) {
        ficheros.add(f);
      } else {
        ficheros.addAll(devuelveFicheros(f));
      }
    }
    return ficheros;
  }
}

