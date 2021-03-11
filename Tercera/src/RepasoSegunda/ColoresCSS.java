package RepasoSegunda;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ColoresCSS {
  public static void main(String[] args) {
    Map<String,String> colores=new HashMap<>();
    colores.put("azul","\"#0000FF\"");
    colores.put("azul otro","\"#0000EE\"");
    colores.put("azul mas","\"#000088\"");
    colores.put("azul menos","\"#000044\"");
    colores.put("azul cielo","\"#000000\"");

    Iterator<Map.Entry<String,String>> it =colores.entrySet().iterator();
    while(it.hasNext()){
      Map.Entry<String,String> actual=it.next();
      System.out.println(actual.getKey() + ":" + actual.getValue());
    }
  }
}
