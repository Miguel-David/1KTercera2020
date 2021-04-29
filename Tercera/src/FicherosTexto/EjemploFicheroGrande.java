package FicherosTexto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EjemploFicheroGrande {
  public static void main(String[] args) {
    File fichero = null;
    FileReader fr = null;
    try {
      fichero = new File("Jugadores.txt");
      fr = new FileReader(fichero);

      BufferedReader reader = new BufferedReader(fr);

      String linea;
      while((linea=reader.readLine())!= null){
        //Tratamiento de cada linea por separado
        System. out.println("Linea: " + linea);
      }
      reader.close();
      fr.close();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (null != fr) {
          fr.close();
        }
      } catch (Exception e2) {
        e2.printStackTrace();
      }

    }
  }
}
