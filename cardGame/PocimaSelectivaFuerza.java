package cardGame;

public class PocimaSelectivaFuerza extends Pocion{

    private double incFuerza;
    private String nombreAtr;
    public PocimaSelectivaFuerza(String nombre, double incFuerza, String nombreAtr){
        super(nombre);
        this.incFuerza = incFuerza;
        this.nombreAtr = nombreAtr;
    }

    public void setIncFuerza(double incFuerza) {
        this.incFuerza = incFuerza;
    }

    public void setNombreAtr(String nombreAtr) {
        this.nombreAtr = nombreAtr;
    }

    @Override
    public int efecto(Atributo atr) {

        if(atr.getNombre().equals(this.nombreAtr)){
            double auxAtr = atr.getValor();
            auxAtr = auxAtr *this.incFuerza;

            return (int) (atr.getValor() + auxAtr);
        }
        return atr.getValor();
    }
}
