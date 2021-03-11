package Excepciones;

public class PruebaExcepcion {
  static   int[] array={2,3,4,5,7};
  public static void main(String[] args) {
    System.out.println(consultar(3)); //checked y unchecked
  }
  public static String consultar(int n){
    try {
      String salida="";
      salida+="El número es "+array[n];
      System.out.println("vkjdfnsl");
      System.out.println("vkjdfnsl");
      System.out.println("vkjdfnsl");
      return salida;
    } catch(Exception e){
      System.out.println("El número se sale del array");
    } finally{
      System.out.println("SIempre estoy ahí");
    }
    return "No está en el array";
  }
}
