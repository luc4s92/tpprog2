package cardGame;

public class NumeroMagico extends Pocion {

    private int nroMagico;
    public NumeroMagico (String nombre, int nroMagico){
        super(nombre);
        this.nroMagico = nroMagico;
    }

    public void setValeCuatro(int nroMagico) {
        this.nroMagico = nroMagico;
    }

    @Override
    public int efecto(Atributo atr) {
        return  this.nroMagico;
    }
}
