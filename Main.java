import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
	private Main() {
		
	}
	public static void main (String [ ] args) {
		
		ListaWebs lista=new ListaWebs();
		lista.cargarLista("smallindex.txt", "smallpld-arcs-1-N.txt");
		
		Diccionario diccionario=new Diccionario();
		diccionario.cargarDiccionario("words.txt");
	}
}
