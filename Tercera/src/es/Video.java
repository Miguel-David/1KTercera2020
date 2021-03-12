package es;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

public class Video implements Comparable<Video>{

  public static final Logger log=Logger.getLogger("Video");


  static{
    FileHandler fichero= null;
    try {
      fichero = new FileHandler("video.txt",true);
    } catch (IOException e) {
      System.out.println("EL SISTEMA DE LOG DE VIDEO NO SE INICIALIZÓ");
    }
    SimpleFormatter formatoSimple=new SimpleFormatter();
    fichero.setFormatter(formatoSimple);
    log.addHandler(fichero);
    log.setUseParentHandlers(false);

    //Inicialización del log
    log.log(Level.INFO,"Comenzamos con los vídeos");
  }

  protected final String url;
  private final int duracion;
  private int visualizaciones;

  public Video(String url, int duracion) {
    chequeaParametros(url,duracion);
    this.url = url;
    this.duracion = duracion;
    visualizaciones=0;
    log.log(Level.INFO,"Se ha creado un vídeo "+this);
  }

  private void chequeaParametros(String url, int duracion) {
    if(!url.startsWith("https://www.youtube.com/watch?v=")){
      log.log(Level.WARNING,"Han intentado crear un video con URL falsa: "+url+" también intentas una duración de "+duracion);
      throw new IllegalArgumentException("LA URL no es de Youtube. ¡CUIDADO!");
    }
    if(duracion<0){
      log.log(Level.WARNING,"Han intentado crear un video con duración negativa: "+url+" también intentas una duración de "+duracion);
      throw new IllegalArgumentException("La duración debe ser positiva");
    }

  }

  public String getUrl() {
    return url;
  }

  public String getDuracion() {
    return ""+duracion/60+":"+duracion%60;
  }

  public int getVisualizaciones() {
    return visualizaciones;
  }

  public void visualizado(){
    visualizaciones++;
  }


  public String info() {
    return  url +" dura: " + getDuracion() +
            " y tiene "+visualizaciones+ " visualizaciones";
  }

  public void setVisualizaciones(int visualizaciones) {
    if(visualizaciones<0){
      throw new IllegalStateException("NO puede haber un vídeo con visualizaciones negativas");
    }
    this.visualizaciones = visualizaciones;
  }

  @Override
  public String toString() {
    return "Video{" +
            "url='" + url + '\'' +
            ", duracion=" + duracion +
            ", visualizaciones=" + visualizaciones +
            '}';
  }

  @Override
  public int compareTo(Video o) {
    if(this.visualizaciones==o.visualizaciones){
      return Integer.compare(this.duracion,o.duracion);
    }
    return Integer.compare(this.visualizaciones,o.visualizaciones);
  }
}

