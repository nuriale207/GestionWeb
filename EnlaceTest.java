import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EnlaceTest {
	Enlace e1,e2;
	@Before
	public void setUp() throws Exception {
		e1=new Enlace(234);
		e2=null;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEnlace() {
		assertNotNull(e1);
	}

	@Test
	public void testGetNombre() {
		assertEquals(e1.getEnlace(),234);
		//assertNull(e2.getNombre());
	}

}
