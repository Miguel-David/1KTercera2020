package Excepciones;



import javax.swing.*;

public class TomaTemperatura {
  public static void main(String[] args) {
    TemperaturaLocalidadDiaria t = null;
    while (t == null) {
      try {
        String localidad = JOptionPane.showInputDialog(null, "Localidad");
        double minima = Double.parseDouble(JOptionPane.showInputDialog(null, "minima"));
        double maxima = Double.parseDouble(JOptionPane.showInputDialog(null, "maxima"));
        t = new TemperaturaLocalidadDiaria(localidad, minima, maxima);
      } catch (IllegalArgumentException iae) {
        JOptionPane.showMessageDialog(null, iae.getMessage());
      }
    }
    System.out.println(t.localidad);

  }
}
