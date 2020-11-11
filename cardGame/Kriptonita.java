package cardGame;

public class Kriptonita extends Pocion{

    private double decremento;

    public Kriptonita(String nombre, double decremento){
        super(nombre);
        this.decremento = decremento;
    }

    public void setDecremento(double decremento) {
        this.decremento = decremento;
    }

    @Override
    public int efecto(Atributo atr) {
        double auxAtr = atr.getValor();
        auxAtr = auxAtr * this.decremento;


        return (int) (atr.getValor() - auxAtr);
    }
}
