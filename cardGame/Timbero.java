package cardGame;

import java.util.ArrayList;

public class Timbero extends Estrategia {

	public Timbero() {
		
	}

	@Override
	public String modoJuego(ArrayList<Atributo> atributos) {
		//retorna un numero aleatorio entre 0 y 4
		int atrAleatorio = (int) (Math.random() * (atributos.size()));
		
		return atributos.get(atrAleatorio).getNombre(); // debe retornar el nombre del atributo 
	
	}

}
