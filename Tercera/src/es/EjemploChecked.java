package es;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EjemploChecked {
  public static void main(String[] args) {
    //Esta es checked
    leefichero();

  }

  private static void leefichero() {
    try {
      System.out.println("Voy a leer el fichero");
      String p=null;
      int[] array=new int[-4];
      p.endsWith("te"); //unchecked
      List<String> lineas= Files.readAllLines(Paths.get("texto,txt"));
      System.out.println("He leido el fichero");
    }

    catch (IOException | NullPointerException e) {
      System.out.println("No existe el fichero");
      System.out.println("fulanico");
      return;
    } catch (Exception e){
      System.out.println("Algo malo ha pasado");
      e.printStackTrace();
    }
    finally {
      System.out.println("Siempre me ejecuto");
    }

  }
}
