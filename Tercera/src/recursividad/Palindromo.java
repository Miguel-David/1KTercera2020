package recursividad;

public class Palindromo {
  //dabalearrozalazorraelabad
  //Si es "" o una sola letra, es palíndromo
  //Si las de los extremos son iguales
  // y el resto es palíndromo, es palíndromo
  public static void main(String[] args) {
    System.out.println(esPalindromo("dabalearrozalazorraelabad"));
    System.out.println(esPalindromo("pericorep"));

  }

  private static boolean esPalindromo(String cadena) {
    if("".equals(cadena) || cadena.length()==1){
      return true;
    } else {
      char primera,ultima;
      primera=cadena.charAt(0);
      ultima=cadena.charAt(cadena.length()-1);
      String lodeEnmedio=cadena.substring(1,cadena.length()-1);
      System.out.println(primera + " " + ultima + " - " + lodeEnmedio);
      return primera==ultima && esPalindromo(lodeEnmedio);
    }
  }

}
