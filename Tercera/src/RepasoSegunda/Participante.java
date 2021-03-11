package RepasoSegunda;

public class Participante implements Comparable<Participante> {
  final String pais;
  final String participante;
  int puntuacion;

  public Participante(String pais, String participante) {
    this.pais = pais;
    this.participante = participante;
    this.puntuacion=0;
  }

  public String getPais() {
    return pais;
  }

  public String getParticipante() {
    return participante;
  }

  public int getPuntuacion() {
    return puntuacion;
  }
  public void votar(int votos){
    puntuacion+=votos;
  }

  @Override
  public String toString() {
    return pais.toUpperCase()+" con: "+ participante +" " +puntuacion +
            "votos";
  }

  @Override
  public int compareTo(Participante o) {
    if(this.puntuacion!=o.puntuacion){
      return -Integer.compare(this.puntuacion,o.puntuacion); //Primer Criterio
    }
    if(!this.pais.equals(o.pais)){
      return this.pais.compareTo(o.pais);
    }
    return this.participante.compareTo(o.participante);
  }
}
