package BoletinIIdeArrayListYExcepciones;

public class Persona {
  protected final String nombre;
  protected final FechaNacimiento nacimiento;

  public String getNombre() {
    return nombre;
  }

  public String getFechaNacimiento(){
    return this.nacimiento.cadenaFecha();
  }

  public int getDiaNacimiento(){
    return this.nacimiento.getDia();
  }
  public int getMesNacimiento(){
    return this.nacimiento.getMes();
  }
  public int getAnyoNacimiento(){
    return this.nacimiento.getAnyo();
  }

  public Persona(String nombre, String fecha) throws Exception {
    if(nombre==null || "".equals(nombre)){
      throw new Exception("El nombre debe contener algo");
    }
    this.nombre = nombre;
    this.nacimiento = new FechaNacimiento(fecha);
  }
  public Persona(String nombre, int dia, int mes,int anyo) throws Exception {
    this(nombre,""+dia+"/"+mes+"/"+anyo);
  }
}
