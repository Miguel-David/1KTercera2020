package Pruebas;

public class Direccion {
  private String nombreVia;
  private int numero;
  private int piso;
  private char puerta;

  public Direccion(String nombreVia, int numero, int piso, char puerta) {
    for (Character c:nombreVia.toCharArray()) {
      if(!Character.isLetter(c)){
        throw new IllegalArgumentException("La via solo puede tener letras");
      }
    }
    this.nombreVia = nombreVia;
    if(numero<=0){
      throw new IllegalArgumentException("El número no puede ser negativo");
    }
    this.numero = numero;

    if(piso<=0){
      throw new IllegalArgumentException("El piso no puede ser negativo");
    }
    this.piso = piso;
    if(!Character.isLetter(puerta)) {
      throw new IllegalArgumentException("La puerta debe ser una letra");
    }
      this.puerta = puerta;
  }

  public String getNombreVia() {
    return nombreVia;
  }

  public void setNombreVia(String nombreVia) {
    this.nombreVia = nombreVia;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getPiso() {
    return piso;
  }

  public void setPiso(int piso) {
    this.piso = piso;
  }

  public char getPuerta() {
    return puerta;
  }

  public void setPuerta(char puerta) {
    this.puerta = puerta;
  }

  @Override
  public String toString() {
    return "Direccion{" +
            "nombreVia='" + nombreVia + '\'' +
            ", numero=" + numero +
            ", piso=" + piso +
            ", puerta=" + puerta +
            '}';
  }
}
