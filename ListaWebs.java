import java.util.ArrayList;
import java.util.Iterator;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class ListaWebs {
	private ArrayList<Web> lista;
	private static ListaWebs miListaWebs=new ListaWebs();

	
	private ListaWebs() {
		this.lista= new ArrayList<Web>();
	}
	
	public void cargarLista(String nomF, String nomEnlaces) {
		try {
		      Scanner entrada = new Scanner(new FileReader(nomF));
		      Scanner entrada2= new Scanner(new FileReader(nomEnlaces));
		    
		     // ListaWebs lista= new ListaWebs();
		      while (entrada.hasNext()&& entrada2.hasNext()) {
			    	 			         
			         String[] datosWeb=entrada.nextLine().split("\\s+" );			         
			         int inEnlaces= Integer.parseInt(datosWeb[1]);
			         Web webAct= new Web(datosWeb[0],inEnlaces);  
			        
			         
			         //System.out.println(datosWeb[0]);
//			         System.out.println(datosWeb[1]);
   
			         ArrayList<Enlace> listaEn= new ArrayList<Enlace>();
			         String[] enlace2=entrada2.nextLine().split("\\s+-->\\s+");
			         String[] enlaceSep=enlace2[1].split("\\s");
			         Integer i=0;
			         while(i<enlaceSep.length) {
			        	 Enlace enlace=new Enlace(Integer.parseInt(enlaceSep[i]));			        	
			        	 listaEn.add(enlace);
//			        	 System.out.println(enlace.getNombre());
			        	 i=i+1;  	 
			         }			        
			         webAct.anadirEnlaces(listaEn);			         
			         this.lista.add(webAct);
		      }
		      entrada.close();
		      entrada2.close();
		   }
		   catch(IOException e) {e.printStackTrace();{
		   
		
	}
		   }	
	
	}
	
	public ListaWebs getListaWebs() {
		return miListaWebs;
	}
	
	private Iterator<Web> getIterador() {
		return this.lista.iterator();
	}
	
	private Web obtenerElemento(int posicion) {
		return this.lista.get(posicion); 
	}
	private void anadirWeb(Web pWeb) {
		
		this.lista.add(pWeb);
		
	}
	private void anadirWebEn(Web pWeb, int pIndice) {
		
		this.lista.add(pIndice, pWeb);
		
	}
	public void imprimir() {
		Iterator <Web> itr= getIterador();
		Web webAct=  new Web("wew",8); 
		while(itr.hasNext()) {
			webAct=itr.next();			
			System.out.println(webAct.getWeb());}
	}
	
	public String id2String(int pId) {
		if(pId>this.getLength()) {
			
			System.out.println("Error:el índice no es válido");
			return "Error:el índice no es válido";
		}
		else {
			return this.lista.get(pId).getNombre();
		}
		
			
		
	}
	
	private Web buscarEn(int inicio, int fin,String pNombre, ListaWebs lista) {
		
		int i=inicio;
		int f=fin;
		int centro=0;
		boolean salir=false;
		//int indice=-1;
		Web webCen=new Web("noExiste",-1);
		while(i<=f && !salir) {
			
			centro=((i+f)/2);
			
			webCen= lista.obtenerElemento(centro);
			
			String nWeb=webCen.getNombre();
			
			if(nWeb.compareTo(pNombre)>0) {
		
				f=centro-1;
				
			}
			else if(nWeb.compareTo(pNombre)<0) {

				i=centro+1;	
			}
			else if(nWeb.equals(pNombre)) {
				//Web web=new Web(webCen);				
				//indice=web.getIndice();
				salir=true;
	
			}
		}
		if(!salir) {
			System.out.println("El elemento no ha aparecido");
		}
		return webCen;
	}
	
	public int string2Id(String pNombre) {
		ListaWebs lista= webOrdenada();
		
		int inicio=0;
		int fin=lista.getLength()-1;

		
		Web web= buscarEn(inicio,fin,pNombre, lista);
		System.out.println(web.getNombre());
		return web.getIndice();
		
		
	}
	public int getLength() {
		return this.lista.size();
	}
//	public int string2Id(String nWeb) {
//		
//	}
	
	public ListaWebs webOrdenada() {
		Iterator<Web> itr=getIterador();
		Web webAct=null;
		ListaWebs listaAux= new ListaWebs();
		while(itr.hasNext()) {
			webAct=itr.next();
			listaAux.anadirWeb(webAct);			
		}
		mergeSort(listaAux,0,(listaAux.getLength()-1));
		
		return listaAux;
		
	}
	
	private  void mergeSort(ListaWebs lista,int inicio, int fin) {
		if(fin-inicio>0) {
		mergeSort(lista, inicio, (inicio+fin)/2);
		mergeSort(lista, (((inicio+fin)/2)+1),fin);
		webOrdenada(lista,inicio,(inicio+fin)/2,fin);
		}
		
	}
	
	
	
	
	private void webOrdenada( ListaWebs lista, int inicio, int centro,int fin){
		
		ListaWebs listOrd=new ListaWebs();
		
		//listOrd=lista;
		int izq=inicio;
		int der=centro+1;
		int indice= 0;
		
		while(izq<=centro && der<= fin) {
			//System.out.println(lista.get(izq).compareTo(lista.get(der)));     
			if(lista.obtenerElemento(izq).getNombre().compareTo(lista.obtenerElemento(der).getNombre())<=0) {	
				listOrd.anadirWebEn(lista.obtenerElemento(izq), indice);
				indice++;
				izq++;
			}
			else {
				listOrd.anadirWebEn(lista.obtenerElemento(der),indice  );
				indice++;
				der++;
				
			}
		}
		
		if(izq>centro) {
			while(der<=fin) {
				listOrd.anadirWebEn(lista.obtenerElemento(der),indice);
				indice++;
				der++;
				
			}
		}
		
		else {
			while(izq<=centro) {
				listOrd.anadirWebEn(lista.obtenerElemento(izq),indice);
				indice++;
				izq++;
				
			}
		}
		for(int j=inicio; j<=fin; j++) {
			lista.sustituir(j, listOrd.obtenerElemento(j-inicio));
		}
	
		
	}
	private void sustituir(int pInd, Web pWeb) {
		this.lista.set(pInd, pWeb);
	}
	public void resetear() {
		this.lista= new ArrayList<Web>();
	}
	
//	public ArrayList<String> enlacesSalientes(String s){
//		                
//		
//	}
	
}

