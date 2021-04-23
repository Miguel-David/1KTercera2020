package recursividad;

public class BinarioRecursivo {
  public static void main(String[] args) {
    System.out.println(binario(456));
    //111001001
  }

  private static String binario(int i) {
    if(i==0) return "0";
    if(i==1) return "1";

    int mitad=i/2;
    String resultado="";
    if(i%2==0){
      resultado="0";
    } else resultado="1";
    return binario(mitad)+resultado;
  }
}
