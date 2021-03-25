package pruebastorneo;

import javax.swing.*;

public class Final extends Partido{
  public Final() {
    super(null);
    boton1.addActionListener(e-> JOptionPane.showMessageDialog(null,"Ganador:"+jugador1));
    boton2.addActionListener(e-> JOptionPane.showMessageDialog(null,"Ganador:"+jugador2));

  }
}
