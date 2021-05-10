package FicherosDatos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaCoches implements Serializable {
  private List<Coche> lista;

  public ListaCoches() {
    this.lista = new ArrayList<>();
  }
  public ListaCoches anyadeCoche(Coche c){
    lista.add(c);
    return this;
  }
}
