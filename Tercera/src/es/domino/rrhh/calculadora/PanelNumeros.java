package es.domino.rrhh.calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelNumeros {

  protected final JPanel panel;
  protected final JButton[] botones=new JButton[10];
  protected final JButton igual=new JButton("=");
  protected final JButton borrar=new JButton("C");
  Controlador controlador;

  protected final JTextField display=new JTextField("0");

  public void setValor(int valor){
    display.setText(""+valor);
  }

  public int getValor(){
    return Integer.parseInt(display.getText());
  }

  public PanelNumeros(Controlador controlador) {
    this.controlador=controlador;
    panel=new JPanel();
    inicializacionLayout();
  }

  private void inicializacionLayout() {
    panel.setBorder(BorderFactory.createTitledBorder("Externo"));
    panel.setLayout(new BorderLayout());
    display.setEditable(false);
    panel.add(display,BorderLayout.NORTH);
    display.setHorizontalAlignment(SwingConstants.RIGHT);
    JPanel panelBotones=new JPanel(new GridLayout(0,3));
    panel.add(panelBotones,BorderLayout.CENTER);
    for(int i= botones.length-1;i>=0;i--){
      botones[i]=new JButton(""+i);

      botones[i].addActionListener(e -> pulsado(e.getSource()));
    }
    panelBotones.add(botones[7]);
    panelBotones.add(botones[8]);
    panelBotones.add(botones[9]);
    panelBotones.add(botones[4]);
    panelBotones.add(botones[5]);
    panelBotones.add(botones[6]);
    panelBotones.add(botones[1]);
    panelBotones.add(botones[2]);
    panelBotones.add(botones[3]);
    panelBotones.add(borrar);
    borrar.addActionListener(e -> display.setText("0"));
    panelBotones.add(botones[0]);
    panelBotones.add(igual);
    igual.addActionListener(e->controlador.calcular());


  }

  private void pulsado(Object source) {
    JButton botonPulsado=(JButton) source;
    String p=display.getText();
    p+=botonPulsado.getText();
    display.setText(""+Integer.parseInt(p));
  }

  public JPanel getPanel() {
    return panel;
  }

  public static void main(String[] args) {
    JFrame prueba=new JFrame("Prueba");
    PanelNumeros pn=new PanelNumeros(null);

    prueba.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    prueba.add(pn.getPanel());
    prueba.pack();
    prueba.setLocationRelativeTo(null);
    prueba.setVisible(true);

  }
}
