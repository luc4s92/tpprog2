package cardGame;

import java.util.ArrayList;

public class Jugador {
	 private String nombre;
	 private Mazo mazoJ;
	 private Estrategia estrategia;
	
	
	
	public Jugador (String nombre, Estrategia estrategia) {
		this.mazoJ = new Mazo();
		this.nombre = nombre;
		this.estrategia = estrategia;
		
	}
	
	public Mazo getMazoJ() {
		
		return this.mazoJ;
		
		
		
	}
	
	public boolean tieneCartas() {
		return this.getMazoJ().getCantCartas() > 0;
	}

	
	public Estrategia getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(Estrategia estrategia) {
		this.estrategia = estrategia;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getAtrAJugar() {
		
		if(this.tieneCartas()) {
			Carta carta = mazoJ.getPrimeraCarta();
			String atrAJugar = this.getEstrategia().modoJuego(carta.getAtributos());
			return atrAJugar;
		}
		return null;
	}
	
	
	
}
