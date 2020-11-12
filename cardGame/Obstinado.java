package cardGame;

import java.util.ArrayList;

public class Obstinado extends Estrategia {
	
	String atrElegido;
	public Obstinado(String atrElegido) {
		this.atrElegido = atrElegido;
	}
	
	@Override
	public String modoJuego(ArrayList<Atributo> atributos) {
		int atrSeleccion = 0;
		
		for(int i= 0; i < atributos.size(); i++) {
			if(atributos.get(i).getNombre().equals(this.atrElegido)) 
				return atributos.get(i).getNombre();
			
		}
		
		
		
		
		
		 // debe retornar el nombre del atributo que elige y no la pocision
		return " ";
	}
	
}
