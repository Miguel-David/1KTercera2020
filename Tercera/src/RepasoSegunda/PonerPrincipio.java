package RepasoSegunda;

import java.util.Arrays;

public class PonerPrincipio {
  public static void main(String[] args) {
    int[] ejemplo={8,8,4,4,2,2};
    int[] resultado=ponerPrincipio(ejemplo,7);
    System.out.println(Arrays.toString(resultado));


  }

  private static int[] ponerPrincipio(int[] array, int numero) {
    int[] salida=new int[array.length+1];
    salida[0]=numero;
    for (int i = 0; i < array.length; i++) {
      salida[i+1]=array[i];
    }
    return salida;
  }
}
