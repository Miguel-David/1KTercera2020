package recursividad;

public class FactorialRecursivo {
  //El factorial de 1 es 1
  //El factorial de n es n*factorial(n-1)
  public static void main(String[] args) {
    System.out.println(factorial(7));
  }

  private static int factorial(int i) {
    if(i==1) return 1;
    return i*factorial(i-1);
  }
}
