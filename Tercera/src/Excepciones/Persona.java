package Excepciones;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
public class Persona {

  private static final Logger logger = Logger.getLogger("Excepciones.Persona");
  /*
  El nombre de la persona solo tendrá letras
  la edad estará entre 0 y 140 años
  el NIF serán 7 u 8 dígitos y una letra
   */
  static {
    FileHandler fileTxt = null;
    try {
      fileTxt = new FileHandler("LogPersona.txt",true);
    } catch (IOException e) {
      System.out.println("La creación del log de Persona no ha funcionado. ¡Míralo!");
    }
    SimpleFormatter formatterTxt = new SimpleFormatter();
    fileTxt.setFormatter(formatterTxt);
    logger.addHandler(fileTxt);
  }
  protected final String nombre;
  private final int edad;
  private final String digitosNIF;
  private final char letraNIF;

  public Persona(String nombre, int edad, String NIF) {
    chequea(nombre,edad,NIF);
    this.nombre = nombre;
    this.edad = edad;
    this.digitosNIF = NIF.substring(0,NIF.length()-2);
    this.letraNIF = NIF.charAt(NIF.length()-1);
    logger.log(Level.INFO,"Se ha creado una persona " +this);
  }

  private void chequea(String nombre, int edad, String nif) {
    for (char c:nombre.toCharArray()) {
      if(!Character.isLetter(c)){
        logger.log(Level.SEVERE,"Se intenta crear una persona con nombre malo: "+nombre);
        throw new IllegalArgumentException("EL NOMBRE SOLO PUEDE TENER LETRAS");
      }
    }
    if(edad<0 || edad>140 ){
      logger.log(Level.SEVERE,"Edad mal al crear "+edad);
      throw  new IllegalArgumentException("EDAD MAL");
    }
    if(nif.length()!=10 && nif.length()!=9){
      logger.log(Level.SEVERE,"Longitud NIF MAL"+nif);
      throw  new IllegalArgumentException("NIF MAL");
    }
    try {
      Integer.parseInt(nif.substring(0, nif.length() - 2));
    } catch (NumberFormatException nfe){
      logger.log(Level.SEVERE,"El NIF tiene letras "+nif);
      throw new IllegalArgumentException("El nif tiene letras");
    }
    if(!Character.isLetter(nif.charAt(nif.length()-1))){
      logger.log(Level.SEVERE,"Letra del NIF MAL "+nif);
      throw new IllegalArgumentException("La letra del nif está mal "+nif);
    }
  }

  public String getNombre() {
    return nombre;
  }

  public int getEdad() {
    return edad;
  }

  public String getNIF() {
    return digitosNIF+"-"+letraNIF;
  }

  @Override
  public String toString() {
    return "Persona{" +
            "nombre='" + nombre + '\'' +
            ", edad=" + edad +
            ", digitosNIF='" + digitosNIF + '\'' +
            ", letraNIF=" + letraNIF +
            '}';
  }
}
