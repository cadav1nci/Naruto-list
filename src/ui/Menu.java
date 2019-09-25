package ui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.*;

public class Menu {

	private Game g;
	private BufferedReader br;

	public Menu() {
		g = new Game("Player 1");
		br = new BufferedReader(new InputStreamReader(System.in));
		showWelcomeMsg();
		systemHandler();

	}

	public int systemMenu() {
		int value;
		while (!false) {

			System.out.println("What would you like to do?");

			System.out.println("1.  Create a clan");
			System.out.println("2.  Create a ninja");
			System.out.println("3.  assign a technique to a ninja");
			System.out.println("4.  search a clan");
			System.out.println("5.  search a ninja");
			System.out.println("6.  search a technique");
			System.out.println("7.  delete a clan");
			System.out.println("8.  delete a ninja");
			System.out.println("9.  delete a technique");
			System.out.println("10.  show clans");
			System.out.println("11.  show ninjas");
			System.out.println("12.  show techniques");
			System.out.println("13.  update information");
			System.out.println("14.  exit");

			value = askInt();

			return value;
		}
	}

	public int askInt() {
		int ret = 0;
		try {
			String i = br.readLine();
			ret = Integer.parseInt(i);

		} catch (NumberFormatException e) {
			System.out.println("Please type an Integer");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	// Method that displays a welcome message for the user
	public void showWelcomeMsg() {

		String msg = "";

		msg += "******************************************************************\n";
		msg += "****************** PET CLUB MANAGING SYSTEM **********************\n";
		msg += "*************** developed by: Antonio Cadavinci *****************\n";
		msg += "**********************Github: cadav1nci************************\n";
		msg += "*********************konoha ft cadavinci inc**********************\n";
		msg += "******************************************************************\n";

		System.out.println();
		System.out.println(msg);
	}

	public void systemHandler() {

		boolean exit = false;
		
		
			while (!exit) {

				int userInput = systemMenu();

				switch (userInput) {
				case 1:

					createClan();
					break;
				case 2:

					createNinja();
					break;
				case 3:

					createTechnique();
					break;
				case 4:

					try {
						searchClan();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 5:
					try {
						searchNinja();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 6:

					try {
						searchTechnique();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 7:

					try {
						deleteClan();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 8:

					try {
						deleteNinja();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 9:

					try {
						deleteTechnique();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 10:

					showClans();
					break;
				case 11:

					try {
						showNinjas();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;

				case 12:

					try {
						showTechniques();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;

				case 13:

					updateInfo();
					break;

				case 14:

					g.saveGame();

					exit = true;

					break;

				case 15:

				default:
					System.out.println();
					break;
				}
			}
			
		 
		System.out.println();
		System.out.println("******************************************************************");
		System.out.println("***************** Thanks for using the program *******************");
		System.out.println("******************************************************************");
	
	}

	// methods from the switch cases

	// ***
	// case 1
	// ***
	public void createClan() {
		try {
			System.out.println("Please type the name of the clan");
			String n = br.readLine();
			System.out.println("You are about to create this Clan--->" + " " + n);
			System.out.println("press 1 to confirm");
			System.out.println("press 2 togo back");
			int c = askInt();
			switch (c) {
			case 1:
				g.addClan(n);
				System.out.println("clan created succesfully");
				System.out.println();
				Runtime.getRuntime().exec("cls");
				break;
			case 2:
				systemHandler();
				break;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// ***
	// case 2
	// ***
	public void createNinja() {
		System.out.println("To which clan do you want to assign the ninja");
		System.out.println();
		System.out.println(g.showClans());
		try {
			String n = br.readLine();
			Clan c = g.binarySearchClan(n);
			// Atributes for the ninja
			System.out.println("type the name of the ninja: ");
			String nn = br.readLine();
			System.out.println("type the personality of the ninja: ");
			String per = br.readLine();
			System.out.println("type the actual date in this format: dd/mm/yy");
			String cd = br.readLine();
			System.out.println("type the power of the ninja");
			double p = Double.parseDouble(br.readLine());
			System.out.println();
			System.out.println("you are about to create the ninja---> " + nn);
			System.out.println("press 1 to accept");
			System.out.println("press 2 to go back");

			int s = Integer.parseInt(br.readLine());

			switch (s) {
			case 1:
				c.addInTheBeginning(nn, per, cd, p);
				g.saveGame();
				break;

			case 2:

				systemHandler();
				break;
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	// ***
	// case 3
	// ***
	public void createTechnique() {
		System.out.println("Type the name of the clan where is the ninja you want to give the technique to: ");
		System.out.println();
		System.out.println(g.showClans());
		try {
			String n = br.readLine();
			Clan c = g.binarySearchClan(n);
			// Atributes for the ninja
			System.out.println("type the name of the ninja: ");
			System.out.println(c.showNinjas());
			Ninja ni = c.searchNinja(n);
			System.out.println(ni.getName());
			System.out.println();
			System.out.println("type the name of the technique");
			String nt = br.readLine();
			System.out.println("type the factor of this technique");
			double p = Double.parseDouble(br.readLine());

			Technique t = new Technique(nt, p);

			System.out.println("you are about to create the technique---> " + nt + " " + "for: " + ni.getName());
			System.out.println("press 1 to accept");
			System.out.println("press 2 to go back");

			int s = Integer.parseInt(br.readLine());

			switch (s) {
			case 1:
				ni.setMainTech(t);
				System.out.println("succesfully created technique");
				g.saveGame();
				break;

			case 2:

				systemHandler();
				break;
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	// ***
	// case 4
	// ***
	public void searchClan() throws IOException {
		System.out.println("Please type the name of the clan you wanna look for: ");
		String nc = br.readLine();
		g.bubbleSortClans();
		try {
			Clan c = g.binarySearchClan(nc);
			System.out.println(c.toString());
			System.out.println();
		} catch (Exception e) {
			System.out.println("clan not found");
		}

	}

	// ***
	// case 5
	// ***
	public void searchNinja() throws IOException {
		System.out.println("Please type the name of the clan you where is the ninja: ");
		String nc = br.readLine();
		g.bubbleSortClans();
		try {
			Clan c = g.binarySearchClan(nc);
			System.out.println("Type the name of the ninja you want to look for: ");
			String nn = br.readLine();
			Ninja n1 = c.searchNinja(nn);
			System.out.println();
			System.out.println(n1.toString());

		} catch (Exception e) {
			System.out.println("clan not found");
			System.out.println("ninja not found");
		}

	}

	// ***
	// case 6
	// ***
	public void searchTechnique() throws IOException {

		System.out
				.println("Please type the name of the clan you where is the ninja whose technique you want to check: ");
		String nc = br.readLine();
		g.bubbleSortClans();
		try {
			Clan c = g.binarySearchClan(nc);
			System.out.println("Type the name of the ninja whose technique you want to look for: ");
			String nn = br.readLine();
			Ninja n1 = c.searchNinja(nn);
			System.out.println();
			System.out.println("type the name of the technique: ");
			String nt = br.readLine();
			Technique t = n1.searchTechnique(nt);
			System.out.println();
			System.out.println(t.toString());

		} catch (Exception e) {
			System.out.println("clan not found");
			System.out.println("Technique not found");
		}

	}

	// ***
	// case 7
	// ***
	public void deleteClan() throws IOException {
		System.out.println("please type the name of the clan you want to delete");
		String nc = br.readLine();
		boolean d = g.removeClan(nc);
		if (d == true) {
			System.out.println("clan removed succesfully");
		} else {
			System.out.println("clan could not be removed");
		}
	}

	// ***
	// case 8
	// ***
	public void deleteNinja() throws IOException {
		try {
			System.out.println("please type the name of the clan where is the ninja you want to delete:");
			String nc = br.readLine();
			g.bubbleSortClans();
			Clan c = g.binarySearchClan(nc);
			System.out.println();
			System.out.println("please type the name of the ninja you want to delete");
			String dn = br.readLine();
			boolean s = c.deleteNinja(dn);
			if (s == true) {
				System.out.println("ninja removed succesfully");
			} else {
				System.out.println("ninja could not be removed");
			}

		} catch (Exception e) {
			System.out.println("could not find the clan");
			System.out.println("could not delete the ninja");
		}
	}

	// ***
	// case 9
	// ***
	public void deleteTechnique() throws IOException {
		try {
			System.out.println("please type the name of the clan where is the ninja with the you want to delete:");
			String nc = br.readLine();
			g.bubbleSortClans();
			Clan c = g.binarySearchClan(nc);
			System.out.println();
			System.out.println("please type the name of the ninja that has the technique you want to delete");
			String dn = br.readLine();
			Ninja n = c.searchNinja(dn);
			System.out.println();
			System.out.println("please type the name of the technique you want to delete");
			String tn = br.readLine();
			boolean s = n.removeTechnique(tn);
			if (s == true) {
				System.out.println("technique removed succesfully");
			} else {
				System.out.println("ninja could not be removed");
			}

		} catch (Exception e) {
			System.out.println("could not find the clan");
			System.out.println("could not delete the technique");
		}

	}

	// ***
	// case 10
	// ***
	private void showClans() {
		System.out.println(g.showClans());

	}

	// ***
	// case 11
	// ***
	private void showNinjas() throws IOException {
	System.out.println("type the name of the clan to see the ninjas");
	System.out.println();
	String nc = br.readLine();
	g.bubbleSortClans();
	Clan c = g.binarySearchClan(nc);
	System.out.println();
	System.out.println(c.showNinjas());
	
	}

	// ***
	// case 12
	// ***
	private void showTechniques() throws IOException {
		try {
			System.out.println("type the name of the clan to see the ninjas");
			System.out.println();
			String nc = br.readLine();
			g.bubbleSortClans();
			Clan c = g.binarySearchClan(nc);
			System.out.println();
			System.out.println(c.showNinjas());
			System.out.println("type the name of the ninja to show the techniques: ");
			String namenin = br.readLine();
			Ninja j = c.searchNinja(namenin);
			System.out.println(j.showTechniques());
		}catch (NullPointerException e) {
			System.out.println("couldn´t find the ninja to show the techniques");
		}
		
	}

	// ***
	// case 13
	// ***
	private void updateInfo() {
		System.out.println("please choose some data to update: ");

	} 

}