package RepasoSegunda;

import java.util.Comparator;

public enum Comparadores {
  POR_NOMBRE_PAIS("Ordenado por nombre", new Comparator<Participante>() {
    @Override
    public int compare(Participante o1, Participante o2) {
      if(!o1.pais.equals(o2.pais)){
        return o1.pais.compareTo(o2.pais); //Primer Criterio
      }
        if(o1.puntuacion!=o2.puntuacion){
          return -Integer.compare(o1.puntuacion,o2.puntuacion);
        }

        return o1.participante.compareTo(o2.participante);
      }
  }),
  POR_NOMBRE_PARTICIPANTE("Ordenado por participante", new Comparator<Participante>() {
    @Override
    public int compare(Participante o1, Participante o2) {
      if(!o1.participante.equals(o2.participante)){
        return o1.participante.compareTo(o2.participante); //Primer Criterio
      }
      if(!o1.pais.equals(o2.pais)){
        return o1.pais.compareTo(o2.pais); //Primer Criterio
      }
      return -Integer.compare(o1.puntuacion,o2.puntuacion);
    }

  });

  String titulo;
  Comparator<Participante> comparator;

  Comparadores(String titulo, Comparator<Participante> comparator) {
    this.titulo = titulo;
    this.comparator = comparator;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public Comparator<Participante> getComparator() {
    return comparator;
  }

  public void setComparator(Comparator<Participante> comparator) {
    this.comparator = comparator;
  }
}
