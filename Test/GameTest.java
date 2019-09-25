import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Clan;
import model.Game;

class GameTest {
	
	private Game g;
	
	public void setupScenary1() {
		g = new Game();
		g.addClan("konoha");
		g.addClan("aloha");
		g.addClan("b");
		g.addClan("caroj");
		g.addClan("darius");
		g.addClan("fogini");
		g.addClan("gatos");
		g.addClan("zippies");
	}
	
	public void setupScenary2() {
		g = new Game();
		g.addClan("konoha");
		g.addClan("aloha");
		
	}


	@Test
	void binarySearchTest() {
		setupScenary1();
		g.bubbleSortClans();
		Clan p = g.binarySearchClan("aloha");
		assertEquals(0, p.getName().compareTo("aloha"));
	}
	
	@Test
	void binarySearchTest2() {
		setupScenary1();
		g.bubbleSortClans();
		Clan p = g.binarySearchClan("fogini");
		assertTrue(p.getName().equals("fogini"));
	}
	
	@Test
	void binarySearchTest3() {
		setupScenary1();
		g.bubbleSortClans();
		
		Clan p = g.binarySearchClan("b");
	
		assertTrue(p.getName().equals("b"));
	}
	
	@Test
	void sortTest() {
		setupScenary1();
		g.bubbleSortClans();
		
		assertTrue(g.getClans().get(0).getName().equals("aloha"));
	}
	
	@Test
	void sortTest2() {
		setupScenary1();
		g.bubbleSortClans();
		
		assertTrue(g.getClans().get(1).getName().equals("b"));
	}
	
	@Test
	void sortTest3() {
		setupScenary1();
		g.bubbleSortClans();
		
		assertTrue(g.getClans().get(g.getClans().size()-1).getName().equals("zippies"));
		
	}
	
	
	
	@Test
	void removeTest() {
		setupScenary1();
		boolean d = g.removeClan("gatos");
		boolean dd = g.removeClan("darius");
		assertTrue(6==g.getClans().size());
	}
	
	@Test
	void removeTest2() {
		setupScenary1();
		boolean d = g.removeClan("gatos");
		boolean dd = g.removeClan("b");
		boolean d1 = g.removeClan("aloha");
		boolean d2 = g.removeClan("konoha");
		boolean d3 = g.removeClan("darius");
		assertTrue(3==g.getClans().size());
	}

		


}
