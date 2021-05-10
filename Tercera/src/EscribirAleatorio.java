import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Objects;

public class EscribirAleatorio {
  public static final int TAMANYO_REGISTRO=8+40;
  public static void main(String[] args) {
    Mascota pajaro=new Mascota("Lorito");
    Mascota gato=new Mascota("Misifú");
    Mascota perro=new Mascota("CanCerbero");
    Mascota tortuga=new Mascota("Leonardo");



    try(RandomAccessFile raf=new RandomAccessFile(new File("mascotas.raf"),"rw")){
      guardaMascota(tortuga,raf);
      guardaMascota(tortuga,raf);
      guardaMascota(tortuga,raf);
      guardaMascota(pajaro, raf);
      guardaMascota(pajaro, raf);
      guardaMascota(gato, raf);
      guardaMascota(perro, raf);
      int numero=Integer.parseInt(JOptionPane.showInputDialog("Mascota?"));
      Mascota leida=leeMascota(raf,numero);
      System.out.println(leida.info());
    } catch (IOException ioe){
      ioe.printStackTrace();
    }
  }

  private static Mascota leeMascota(RandomAccessFile raf, int posicion) throws IOException {
    raf.seek(posicion*TAMANYO_REGISTRO);
    long id=raf.readLong();
    String nombre=raf.readUTF();
    return new Mascota(id,nombre);
  }

  private static void guardaMascota(Mascota mascota, RandomAccessFile raf) throws IOException {
    raf.seek(mascota.getId()*TAMANYO_REGISTRO);
    raf.writeLong(mascota.getId());
    raf.writeUTF(mascota.getNombre());
  }
}

class Mascota{
  private static long totalId=0;
  private  long id;
  protected final String nombre;


  public Mascota(long id, String nombre) {
    this.id = id;
    this.nombre = nombre;
  }

  public Mascota(String nombre) {
    this.id = totalId;
    totalId++;
    this.nombre = nombre;
  }

  public static long getTotalId() {
    return totalId;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getId() {
    return id;
  }


  public String getNombre() {
    return nombre;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Mascota mascota = (Mascota) o;
    return id == mascota.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "Mascota{" +
            "id=" + id +
            ", nombre='" + nombre + '\'' +
            '}';
  }

  public String info(){
    return id+" - "+nombre;
  }
}
