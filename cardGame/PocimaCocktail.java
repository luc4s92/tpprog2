package cardGame;

import java.util.ArrayList;

public class PocimaCocktail extends Pocion{

    private ArrayList<Pocion>pocimas;

    public PocimaCocktail(String nombre){
        super(nombre);
        this.pocimas = new ArrayList<>();
    }

    public void addPocimas(Pocion p){
        pocimas.add(p);
    }


    public ArrayList<Pocion> getPocimas(){

        return new ArrayList<Pocion>(pocimas);
    }

    @Override
    public int efecto(Atributo atr) {
    	Atributo atributo = new Atributo();
    	atributo.setNombre(atr.getNombre());
    	atributo.setValor(atr.getValor());
        double auxAtr = 0;

        for (Pocion pocion:pocimas){
            auxAtr = pocion.efecto(atributo);
            atributo.setValor((int) auxAtr);
        }

        return atributo.getValor();
    }
}
