package recursividad;

public class MCDEuclides {
  public static void main(String[] args) {
    System.out.println(mcd(120, 12));
  }

  private static int mcd(int a, int b) {
      if(b==0) return a;
      else return mcd(b,a%b);
  }
}
