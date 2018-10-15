import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
public class Web {
	/*El tipo primitivo int no es una clase y por tanto no es heredera de la clase objeto por lo que 
	 * no se puede tratar como un objeto y crear un ArrayList. Podríamos haber utilizado la clase integer
	 * pero en nuestro caso hemos creado la clase Enlace en la que se almacena un int.
	*/
	private String nombre;
	private Integer indice;
	private ArrayList<Enlace> listaEnlaces;
	public Web(String pNombre, int pIndice) {
		this.nombre=pNombre;
		this.indice=pIndice;
		this.listaEnlaces= new ArrayList<Enlace>();
		
	}
	
	public void anadirEnlaces(ArrayList<Enlace> pLista) {
		//Pre
		//Post añade los enlaces de la lista dada a la web.
		this.listaEnlaces=pLista;
	}
		
	
	public ArrayList<Enlace> getEnlaces() {
		//Pre
		//Post devuelve los enlaces de la web.
		return this.listaEnlaces;
		
	}
	

	public String getNombre() {
		return this.nombre;
	}

	public int getIndice() {
		//Pre
		//Post devuelve el indice de la web.
		return this.indice;
	}


}
