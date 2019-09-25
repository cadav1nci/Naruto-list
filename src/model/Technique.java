package model;

import java.util.Comparator;

public class Technique implements Comparator<Technique>{
	private Technique next;
	private String name;
	private double factor;
	
	public Technique(String name, double factor) {
		
		this.name = name;
		this.factor = factor;
	}
	
	public void setNext(Technique t) {
		this.next = t;
	}

	public Technique getNext() {
		return this.next;
	}

	public String getName() {
		return name;
	}

	public double getFactor() {
		return factor;
	}
	
	
	@Override
	public String toString() {
		return name + " factor: " + factor + "";
	}

	@Override
	public int compare(Technique o1, Technique o2) {
		// TODO Auto-generated method stub
		return (int) (o1.getFactor()-o2.getFactor());
	}

	

}
