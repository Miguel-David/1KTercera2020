package Ficheros;

import java.io.File;
import java.util.*;

import org.apache.commons.io.FilenameUtils;

public class OcupacionPorExtension {
  public static void main(String[] args) {
    File directorio=new File("fotos");
    EstadisticaDirectorio estadisticaDirectorio=new EstadisticaDirectorio(directorio);
    for (String s:estadisticaDirectorio.extensionesDiferentes()) {
      System.out.println(s);
    }
    for (Map.Entry<String,Integer> entrada:
            estadisticaDirectorio.ficherosPorExtension().entrySet()) {
      System.out.println(entrada.getKey() + " - " + entrada.getValue());
    }
    for (Map.Entry<String,Long> entrada:
            estadisticaDirectorio.ocupacionExtension().entrySet()) {
      System.out.println(entrada.getKey() + " - " + entrada.getValue());
    }
    System.out.println(estadisticaDirectorio.elUltimo());
  }

}

class EstadisticaDirectorio{
  private final File directorio;
  private final File[] ficherosDirectorio;
  private final Map<String,List<File>> ficherosExtension;

  public EstadisticaDirectorio(File directorio) {
    if(directorio==null){
      throw new IllegalArgumentException("El directorio no puede ser nulo");
    }
    if(directorio.isFile()){
      throw new IllegalArgumentException("No se pueden hacer estadísticas de un fichero, solo de directorios");
    }
    this.directorio = directorio;
    this.ficherosDirectorio=directorio.listFiles();
    //Creo el mapa de ficheros por extensión
    this.ficherosExtension=new TreeMap<>();
    inicializaMapaExtensiones();
  }

  private void inicializaMapaExtensiones() {
    for (File fichero:this.ficherosDirectorio) {
      String extensionActual=FilenameUtils.getExtension(fichero.getName());
      if(!ficherosExtension.containsKey(extensionActual)){
        List<File> nuevaLista=new ArrayList<>();
        nuevaLista.add(fichero);
        ficherosExtension.put(extensionActual,nuevaLista);
      } else {
        List<File> losQueHabia=ficherosExtension.get(extensionActual);
        losQueHabia.add(fichero);
        ficherosExtension.put(extensionActual,losQueHabia);
      }
    }
  }

  public int numeroFicheros(){
    return ficherosDirectorio.length;
  }

  public long tamanyoTotal(){
    long total=0;
    for (File f:ficherosDirectorio) {
      total+=f.length();

    }
    return total;
  }
  public Set<String> extensionesDiferentes(){
    return ficherosExtension.keySet();
    /*
    return ficherosPorExtension().keySet();
     */
    /*Set<String> extensiones=new TreeSet<>();
    for (File f:ficherosDirectorio) {
      extensiones.add(FilenameUtils.getExtension(f.getName()));
    }
    return extensiones;*/
  }

  public Map<String, Integer> ficherosPorExtension(){
    Map<String,Integer> salida=new TreeMap<>();
    for (Map.Entry<String,List<File>> entrada:ficherosExtension.entrySet()) {
      salida.put(entrada.getKey(),entrada.getValue().size());
    }
    return salida;
    /*Map<String,Integer> salida=new TreeMap<>();
    for (File fichero:ficherosDirectorio) {
      String extension=FilenameUtils.getExtension(fichero.getName());
      if(!salida.containsKey(extension)){
        salida.put(extension,1);
      } else {
        int losQueHabia=salida.get(extension);
        salida.put(extension,losQueHabia+1);
      }
    }
    return salida;*/
  }

  public Map<String,Long> ocupacionExtension(){
    Map<String,Long> salida=new TreeMap<>();
    for (Map.Entry<String,List<File>> entrada:ficherosExtension.entrySet()) {
      long total=0;
      for (File f:entrada.getValue()) {
        total+=f.length();
      }
      salida.put(entrada.getKey(),total);
    }


    return salida;

    /*Map<String,Long> salida=new TreeMap<>();
    for (File fichero:ficherosDirectorio) {
      long tamanyoFicheroActual=fichero.length();
      String extensionFicheroActual=FilenameUtils.getExtension(fichero.getName());
      if(!salida.containsKey(extensionFicheroActual)){
        salida.put(extensionFicheroActual,tamanyoFicheroActual);
      } else {
        long tamanyoAnterior=salida.get(extensionFicheroActual);
        salida.put(extensionFicheroActual,tamanyoAnterior+tamanyoFicheroActual);
      }
    }
    return salida;*/
  }
  public String elUltimo(){
    String salida="";
    for (Map.Entry<String,List<File>> entrada:ficherosExtension.entrySet()) {
      salida+=entrada.getKey()+": ";
      for (File f:entrada.getValue()) {
        salida+=f.getName()+" ";
      }
      salida+="\n";
    }


    return salida;
  }
}
