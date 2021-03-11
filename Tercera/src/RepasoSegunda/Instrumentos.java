package RepasoSegunda;

public abstract class Instrumentos {
  protected final String numSerie;

  Instrumentos(String numSerie){
    this.numSerie=numSerie;
  }

  public String getNumSerie() {
    return numSerie;
  }

  abstract String afinar();
  abstract String hacerSonar();
}

class Guitarra extends Instrumentos{


  Guitarra(String numSerie) {
    super(numSerie);
  }

  @Override
  String afinar() {
    return "Afino las cuerdas de la guitarra";
  }

  @Override
  String hacerSonar() {
    return "Rasgo las cuerdas";
  }
}

class Trompeta extends Instrumentos{
  Trompeta(String numSerie) {
    super(numSerie);
  }

  @Override
  String afinar() {
    return  "Afino mi trompeta y sus teclas" ;
  }

  @Override
  String hacerSonar() {
    return  "Soplando por la boquilla suena mi trompeta";
  }
}


