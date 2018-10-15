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
	public void imprimir(){
		//Pre:
		//Post: imprime por pantalla los elementos del diccionario en el orden en el que están almacenados.
		
		Iterator<String> itr=this.diccionario.iterator();
		
		while(itr.hasNext()){
			String palabraAct=itr.next();
			System.out.println(palabraAct);
		}
	}
	public void cargarDiccionario(String nomF) {
		//Pre:el nombre del fichero debe ser válido y estar seguido por la extensión .txt. Las palabras se 
		//	  almacenan en una lista donde en cada linea hay una sola palabra.
		//Post:carga las palabras contenidas en el fichero nomF en el diccionario.
		try {
			Scanner entrada = new Scanner(new FileReader(nomF));
			//Diccionario palabras=new Diccionario();
			while(entrada.hasNext()) {
				this.diccionario.add(entrada.next());
			}
			entrada.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public boolean esta(String s){	
		//Pre: el diccionario debe tener al menos un elemento.
		//Post: devuelve true si el elemento  s está en el diccionario y false en el caso contrario.
			
			int i=0;
			int f=this.diccionario.size()-1;
			int centro=0;
			boolean salir=false;
			//int indice=-1;
			String palabra=new String("noExiste");
			while(i<=f && !salir) {
				
				centro=((i+f)/2);
				
				palabra= this.diccionario.get(centro);
				
				
				if(palabra.compareToIgnoreCase(s)>0) {
			
					f=centro-1;
					
				}
				else if(palabra.compareToIgnoreCase(s)<0) {

					i=centro+1;	
				}
				else if(palabra.compareToIgnoreCase(s)==0) {
					//Web web=new Web(webCen);				
					//indice=web.getIndice();
					salir=true;
		
				}
			}

			return salir;
		}
	
	
	public void anadirPalabra(String pPalabra) {
		//Pre:
		//Post:añade la palabra pPalabra al final del diccionario .
		
		this.diccionario.add(pPalabra);
		
		
		
	}
	
	public static Diccionario getDiccionario() {
	//Pre: 
	//Post: devuelve la unica instancia del diccionario.
		return miDiccionario;
	}
	

	public void diccionarioOrdenado(){
		//Pre:el diccionario contiene al menos un elemento
		//Post: ordena el diccionario alfabeticamente
		mergeSort(this.diccionario,0,(this.diccionario.size()-1));
		
	}
	private  void mergeSort(ArrayList<String> lista,int inicio, int fin) {
		//Pre:el diccionario contiene al menos un elemento
		//Post: realiza llamadas recursivas para ordenar el diccionario
		if(fin-inicio>0) {
		mergeSort(lista, inicio, (inicio+fin)/2);
		mergeSort(lista, (((inicio+fin)/2)+1),fin);
		diccionarioOrdenado(lista,inicio,(inicio+fin)/2,fin);
		}
		
	}
private void diccionarioOrdenado( ArrayList<String> lista, int inicio, int centro,int fin){
	//Pre:el diccionario contiene al menos un elemento
	//Post: realiza las operaciones necesarias para ordenar los elementos del dicionario 
	//	    desde las posiciones  inicio hasta la fin.
	ArrayList<String> listOrd=new ArrayList<String>();
		
		//listOrd=lista;
		int izq=inicio;
		int der=centro+1;
		int indice= 0;
		
		while(izq<=centro && der<= fin) {
			//System.out.println(lista.get(izq).compareTo(lista.get(der)));     
			if(this.diccionario.get(izq).compareTo(this.diccionario.get(der))<=0) {	
				listOrd.add( indice, this.diccionario.get(izq));
				indice++;
				izq++;
			}
			else {
				listOrd.add(indice,this.diccionario.get(der)  );
				indice++;
				der++;
				
			}
		}
		
		if(izq>centro) {
			while(der<=fin) {
				listOrd.add(indice,this.diccionario.get(der));
				indice++;
				der++;
				
			}
		}
		else {
			while(izq<=centro) {
				listOrd.add(indice,this.diccionario.get(izq));
				indice++;
				izq++;
				
			}
		}
		for(int j=inicio; j<=fin; j++) {
			this.diccionario.set(j, listOrd.get(j-inicio));
		}
	
}
	public void resetear(){
		//Pre:
		//Post: elimina el contenido del diccionario.
		this.diccionario=new ArrayList<String>();
	}

}
