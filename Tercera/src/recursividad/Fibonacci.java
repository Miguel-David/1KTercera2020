package recursividad;

public class Fibonacci {
  //Sucesión de fibonacci
  //nº1 -->1
  //nº2 -->1
  //....
  //nºn -->(nºn-1)+(nºn-2)

  public static void main(String[] args) {
    int numeroNumeros=701408733;
    int n1=1;
    int n2=1;
    System.out.println(n1);
    System.out.println(n2);
    int numerosImprimidos=2;
    int nuevoNumero=0;
    while(nuevoNumero<numeroNumeros){
      System.out.println(n1 + n2);
      nuevoNumero=n1+n2;
      n1=n2;
      n2=nuevoNumero;
    }
  }
}
