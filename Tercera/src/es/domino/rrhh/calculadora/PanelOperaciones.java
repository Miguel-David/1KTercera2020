package es.domino.rrhh.calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;

public class PanelOperaciones {
  Controlador controlador;
  JPanel panel=new JPanel();

  public PanelOperaciones(Controlador controlador) {
    this.controlador = controlador;
    panel.setLayout(new BorderLayout());
    JTabbedPane pestanyas=new JTabbedPane();
    Map<TipoOperacion,JPanel> paneles=new TreeMap<>();
    for (TipoOperacion t:TipoOperacion.values()) {
      paneles.put(t,new JPanel());
    }
    for (Map.Entry<TipoOperacion,JPanel> panel: paneles.entrySet()) {
      pestanyas.addTab(panel.getKey().name(),panel.getValue());
    }
    panel.add(pestanyas);


    for (final Operacion o:OperacionesDisponibles.listaOperaciones ) {
      //panel.add(o.boton);
      paneles.get(o.getTipo()).add(o.boton);
      o.boton.addActionListener(e -> controlador.utiliza(o));
    }

  }

  public JPanel getPanel() {
    return panel;
  }
}
