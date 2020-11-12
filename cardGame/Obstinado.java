package cardGame;

import java.util.ArrayList;

public class Obstinado extends Estrategia {
	
	int atrElegido;
	public Obstinado(int atrElegido) {
		this.atrElegido = atrElegido;
	}
	
	@Override
	public int modoJuego(ArrayList<Atributo> atributos) {
		int atrSeleccion = 0;
		if(this.atrElegido < atributos.size()) {
			atrSeleccion = this.atrElegido;
		}
			
		return atrSeleccion; // debe retornar el nombre del atributo que elige y no la pocision
		
	}

}
