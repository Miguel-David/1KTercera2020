package RepasoSegunda;

import java.util.Arrays;

public class Recortador {
  public static void main(String[] args) {
    int[] ejemplo={8,8,4,4,2,2};
    int[] resultado=recortar(ejemplo,2);
    System.out.println(Arrays.toString(resultado));
  }

  private static int[] recortar(int[] array, int quitar) {
    int[] salida=new int[array.length-quitar];
    for (int i = 0; i < salida.length; i++) {
      salida[i]=array[i];
    }
    return salida;
  }

}
