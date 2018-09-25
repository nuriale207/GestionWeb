import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class ListaWebs {
	private ArrayList<Web> lista;

	
	public ListaWebs() {
		this.lista= new ArrayList<Web>();
	}
	
	public void cargarLista(String nomF, String nomEnlaces) {
		try {
		      Scanner entrada = new Scanner(new FileReader(nomF));
		      Scanner entrada2= new Scanner(new FileReader(nomEnlaces));
		    
		      ListaWebs lista= new ListaWebs();
		      while (entrada.hasNext()&& entrada2.hasNext()) {
			    	 			         
			         String[] datosWeb=entrada.nextLine().split("\\s+" );			         
			         int inEnlaces= Integer.parseInt(datosWeb[1]);
			         Web webAct= new Web(datosWeb[0],inEnlaces);  
			         
//			         System.out.println(datosWeb[0]);
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
			         lista.anadirWeb(webAct);
		      }
		      entrada.close();
		      entrada2.close();
		   }
		   catch(IOException e) {e.printStackTrace();{
		   
		
	}
		   }	
	
	}
	
	public void anadirWeb(Web pWeb) {
		this.lista.add(pWeb);
		
	}
	
	public void imprimir() {
		System.out.println(this.lista);
	}
	
//	public String id2String(int pId) {
//		
//	}
}
