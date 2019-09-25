package model;

import java.io.Serializable;

import model.DLL.Node;

public class Clan implements Serializable, Comparable<Clan> {

	private static final long serialVersionUID = 1L;
	private Ninja firstCharacter;
	private Ninja lastCharacter;
	private int size;
	private String name;

	public Clan(String name) {
		this.firstCharacter = null;
		this.lastCharacter = null;

		this.name = name;
		this.size = 0;
	}

	public void setLastCharacter(Ninja c) {
		lastCharacter = c;
	}

	public Ninja getLastCharacter() {
		return lastCharacter;
	}

	public Ninja getMainCharacter() {
		return firstCharacter;
	}

	public void setMainCharacter(Ninja n) {
		this.firstCharacter = n;
	}

	public int getSize() {
		return this.size;
	}

	public void setName(String nam) {
		this.name = nam;
	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		return "name: " + this.name + " amount of ninjas: " + this.size;
	}

	// operational methods
	public boolean isEmpty() {
		return firstCharacter == null;
	}

	// add in the end of the list
	public void addInTheBeginning(String n, String per, String creat, double p) {
		if (!isEmpty()) {
			Ninja nodo = new Ninja(n, per, creat, p);
			Ninja temp = firstCharacter;
			firstCharacter=nodo;
			firstCharacter.setNext(temp);
			size++;
		} else {
			firstCharacter = new Ninja(n, per, creat, p);
			size++;
		}
	}

	public void selectionSortNinjasByName() {
		if (firstCharacter != null) {

		}

	}

	public String showNinjas() {
		String msg = "";
		if (firstCharacter != null) {
			Ninja sig = firstCharacter;
			while (sig != null) {

				msg += sig.toString() + "\n";
				sig = sig.getNext();

			}

		}
		return msg;
	}

	public boolean deleteNinja(String n) {
		boolean flag = false;
		if (firstCharacter != null) {
			Ninja sig = firstCharacter;
			while (sig != null && !flag) {
				if (sig.getName().equals(n) && sig.getPrevious() == null) {
					sig = sig.getNext();
					flag = true;
					size -= 1;
				} else if (sig.getName().contentEquals(n) && sig.getNext() == null) {
					sig.getPrevious().setNext(null);
					flag = true;
					size -= 1;
					;
				} else if (sig.getName().contentEquals(n) && sig.getNext() != null && sig.getPrevious() != null) {
					sig.getPrevious().setNext(sig.getNext());
					sig.getNext().setPrevious(sig.getPrevious());
					flag = true;
					size -= 1;
				} else {
					sig = sig.getNext();
				}
			}

		}
		return flag;
	}

	public void deleteNode(String n) {
		if (firstCharacter != null) {
			Ninja del = firstCharacter;
			// Base case
			if (firstCharacter == null || n == null) {
				return;
			}

			// If node to be deleted is head node
			if (firstCharacter.getName().equals(n)) {
				firstCharacter = firstCharacter.getNext();
				size -= 1;
			}

			// Change next only if node to be deleted
			// is NOT the last node
			if (del.getNext() != null) {
				del.getNext().setPrevious(del.getPrevious());
				size -= 1;
			}

			// Change prev only if node to be deleted
			// is NOT the first node
			if (del.getPrevious() != null) {
				del.getPrevious().setNext(del.getNext());
				size -= 1;
			}

		}

		// Finally, free the memory occupied by del
		return;
	}

	public Ninja searchNinja(String n) {
		
		if (firstCharacter != null) {
			Ninja p = null;
			boolean flag = false;
			Ninja sig = firstCharacter;
			while (sig != null && !flag) {
				if (sig.getName().equals(n)) {
					p = sig;
					flag = true;
				} else {
					sig = sig.getNext();
				}
			}
			return p;
		}
		return null;
	}

	public int compareTo(Clan c) {
		// TODO Auto-generated method stub
		return this.name.compareTo(c.getName());
	}

}
