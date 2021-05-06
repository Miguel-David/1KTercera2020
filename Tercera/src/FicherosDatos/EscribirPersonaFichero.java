package FicherosDatos;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;

public class EscribirPersonaFichero {
  public static void main(String[] args) throws IOException {
    Persona p=new Persona(
            "Juan",(byte)38,(short)175,(short)70,"473532"
    );
    p
            .anyadeAmigo("Elena")
            .anyadeAmigo("Flori")
            .anyadeAmigo("Clara");

    System.out.println(p);

    FileOutputStream fos=new FileOutputStream("personas.dam",true);
    DataOutputStream dos=new DataOutputStream(fos);
    dos.writeUTF(p.getNia());
    dos.writeUTF(p.getNombre());
    dos.writeByte(p.getEdad());
    dos.writeShort(p.getAltura());
    dos.writeShort(p.getPeso());

    dos.writeShort(p.amigos.size());
    for (String s:p.amigos) {
      dos.writeUTF(s);
    }
    try{
      dos.close();
      fos.close();
    } finally {
      dos.close();
      fos.close();
    }
  }
}
