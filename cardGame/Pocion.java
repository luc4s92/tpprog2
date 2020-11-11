package cardGame;

public abstract class Pocion {
private String nombre;

	public Pocion(String nombre) {
		this.nombre = nombre;
		
	}

	public abstract int efecto (Atributo atr);

	public String getNombre() {
		return nombre;
	}


	@Override
	public String toString() {
		return this.nombre ;
	}
}
