package pruebastorneo;

import java.util.List;
import java.util.regex.Pattern;

public class Ronda {
  Partido[] partidos;

  public Ronda(Ronda siguiente) {
    if(siguiente==null){
      this.partidos=new Partido[1];
      this.partidos[0]=new Final();
    } else {
      this.partidos = new Partido[siguiente.getPartidos().length*2];
      for (int i = 0; i < this.partidos.length; i++) {
        this.partidos[i]=new Partido(siguiente.getPartidos()[i/2]);
      }
    }
  }
  public void rellena(List<String> nombres){
    int indiceLista=0;
    for (int i = 0; i < partidos.length; i++) {
      partidos[i].ponJugador(nombres.get(indiceLista));
      indiceLista++;
      partidos[i].ponJugador(nombres.get(indiceLista));
      indiceLista++;
    }
  }

  public Partido[] getPartidos() {
    return partidos;
  }
}
