package es;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.*;

public class YouTubeKids {
  public static void main(String[] args) throws IOException {
    List<String> lineas=new ArrayList<>();
    String nombreFichero="video.csv";
    Scanner sc=new Scanner(System.in);
    while(lineas.size()<2) {
      try {
        lineas = Files.readAllLines(Paths.get(nombreFichero));
      } catch (NoSuchFileException nsfe){
        System.out.println("Inténtalo otra vez con otro fichero, "+nombreFichero+" no existe");
        nombreFichero=sc.nextLine();
      } catch (IOException ioe) {
        ioe.printStackTrace();
        throw ioe;
      }
    }
    lineas.remove(0);
    Set<Video> miLista=new TreeSet<>(); //No ordena porque se cambian las visualizaciones después.



      for (String s:lineas) {
        String[] campos=s.split(",");
        if(campos.length==1){
          System.out.println("Línea sin suficientes campos:\"" + s + "\"");
          continue;
        }

        Video nuevo=null;
        try {
          nuevo = new Video(campos[0], Integer.parseInt(campos[1]));
          if(campos.length==3){
            nuevo.setVisualizaciones(Integer.parseInt(campos[2]));
          }
          miLista.add(nuevo);

        } catch (NumberFormatException nfe){
          System.out.println("Duración mal. Pasamos de ese vídeo");
          continue;
        } catch (IllegalArgumentException iae){
          System.out.println(iae.getMessage());
        }




      }

    //Leido el fichero
    Iterator<Video> it= miLista.iterator();
    while(it.hasNext()){
      System.out.println(it.next().info());
    }
  }
}
