package pruebastorneo;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Campeonato {
  JFrame frame;
  JPanel panel;
  public static void main(String[] args) throws IOException {
    Campeonato c=new Campeonato();
    JFrame frame=new JFrame("CC");
    c.inciliza();
    frame.add(c.panel);

    Ronda ultima=new Ronda(null);
    Ronda semifinal=new Ronda(ultima);
    Ronda cuartos=new Ronda(semifinal);
    List<String> lineas= Files.readAllLines(Paths.get("Jugadores.txt"));
    cuartos.rellena(lineas);
    c.anyadePartidos(cuartos.getPartidos(),0);
    c.anyadeSeparador();
    c.anyadePartidos(semifinal.getPartidos(),1);
    c.anyadeSeparador();
    c.anyadePartidos(ultima.getPartidos(),2);
    frame.pack();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

  private void anyadeSeparador() {

  }

  private void inciliza() {
    panel=new JPanel(new GridBagLayout());
  }

  private void anyadePartidos(Partido[] primeraRonda, int i) {
    GridBagConstraints c=new GridBagConstraints();
    if(i>0) {
      c.gridx = i - 1;
      c.gridy = 0;
      panel.add(new JLabel(" PASAN: "));
    }
    c.weighty=1;
    c.gridx=i*2;
    for (int j = 0; j < primeraRonda.length; j++) {
      c.gridy=j;
      panel.add(primeraRonda[j].getPanel(),c);
    }

  }
}
