package Excepciones;

public class TemperaturaLocalidadDiaria {
  String localidad;
  double maxima;
  double minima;

  public TemperaturaLocalidadDiaria(String localidad, double maxima, double minima) {
    //Forma correcta de comprobar null en String

    if(localidad==null  || "".equals(localidad)){
      throw new IllegalArgumentException("ERROR EN LOCALIDAD");
    }
    this.localidad = localidad;
    if(minima>maxima){
      throw new IllegalArgumentException("ERROR EN TEMPERATURAS");
    }
    this.maxima = maxima;
    this.minima = minima;
  }

  public static void main(String[] args) {
    TemperaturaLocalidadDiaria t=new TemperaturaLocalidadDiaria(null,5,7);
  }
}
