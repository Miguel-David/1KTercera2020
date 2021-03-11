package RepasoSegunda;

import java.util.Arrays;

public class GalaEurovision {
  public static void main(String[] args) {
    Participante[] participantes=new Participante[5];
    participantes[0]=new Participante("España","Chiquilicuatre");
    participantes[1]=new Participante("UK","Tom Jones");
    participantes[2]=new Participante("Germany","DasBoot");
    participantes[3]=new Participante("Italia","Adriano Chelentano");
    participantes[4]=new Participante("Francia","Ratatuille");

    participantes[0].votar(5);
    participantes[3].votar(8);

    Arrays.sort(participantes);
    for (Participante p:participantes) {
      System.out.println(p);
    }
    System.out.println("--------"+Comparadores.POR_NOMBRE_PAIS.getTitulo()+"----------");
    //Arrays.sort(participantes,);
    Arrays.sort(participantes,Comparadores.POR_NOMBRE_PAIS.getComparator());
    for (Participante p:participantes) {
      System.out.println(p);
    }
    System.out.println("-----------"+Comparadores.POR_NOMBRE_PARTICIPANTE.getTitulo()+"-------");
    Arrays.sort(participantes,Comparadores.POR_NOMBRE_PARTICIPANTE.getComparator());
    for (Participante p:participantes) {
      System.out.println(p);
    }
    System.out.println("----------------------Con funcion anónima-------");
    Arrays.sort(participantes,(o1,o2)->o1.pais.compareTo(o2.pais));
    for (Participante p:participantes) {
      System.out.println(p);
    }
    String[] nombres={"Álvaro","Sonia","Ana"};
    Arrays.sort(nombres);
    for (String s:nombres) {
      System.out.println(s);
    }
  }
}
