package BoletinIIdeArrayListYExcepciones;

import java.util.ArrayList;
import java.util.List;

public class ListaPersonas {
  List<Persona> lista;

  public ListaPersonas() {
    this.lista = new ArrayList<>();
  }
  public void anyadePersona(Persona p){
    lista.add(p);
  }

}
