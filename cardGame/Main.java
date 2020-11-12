package cardGame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class Main {

	public static void main(String[] args) {
		

		
		
		
		
		 Mazo nuevoMazo = armarMazo("./superheroes.json");
		 Estrategia e1 = new Timbero();
		 Estrategia e2 = new Obstinado("fuerza");
	     Estrategia e3 = new Ambicioso();
	     Jugador j1 = new Jugador("Juan", e1);
	     Jugador j2 = new Jugador("Maria", e2);

	     Juego juego = new Juego(5);

	     //creacion de las pociones
		 Pocion fortalecedora = new Fortalecedora("Fortalecedora",0.2);
		 Pocion fortalecedora2 = new Fortalecedora("Fortalecedora",0.3);
		 Pocion fortalecedoraPlus = new FortalecedoraPlus("FortalecedoraPlus",0.5);
		 Pocion fortalecedoraPlus2 = new FortalecedoraPlus("FortalecedoraPlus",0.55);
		 Pocion kryptonita = new Kriptonita("Kriptonita", 0.25);
		 Pocion kryptonita2 = new Kriptonita("Kriptonita", 0.20);
		 Pocion reductorDePlomo = new ReductorDePlomo("Reductor de Plomo", 0.55);
		 Pocion reductorDePlomo2 = new ReductorDePlomo("Reductor de Plomo", 0.54);
		 Pocion quieroValeCuatro = new QuieroValeCuatro("Quiero Vale Cuatro", 4);
		 Pocion quieroValeCinco = new QuieroValeCuatro("Quiero Vale Cuatro", 5);
		 Pocion numeroMagico = new NumeroMagico("Numero magico",23);
		 Pocion numeroMagico2 = new NumeroMagico("Numero magico",26);
		 Pocion selectFuerza = new PocimaSelectivaFuerza("Pocima selectiva Fuerza", 0.35,"fuerza");
		 Pocion selectFuerza2 = new PocimaSelectivaFuerza("Pocima selectiva Fuerza", 0.55,"fuerza");
		 Pocion selectPeso = new PocimaSelectivaPeso("Pocima selectiva peso",0.43,"peso");
		 Pocion selectPeso2 = new PocimaSelectivaPeso("Pocima selectiva peso",0.5,"peso");
		 PocimaCocktail cocktail = new PocimaCocktail("cocktail");
		 PocimaCocktail cocktail2 = new PocimaCocktail("cocktail");

		 cocktail2.addPocimas(fortalecedora2);
		 cocktail2.addPocimas(selectPeso);
		 cocktail.addPocimas(fortalecedora);
		 cocktail.addPocimas(kryptonita);
		 cocktail.addPocimas(quieroValeCinco);

		 //armando arreglo de pociones
		System.out.println("Pocimas");
		ArrayList<Pocion> pocimas = new ArrayList<>();
		pocimas.add(fortalecedora);
		pocimas.add(fortalecedoraPlus);
		pocimas.add(kryptonita);
		pocimas.add(reductorDePlomo);
		pocimas.add(quieroValeCuatro);
		pocimas.add(numeroMagico);
		pocimas.add(selectFuerza);
		pocimas.add(selectPeso);
		pocimas.add(fortalecedora2);
		pocimas.add(fortalecedoraPlus2);
		pocimas.add(kryptonita2);
		pocimas.add(reductorDePlomo2);
		pocimas.add(quieroValeCinco);
		pocimas.add(numeroMagico2);
		pocimas.add(selectFuerza2);
		pocimas.add(selectPeso2);








	     

		juego.repartirMazo(j1,j2,nuevoMazo,pocimas);

		System.out.println(j1.getMazoJ().getCartas());
		System.out.println(j2.getMazoJ().getCartas());


		juego.jugar(j1,j2);


	}
	
	
	 public static Mazo armarMazo(String jsonFile) {
	        //URL url = getClass().getResource(jsonFile);
	        File jsonInputFile = new File(jsonFile);
	        InputStream is;
	        Mazo mazo = new Mazo();
	        try {
	        	 
	            is = new FileInputStream(jsonInputFile);
	            // Creo el objeto JsonReader de Json.
	            JsonReader reader = Json.createReader(is);
	            // Obtenemos el JsonObject a partir del JsonReader.
	            JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
	            for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
	                Carta cartax = new Carta();     
	               
	                cartax.setNombre(carta.getString("nombre"));
	               	
	                JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
	                	                	                
	                	
	                for (String nombreAtributo:atributos.keySet()) 
	                	
	                {
	                	            
	               	    Atributo atributo = new Atributo();       	                
	                      
	               		           	
	                	
	                	atributo.setNombre(nombreAtributo);
	                	atributo.setValor(atributos.getInt(nombreAtributo));
	                
	                   
	                    cartax.agregarAtributo(atributo);                    
	                }
	             
	               		mazo.agregarCarta(cartax);
	            }
	            
	            reader.close();
	            return mazo;
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            return null ;
	        }
	    }

}
