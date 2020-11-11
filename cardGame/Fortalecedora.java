package cardGame;

public  class Fortalecedora extends Pocion{
    double incremento ;

    public Fortalecedora (String nombre, double incremento){
        super(nombre);
        this.incremento = incremento;
    }

    public void setIncremento(double incremento) {
        this.incremento = incremento;
    }

    @Override
    public int efecto(Atributo atr) {
        double auxAtr =atr.getValor();
            auxAtr = auxAtr * this.incremento;
        return (int) (atr.getValor() +auxAtr);
    }
}
