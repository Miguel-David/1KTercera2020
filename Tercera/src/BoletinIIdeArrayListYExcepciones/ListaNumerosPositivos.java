package BoletinIIdeArrayListYExcepciones;

import java.util.ArrayList;
import java.util.List;

public class ListaNumerosPositivos {
  public static void main(String[] args) {
    List<Integer> listaNumeros = new ArrayList<>();
    int numeros = 101;
    for (int i = 0; i < numeros; i++) {
      listaNumeros.add(i * i);
    }

      System.out.println(listaNumeros);

  }
}
