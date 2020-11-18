package cardGame;

import java.util.ArrayList;

public class Juego {
	private int rondas;
	
	
	public Juego(int rondas) {
		this.rondas = rondas;
	}
	
	 public void repartirMazo(Jugador j1, Jugador j2, Mazo m, ArrayList<Pocion> pocimas) {
	        // Reparte el mazo y saca la carta que no va
		 	m.mezclarCartas();
	        ArrayList<Carta> cartas = m.getCartas();
	        
	        for (int i = 0; i < cartas.size(); i++) {
	        	// mover new carta
	            if ((i % 2) == 0) {
	                if (i < pocimas.size()) {
	                	
	                	Carta auxCarta = new Carta();
	                    auxCarta = cartas.get(i);
	                    auxCarta.agregarPocima(pocimas.get(i));
	                    j1.getMazoJ().agregarCarta(auxCarta);
	                    
	                } else {
	                    j1.getMazoJ().agregarCarta(cartas.get(i));
	                }
	            } else {
	            	
	                if (i < pocimas.size()) {
	                	
	                	Carta auxCarta = new Carta();
	                    auxCarta = cartas.get(i);
	                    auxCarta.agregarPocima(pocimas.get(i));
	                    j2.getMazoJ().agregarCarta(auxCarta);
	                    
	                } else {
	                    j2.getMazoJ().agregarCarta(cartas.get(i));
	                }
	            }

	        }
	    }
	 
	 
	
	 private void ganadorSeQuedaCarta(Jugador ganador, Jugador perdedor) {   		    		    	
	        ganador.agregarCartaGanada(perdedor.getPrimeraCartaJ()); // forma interna
	        perdedor.perdioCarta();
	        ganador.pasarCartaAlFinal(); 
	    }
	 
	 public void jugar(Jugador j1, Jugador j2) {
		 
		 Jugador jugadorConTurno = j1;
		 Jugador jugadorGanador ;
		 int ronda = 1;
		
		 while(ronda <= this.rondas && j1.tieneCartas() && j2.tieneCartas()) {
			 String atrAJugar = jugadorConTurno.getAtrAJugar();
			 
			 Carta cartaJ1 = j1.getPrimeraCartaJ();
			 Carta cartaJ2 = j2.getPrimeraCartaJ();			 
			 
			 int resultadoRonda = cartaJ1.compararCartas(cartaJ2, atrAJugar);
			 
			 if(resultadoRonda == 0) {
				 j1.pasarCartaAlFinal();
				 j2.pasarCartaAlFinal();;
				 jugadorGanador = jugadorConTurno;
			 }else
				 if(resultadoRonda == 1) {
					 //pasarle la carta al ganador y sacarcela al perdedor
					 jugadorGanador = j1;
					 ganadorSeQuedaCarta(j1,j2);
				 }
				 else {
					 //pasarle la carta al ganador y sacarsela al perdedor
					 jugadorGanador = j2;
					 ganadorSeQuedaCarta(j2,j1);
				 }
			 
			 		 
			 imprimirRonda(jugadorConTurno,jugadorGanador,atrAJugar,cartaJ1,cartaJ2,ronda,j1,j2);
			 jugadorConTurno = jugadorGanador;	
			 ronda++;
		 }	 
					 		 		 		 
		 imprimirGanadorJuego(j1,j2);		 
	 }
	 
	 
	 public void imprimirRonda(Jugador jugadorConTurno, Jugador jGanador, String atr, Carta cartaJ1, Carta cartaJ2, int turno, Jugador j1, Jugador j2) {
		 System.out.println("----------------- Ronda " + turno + "--------------------");
		 System.out.println("El Jugador " + jugadorConTurno.getNombre() + " selecciona el atributo: " + atr );
		 System.out.println("La carta de " + j1.getNombre() + cartaJ1.imprimirCartaJuego(atr));
		 System.out.println("La carta de " + j2.getNombre() + cartaJ2.imprimirCartaJuego(atr));
		 System.out.println("Gana la ronda : " + jGanador.getNombre());
		 System.out.println(j1.getNombre()+ " posee ahora " + j1.CantCartasJ()+ " cartas y "+ j2.getNombre() + " posee ahora " +
		  j2.CantCartasJ()+ " cartas." );
	 }
	 
	 public void imprimirGanadorJuego(Jugador j1, Jugador j2) {
		 
		 System.out.println("--------------Fin del Juego---------------");
	    	if(j1.CantCartasJ() > j2.CantCartasJ()) { //metodo del jugador
	    		System.out.println("El ganador del juego es : " + j1.getNombre() + " con: " + j1.CantCartasJ() + " cartas"  );
	    		
	    	}
	    	else {
	    		System.out.println("El ganador del juego es : " + j2.getNombre() + " con: " + j2.CantCartasJ() + " cartas"  );
	    	}
	    }
	 
	 
	 
}
