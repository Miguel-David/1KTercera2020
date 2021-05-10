package FicherosDatos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Mecanico {
  public static void main(String[] args) {
    ListaCoches listaCoches=new ListaCoches();
    listaCoches.anyadeCoche(new Coche("5454-GGG"));
    listaCoches.anyadeCoche(new Coche("0000-GGG"));
    listaCoches.anyadeCoche(new Coche("3333-GGG"));
    listaCoches.anyadeCoche(new Coche("5555-GGG"));
    listaCoches.anyadeCoche(new Coche("7777-GGG"));


    try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("coche.obj")))){

        oos.writeObject(listaCoches);

    }catch (IOException ioe){
      ioe.printStackTrace();
    }
  }
}
