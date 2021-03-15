package BoletinIIdeArrayListYExcepciones;

public class PrimerEjercicio {
  /*
  Crear un método que:
  a. lanza una Excepción dentro de un bloque try, pasándole un texto
  b. capture la Excepción e imprima el mensaje
  c. añada un finally e imprima un mensaje para demostrar que se ha ejecutado

   */
  public static void main(String[] args) {
    metodoExcepciones();
  }

  private static void metodoExcepciones() {
    try{
      throw new IllegalStateException("Error provocado");

    } catch (IllegalStateException e){
      System.out.println(e.getMessage());
    } finally {
      System.out.println("Siempre paso por aquí");
    }
  }

}
