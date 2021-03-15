package BoletinIIdeArrayListYExcepciones;

public class TercerEjercicio {
  /*
  Escriba una excepción propia ME1 que deriva de Exception. Escriba una excepción
ME2 propia que deriva de ME1. Escriba un bloque try que captura de forma
diferenciada
a. NullPointerException
b. otras RunTimeException
c. ME1 y ME2
d. otras Exception

   */
  public static void main(String[] args) {
    //Leyendo de Internet los movimientos de los enemigos en el LoL
    //Si el lag es >120ms PROBLEMA->Vas a perder
    try {
      double lag = 160.45;
      if (lag > 120) {
        throw new ME1();
      }
    }
    catch (NullPointerException n){

    }
    catch (RuntimeException r){

    }
    catch (ME2 me2){
      System.out.println("RE");
    }
     catch (ME1 m){
      System.out.println("PEPE");
    }
    catch (Exception e){
      }

  }
}

class ME1 extends Exception{

}
class ME2 extends ME1{

}