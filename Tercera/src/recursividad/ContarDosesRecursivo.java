package recursividad;

public class ContarDosesRecursivo {
  //Caso Base: Si el string es "2", devuelve 1, sino, devuelve 0
  //Caso recursivo: Si el primer caracter es '2', 1+los doses del resto
  //Si el primer caracter no es un 2, 0+los doses del resto
  public static void main(String[] args) {
    System.out.println(calculaDoses("22ttt222tt22t2t2t2hh2"));
  }

  private static int calculaDoses(String s) {
    if(s.length()==1){
      if(s.equals("2")) return 1;
      else return 0;
    }
    char primero=s.charAt(0);
    String resto=s.substring(1);
    if(primero=='2') return 1+calculaDoses(resto);
    else return 0+calculaDoses(resto);
  }
}
