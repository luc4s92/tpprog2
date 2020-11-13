package cardGame;

public class Reductora extends Pocion{

    private double decremento;

    public Reductora(String nombre, double decremento){
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
