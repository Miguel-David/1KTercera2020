package BoletinIIdeArrayListYExcepciones;

import java.util.ArrayList;
import java.util.List;

public class LlenarArray {
  public static void main(String[] args) {
    List<Integer> lista=new ArrayList<>();
    System.out.println("numero" + "," + "ArrayList"+","+"Array");
    for(int total=100;total<10000000;total+=1000) {
      long startTime = System.nanoTime();
      for (int i = 0; i < total; i++) {
        lista.add(i * i);
      }
      long endTime = System.nanoTime();
      lista.clear();
      long duration = (endTime - startTime);
      int[] miArray=new int[total];
      long startTime2 = System.nanoTime();
      for (int i = 0; i < total; i++) {
        miArray[i]=i*i;
      }
      long endTime2 = System.nanoTime();
      lista.clear();
      long duration2 = (endTime2 - startTime2);



      System.out.println(total + "," + duration+","+duration2);
    }


  }
}
