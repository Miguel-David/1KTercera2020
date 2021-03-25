package pruebastorneo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Partido {
  String jugador1=null;
  String jugador2=null;
  JButton boton1;
  JButton boton2;
  Partido siguientePartido;
  JPanel panel;

  public Partido(Partido siguiente) {
    boton1=new JButton("------");
    boton2=new JButton("------");
    boton1.setEnabled(false);
    boton2.setEnabled(false);
    if(siguiente!=null) {
      boton1.addActionListener(e -> {
        siguiente.ponJugador(jugador1);
        boton1.setEnabled(false);
        boton2.setEnabled(false);
      });
      boton2.addActionListener(e -> {
        siguiente.ponJugador(jugador2);
        boton1.setEnabled(false);
        boton2.setEnabled(false);
      });
    }
    siguientePartido=siguiente;
    panel=new JPanel(new GridLayout(2,0));
    panel.add(boton1);
    panel.add(boton2);
  }

  public JPanel getPanel() {
    return panel;
  }

  public void ponJugador(String nombre){
    if(jugador1==null){
      jugador1=nombre;
      boton1.setText(jugador1);
      boton1.setEnabled(true);
    } else if(jugador2==null){
      jugador2=nombre;
      boton2.setText(jugador2);
      boton2.setEnabled(true);
    } else {
      throw new IllegalArgumentException("Demasiados jugadores");
    }
  }

  public static void main(String[] args) {
    JFrame frame=new JFrame("CC");
    Partido p=new Partido(null);
    p.ponJugador("ana");
    p.ponJugador("Bea");
    frame.add(p.getPanel());
    frame.pack();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}
