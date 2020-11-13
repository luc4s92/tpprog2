package cardGame;

public class PocimaSelectivaAtr extends Pocion{

    private double incAtr;
    private String nombreAtr;
    public PocimaSelectivaAtr(String nombre, double incAtr, String nombreAtr){
        super(nombre);
        this.incAtr = incAtr;
        this.nombreAtr = nombreAtr;
    }

    public void setIncFuerza(double incAtr) {
        this.incAtr = incAtr;
    }

    public void setNombreAtr(String nombreAtr) {
        this.nombreAtr = nombreAtr;
    }

    @Override
    public int efecto(Atributo atr) {

        if(atr.getNombre().equals(this.nombreAtr)){
            double auxAtr = atr.getValor();
            auxAtr = auxAtr *this.incAtr;

            return (int) (atr.getValor() + auxAtr);
        }
        return atr.getValor();
    }
}
