package BoletinIIdeArrayListYExcepciones;

public class SegundoEjercicio {
  public static void main(String[] args) {
    try {
      throw new MiExcepcion("ERROR", "Lo que ha pasado es que ....");
    } catch (MiExcepcion miExcepcion) {
      System.out.println(miExcepcion.getMessage() + " Profundizando más: " + miExcepcion.getExplicacionLarga());
    }
  }
}

class MiExcepcion extends Exception{
  String explicacionLarga;
  MiExcepcion(String corta,String larga){
    super(corta);
    explicacionLarga=larga;
  }

  public String getExplicacionLarga() {
    return explicacionLarga;
  }
}
