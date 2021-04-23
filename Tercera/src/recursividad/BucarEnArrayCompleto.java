package recursividad;

public class BucarEnArrayCompleto {
  //Tenemos un array con números ordenados
  //Queremos saber si un numero dado está en el array
  //Buscamos galápago
  public static void main(String[] args) {
    int[] numeros={2,4,6,8,10,12,14,16,18};
    System.out.println(esta(numeros, 4, 0, numeros.length));
  }

  private static boolean esta(int[] numeros, int buscado,int izquierda,int derecha) {
    System.out.println(izquierda + " - " + derecha);
    if(izquierda>=derecha) return false;
    int objetivo=(izquierda+derecha)/2;
    if(numeros[objetivo]==buscado) return true;
    else {
      if(numeros[objetivo]>buscado){
        esta(numeros,buscado,izquierda,objetivo-1);
      } else {
        esta(numeros,buscado,objetivo+1,derecha);
      }
    }
    return false;
  }
}
