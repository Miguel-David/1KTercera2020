package es.domino.rrhh.calculadora;

import javax.swing.*;
import java.awt.*;

public class Controlador {
  static PanelNumeros pn;
  static PanelOperaciones po;
  private Operacion operacionPendiente=null;

  public void calcular(){
    if(operacionPendiente!=null) {
      OperacionBinaria ob = (OperacionBinaria) operacionPendiente;
      ob.operando2 = pn.getValor();
      pn.setValor(operacionPendiente.operar());

    }
  }

  public static void main(String[] args) {
    Controlador controlador=new Controlador();
    JFrame prueba=new JFrame("Prueba");
    pn=new PanelNumeros(controlador);
    po=new PanelOperaciones(controlador);
    prueba.setLayout(new GridLayout(0,2));
    prueba.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    prueba.add(pn.getPanel());
    prueba.add(po.getPanel());
    prueba.pack();
    prueba.setLocationRelativeTo(null);
    prueba.setVisible(true);
  }

  public void utiliza(Operacion operacion1) {
    if(operacion1 instanceof OperacionUnitaria) {
      operacion1.operando1 = pn.getValor();
      pn.setValor(operacion1.operar());
    } else {
      if(operacionPendiente!=null) {
        this.calcular();
      }
        operacion1.operando1 = pn.getValor();
        operacionPendiente = operacion1;
        pn.setValor(0);

    }
  }
}
