package cardGame;

import java.util.ArrayList;

public class Ambicioso extends Estrategia {

	

	@Override
	public String modoJuego(ArrayList<Atributo> atributos) {


		String atrMayor = " ";
		int maxValor = 0;
	


		for(int i = 0; i < atributos.size();i++) {

			if (  maxValor < atributos.get(i).getValor()) {
				
				maxValor = atributos.get(i).getValor();
				atrMayor = atributos.get(i).getNombre();
			}


		}
		

		return atrMayor; //debe retornar el string (nombre) del atributo
	}

}
