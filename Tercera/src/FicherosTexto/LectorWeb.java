package FicherosTexto;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class LectorWeb {
  public static void main(String[] args) throws MalformedURLException {
    URL url=new URL("https://elmundo.es/");

    try(
            BufferedReader lector=
                    new BufferedReader(
                            new InputStreamReader(
                                    url.openStream()))){
      String linea;
      while((linea=lector.readLine())!=null){
        if(linea.contains("<h2")) System.out.println(linea);
      }

    } catch (Exception e){
      e.printStackTrace();
    }
  }
}
