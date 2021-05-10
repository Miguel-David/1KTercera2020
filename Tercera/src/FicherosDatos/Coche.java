package FicherosDatos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class Coche implements Serializable {
  Map<PosicionesRuedas, String> ruedas;
  private final String matricula;

  Coche(String matricula){
    this.matricula = matricula;
    ruedas=new HashMap<>();
    for (PosicionesRuedas p:PosicionesRuedas.values()) {
      ruedas.put(p,"No hay rueda instalada");
    }
  }
  public Coche cambiaRueda(PosicionesRuedas posicionesRuedas,String nuevaRueda){
    System.out.println("Quito la rueda "
            + posicionesRuedas.getDescripcion()
            + " que era: "
            +ruedas.get(posicionesRuedas));
    ruedas.put(posicionesRuedas,nuevaRueda);
    System.out.println("Ahora hay en " + posicionesRuedas.getDescripcion() + " un rueda: " + nuevaRueda);
    return this;
  }
  public String info(){
    String salida= "El coche: " + matricula + " tiene las siguientes ruedas:";
    for (Map.Entry<PosicionesRuedas,String> entrada:ruedas.entrySet()
         ) {
      salida+="\n     "+entrada.getKey().getDescripcion()+" - "+entrada.getValue();
    }
    return salida;
  }
}
enum PosicionesRuedas{
  DI("Delantera Izquierda"),
  DD("Delantera Derecha"),
  TI("Trasera Izquierda"),
  TD("Trasera Derecha");


  private final String descripcion;

  PosicionesRuedas(String s) {
    this.descripcion =s;
  }

  public String getDescripcion() {
    return descripcion;
  }
}
