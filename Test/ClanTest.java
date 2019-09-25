import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Clan;
import model.Ninja;

class ClanTest {
	Clan c;
	public void setupScenary1() {
		c=new Clan("lokos");
		c.addInTheBeginning("aruto", "funny", "02/10/1997", 100);
		c.addInTheBeginning("baruto", "sad", "02/10/1997", 200);
		c.addInTheBeginning("caruto", "angry", "02/10/1997", 200);
		c.addInTheBeginning("daruto", "crazy", "02/10/1997", 200);
	}
	
	public void setupScenary2() {
		c=new Clan("lokos");
		
	}
	
	public void setupScenary3() {
		c=new Clan("lokos");
		c.addInTheBeginning("aruto", "funny", "02/10/1997", 100);
		c.addInTheBeginning("baruto", "funny", "02/10/1997", 100);
	}
	
	
	@Test
	public void  isEmptyTest() {
		setupScenary2();
		assertTrue(c.isEmpty());
	}
	
	

	@Test
	public void  isEmptyTest2() {
		setupScenary1();
		assertFalse(c.isEmpty());
	}
	
	@Test
	public void  addTest() {
		setupScenary1();
		c.addInTheBeginning("eruto", "fun", "03/10/1999", 300);
		assertTrue(c.getSize()==5);
	}
	
	@Test
	public void  addTest2() {
		setupScenary1();
		c.addInTheBeginning("eruto", "fun", "03/10/1999", 300);
		c.addInTheBeginning("fruto", "fun", "03/10/1999", 300);
		c.addInTheBeginning("gruto", "fun", "03/10/1999", 300);
		c.addInTheBeginning("hiruto", "fun", "03/10/1999", 300);
		assertTrue(c.getSize()==8);
	}
	
	@Test
	public void  addTest3() {
		setupScenary3();
		c.addInTheBeginning("eruto", "fun", "03/10/1999", 300);
		
		assertTrue(c.getSize()==3);
	}
	
	@Test
	public void  deleteTest() {
		setupScenary1();
		c.deleteNode("aruto");
		
			assertTrue(c.getSize()==3);
	}
	
	@Test
	public void  deleteTest2() {
		setupScenary1();
		c.deleteNode("aruto");
		c.deleteNode("baruto");
		c.deleteNode("caruto");
		assertEquals(1, c.getSize());
	}
	
	@Test
	public void  deleteTest3() {
		setupScenary3();
		c.deleteNode("aruto");
		
		assertTrue(c.getSize()==1);
	}
	
	@Test
	public void  searchTest() {
		setupScenary1();
		Ninja n = c.searchNinja("aruto");
		
		assertTrue(n.getName().equals("aruto"));
	}
	
	@Test
	public void  searchTest2() {
		setupScenary3();
		Ninja n = c.searchNinja("baruto");
		
		assertTrue(n.getName().equals("baruto"));
	}
	
	@Test
	public void  searchTest3() {
		setupScenary1();
		Ninja n = c.searchNinja("daruto");
		
		assertTrue(n.getName().equals("daruto"));
	}


	@Test
	public void  sortTest() {
		
	}
	
	@Test
	public void  sortTest2() {
		
	}
	

}
