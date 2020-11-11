package cardGame;

public class QuieroValeCuatro extends Pocion {

    private int valeCuatro;
    public QuieroValeCuatro (String nombre, int valeCuatro){
        super(nombre);
        this.valeCuatro = valeCuatro;
    }

    public void setValeCuatro(int valeCuatro) {
        this.valeCuatro = valeCuatro;
    }

    @Override
    public int efecto(Atributo atr) {
        return  this.valeCuatro;
    }
}
