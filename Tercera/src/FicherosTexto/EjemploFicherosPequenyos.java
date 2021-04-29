package FicherosTexto;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EjemploFicherosPequenyos {
  //A partir de un fichero de nombres,
  // Escribir otro con los nombres en mayúsculas

  public static void main(String[] args) throws IOException {
    //leo fichero en lista de Strings
    List<String> lineas= Files.readAllLines(Paths.get("Jugadores.txt"), StandardCharsets.UTF_8);

    //Hago cosicas, lo que pida el ejercicio
    List<String> lineasNuevas=new ArrayList<>();
    for (String s:lineas) {
      if(!s.contains("r")) lineasNuevas.add(s);
    }

    //escribo lista de Strings en fichero
    Files.write(Paths.get("JugadoresMAYUS.txt"),lineasNuevas,StandardCharsets.UTF_8);
  }
}
