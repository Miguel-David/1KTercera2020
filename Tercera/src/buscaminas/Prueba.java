package buscaminas;

import javax.swing.*;
import java.awt.*;

public class Prueba {
  public static void main(String[] args) {
    JFrame frame=new JFrame("BUSCA");
    frame.setLayout(new GridLayout(5,5));
    for (int i = 0; i < 25; i++) {
      //frame.add(new Celda().getBoton());
    }
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
