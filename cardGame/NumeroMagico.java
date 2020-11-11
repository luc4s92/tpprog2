package cardGame;

public class NumeroMagico extends Pocion{

    private int nroMagic;

    public  NumeroMagico(String nombre, int nroMagic){
      super(nombre);
      this.nroMagic = nroMagic;
    }

    public void setNroMagic(int nroMagic) {
        this.nroMagic = nroMagic;
    }

    @Override
    public int efecto(Atributo atr) {
        return this.nroMagic;
    }
}
