package cardGame;

import java.util.ArrayList;

public class Juego {
    private int rondas;


    public Juego(int rondas) {
        this.rondas = rondas;
    }

    public void repartirMazo(Jugador j1, Jugador j2, Mazo m, ArrayList<Pocion> pocimas) {
        // Reparte el mazo y saca la carta que no va
        ArrayList<Carta> cartas = m.getCartas();
        
        for (int i = 0; i < cartas.size(); i++) {
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

    public boolean getGanador(Jugador j1, Jugador j2, int i, String atr) {
    	boolean resultado = true;

        if (!j1.getMazoJ().getCarta(i).tienePocima() && !j2.getMazoJ().getCarta(i).tienePocima()) {
            if (j1.getMazoJ().getCarta(i).getAtributo(atr).getValor() > j2.getMazoJ().getCarta(i)
                    .getAtributo(atr).getValor()) {
                resultado = true;
            } else
                resultado = false;
        } else {
            if (j1.getMazoJ().getCarta(i).tienePocima() && j2.getMazoJ().getCarta(i).tienePocima()) {
                if (j1.getMazoJ().getCarta(i).getAtrConPocion(atr) > j2.getMazoJ().getCarta(i).getAtrConPocion(atr)) {
                    resultado = true;
                } else {
                    resultado = false;
                }

            } else {
                if (j1.getMazoJ().getCarta(i).tienePocima() && !j2.getMazoJ().getCarta(i).tienePocima()) {
                    if (j1.getMazoJ().getCarta(i).getAtrConPocion(atr) > j2.getMazoJ().getCarta(i).getAtributo(atr).getValor()) {
                        resultado = true;
                    } else {
                        resultado = false;
                    }
                } else {
                    if (!j1.getMazoJ().getCarta(i).tienePocima() && j2.getMazoJ().getCarta(i).tienePocima()) {
                        if (j1.getMazoJ().getCarta(i).getAtributo(atr).getValor() > j2.getMazoJ().getCarta(i).getAtrConPocion(atr)) {
                            resultado = true;
                        } else
                            resultado = false;
                    }
                }

            }

        }
        return  resultado;
    }


    public void imprimir(Jugador ganador, Jugador perdedor, int i, String atr) {


        if (ganador.getMazoJ().getCarta(i).tienePocima() && perdedor.getMazoJ().getCarta(i).tienePocima()) { //si los dos tienen pocima
            System.out.println("El jugador " + ganador.getNombre() + " selecciona competir por el atributo " +
                    ganador.getMazoJ().getCarta(i).getAtributo(atr));

            System.out.println("La carta de " + ganador.getNombre() + " es " + ganador.getMazoJ().getCarta(i).getNombreCarta() + " con " + ganador.getMazoJ().getCarta(i).getAtributo(atr) +
                    " se aplico pocima " + ganador.getMazoJ().getCarta(i).getPocima() + " valor resultante " + ganador.getMazoJ().getCarta(i).getAtrConPocion(atr));
            System.out.println("La carta de " + perdedor.getNombre() + " es " + perdedor.getMazoJ().getCarta(i).getNombreCarta() + " con " + perdedor.getMazoJ().getCarta(i).getAtributo(atr) +
                    " se aplico pocima " + perdedor.getMazoJ().getCarta(i).getPocima() + " valor resultante " + perdedor.getMazoJ().getCarta(i).getAtrConPocion(atr));

        } else {
            if (ganador.getMazoJ().getCarta(i).tienePocima()) { //el ganador tiene pocima el perdedor no
                System.out.println("El jugador " + ganador.getNombre() + " selecciona competir por el atributo " +
                        ganador.getMazoJ().getCarta(i).getAtributo(atr));
                System.out.println("La carta de " + ganador.getNombre() + " es " + ganador.getMazoJ().getCarta(i).getNombreCarta() + " con " + ganador.getMazoJ().getCarta(i).getAtributo(atr) +
                        " se aplico pocima " + ganador.getMazoJ().getCarta(i).getPocima() + " valor resultante " + ganador.getMazoJ().getCarta(i).getAtrConPocion(atr));
                System.out.println("La carta de " + perdedor.getNombre() + " es " + perdedor.getMazoJ().getCarta(i).getNombreCarta() + " con " + perdedor.getMazoJ().getCarta(i).getAtributo(atr));
            } else {
                if (perdedor.getMazoJ().getCarta(i).tienePocima()) { // el ganador no tiene pocima, el perdedor si
                    System.out.println("El jugador " + ganador.getNombre() + " selecciona competir por el atributo " + ganador.getMazoJ().getCarta(i).getAtributo(atr));
                    System.out.println("La carta de " + ganador.getNombre() + " es " + ganador.getMazoJ().getCarta(i).getNombreCarta() + " con " + ganador.getMazoJ().getCarta(i).getAtributo(atr));
                    System.out.println("La carta de " + perdedor.getNombre() + " es " + perdedor.getMazoJ().getCarta(i).getNombreCarta() + " con " + perdedor.getMazoJ().getCarta(i).getAtributo(atr) +
                            " se aplico pocima " + perdedor.getMazoJ().getCarta(i).getPocima() + " valor resultante " + perdedor.getMazoJ().getCarta(i).getAtrConPocion(atr));
                } else {

                    System.out.println( //ninguno tiene pocima
                            "El jugador " + ganador.getNombre() + " selecciona competir por el atributo " + ganador.getMazoJ().getCarta(i).getAtributo(atr));
                    System.out.println("La carta de " + ganador.getNombre() + " es " + ganador.getMazoJ().getCarta(i).getNombreCarta() + " con " + ganador.getMazoJ().getCarta(i).getAtributo(atr));
                    System.out.println("La carta de " + perdedor.getNombre() + " es " + perdedor.getMazoJ().getCarta(i).getNombreCarta() + " con " + perdedor.getMazoJ().getCarta(i).getAtributo(atr));

                }
            }


        }
    }
    private void ganadorSeQuedaCarta(Jugador ganador, Jugador perdedor, int i) {
    	//le pasa la carta al ganador y el ganador pasa su 1ra carta al final
    	
    	Carta aux = new Carta();
    	aux = ganador.getMazoJ().getCarta(i);
        ganador.getMazoJ().agregarCarta(perdedor.getMazoJ().getCarta(i)); // forma interna
        perdedor.getMazoJ().eliminarCarta();
        ganador.getMazoJ().agregarCarta(aux);
        ganador.getMazoJ().eliminarCarta();// metodo que pase una posicion y remueva en el mazo
    }
    
    public String getAtrAJugar(Jugador j1, Jugador j2, int i, boolean ganador){
        if(ganador){
            return j1.getEstrategia().modoJuego(j1.getMazoJ().getCarta(i).getAtributos());
        }
        else {
            return j2.getEstrategia().modoJuego(j2.getMazoJ().getCarta(i).getAtributos());
        }
    }

    public void imprimirGanadorRonda(Jugador ganadorRonda, Jugador perdedorRonda) {
    	 System.out.println("Gana la ronda "+ ganadorRonda.getNombre()+ " y queda con " + ganadorRonda.getMazoJ().getCantCartas() + " (" +
    			 perdedorRonda.getNombre()+ " posee ahora " + perdedorRonda.getMazoJ().getCantCartas() + " cartas )");
    }
    
    public void imprimirGanadorJuego(Jugador j1, Jugador j2) {
    	if(j1.getMazoJ().getCantCartas() > j2.getMazoJ().getCantCartas()) {
    		System.out.println("El ganador del juego es : " + j1.getNombre() + " con: " + j1.getMazoJ().getCantCartas() + " cartas"  );
    		
    	}
    	else {
    		System.out.println("El ganador del juego es : " + j2.getNombre() + " con: " + j2.getMazoJ().getCantCartas() + " cartas"  );
    	}
    }
    
    public void jugar(Jugador j1, Jugador j2){
    	int primera = 0;
        int turno = 1;
        String atr = " ";
        boolean ganador = true;
        while( turno <= rondas && ( j1.tieneCartas() &&  j2.tieneCartas())){

            atr = getAtrAJugar(j1,j2,primera,ganador);

            if (j1.getMazoJ().getCarta(primera).getAtributo(atr).equals(j2.getMazoJ().getCarta(primera).getAtributo(atr))){

                if (ganador == true){
                    System.out.println("--------- Ronda " + turno + "--------");
                    imprimir(j1,j2,primera,atr);
                    ganador =  getGanador(j1,j2,primera,atr);
                        if (ganador == true){
                                ganadorSeQuedaCarta(j1, j2, primera);                             
                                imprimirGanadorRonda(j1,j2);
                        }
                        else {
                                ganadorSeQuedaCarta(j2, j1, primera);                              
                                imprimirGanadorRonda(j2,j1);
                        }                
                }
                else {
                    System.out.println("--------- Ronda " + turno + "--------");
                    imprimir(j2,j1,primera,atr);
                    ganador =  getGanador(j1,j2,primera,atr);
                    if (ganador == true){
                                ganadorSeQuedaCarta(j1, j2, primera);                             
                                imprimirGanadorRonda(j1,j2);
                    }
                    else{
                        ganadorSeQuedaCarta(j2, j1, primera);                       
                        imprimirGanadorRonda(j2,j1);
                    }                    
                }
                turno ++;
            }
           
        }
         imprimirGanadorJuego(j1,j2);
    }



}
