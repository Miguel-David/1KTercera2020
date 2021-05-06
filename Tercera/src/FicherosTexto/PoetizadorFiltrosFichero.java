package FicherosTexto;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class PoetizadorFiltrosFichero {
  public static void main(String[] args) {
    intentaDisenyoBonito();
    JFileChooser elegidor=new JFileChooser(".");

    try {
      List<String> lineas = Files.readAllLines(Paths.get("Filtros.1k"));
      Iterator<String> iteratorLineas= lineas.iterator();
      while(iteratorLineas.hasNext()) {
        String extension= iteratorLineas.next();
        String mensaje=iteratorLineas.next();


        FileFilter nuevoFiltro = new FileFilter() {
          @Override
          public boolean accept(File f) {
            return f.isDirectory() || f.getName().endsWith(extension);
          }

          @Override
          public String getDescription() {
            return mensaje;
          }
        };
        elegidor.addChoosableFileFilter(nuevoFiltro);
      }
      elegidor.setAcceptAllFileFilterUsed(false);
    } catch (IOException ioe){
      ioe.printStackTrace();
    } catch (NoSuchElementException nsee){
      nsee.printStackTrace();
    }
    

    elegidor.showOpenDialog(null);

    JOptionPane.showMessageDialog(null,"SEGUIMOS FUNCIONANDO");
  }
  public static void intentaDisenyoBonito(){
    try {
      UIManager.setLookAndFeel(
              UIManager.getSystemLookAndFeelClassName());
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
