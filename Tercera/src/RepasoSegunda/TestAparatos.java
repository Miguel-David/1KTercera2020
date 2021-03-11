package RepasoSegunda;

import java.util.ArrayList;
import java.util.List;

public class TestAparatos {
  public static void main(String[] args) {
    List<Aparato> lista=new ArrayList<>();
    lista.add(new Zepelin("vfkjdn"));
    lista.add(new Zepelin("vfkjdn"));
    lista.add(new Reactor("vfkjdn"));
    lista.add(new Zepelin("vfkjdn"));

    for (Aparato a:lista) {
      System.out.println(a.encender());
      if(a instanceof Reactor){
        //Reactor r=(Reactor) a; No hace falta porque volar es común. ¡CUIDADO!
        System.out.println(a.volar());
      }
    }
  }
}
