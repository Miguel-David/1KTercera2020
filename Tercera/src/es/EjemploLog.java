package es;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class EjemploLog {
  public static final Logger log=Logger.getLogger("Ejemplo");
  public static void main(String[] args) throws IOException {
    FileHandler fichero=new FileHandler("logs.txt",true);
    SimpleFormatter formatoSimple=new SimpleFormatter();
    fichero.setFormatter(formatoSimple);
    log.addHandler(fichero);
    //Inicialización del log
    log.log(Level.INFO,"Inicio de la aplicacion");
  }
}
