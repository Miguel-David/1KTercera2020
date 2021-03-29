package BoletinIIdeArrayListYExcepciones;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class FicheroPersonasPreguntas {
  List<Persona> lista=new ArrayList<>();
  public static void main(String[] args) throws IOException {
    Scanner sc=new Scanner(System.in);
    FicheroPersonasPreguntas fichero=new FicheroPersonasPreguntas();
    //Esta línea hay que aprenderla de memoria
    List<String> lineas= Files.readAllLines(Paths.get("nacimientos.txt"));
    for (String s:lineas
         ) {
      try {
        fichero.intentaAnyadir(s);
      } catch (Exception e) {
        System.out.println("Error al pasar a persona: " + s);
        System.out.println("Introduzca línea alternativa");
        try {
          fichero.intentaAnyadir(sc.nextLine());
        } catch (Exception exception) {
          System.out.println("Te has equivocado otra vez. Paso de añadir persona en sustitución");
        }
      }
    }
    System.out.println("Hemos leido " + fichero.lista.size() + " Personas");
    if(fichero.coincidenciaDias()){
      System.out.println("Hay dos personas que celebran el cumple juntas");
    } else {
      System.out.println("Cada persona tiene el cumple sola");
    }
    if(fichero.coincidenciasLineal()){
      System.out.println("Hay dos personas que celebran el cumple juntas");
    } else {
      System.out.println("Cada persona tiene el cumple sola");
    }
    Map<String,List<Persona>> coincidentes=fichero.seleccionaGenteNacimiento();
    for (Map.Entry<String,List<Persona>> entrada:coincidentes.entrySet()) {
      if(entrada.getValue().size()>1){
        System.out.println("El " + entrada.getKey() + " Nacieron:");
        for (Persona p: entrada.getValue()) {
          System.out.println("     " + p.getNombre());
        }
      }
    }
  }

  private Map<String, List<Persona>> seleccionaGenteNacimiento() {
    Map<String,List<Persona>> diasPersonas=new HashMap<>();
    for (Persona p:lista) {
      String cumple=p.getDiaNacimiento()+"/"+p.getMesNacimiento();
      if(!diasPersonas.containsKey(cumple)){
        List<Persona> nueva=new ArrayList<>();
        nueva.add(p);
        diasPersonas.put(cumple,nueva);
      } else {
        List<Persona> yaVistasConElMismoCumple=diasPersonas.get(cumple);
        yaVistasConElMismoCumple.add(p);
      }
    }
    return diasPersonas;
  }

  private boolean coincidenciasLineal(){
    //Tiene O(n^2) con  List<String> vistos=new ArrayList<>();
    Set<String> vistos=new HashSet<>();
    for (Persona p:lista) {
      if(vistos.contains(p.getDiaNacimiento()+"/"+p.getMesNacimiento())){
        return true;
      }
      vistos.add(p.getDiaNacimiento()+"/"+p.getMesNacimiento());
    }
    return false;
  }
  private boolean coincidenciaDias() {
    //O(n^2)
    for (int elDeFuera = 0; elDeFuera < lista.size()-1; elDeFuera++) {
      Persona actual = lista.get(elDeFuera);
      for (int i = elDeFuera + 1; i < lista.size(); i++) {
        if (actual.getDiaNacimiento() == lista.get(i).getDiaNacimiento() &&
                actual.getMesNacimiento() == lista.get(i).getMesNacimiento()) {
          return true;
        }
      }
    }
    return false;
  }

  private void intentaAnyadir(String s) throws Exception {
    String[] campos=s.split(":");

      lista.add(new Persona(campos[0].trim(),campos[1].trim()));

  }
}
