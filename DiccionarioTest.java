import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiccionarioTest {
	String p1,p2,p3,p4,p5;
	@Before
	public void setUp() throws Exception {
		p1=new String("hola");
		p2=new String("ordenador");
		p3=new String("estuche");
		p4=new String("casa");
		p5=new String("ventana");
		
	}

	@After
	public void tearDown() throws Exception {
		Diccionario.getDiccionario().resetear();
	}

	@Test
	public void testCargarDiccionario() {
		Diccionario.getDiccionario().anadirPalabra("supercalifragilisticoespialidoso");
		assertTrue(Diccionario.getDiccionario().esta("supercalifragilisticoespialidoso"));
		Diccionario.getDiccionario().cargarDiccionario("words.txt");
		Diccionario.getDiccionario().imprimir();
		assertNotNull(Diccionario.getDiccionario());
	}

	@Test
	public void testAñadirPalabra() {
		Diccionario.getDiccionario().anadirPalabra(p1);
		assertTrue(Diccionario.getDiccionario().esta(p1));
		Diccionario.getDiccionario().anadirPalabra(p2);
		Diccionario.getDiccionario().anadirPalabra(p3);
		assertTrue(Diccionario.getDiccionario().esta(p2));
		assertTrue(Diccionario.getDiccionario().esta(p3));
		Diccionario.getDiccionario().imprimir();
	}

	@Test
	public void testGetDiccionario() {
		Diccionario.getDiccionario().anadirPalabra(p1);
		assertNotNull(Diccionario.getDiccionario());;
	}

	@Test
	public void testDiccionarioOrdenado() {
		//Test lista vacia
		Diccionario.getDiccionario().diccionarioOrdenado();
		Diccionario.getDiccionario().imprimir();
		//Test lista un solo elemento
		Diccionario.getDiccionario().anadirPalabra(p4);
		Diccionario.getDiccionario().diccionarioOrdenado();
		Diccionario.getDiccionario().imprimir();
		//Lista ordenada
		Diccionario.getDiccionario().anadirPalabra(p3);
		Diccionario.getDiccionario().anadirPalabra(p1);
		Diccionario.getDiccionario().anadirPalabra(p2);
		Diccionario.getDiccionario().anadirPalabra(p5);
		Diccionario.getDiccionario().diccionarioOrdenado();
		Diccionario.getDiccionario().imprimir();
		
		//Lista algo desordenada
		Diccionario.getDiccionario().resetear();
		Diccionario.getDiccionario().anadirPalabra(p1);
		Diccionario.getDiccionario().anadirPalabra(p2);
		Diccionario.getDiccionario().anadirPalabra(p3);
		Diccionario.getDiccionario().anadirPalabra(p4);
		Diccionario.getDiccionario().anadirPalabra(p5);
		Diccionario.getDiccionario().diccionarioOrdenado();
		Diccionario.getDiccionario().imprimir();
		
		//Lista muy desordenada
		Diccionario.getDiccionario().resetear();
		Diccionario.getDiccionario().anadirPalabra(p5);
		Diccionario.getDiccionario().anadirPalabra(p2);
		Diccionario.getDiccionario().anadirPalabra(p1);
		Diccionario.getDiccionario().anadirPalabra(p3);
		Diccionario.getDiccionario().anadirPalabra(p4);
		Diccionario.getDiccionario().diccionarioOrdenado();
		Diccionario.getDiccionario().imprimir();
	}
	
	@Test
	public void testEsta(){
		//Diccionario vacío
		assertFalse(Diccionario.getDiccionario().esta(p1));
		Diccionario.getDiccionario().anadirPalabra(p1);
		//1 elemento
		assertFalse(Diccionario.getDiccionario().esta(p2));
		assertTrue(Diccionario.getDiccionario().esta(p1));
		//varios elementos
		Diccionario.getDiccionario().anadirPalabra(p2);
		Diccionario.getDiccionario().anadirPalabra(p3);
		Diccionario.getDiccionario().anadirPalabra(p4);
		Diccionario.getDiccionario().anadirPalabra(p5);
		
		
		assertTrue(Diccionario.getDiccionario().esta("hola"));
		assertFalse(Diccionario.getDiccionario().esta("orpt"));
		//muchos elementos
		Diccionario.getDiccionario().resetear();
		Diccionario.getDiccionario().cargarDiccionario("words.txt");		
		Diccionario.getDiccionario().diccionarioOrdenado();
		assertTrue(Diccionario.getDiccionario().esta("world"));
		assertFalse(Diccionario.getDiccionario().esta("jhoiy"));
	}

}
