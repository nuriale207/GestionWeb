import java.util.ArrayList;
public class Web {
	private String nombre;
	private Integer indice;
	private ArrayList<Enlace> listaEnlaces;
	private ArrayList<String> listaPalabras;
	public Web(String pNombre,Integer pIndice) {
		this.nombre=pNombre;
		this.indice=pIndice;
		this.listaEnlaces= new ArrayList<Enlace>();
		this.listaPalabras=new ArrayList<String>();
	}
	
	public void anadirEnlaces(ArrayList<Enlace> pLista) {
		this.listaEnlaces=pLista;
		
	}

}
