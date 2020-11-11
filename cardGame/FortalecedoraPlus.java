package cardGame;

public class FortalecedoraPlus extends Pocion{

    private double incremento;

    public FortalecedoraPlus(String nombre, double incremento){
        super(nombre);
        this.incremento=incremento;
    }

    public void setIncremento(double incremento) {
        this.incremento = incremento;
    }

    @Override
    public int efecto(Atributo atr) {

        double auxtr = atr.getValor() ;
          auxtr =  auxtr * this.incremento;

        return (int) (atr.getValor() + auxtr);
    }
}
