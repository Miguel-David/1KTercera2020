package buscaminas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Celda {
  JButton boton=new JButton(" ");
  boolean descubierta=false;
  int numero=0;
  Tablero t;
  int fila;
  int columna;

  public Celda(Tablero t,int fila,int columna) {
    this.t=t;
    this.fila=fila;
    this.columna=columna;
    boton.setPreferredSize(new Dimension(30,30));
    Font  f2  = new Font(Font.SANS_SERIF,  Font.BOLD, 16);
    boton.setFont(f2);

    boton.setFocusPainted(false);
    boton.setContentAreaFilled(false);
    boton.setMargin(new Insets(1,1,1,1));
    boton.setText(" ");
    boton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        descubrir();
      }
    });
  }

  public void descubrir() {
    this.descubierta=true;
    boton.setBackground(Color.lightGray);
    boton.setOpaque(true);

    if(numero==0){
      boton.setText(" ");
    } else if(numero==-1){
      boton.setText("\uD83D\uDCA3");
    } else {
      boton.setText("" + numero);
    }
    t.descubierta(fila,columna);
  }

  public JButton getBoton() {
    return boton;
  }
  public void ponNumero(int numero){
    this.numero=numero;
    if(descubierta) {
      boton.setText("" + numero);
    } else {
      boton.setText(" ");
    }
  }


}
