package cardGame;

public class PocimaSelectivaPeso extends Pocion{
    private double incPeso;
    private String nombreAtr;
    public PocimaSelectivaPeso(String nombre, double peso, String nombreAtr){
        super(nombre);
        this.incPeso = peso;
        this.nombreAtr = nombreAtr;
    }

    public void setIncPeso(double incPeso) {
        this.incPeso = incPeso;
    }

    public void setNombreAtr(String nombreAtr) {
        this.nombreAtr = nombreAtr;
    }

    @Override
    public int efecto(Atributo atr) {
        if (atr.getNombre().equals(this.nombreAtr)) {
            double auxAtr = atr.getValor();
            auxAtr = auxAtr * this.incPeso;

            return (int) (atr.getValor() + auxAtr);
        }
        else
            return atr.getValor();
    }
}
