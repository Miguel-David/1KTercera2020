package BoletinIIdeArrayListYExcepciones;

import javax.swing.*;
import java.util.Calendar;

public class FechaNacimiento {
  //TODO ESTO DE AQUÍ ESTÁ MAL. DEBEMOS USAR LAS FECHAS INCORPORADAS EN JAVA
  protected final int dia;
  protected final int mes;
  protected final int anyo;

  public int getDia() {
    return dia;
  }

  public int getMes() {
    return mes;
  }

  public int getAnyo() {
    return anyo;
  }

  public FechaNacimiento(int dia, int mes, int anyo) throws Exception {
    //INTENTAMOS CREAR UNA FECHA CON ESE DIA, MES Y ANYO
    compruebaLimites(dia,0,31,"Día");
    compruebaLimites(mes,0,12,"Mes");
    Calendar cal= Calendar.getInstance();
    int year= cal.get(Calendar.YEAR);
    compruebaLimites(anyo,-7000,year,"Año");
    this.dia = dia;
    this.mes = mes;
    this.anyo = anyo;
  }

  public FechaNacimiento(String fechaCadena) throws Exception {
    String[] campos=fechaCadena.split("/");
    int dia= 0;
    int mes= 0;
    int anyo= 0;
    try {
      dia = Integer.parseInt(campos[0]);
      mes = Integer.parseInt(campos[1]);
      anyo = Integer.parseInt(campos[2]);
    } catch (NumberFormatException e) {
      throw new Exception("Error al conseguir los enteros de la fecha");
    }
    compruebaLimites(dia,0,31,"Día");
    compruebaLimites(mes,0,12,"Mes");
    Calendar cal= Calendar.getInstance();
    int year= cal.get(Calendar.YEAR);
    compruebaLimites(anyo,-7000,year,"Año");
    this.dia = dia;
    this.mes = mes;
    this.anyo = anyo;
  }
  public String cadenaFecha(){
    return dia+" de "+MESES.values()[mes+1].toString().toLowerCase()+" de "+anyo;
  }

  private void compruebaLimites(int campo,int limInferior,int limSuperior,String mensaje) throws Exception {
    if(campo<=limInferior || campo >limSuperior){
      throw new Exception("Error en el límite de: "+mensaje+ " limites:"+limInferior+" y "+limSuperior);
    }
  }

  enum MESES{
    //SOLO EN ESTE CASO QUE NUNCA CAMBIARÁN LOS MESES NI ELORDEN,
    //APROVECHAMOS EL NÚMERO DE ORDEN DEL ARRAY
    ENERO,
    FEBRERO,
    MARZO,
    ABRIL,
    MAYO,
    JUNIO,
    JULIO,
    AGOSTO,
    SEPTIEMBRE,
    OCTUBRE,
    NOVIEMBRE,
    DICIEMBRE;
  }

  public static void main(String[] args) throws Exception {
    FechaNacimiento f=new FechaNacimiento("21/03/2001");
    System.out.println(f.cadenaFecha());
  }

}
