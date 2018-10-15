import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
	private Main() {
		
	}
	public static void main (String [ ] args) {
		
		ListaWebs.getListaWebs().cargarLista("smallindex.txt", "smallpld-arcs-1-N.txt");
		ListaWebs.getListaWebs().imprimir();
		
		Diccionario.getDiccionario().cargarDiccionario("words.txt");
		System.out.println(ListaWebs.getListaWebs().web2Words("worldisawesome.com"));
		
		Diccionario diccionario=Diccionario.getDiccionario();
		diccionario.cargarDiccionario("words.txt");
		
		System.out.println(diccionario.esta("021buy.net"));	
//		Web web=new Web("google.com");
//		Web web2=new Web("youtube.com");
//		Web web3=new Web("ebay.com");
//		Web web4=new Web("amazon.com");
//		
//		System.out.println(web.getNombre().compareTo(web2.getNombre()));
//		System.out.println(web2.getNombre().compareTo(web3.getNombre()));
//		System.out.println(web4.getNombre().compareTo(web.getNombre()));
//		//System.out.println(web.getNombre());
		
		//System.out.println(web.limpiarNombreWeb());
	}
}
