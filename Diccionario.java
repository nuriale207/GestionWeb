import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class Diccionario {
	private ArrayList<String> diccionario;
	private static Diccionario miDiccionario= new Diccionario();
	private Diccionario () {
		this.diccionario= new ArrayList<String>();
	}
	
	public void cargarDiccionario(String nomF) {
		try {
			Scanner entrada = new Scanner(new FileReader(nomF));
			Diccionario palabras=new Diccionario();
			while(entrada.hasNext()) {
				palabras.añadirPalabra(entrada.next());
				
			}
			entrada.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void añadirPalabra(String pPalabra) {
		this.diccionario.add(pPalabra);
	}
	
	public static Diccionario getDiccionario() {
		return miDiccionario;
	}
	
	public String esta(String pPalabra) {
		Iterator<String> itr=this.diccionario.iterator();
		Boolean igual=false;
		String palabraAct= new String();
		while(itr.hasNext()&& igual==false) {
			palabraAct=itr.next();
			
			if(pPalabra.contains(palabraAct)) {
				igual=true;
			}
			
		}
		return palabraAct;
	}

}
