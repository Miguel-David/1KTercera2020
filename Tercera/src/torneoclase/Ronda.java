package torneoclase;



import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ronda implements Marcadorizable{
  private List<String> jugadores=new ArrayList<>();
  private final Partido[] partidos;
  private final JPanel panel;
  Ronda siguiente;
  GanadorTorneo ganadorTorneo;
  Ronda(int numeroPartidos,Marcadorizable siguiente){
    if(siguiente instanceof Ronda) {
      this.siguiente = (Ronda)siguiente;
    } else {
      ganadorTorneo=(GanadorTorneo) siguiente;
    }
    partidos=new Partido[numeroPartidos];
    panel=new JPanel(new GridLayout(0,1));
    for (int i = 0; i < partidos.length; i++) {
      partidos[i]=new Partido(this);
      panel.add(partidos[i].getPanel());
    }
  }
  public void anyadeJugador(String nombre){
    jugadores.add(nombre);
    if(jugadores.size()== partidos.length*2){
      mostrarJugadores();
    }
  }
  public void mostrarJugadores(){
    int indiceLista=0;

      for (int i = 0; i < partidos.length; i++) {
        partidos[i].anyadeJugador(jugadores.get(indiceLista++));
        partidos[i].anyadeJugador(jugadores.get(indiceLista++));
      }

  }

  public JPanel getPanel() {
    return panel;
  }

  public void leeFichero(String nombreFichero){

    try {
      List<String> jugadores= Files.readAllLines(Paths.get(nombreFichero));
      for (String s:jugadores
      ) {
        this.anyadeJugador(s);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public void gana(String jugador) {
    if(siguiente!=null) {
      siguiente.anyadeJugador(jugador);
    } else {
      ganadorTorneo.setGanador(jugador);
    }
  }

  public static void main(String[] args) {
    JFrame ventana=new JFrame("Partido Suelto");
    JPanel temp=new JPanel(new GridLayout(1,0));
    GanadorTorneo panelGanador=new GanadorTorneo();
    Ronda r3=new Ronda(1,panelGanador);
    Ronda r2=new Ronda(2,r3);
    Ronda r1=new Ronda(4,r2);
    Ronda r=new Ronda(8,r1);

    r.leeFichero("ATP.txt");

    temp.add(r.getPanel());
    temp.add(r1.getPanel());


    temp.add(r2.getPanel());
    temp.add(r3.getPanel());
    temp.add(panelGanador.getPanel());

    ventana.add(temp);
    ventana.pack();
    ventana.setVisible(true);
    ventana.setLocationRelativeTo(null);
  }
}
