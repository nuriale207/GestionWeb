import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaWebsTest {
	Web w1,w2,w3,w4,w5;
	ListaWebs L1;
	@Before
	public void setUp() throws Exception {
		
		w1=new Web("youtube.com",3);
		w2=new Web("gmail.com",4);
		w3=new Web("ebay.com",5);
		w4=new Web("amazon.com",6);
		w5=new Web("booking.com",7);
		Diccionario.getDiccionario().cargarDiccionario("words.txt");
		
		
	}

	@After
	public void tearDown() throws Exception {
		ListaWebs.getListaWebs().resetear();
		w1=null;
		w1=null;
		w1=null;
		w1=null;
		
	}

//	@Test
//	public void testListaWebs() {
//		L1.getListaWebs().cargarLista("smallindex.txt", "smallpld-arcs-1-N.txt");
//		assertNotNull(L1);
//	}

	@Test
	public void testCargarLista() {
		ListaWebs.getListaWebs().cargarLista("smallindex.txt", "smallpld-arcs-1-N.txt");
		assertEquals(ListaWebs.getListaWebs().getLength(),1000);
		
		
		
	}

	@Test
	public void testAnadirWeb() {
		ListaWebs.getListaWebs().anadirWeb(w1);
		assertNotNull(ListaWebs.getListaWebs());
		assertEquals(ListaWebs.getListaWebs().getLength(),1);
		ListaWebs.getListaWebs().anadirWeb(w2);
		ListaWebs.getListaWebs().anadirWeb(w3);
		assertEquals(ListaWebs.getListaWebs().getLength(),3);
		
	}
	
	@Test
	public void testEnlacesSalientes() {
		ListaWebs.getListaWebs().cargarLista("smallindex.txt", "smallpld-arcs-1-N.txt");
		//Web con varios enlaces salientes
		System.out.println(ListaWebs.getListaWebs().enlacesSalientes("012design.com"));
		System.out.println(ListaWebs.getListaWebs().enlacesSalientes("021cars.com"));
		
		//Web sin enlaces salientes.
		ListaWebs.getListaWebs().resetear();
		ListaWebs.getListaWebs().anadirWeb(w2);
		ListaWebs.getListaWebs().anadirWeb(w3);
		System.out.println(ListaWebs.getListaWebs().enlacesSalientes("gmail.com"));
		}

	@Test
	public void testImprimir() {
		//Imprimir lista vacía
		ListaWebs.getListaWebs().resetear();
		ListaWebs.getListaWebs().imprimir();
		
		//Imprimir lista 1 elemento
		ListaWebs.getListaWebs().anadirWeb(w2);
		ListaWebs.getListaWebs().imprimir();
		
		//Imprimir lista larga
		ListaWebs.getListaWebs().resetear();
		ListaWebs.getListaWebs().cargarLista("smallindex.txt", "smallpld-arcs-1-N.txt");
		ListaWebs.getListaWebs().imprimir();
		

	}

	@Test
	public void testId2String() {
	
		ListaWebs.getListaWebs().cargarLista("smallindex.txt", "smallpld-arcs-1-N.txt");
		//Prueba obtener nombre del primero, último y un elemento del centro
		assertTrue(ListaWebs.getListaWebs().id2String(0).equals("0-3ani.ro"));
		assertTrue(ListaWebs.getListaWebs().id2String(3).equals("0-adult.net"));
		assertTrue(ListaWebs.getListaWebs().id2String(999).equals("005tourdial.com"));
		//Prueba id> que el número de elementos de la web
		assertFalse(ListaWebs.getListaWebs().id2String(1500).equals("005tourdial.com"));

	}
	@Test
	public void testwebOrdenada() {
		//Ordenar lista vacia
		ListaWebs.getListaWebs().webOrdenada();
		//Ordenar lista de un elemento
		ListaWebs.getListaWebs().anadirWeb(w1);
		ListaWebs.getListaWebs().webOrdenada();
		//Ordenar lista de más de un elemento parcialmente ordenada
		ListaWebs.getListaWebs().anadirWeb(w2);
		ListaWebs.getListaWebs().anadirWeb(w3);
		ListaWebs.getListaWebs().anadirWeb(w4);
		ListaWebs.getListaWebs().anadirWeb(w5);

		ListaWebs.getListaWebs().webOrdenada().imprimir();
		System.out.println();
		
		ListaWebs.getListaWebs().resetear();
			
		//prueba 2:elementos ordenados 
	
		ListaWebs.getListaWebs().anadirWeb(w4);
		ListaWebs.getListaWebs().anadirWeb(w5);
		ListaWebs.getListaWebs().anadirWeb(w3);
		ListaWebs.getListaWebs().anadirWeb(w2);
		ListaWebs.getListaWebs().anadirWeb(w1);
		ListaWebs.getListaWebs().webOrdenada().imprimir();
		
		//prueba 3:elementos desordenados completamente 
		ListaWebs.getListaWebs().resetear();
		ListaWebs.getListaWebs().anadirWeb(w1);
		ListaWebs.getListaWebs().anadirWeb(w2);
		ListaWebs.getListaWebs().anadirWeb(w3);
		ListaWebs.getListaWebs().anadirWeb(w5);
		ListaWebs.getListaWebs().anadirWeb(w4);
		ListaWebs.getListaWebs().webOrdenada().imprimir();
		
		//prueba 4: lista de varios elementos
		ListaWebs.getListaWebs().resetear();
		ListaWebs.getListaWebs().cargarLista("smallindex.txt", "smallpld-arcs-1-N.txt");
		ListaWebs.getListaWebs().webOrdenada().imprimir();
	}
	
	@Test
	
	public void testString2Id() {
		//Lista vacía
		ListaWebs.getListaWebs().string2Id("hola");
		
		//Lista de un elemento
		ListaWebs.getListaWebs().anadirWeb(w1);
		assertEquals(ListaWebs.getListaWebs().string2Id("youtube.com"),3);
		assertNotEquals(ListaWebs.getListaWebs().string2Id("0-3ani.ro"),2);
		ListaWebs.getListaWebs().resetear();
		ListaWebs.getListaWebs().cargarLista("smallindex.txt", "smallpld-arcs-1-N.txt");
		//Prueba string bien indicado, primer, último y elemento del centro.
		assertEquals(ListaWebs.getListaWebs().string2Id("0-3ani.ro"),0);
		assertEquals(ListaWebs.getListaWebs().string2Id("000880.com"),206);
		assertEquals(ListaWebs.getListaWebs().string2Id("005tourdial.com"),999);
		//String mal índicado
		assertNotEquals(ListaWebs.getListaWebs().string2Id("hola.ro"),0);
		assertEquals(ListaWebs.getListaWebs().string2Id("hola.ro"),-1);

		 

	}
	
	@Test
	public void testWord2Webs (){
		
		ListaWebs.getListaWebs().cargarLista("smallindex.txt", "smallpld-arcs-1-N.txt");
		//Ninguna web tiene la palabra
		System.out.println(ListaWebs.getListaWebs().word2Webs("kaixo"));
		//Una web tiene la palabra
		System.out.println(ListaWebs.getListaWebs().word2Webs("world"));
		//Varias webs tienen la palabra
		System.out.println(ListaWebs.getListaWebs().word2Webs("sex"));
		//Lista vacia
		ListaWebs.getListaWebs().resetear();
		ListaWebs.getListaWebs().word2Webs("world");
	}
	@Test
	public void testWebs2Words (){
		
		ListaWebs.getListaWebs().cargarLista("smallindex.txt", "smallpld-arcs-1-N.txt");
		//la web no está en la lista
		System.out.println(ListaWebs.getListaWebs().web2Words("hola.com"));
		//la web está en la lista. Caso1: No contiene palabras. Caso2: no contiene letras. 
		//Caso3:contiene una palabra. Caso4: contiene varias palabras.
		System.out.println(ListaWebs.getListaWebs().web2Words("021bg.com"));
		System.out.println(ListaWebs.getListaWebs().web2Words("0120600611.com"));
		System.out.println(ListaWebs.getListaWebs().web2Words("01wed.com"));
		System.out.println(ListaWebs.getListaWebs().web2Words("007radardetectors.com "));

	}
	@Test
	public void testGetLength (){
		//Lista vacia
		assertEquals(ListaWebs.getListaWebs().getLength(),0);
		ListaWebs.getListaWebs().anadirWeb(w1);
		//Lista un elemento
		assertEquals(ListaWebs.getListaWebs().getLength(),1);
		//Lista varios elementos
		ListaWebs.getListaWebs().cargarLista("smallindex.txt", "smallpld-arcs-1-N.txt");
		assertEquals(ListaWebs.getListaWebs().getLength(),1001);

	}
	@Test
	public void testListaXXL (){
		ListaWebs.getListaWebs().cargarLista("index.txt", "pld-arcs-1-N.txt");
		//ListaWebs.getListaWebs().imprimir();
		
		System.out.println(ListaWebs.getListaWebs().enlacesSalientes("zzzwebhosting.com"));
		System.out.println(ListaWebs.getListaWebs().string2Id("zzzwebhosting.com"));
		System.out.println(ListaWebs.getListaWebs().string2Id("sfdasgasrgsg"));
		
		System.out.println(ListaWebs.getListaWebs().word2Webs("world"));
		
		
	}
		
	@Test
	public void testGuardarWebs(){
		ListaWebs.getListaWebs().guardarWebs("vacio.txt", "vacioIndex.txt");
		
		ListaWebs.getListaWebs().cargarLista("smallindex.txt", "smallpld-arcs-1-N.txt");
		ListaWebs.getListaWebs().guardarWebs("nuevo.txt","nuevoEnlaces.txt");
		ListaWebs.getListaWebs().anadirWeb(w1);
		ListaWebs.getListaWebs().guardarWebs("nuevo.txt","nuevoEnlaces.txt");
		ListaWebs.getListaWebs().guardarWebs("nuevo2.txt","nuevo2Enlaces.txt");

	}
}
