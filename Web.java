import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
public class Web {
	private String nombre;
	private Integer indice;
	private ArrayList<Enlace> listaEnlaces;
	private ArrayList<String> listaPalabras;
	public Web(String pNombre, int pIndice) {
		this.nombre=pNombre;
		this.indice=pIndice;
		this.listaEnlaces= new ArrayList<Enlace>();
		this.listaPalabras=new ArrayList<String>();
	}
	
	public void anadirEnlaces(ArrayList<Enlace> pLista) {
		//Pre
		//Post añade los enlaces de la lista dada a la web.
		this.listaEnlaces=pLista;
//		Iterator<Enlace> itr= pLista.iterator();
//		Enlace enlace=new Enlace(4);
//		while(itr.hasNext()) {
//			enlace=itr.next();
//			this.listaEnlaces.add(enlace);
			
//		}
		
	}
	public ArrayList<Enlace> getEnlaces() {
		//Pre
		//Post devuelve los enlaces de la web.
		return this.listaEnlaces;
		
	}
	
//	public ArrayList<String> getWebs(){
//		Iterator<Enlace> itr= this.listaEnlaces.iterator();
//		Enlace enlaceAct=new Enlace(3);
//		
//		while (itr.hasNext()) {
//			enlaceAct=itr.next();
//			
//			
//		}
//		
//	}
	
	public String getNombre() {
		return this.nombre;
	}
	public String getWeb() {
		return this.nombre;
	}
	
	public int getIndice() {
		//Pre
		//Post devuelve el indice de la web.
		return this.indice;
	}
//	public void anadirPalabras() {
//		Diccionario diccionario= Diccionario.getDiccionario();
//		diccionario.esta(this.nombre);
//		System.out.println(diccionario.esta(this.nombre));
//	}
	
//	public String limpiarNombreWeb() {
//		String[] pSeparada= this.nombre.split(Pattern.quote("."));
//		return pSeparada[0];
//	}

}
