package RepasoSegunda;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EjercicioMapa {
  public static void main(String[] args) {
    Map<String,String> ciudades=new HashMap<>();
    ciudades.put("Madrid","España");
    ciudades.put("Murcia","Levante");
    ciudades.put("Elche","Comunidad Valenciana");
    ciudades.put("París","Francia");
    ciudades.put("Berlín","Unión Europea");

    Iterator<Map.Entry<String,String>> it=ciudades.entrySet().iterator();
    while(it.hasNext()){
      Map.Entry<String,String> entrada=it.next();
      System.out.println(entrada.getKey() + " es capital de " + entrada.getValue());
    }
  }
}
