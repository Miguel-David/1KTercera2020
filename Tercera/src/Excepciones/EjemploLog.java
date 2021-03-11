package Excepciones;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class EjemploLog {
  private static Logger log;

  public static void main(String[] args) throws IOException {
    log=Logger.getLogger("Mi Aplicación");
    FileHandler fileHandler=new FileHandler("miLog.txt",true);
    SimpleFormatter formatterTxt = new SimpleFormatter();
    fileHandler.setFormatter(formatterTxt);
    log.addHandler(fileHandler);
    log.log(Level.INFO,"Inicio la aplicación");
    log.log(Level.INFO,"El log está funcionando");
  }
}
