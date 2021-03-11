package Excepciones;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CheckedException {
  public static void main(String[] args)  {
    try {
      leerFichero();
    } catch (IOException ioe){
      System.out.println("Fichero no está");
    }
    try {
      leerFichero();
    } catch (Exception e){
      System.out.println("Fichero no está");
    }

    try{
      leerFichero();
    } catch (Exception e){
    }
    int[] vector={1,2,3,4,5};
    int indice=0;
    try{
      while(true){
        System.out.println(vector[indice++]);
      }
    }  catch (ArrayIndexOutOfBoundsException aiobe){

    }
  }

  private static void leerFichero() throws IOException {
    List<String> lista= Files.readAllLines(Paths.get("texto.txt"));
  }
}
