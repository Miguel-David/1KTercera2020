package Ficheros;

import Pruebas.Direccion;

import java.io.File;

public class UsoTamanyo {
  public static void main(String[] args) {
    System.out.println(TamanyoDirectorio.tamanyoDirectorio(new File("..")));
  }
}
