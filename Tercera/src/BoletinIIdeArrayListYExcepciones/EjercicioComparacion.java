package BoletinIIdeArrayListYExcepciones;


import java.util.*;

/*
Ejercicio de Comparación
Diseña e implementa la clase Manzana sabiendo que:
● Tiene un atributo numérico entero llamado sabor que indica el nivel de sabor de la
manzana en una escala de 0 a 10.
● Una manzana cualquiera tiene inicialmente un valor medio de sabor, aunque el
usuario puede decidir ese valor al crearla.
● Se desea poder decidir si una manzana es mejor que otra en base a su sabor. Esta
funcionalidad puede permitir, por ejemplo, crear un vector de manzanas y ordenarlas
de menor a mayor sabor
 */
public class EjercicioComparacion {
  public static void main(String[] args) {
    //Manzana m=new Manzana("      ",4);
    //Manzana m=new Manzana("    Ralls Genet    ",3);
    //Manzana mm=new Manzana("%43 grfd ",6);
    List<Manzana> cesto=new ArrayList<>();
    cesto.add(new Manzana("Red delicious"));
    cesto.add(new Manzana("Golden delicious",9));
    cesto.add(new Manzana("Gala",3));
    cesto.add(new Manzana("Granny smith"));
    cesto.add(new Manzana("McIntosh",10));
    cesto.add(new Manzana("Winesap",7));
    cesto.sort(Manzana::compareTo);
    for (Manzana m:cesto) {
      System.out.println(m.getSabor() + ": " + m.getNombre());
    }
    System.out.println("------------------------");
    cesto.sort((e1,e2)->e1.getNombre().compareTo(e2.getNombre()));
    cesto.forEach((e)->System.out.println(e.getNombre()+" "+e.getSabor()));
  }
}
class Manzana implements Comparable<Manzana>{
  protected final String nombre;
  protected final int sabor;

  public Manzana(String nombre, int sabor) {
    if(nombre==null){
      throw new IllegalArgumentException("El nombre no puede ser nulo");
    }
    nombre=nombre.trim();
    if(nombre.length()==0){
      throw new IllegalArgumentException("El nombre no puede estar en blanco");
    }
    for (char c:nombre.toCharArray()) {
      if(!(Character.isLetter(c)|| Character.isSpaceChar(c))){
        throw new IllegalArgumentException("El nombre tiene caracteres no válidos");
      }
    }

    this.nombre = nombre;
    if(sabor<0 || sabor>10){
      throw new IllegalArgumentException("El sabor debe estar entre 0 y 10");
    }
    this.sabor = sabor;
  }
  Manzana(String nombre){
    this(nombre,5);
  }

  public String getNombre() {
    return nombre;
  }

  public int getSabor() {
    return sabor;
  }

  @Override
  public int compareTo(Manzana o) {
    if(this.sabor==o.sabor){
      return this.nombre.compareTo(o.nombre);
    }
    return -Integer.compare(this.sabor,o.sabor);
  }
}
