package es.domino.rrhh.buscaminas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Botones {
  static int lado=10;
  public static void main(String[] args) {
    JFrame ventana=new JFrame();
    ventana.setLayout(new GridLayout(20,20));
    JButton[][] botones=new JButton[20][20];
    for (int i = 0; i < botones.length; i++) {
      for (int j = 0; j < botones[0].length; j++) {
        JButton boton=new JButton();
        botones[i][j]=boton;
        Icon icon = new ImageIcon("vacio.png");
        boton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            Icon icon = new ImageIcon("bomba.png");
            boton.setIcon(icon);
          }
        });
        boton.setIcon(icon);
        boton.setPreferredSize(new Dimension(20, 20));
        ventana.add(boton);
      }
    }
    ventana.pack();
    ventana.setLocationRelativeTo(null);
    ventana.setVisible(true);
  }
}
