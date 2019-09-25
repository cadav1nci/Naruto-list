package model;

public class Ninja implements Comparable<Ninja>{
	private Technique maintech;
	private int size;
	private Ninja next;
	private Ninja previous;
	private String name;
	private String personality;
	private String creationDate;
	private double power;

	//constructor for when the character know its 2 nodes,
	public Ninja(Ninja next, Ninja previous, String name, String personality, String creationDate, double power) {
		this.next = next;
		this.previous = previous;
		this.name = name;
		this.personality = personality;
		this.creationDate = creationDate;
		this.power = power;
	}

	public Ninja(String name, String personality, String creationDate, double power) {

		this.name = name;
		this.personality = personality;
		this.creationDate = creationDate;
		this.power = power;
		this.size=0;
		
	}

	public Technique getMaintech() {
		return maintech;
	}

	public void setMainTech(Technique t) {
		this.maintech = t;
	}

	public Ninja getNext() {
		return next;
	}

	public void setNext(Ninja c) {
		this.next = c;
	}

	public Ninja getPrevious() {
		return previous;
	}

	public void setPrevious(Ninja p) {
		this.previous = p;
	}

	public String getName() {
		return name;
	}

	public String getPersonality() {
		return personality;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public double getPower() {
		return power;
	}

	@Override
	public String toString() {
		return "name: " + name + ", personality: " + personality
				+ ", creationDate: " + creationDate + ", power: " + power + "";
	}
	
	public String toStringTech() {
		return "name: "+name+" "+maintech.getName()+"power: "+(this.power*maintech.getFactor());
	}
	
	
	//String name, double factor
	public void addTechnique(String name, double factor) {
		Technique t = new Technique(name, factor);
		if(maintech==null) {
			maintech= t;
			size++;
		}else {
			Technique temp = maintech;
			maintech=t;
			maintech.setNext(temp);
			size++;
		}
	}
	
	public String showTechniques() {
		String msg=null;
		if (maintech!=null) {
			Technique next = maintech;
			while(next!=null) {
				msg+=this.name+" "+next.getName()+"power: "+((int)this.power*next.getFactor())+"\n";
				next=next.getNext();
			}
			
		}
		return msg;
	}
	
	public Technique searchTechnique(String n) {
		Technique t = null;
		if (maintech!=null) {
			Technique next = maintech;
			while(next!=null) {
				if(next.getName().equalsIgnoreCase(n)) {
					t=next;
					next=null;
				}else {
					next=next.getNext();
				}
			}
		}
		return t;
	}
	
	public boolean removeTechnique(String n) {
		
		boolean flag = false;
		if (maintech!=null) {
			Technique next = maintech;
			Technique prev = null;
			while(next!=null&&!flag) {
				if (next.getName().equalsIgnoreCase(n)) {
					if(next.getNext()==null) {
						prev.setNext(null);
						flag =true;
						size--;
					}else if (prev==null&&next.getNext()!=null){
						next=next.getNext();
						flag=true;
						size--;
					}
				}
				
				prev = next;
				next = next.getNext();
			}
		}
		return flag;
	}
	
	 
	public void insertionSortTecniques() {
		if(maintech!=null) {
			Technique key = maintech.getNext();
			Technique j =  maintech;
			while(j.compare(j, key)>0) {
				Technique temp = j;
		
			}
		}
		
	}
	
	

	@Override
	public int compareTo(Ninja o) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(o.getName());
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

}
