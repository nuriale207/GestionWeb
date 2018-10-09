
public class Enlace {
	private int posicion ;
	
	public Enlace(Integer pPosicion) {
		this.posicion=pPosicion;
	}

	public int getEnlace() {
		//Pre
		//Post: devuelve el valor del entero contenido en el enlace.
		return this.posicion;
	}
}
