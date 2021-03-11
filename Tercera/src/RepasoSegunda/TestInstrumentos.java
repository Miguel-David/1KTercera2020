package RepasoSegunda;

import java.util.ArrayList;
import java.util.List;

public class TestInstrumentos {
  public static void main(String[] args) {
    List<Instrumentos> lista=new ArrayList<>();
    lista.add(new Guitarra("ere"));
    lista.add(new Guitarra("mere"));
    lista.add(new Guitarra("tere"));
    lista.add(new Trompeta("pere"));

    for (Instrumentos i:lista) {
      System.out.println(i.afinar());
      if(i instanceof Guitarra){
        System.out.println(i.hacerSonar());
      }
    }

  }
}
