package RepasoSegunda;

import java.util.Arrays;
import java.util.List;

public class OrdenacionNatural {
  public static void main(String[] args) {
    int[] array={3,5,2,24,54,56,7,3,23,32,43,3,32};
    Arrays.sort(array);
    for (int i:array) {
      System.out.println(i);
    }
    for(int j:array) {
      System.out.println(j);
    }
    System.out.println("---------------------------");
    
    List<Integer> lista=Arrays.asList(8,2,4,67,2,5,7,8,5);
    Arrays.stream(lista.toArray()).sorted().forEach(System.out::println);

  }
}
