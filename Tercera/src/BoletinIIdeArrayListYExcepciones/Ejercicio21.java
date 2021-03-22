package BoletinIIdeArrayListYExcepciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ejercicio21 {
  /*. Escriba un método que recibe 2 listas de letras, cada una ordenada,
  y devuelve una
lista que combina ambas respetando el orden
     ‘a’, ‘e’, ‘i’, ‘o’, ‘u’ ]
[ ‘d’, ‘m’, ‘y’, ‘z’ ]
[ ‘a’, ‘d’, ‘e’, ‘i’, ‘m’, ‘o’, ‘u’, ‘y’, ‘z’ ]
   */

  public static void main(String[] args) {
    List<Character> primera= Arrays.asList('a', 'e', 'i', 'o', 'u') ;
    List<Character> segunda= Arrays.asList('d', 'm', 'y', 'z') ;
    List<Character> solucion=new ArrayList<>();
    solucion.addAll(primera); //O(n)
    solucion.addAll(segunda); //O(n)
    solucion.sort((o1, o2) -> o1.compareTo(o2)); //O(nlogn)
    //Se puede hacer en O(n)
    System.out.println(solucion);
    int punteroPrimera=0;
    int punteroSegunda=0;
    solucion.clear();
    while(punteroPrimera<primera.size() && punteroSegunda<segunda.size()){
      if(primera.get(punteroPrimera)<segunda.get(punteroSegunda)){
        solucion.add(primera.get(punteroPrimera++));
      } else {
        solucion.add(segunda.get(punteroSegunda++));
      }
    }
    System.out.println(punteroPrimera);
    System.out.println(punteroSegunda);
    System.out.println(solucion);
    if(punteroPrimera<primera.size()){
      solucion.addAll(primera.subList(punteroPrimera,primera.size())); //O(n)
    }
    if(punteroSegunda<segunda.size()){
      solucion.addAll(segunda.subList(punteroSegunda,segunda.size())); //O(n)
    }
    System.out.println(solucion);
  }

}
