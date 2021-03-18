package es.domino.rrhh.calculadora;

import java.util.ArrayList;
import java.util.List;

public class OperacionesDisponibles {
  static List<Operacion> listaOperaciones=new ArrayList<>();
  static {
    listaOperaciones.add(new OperacionUnitaria("+/-",TipoOperacion.ARITMÉTICAS) {
      @Override
      public int operar() {
        return operando1*-1;
      }
    });
    listaOperaciones.add(new OperacionUnitaria("x^2",TipoOperacion.ARITMÉTICAS) {
      @Override
      public int operar() {
        return operando1*operando1;
      }
    });
    listaOperaciones.add(new OperacionUnitaria("PIII",TipoOperacion.ARITMÉTICAS) {
      @Override
      public int operar() {
        return 314159;
      }
    });
    listaOperaciones.add(new OperacionUnitaria("a Binario",TipoOperacion.RARAS) {
      @Override
      public int operar() {
        return Integer.parseInt(Integer.toBinaryString(operando1));
      }
    });
    listaOperaciones.add(new OperacionBinaria("+",TipoOperacion.DIFÍCILES) {
      @Override
      public int operar() {
        return operando1+operando2;
      }
    });
    listaOperaciones.add(new OperacionBinaria("-",TipoOperacion.CONVERSIÓN) {
      @Override
      public int operar() {
        return operando1-operando2;
      }
    });
    listaOperaciones.add(new OperacionBinaria("*",TipoOperacion.ESPECIALES) {
      @Override
      public int operar() {
        return operando1*operando2;
      }
    });
    listaOperaciones.add(new OperacionBinaria("/",TipoOperacion.CONVERSIÓN) {
      @Override
      public int operar() {
        return operando1/operando2;
      }
    });
    listaOperaciones.add(new OperacionBinaria("%",TipoOperacion.ESPECIALES) {
      @Override
      public int operar() {
        return operando1%operando2;
      }
    });
    listaOperaciones.add(new OperacionBinaria("+",TipoOperacion.DIFÍCILES) {
      @Override
      public int operar() {
        return operando1+operando2;
      }
    });
    listaOperaciones.add(new OperacionBinaria("x^y",TipoOperacion.ESPECIALES) {
      @Override
      public int operar() {
        return (int) Math.floor(Math.pow(operando1,operando2));
      }
    });
    listaOperaciones.add(new OperacionUnitaria("Mb->Kb",TipoOperacion.ARITMÉTICAS) {
      @Override
      public int operar() {
        return operando1*1024;
      }
    });
    listaOperaciones.add(new OperacionUnitaria("libras a kg",TipoOperacion.DIFÍCILES) {
      @Override
      public int operar() {
        return (int) (operando1*0.45);
      }
    });
  }
}
