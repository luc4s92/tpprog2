package cardGame;

import java.util.ArrayList;

public class Ambicioso extends Estrategia {

	

	@Override
	public int modoJuego(ArrayList<Atributo> atributos) {



		int maxValor = 0;
		int posMayor = 0;


		for(int i = 0; i < atributos.size();i++) {

			if (  maxValor < atributos.get(i).getValor()) {
				posMayor = i;
				maxValor = atributos.get(i).getValor();

			}


		}


		return posMayor;
	}

}
