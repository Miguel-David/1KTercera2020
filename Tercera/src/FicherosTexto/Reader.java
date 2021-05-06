package FicherosTexto;



import java.io.*;

public class Reader {
  public static void main(String[] args) throws IOException {
    File fichero;
    fichero = new File("Jugadores.txt");
    try (BufferedReader br= new BufferedReader(new FileReader(fichero)))
    {
      for (int i = 0; i < 5; i++) {
        String linea = br.readLine();
        if (linea != null) {
          System.out.println(linea);
        }
      }
    }
  }
}
