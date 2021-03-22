package buscaminas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Tablero {
  int filas;
  int columnas;
  Celda[][] celdas;
  JPanel panel;

  public Tablero(int filas, int columnas) {
    this.filas = filas;
    this.columnas = columnas;
    celdas=new Celda[filas][columnas];
    panel=new JPanel(new GridLayout(filas,columnas));
    for (int i = 0; i < filas; i++) {
      for (int j = 0; j < columnas; j++) {
        celdas[i][j]=new Celda(this,i,j);
        panel.add(celdas[i][j].getBoton());
      }
    }
  }
  void ponBombas(int numeroBombas){
    Random random=new Random();
    for (int i = 0; i < numeroBombas; i++) {
      int aleatorio1= random.nextInt(filas);
      int aleatorio2=random.nextInt(columnas);
      celdas[aleatorio1][aleatorio2].ponNumero(-1);
    }
  }
  void ponNumeros(){
    for (int i = 0; i < filas; i++) {
      for (int j = 0; j < columnas; j++) {
        if(celdas[i][j].numero==-1) continue;
        int total=0;
        if(i>0) total+=celdas[i-1][j].numero==-1?1:0;
        if(i<filas-1) total+=celdas[i+1][j].numero==-1?1:0;
        if(j>0) total+=celdas[i][j-1].numero==-1?1:0;
        if(j<columnas-1) total+=celdas[i][j+1].numero==-1?1:0;
        if(i>0 && j>0) total+=celdas[i-1][j-1].numero==-1?1:0;
        if(i>0 && j<columnas-1) total+=celdas[i-1][j+1].numero==-1?1:0;
        if(i<filas-1 && j<columnas-1) total+=celdas[i+1][j+1].numero==-1?1:0;
        if(i<filas-1 && j>0) total+=celdas[i+1][j-1].numero==-1?1:0;
        celdas[i][j].ponNumero(total);
      }
    }

  }
  void muestra(){
    for (int i = 0; i < filas; i++) {
      for (int j = 0; j < columnas; j++) {
        celdas[i][j].descubrir();

      }
    }
  }

  public JPanel getPanel() {
    return panel;
  }

  public static void main(String[] args) {
    JFrame frame=new JFrame("BUSCA");
    Tablero t=new Tablero(10,20);
    t.ponBombas(180);
    t.ponNumeros();
    //t.muestra();
    frame.add(t.getPanel());
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public void descubierta(int fila, int columna) {
    if(celdas[fila][columna].numero==-1){
      JOptionPane.showMessageDialog(null,"PIERDES");
      return;
    }
    if(celdas[fila][columna].numero!=0){
      return;
    }
    List<Celda> vacias=new ArrayList<>();
    if(fila>0) vacias.add(celdas[fila-1][columna]);
    if (fila<filas-1) vacias.add(celdas[fila+1][columna]);
    if(columna>0)vacias.add(celdas[fila][columna-1]);
    if(columna<columnas-1)vacias.add(celdas[fila][columna+1]);
    while(vacias.size()>0){
      if(!vacias.get(0).descubierta) vacias.get(0).descubrir();
      vacias.remove(0);
    }
  }
}
