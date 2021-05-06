package FicherosTexto;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.*;
import java.nio.file.Files;
import java.util.List;


public class Poetizador {
  public static void main(String[] args) throws IOException {
    intentaDisenyoBonito();
    JFileChooser elegidor=new JFileChooser(".");

    for (Filtros f:Filtros.values()) {
      elegidor.addChoosableFileFilter(f.getFileFiler());
    }
    elegidor.setAcceptAllFileFilterUsed(false);
    elegidor.showOpenDialog(null);

    File fichero=elegidor.getSelectedFile();
    System.out.println("Has elegido :" + fichero.getName());

    //Línea más larga, ejemplo de ReadAllines
    int longitudMaxima=calculaLineaMasLarga(fichero);


    String nuevoNombre=cambiaExtension(fichero.getName(),"poema");
    File nuevoFichero=new File(nuevoNombre);
    try(BufferedReader br=new BufferedReader(new FileReader(fichero));
        BufferedWriter bw=new BufferedWriter(new FileWriter(nuevoFichero))){
      String linea;
      while((linea=br.readLine())!=null){
        //PRoceso real de las líneas
        //Guardamos en fichero
        String enPoema=centra(linea,longitudMaxima);
        bw.write(enPoema);
        bw.newLine();
      }

    } catch (FileNotFoundException fnoe){
      fnoe.printStackTrace();
      System.out.println("Ha pasado algo muy gordo");
    } catch (IOException ioe){
      ioe.printStackTrace();
      System.out.println("No se pudo leer el fichero elegido");
    }
  }

  private static String centra(String linea, int longitudMaxima) {
    String salida="";
    int mitad=longitudMaxima/2;
    int espacios=mitad-linea.length()/2;
    for (int i = 0; i < espacios; i++) {
      salida+=" ";
    }
    return salida+linea;
  }

  private static int calculaLineaMasLarga(File fichero) throws IOException {
    List<String> linea= Files.readAllLines(fichero.toPath());
    //máximo
    int maximo=0;
    for (String s:linea) {
      if(s.length()>maximo){
        maximo=s.length();
      }
    }
    return maximo;
  }

  private static String cambiaExtension(String name, String extension) {
    return name.substring(0,name.length()-3)+extension;
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

enum Filtros{
  TXT(f ->{ return f.getName().endsWith(".txt");}, "Fichericos de texto txt"),
  FOTO(f ->{ return f.getName().endsWith(".bmp");},"Fotos de poetas"),
  POESIA(f ->{ return f.getName().endsWith(".poesia");},"Nuestras poesías"),
  GRANDES(f-> f.length()>10000,"Ficheros Grandes"),
  TXTPEQUENYOS(f-> f.length()<100 && f.getName().endsWith(".txt"),
          "Fciheros de texto menores de 1Kb");

  private final Valido valido;
  private final String descripcion;

  Filtros( Valido valido, String descripcion) {
    this.valido=valido;
    this.descripcion=descripcion;
  }

  public FileFilter getFileFiler() {
    FileFilter filtro=new FileFilter() {
      @Override
      public boolean accept(File f) {
        return f.isDirectory() || valido.aceptable(f);
      }

      @Override
      public String getDescription() {
        return descripcion;
      }
    };
    return filtro;
  }
}

interface Valido{
  boolean aceptable(File f);
}