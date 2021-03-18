package es.domino.rrhh.calculadora;

import javax.swing.*;

public abstract class Operacion {
  int operando1;
  String etiqueta;
  JButton boton;
  TipoOperacion tipo;

  public Operacion(String etiqueta,TipoOperacion tipo) {
    this.etiqueta = etiqueta;
    this.boton=new JButton(etiqueta);
    this.tipo=tipo;
  }

  public TipoOperacion getTipo() {
    return tipo;
  }

  public abstract int operar();

}

abstract class OperacionUnitaria extends Operacion{
  public OperacionUnitaria(String etiqueta,TipoOperacion tipoOperacion) {
    super(etiqueta,tipoOperacion);
  }
}

abstract class OperacionBinaria extends Operacion{
  int operando2;

  public OperacionBinaria(String etiqueta,TipoOperacion tipoOperacion) {
    super(etiqueta,tipoOperacion);
    this.operando2 = operando2;
  }
}