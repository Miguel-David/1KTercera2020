package RepasoSegunda;

import java.util.*;

public class OGrande {
  public static void main(String[] args) {
    int[] array={4,3,5,5,3,23,4,4,54,32,432,431,123,7};
    int maximo=Integer.MIN_VALUE;
    for (int i = 0; i < array.length; i++) {
      if(array[i]>maximo){
        maximo=array[i];
      }
    }
    System.out.println(maximo);
    int maximoP=Integer.MIN_VALUE;
    for (int i = 0; i < array.length; i+=2) {
      if(array[i]>maximoP){
        maximoP=array[i];
      }
    }

    ///
    Arrays.sort(array); //nlogn
    System.out.println(array[array.length - 1]);

    //
    List<Integer> lista=new ArrayList<>();
    Set<Integer> conjunto=new HashSet<>();
    //Pongo tropecientos números en ambos
    int num=45;
    if(!lista.contains(45)) System.out.println("NO Está"); //O(n)
    if(!conjunto.contains(45)) System.out.println("No Está"); //O(1)

    //Está ordenado del mayor al menor

/*
20 -->20 segundos
40 -->40 segundos
80 -->80 segundos
log base 2 tamaño
4 palabras --> 2 veces 00 01 10 11
256 -------------> 8 veces
1024           --> 10 veces
4096 12 veces
8192 13 veces
 */
  }
}
