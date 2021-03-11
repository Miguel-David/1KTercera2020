package Pruebas;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Principal {
  private static final Logger logger= Logger.getLogger("Direccion.class");
  public static void main(String[] args) {
    FileHandler fileTxt = null;
    try {
      fileTxt = new FileHandler("Logging.txt");
    } catch (IOException e) {
      e.printStackTrace();
    }
    SimpleFormatter formatterTxt = new SimpleFormatter();
    fileTxt.setFormatter(formatterTxt);
    logger.addHandler(fileTxt);
    logger.log(Level.INFO,"Iniciamos el programa");
    Scanner sc=new Scanner(System.in);
    System.out.println("Nombre de la vía?");
    String nombre=sc.nextLine();
    int numero=0;
    boolean numeroBien=false;
    while(!numeroBien){
      System.out.println("Número?");
      try {
        numero = sc.nextInt();
        numeroBien=true;
      } catch (InputMismatchException ime){
        System.out.println("Eso no es un número");
        sc.nextLine();
      }
    }
    int piso=0;
    boolean pisoBien=false;
    while(!pisoBien){
      System.out.println("Piso?");
      try {
        piso = sc.nextInt();
        sc.nextLine();
        pisoBien=true;
      } catch (InputMismatchException ime){
        System.out.println("Eso no es un número");
        sc.nextLine();
      }
    }
    char letra='\0';
    boolean letraBien=false;
    while(!letraBien){
      System.out.println("Letra?");
      String entrada=sc.nextLine();
      if(entrada.length()>1){
        System.out.println("Sólo una letra"+entrada.length());
      } else {
        letra=entrada.charAt(0);
        letraBien=true;
      }
    }
    try {
      Direccion direccion = new Direccion(nombre, numero, piso, letra);
      logger.log(Level.INFO,"Se crea la dirección "+direccion);
    } catch (IllegalArgumentException iae){
      logger.log(Level.SEVERE,"No se crea el objeto por "+iae.getMessage());
    }
  }
}
