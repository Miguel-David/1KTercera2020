package clasificador;

import javax.swing.*;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.HashSet;
import java.util.Set;

public class BuscaFicherosJava {
  public static void intentaDisenyoBonito(){
    try {
      UIManager.setLookAndFeel(
              UIManager.getSystemLookAndFeelClassName());
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  public static File eligeDir(){
    JFileChooser jFileChooser = new JFileChooser("./");
    jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    jFileChooser.showOpenDialog(null);
    File dir = new File(String.valueOf(jFileChooser.getSelectedFile()));
    return dir;
  }
  public static Set<File> buscaFicherosJava(File directorio){
    Set<File> ficherosJava = new HashSet<>();
    File[] ficherosYDir =
            directorio.listFiles(file->file.isDirectory() || file.getName().endsWith(".java"));
    /*
    File[] ficherosYDir = directorio.listFiles(new FileFilter() {
      @Override
      public boolean accept(File file) {
        if(file.isDirectory() || file.getName().endsWith(".java")){
          return true;
        }
        return false;
      }
    });*/
    for (File f:ficherosYDir) {
      if(f.isDirectory()){
        ficherosJava.addAll(buscaFicherosJava(f));
      }else{
        ficherosJava.add(f);
      }
    }
    return ficherosJava;
  }
  public static void main(String[] args) {
    intentaDisenyoBonito();
    File directorioBase = eligeDir();
    buscaFicherosJava(directorioBase).forEach(f->System.out.println(f.getName()));
  }
}

