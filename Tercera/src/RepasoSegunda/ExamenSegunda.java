package RepasoSegunda;

public class ExamenSegunda {
  public static void main(String[] args) {

  }
}

abstract class Aparato{
  protected String numSerie;
  Aparato(String numSerie){
    this.numSerie=numSerie;
  }
  abstract String encender();
  abstract String volar();
}

class Reactor extends Aparato{

  Reactor(String numSerie) {
    super(numSerie);
  }

  @Override
  String encender() {
    return "Pruuuuum";
  }

  @Override
  String volar() {
    return "Fiuuuuuuu";
  }
}

class Zepelin extends Aparato{

  Zepelin(String numSerie) {
    super(numSerie);
  }

  @Override
  String encender() {
    return "Me inflo de gas";
  }

  @Override
  String volar() {
    return "Vuelo lento a merced del viento";
  }
}
