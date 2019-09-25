
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Ninja;

class NinjaTest {

	Ninja n;

	public void setupScenary1() {
		// String name, String personality, String creationDate, double power
		n = new Ninja("naruto", "funny", "22/09/2019", 2);
		n.addTechnique("genin", 1.2);
		n.addTechnique("jounin", 2);
		n.addTechnique("shounin", 2.2);
		n.addTechnique("kage", 3);
		n.addTechnique("kasekage", 3.2);
	}

	public void setupScenary2() {
		// String name, String personality, String creationDate, double power
		n = new Ninja("naruto", "funny", "22/09/2019", 2);
	}
	
	@Test
	public void addTest() {
		setupScenary1();
		n.addTechnique("chotos", 3);
		assertTrue(n.getSize()==6);
	}
	
	@Test
	public void addTest2() {
		setupScenary1();
		n.addTechnique("chotos", 3);
		n.addTechnique("chalas", 3);
		n.addTechnique("wachin", 4);
		assertTrue(n.getSize()==8);
	}
	
	@Test
	public void removeTest() {
		setupScenary1();
		boolean d =  n.removeTechnique("genin");
		boolean dd = n.removeTechnique("jounin");
		boolean ddd = n.removeTechnique("kasekage");
		boolean dddd = n.removeTechnique("shounin");
		//assertTrue(d&&dd);
		assertEquals(1, n.getSize());
	}
	
	@Test
	public void removeTest2() {
		//returns true if it deletes the node
		setupScenary1();
		boolean d =  n.removeTechnique("genin");
		boolean dd = n.removeTechnique("jounin");
		boolean ddd = n.removeTechnique("kasekage");
		//assertTrue(d&&dd);
		assertTrue(d&&dd&&ddd);
	}
	
	
	@Test
	public void sortTest() {
		//returns true if it deletes the node
		setupScenary1();
		n.insertionSortTecniques();
		assertTrue(n.getMaintech().getName().equals("genin"));
	}
	
	@Test
	public void sortTest2() {
		//returns true if it deletes the node
		setupScenary1();
		
	}
	
	

}
