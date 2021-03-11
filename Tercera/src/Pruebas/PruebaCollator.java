package Pruebas;

import java.text.Collator;
import java.util.*;

public class PruebaCollator {
  public static void main(String[] args) {
    Collator ordenacion1=Collator.getInstance(new Locale("es"));
    Collator ordenacion2=Collator.getInstance(new Locale("es"));
    Collator ordenacion3=Collator.getInstance(new Locale("es"));
    ordenacion1.setStrength(Collator.PRIMARY);
    ordenacion2.setStrength(Collator.SECONDARY);
    ordenacion3.setStrength(Collator.TERTIARY);
    List<String> nombres1=new ArrayList<>();
    List<String> nombres2=new ArrayList<>();
    List<String> nombres3=new ArrayList<>();
    nombres1.addAll(Arrays.asList("Ana","Bea","Álvaro","Árbol","alberto","azucena","Clara"));
    nombres2.addAll(Arrays.asList("Ana","Bea","Álvaro","Árbol","alberto","azucena","Clara"));
    nombres3.addAll(Arrays.asList("Ana","Bea","Álvaro","Árbol","alberto","azucena","Clara"));
    nombres1.sort(ordenacion1);
    nombres2.sort(ordenacion2);
    nombres3.sort(ordenacion3);
    System.out.println(nombres1);
    System.out.println(nombres2);
    System.out.println(nombres3);
    List cadenas = new ArrayList(Arrays.asList("Cantabria", "Álava", "Alava", "alava"));

    String[] sortedNoCollator = (String[]) cadenas.toArray(new String[0]);
    List sortedPrimaryCollator = new ArrayList(cadenas);
    List sortedSecondaryCollator = new ArrayList(cadenas);
    List sortedTertiaryCollator = new ArrayList(cadenas);

    Collator primaryCollator = Collator.getInstance(new Locale("es"));
    Collator secondaryCollator = Collator.getInstance(new Locale("es"));
    Collator tertiaryCollator = Collator.getInstance(new Locale("es"));

    primaryCollator.setStrength(Collator.PRIMARY);
    secondaryCollator.setStrength(Collator.SECONDARY);
    tertiaryCollator.setStrength(Collator.TERTIARY);

    Arrays.sort(sortedNoCollator);
    sortedPrimaryCollator.sort(primaryCollator);
    sortedSecondaryCollator.sort(secondaryCollator);
    sortedTertiaryCollator.sort(tertiaryCollator);

    System.out.printf("Lista cadenas:                             %s%n", cadenas);
    System.out.printf("Ordenación sin clase Collator:             %s%n", Arrays.asList(sortedNoCollator));
    System.out.printf("Ordenación con clase Collator (primary):   %s%n", sortedPrimaryCollator);
    System.out.printf("Ordenación con clase Collator (secondary): %s%n", sortedSecondaryCollator);
    System.out.printf("Ordenación con clase Collator (tertiary):  %s%n", sortedTertiaryCollator);
    Map<String, String> favouriteMovies=new HashMap<>();

    favouriteMovies.put("Raphael", "Star Wars");
    favouriteMovies.put("Cristina", "Matrix Wars");
    favouriteMovies.put("Olivia", "James Bond");

    favouriteMovies
            .entrySet()
            .stream()
            .sorted(Map.Entry.<String,String>comparingByValue().reversed())
            .forEachOrdered(System.out::println);
  }
}
