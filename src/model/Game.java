package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable{
	private ArrayList <Clan> clans;
	private String name;

	
	
	//constructor for creating a game with a main clan
	public Game(String k) {
		this.name= k;
		clans = new ArrayList<Clan>();
		loadGame();
		
	}
	
	public Game() {
		this.name="los pibes";
		clans = new ArrayList<Clan>();
	}

	public void addClan(String name) {
		Clan e = new Clan (name);
		clans.add(e);
		saveGame();
	}
	
	public ArrayList<Clan> getClans(){
		return this.clans;
	}
	public boolean removeClan(String n) {
		boolean flag = false;
		for (int i = 0; i < clans.size()&&!flag; i++) {
			if (clans.get(i).getName().equals(n)) {
				clans.remove(i);
				flag = true;
			}else {
				continue;
			}
		}
		return flag;
	}
	
	
	public void bubbleSortClans() {
		for (int i = clans.size(); i>0; i--) {
			for (int j = 0;j<i-1;j++) {
				if(clans.get(j).compareTo(clans.get(j+1))>0) {
					Clan temp = clans.get(j);
					clans.set(j, clans.get(j+1));
					clans.set(j+1, temp);
					
				}
			}
		}
	}
	
	public Clan binarySearchClan(String n) {
		int beg = 0;
		int last = clans.size();
		int mid =0;
		boolean flag = false;
		while(beg<=last&&!flag) {
			mid = (last-beg)/2;
			if (clans.get(mid).getName().compareTo(n)<0) {
				beg=mid+1;
			}else if (clans.get(mid).getName().compareTo(n)>0) {
				last=mid-1;
			}else {
				flag=true;
			}
			
		}
		return clans.get(mid);
	}
	
	public String showClans() {
		String msg ="";
		for(int i =0; i<clans.size();i++) {
			msg+= i+"]"+" "+clans.get(i).toString()+"\n";
		}
		
		return msg;
	}
	
	
	public void saveGame() {
		try {

			File f = new File("serialized/game");
			ObjectOutputStream fichero = new ObjectOutputStream(new FileOutputStream(f));
			fichero.writeObject(clans);
			System.out.println();
			fichero.close();

		} catch (Exception e1) {
			System.out.println("llega aca mi so");
		}
	}

	
	
		public void loadGame() {

			System.out.println("loading data ....");
			try {
				File f = new File("serialized/game");

				ObjectInputStream fichero_recuperado = new ObjectInputStream(new FileInputStream(f));
				clans = (ArrayList<Clan>) fichero_recuperado.readObject();
				
				fichero_recuperado.close();
			} catch (Exception e) {
				clans=new ArrayList<Clan>();
	}
	

		}
}
