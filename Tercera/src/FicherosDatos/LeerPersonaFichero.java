package FicherosDatos;

import java.io.*;

public class LeerPersonaFichero {
  public static void main(String[] args) throws IOException {
    try(DataInputStream dis=new DataInputStream(new FileInputStream("personas.dam"))) {
      while(true) {
        String nia = dis.readUTF();
        String nombre = dis.readUTF();
        byte edad = dis.readByte();
        short altura = dis.readShort();
        short peso = dis.readShort();
        Persona leida = new Persona(nombre, edad, altura, peso, nia);

        //Tengo que leer a los amigos
        short numeroAmigos=dis.readShort();
        for (int i = 0; i < numeroAmigos; i++) {
          String nombreAmigo=dis.readUTF();
          leida.anyadeAmigo(nombreAmigo);
        }
        System.out.println(leida);
      }
    } catch (EOFException eofe){
      System.out.println("Terminado de leer");
    }
  }
}
