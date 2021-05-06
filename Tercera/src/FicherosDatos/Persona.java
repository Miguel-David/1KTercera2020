package FicherosDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Persona {
  protected final String nia;
  protected String nombre;
  protected byte edad;
  protected short altura;
  protected short peso;
  protected final List<String> amigos;


  public Persona(String nombre, byte edad, short altura, short peso, String nia) {
    this.nombre = nombre;
    this.edad = edad;
    this.altura = altura;
    this.peso = peso;
    this.nia = nia;
    amigos=new ArrayList<>();
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public byte getEdad() {
    return edad;
  }

  public void setEdad(byte edad) {
    this.edad = edad;
  }

  public short getAltura() {
    return altura;
  }

  public void setAltura(short altura) {
    this.altura = altura;
  }

  public short getPeso() {
    return peso;
  }

  public void setPeso(short peso) {
    this.peso = peso;
  }

  public String getNia() {
    return nia;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Persona persona = (Persona) o;
    return nia.equals(persona.nia);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nia);
  }

  @Override
  public String toString() {
    String salida= "Persona{" +
            "nombre='" + nombre + '\'' +
            ", edad=" + edad +
            ", altura=" + altura +
            ", peso=" + peso +
            ", nia='" + nia + '\'' +"\n";
    for (String s:amigos) {
      salida+="    "+s+"\n";
    }
    return salida;
  }

  public String info(){
    return nia.toUpperCase()+" - "+nombre;
  }

  public List<String> getAmigos() {
    List<String> salida=new ArrayList<>(amigos);
    return salida;
  }

  public Persona anyadeAmigo(String amigo){
    amigos.add(amigo);
    return this;
  }

}
