package Excepciones;



import java.util.InputMismatchException;
import java.util.Scanner;

public class ListaClase {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    boolean personaBuena=false;
    while(!personaBuena) {
      try {
        System.out.println("Introduzca el nombre:");
        String nombre = sc.nextLine();
        System.out.println("Introduzca la edad:");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduzca el DNI:");
        String dni = sc.nextLine();
        Persona entrada = new Persona(nombre, edad, dni);
        System.out.println(entrada);
        personaBuena=true;
      } catch (InputMismatchException | IllegalArgumentException iae){
        System.out.println("Error al procesar Persona: ");
        System.out.println(iae.getMessage());
      }
    }



  }
}
