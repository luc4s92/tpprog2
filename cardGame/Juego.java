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


        if (ganador.getMazoJ().getCarta(i).tienePocima() && perdedor.getMazoJ().getCarta(i).tienePocima()) {
            System.out.println("El jugador " + ganador.getNombre() + " selecciona competir por el atributo " +
                    ganador.getMazoJ().getCarta(i).getAtributo(atr));

            System.out.println("La carta de " + ganador.getNombre() + " es " + ganador.getMazoJ().getCarta(i).getNombreCarta() + " con " + ganador.getMazoJ().getCarta(i).getAtributo(atr) +
                    " se aplico pocima " + ganador.getMazoJ().getCarta(i).getPocima() + " valor resultante " + ganador.getMazoJ().getCarta(i).getAtrConPocion(atr));
            System.out.println("La carta de " + perdedor.getNombre() + " es " + perdedor.getMazoJ().getCarta(i).getNombreCarta() + " con " + perdedor.getMazoJ().getCarta(i).getAtributo(atr) +
                    " se aplico pocima " + perdedor.getMazoJ().getCarta(i).getPocima() + " valor resultante " + perdedor.getMazoJ().getCarta(i).getAtrConPocion(atr));

        } else {
            if (ganador.getMazoJ().getCarta(i).tienePocima()) {
                System.out.println("El jugador " + ganador.getNombre() + " selecciona competir por el atributo " +
                        ganador.getMazoJ().getCarta(i).getAtributo(atr));
                System.out.println("La carta de " + ganador.getNombre() + " es " + ganador.getMazoJ().getCarta(i).getNombreCarta() + " con " + ganador.getMazoJ().getCarta(i).getAtributo(atr) +
                        " se aplico pocima " + ganador.getMazoJ().getCarta(i).getPocima() + " valor resultante " + ganador.getMazoJ().getCarta(i).getAtrConPocion(atr));
                System.out.println("La carta de " + perdedor.getNombre() + " es " + perdedor.getMazoJ().getCarta(i).getNombreCarta() + " con " + perdedor.getMazoJ().getCarta(i).getAtributo(atr));
            } else {
                if (perdedor.getMazoJ().getCarta(i).tienePocima()) {
                    System.out.println("El jugador " + ganador.getNombre() + " selecciona competir por el atributo " + ganador.getMazoJ().getCarta(i).getAtributo(atr));
                    System.out.println("La carta de " + ganador.getNombre() + " es " + ganador.getMazoJ().getCarta(i).getNombreCarta() + " con " + ganador.getMazoJ().getCarta(i).getAtributo(atr));
                    System.out.println("La carta de " + perdedor.getNombre() + " es " + perdedor.getMazoJ().getCarta(i).getNombreCarta() + " con " + perdedor.getMazoJ().getCarta(i).getAtributo(atr) +
                            " se aplico pocima " + perdedor.getMazoJ().getCarta(i).getPocima() + " valor resultante " + perdedor.getMazoJ().getCarta(i).getAtrConPocion(atr));
                } else {

                    System.out.println(
                            "El jugador " + ganador.getNombre() + " selecciona competir por el atributo " + ganador.getMazoJ().getCarta(i).getAtributo(atr));
                    System.out.println("La carta de " + ganador.getNombre() + " es " + ganador.getMazoJ().getCarta(i).getNombreCarta() + " con " + ganador.getMazoJ().getCarta(i).getAtributo(atr));
                    System.out.println("La carta de " + perdedor.getNombre() + " es " + perdedor.getMazoJ().getCarta(i).getNombreCarta() + " con " + perdedor.getMazoJ().getCarta(i).getAtributo(atr));

                }
            }


        }
    }
    private void ganadorSeQuedaCarta(Jugador ganador, Jugador perdedor, int i) {
        ganador.getMazoJ().agregarCarta(perdedor.getMazoJ().getCarta(i)); // forma interna
        perdedor.getMazoJ().eliminarCarta(); // metodo que pase una posicion y remueva en el mazo
    }
    public String getAtrAJugar(Jugador j1, Jugador j2, int i, boolean ganador){
        if(ganador){
            return j1.getEstrategia().modoJuego(j1.getMazoJ().getCarta(i).getAtributos());
        }
        else {
            return j2.getEstrategia().modoJuego(j2.getMazoJ().getCarta(i).getAtributos());
        }
    }

    public void jugar(Jugador j1, Jugador j2){
        int turno = 1;
        int i = 0;
        String atr = " ";
        boolean ganador = true;
        while( i < rondas && ( j1.getMazoJ().getCantCartas()!= 0) && ( j2.getMazoJ().getCantCartas())!= 0){

            atr = getAtrAJugar(j1,j2,i,ganador);

            if (j1.getMazoJ().getCarta(i).getAtributo(atr).equals(j2.getMazoJ().getCarta(i).getAtributo(atr))){


                if (ganador == true){
                    System.out.println("--------- Ronda " + turno + "--------");
                    imprimir(j1,j2,i,atr);
                    ganador =  getGanador(j1,j2,i,atr);
                        if (ganador == true){
                                ganadorSeQuedaCarta(j1, j2, i);
                                System.out.println("Gana la ronda "+ j1.getNombre()+ " y queda con " + j1.getMazoJ().getCantCartas() + " (" +
                                j2.getNombre()+ " posee ahora " + j2.getMazoJ().getCantCartas() + " cartas )");


                        }
                        else {
                                ganadorSeQuedaCarta(j2, j1, i);
                                System.out.println("Gana la ronda "+ j2.getNombre()+ " y queda con " + j2.getMazoJ().getCantCartas() + " (" +
                                        j1.getNombre()+ " posee ahora " + j1.getMazoJ().getCantCartas() + " cartas )");


                        }
                 turno++;
                }
                else {
                    System.out.println("--------- Ronda " + turno + "--------");
                    imprimir(j2,j1,i,atr);
                    ganador =  getGanador(j1,j2,i,atr);
                    if (ganador == true){

                                ganadorSeQuedaCarta(j1, j2, i);
                                System.out.println("Gana la ronda "+ j1.getNombre()+ " y queda con " + j1.getMazoJ().getCantCartas() + " (" +
                                j2.getNombre()+ " posee ahora " + j2.getMazoJ().getCantCartas() + " cartas )");


                    }
                    else{
                        ganadorSeQuedaCarta(j2, j1, i);
                        System.out.println("Gana la ronda "+ j2.getNombre()+ " y queda con " + j2.getMazoJ().getCantCartas() + " (" +
                                j1.getNombre()+ " posee ahora " + j1.getMazoJ().getCantCartas() + " cartas )");


                    }
                    turno ++;
                }
                i++;
            }

        }
    }



}
