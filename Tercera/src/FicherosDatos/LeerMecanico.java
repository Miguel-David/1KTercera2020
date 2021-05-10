package FicherosDatos;

import java.io.*;

public class LeerMecanico {
  public static void main(String[] args) {
    try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new File("coche.obj")))){
      Coche c;
      while(true) {
        c=(Coche) ois.readObject();
        System.out.println(c.info());
      }
    }  catch (EOFException eof){
      System.out.println("Termino de leer");
    }
     catch (IOException ioe){
      ioe.printStackTrace();
    } catch (ClassNotFoundException cnfe){
      System.out.println("No hay coches en el fichero");
      cnfe.printStackTrace();
    }
  }
}
