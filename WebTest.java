import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WebTest {
	Web w1,w2,w3,w4;
	Enlace e1,e2,e3;
	@Before
	public void setUp() throws Exception {
		 w1=new Web("www.youtube.com",876);
		 w2=new Web("www.gmail.com",86);
		 w3=new Web("www.ebay.com",76);
		 w4=new Web("www.amazon.com",6);
		ArrayList<Enlace> enlaces= new ArrayList<Enlace>();
		e1=new Enlace(2);
		e2=new Enlace(3);
		e3=new Enlace(4);
		enlaces.add(e1);
		enlaces.add(e2);
		enlaces.add(e3);
	}

	@After
	public void tearDown() throws Exception {
		w1=null;
		w1=null;
		w1=null;
		w1=null;
	}

	@Test
	public void testWeb() {
		Web w5=new Web("nuria.com",1);
		assertNotNull(w5);
	}

	@Test
	public void testAnadirEnlaces() {
		ArrayList<Enlace> enlaces= new ArrayList<Enlace>();
		e1=new Enlace(2);
		e2=new Enlace(3);
		e3=new Enlace(4);
		enlaces.add(e1);
		enlaces.add(e2);
		enlaces.add(e3);
		assertNotNull(enlaces);
		w1.anadirEnlaces(enlaces);
		assertNotNull(w1.getEnlaces());
	}

	@Test
	public void testGetNombre() {
		Web w1=new Web("www.youtube.com",876);
		assertTrue(w1.getNombre().equals("www.youtube.com"));
		assertFalse(w1.getNombre().equals("www.yube.com"));
	}

	@Test
	public void testAnadirPalabras() {
		fail("Not yet implemented");
	}

	@Test
	public void testLimpiarNombreWeb() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetIndice() {
		assertEquals(w1.getIndice(),876);
		assertEquals(w2.getIndice(),86);
		assertEquals(w4.getIndice(),6);
	}

}
