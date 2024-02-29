package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CountDownLatch;

public class Driver { 
	static Scanner input = new Scanner(System.in); 
	static ArrayList<Customer> CST = new ArrayList<Customer>();  // Array list for the customers
	static ArrayList<Media> MED = new ArrayList<Media>();  // Array list for the media 
	static MediaRentalManger DataBase = new MediaRentalManger(CST, MED); //data base from type media rental

	public static void main(String[] args) {
		try {
			readFiles1();  //call  the method that give all data the user input it befro this time
		} catch (Exception e) {
			System.out.println("there is an erorr!!");
		}
		System.out.println("DATA_BASE: (Musab Masalmah)\n\n"); 
		System.out.printf(
				"1)Add a customer. \n\n2)Add a media.\n\n3)Add to cart.\n\n4)Remove from cart.\n\n5)process.\n\n6)Return Media.\n\n7)Search Media.\n\n8)Print All Customar Information.\n\n9)Print All Media Information.\n\n10)Save.\n\n0)Exit.\n\nEnter your choice:");
		try {
			int choice = input.nextInt();

			while (choice != 0) { 

				switch (choice) {  //switch to choice the user to choice the thing he want it 
				case 1: {
					testAddingCustomers();
					break;
				}
				case 2: {
					testAddingMedia();  //call method 
					break;
				}
				case 3: {
					testingAddingToCart();  //call method
					break;
				}
				case 4: {
					testingRemovingFromCart();  //call method
					break;
				}
				case 5: {
					testProcessingRequestsOne();  //call method
					break;
				}
				case 6: {
					testReturnMedia();  //call method
					break;
				}
				case 7: {
					testSearchMedia();  //call method  
					break;
				}
				case 8: {
					printCoustmerInfo();  //call method
					break;
				}
				case 9: {
					printMediaInfo();  //call method
					break;
				}
				case 10: {
					try {
						FileWriter medWriter = new FileWriter("Media.txt"); //file writer that append data to file 
						medWriter.append(DataBase.getALLMediainfo());
						medWriter.close();
						
						FileWriter custWriter = new FileWriter("Customer.txt");//file writer that append data to file
						custWriter.append(DataBase.getAllCustomersInfo());
						custWriter.close();
						
						FileWriter cartWriter = new FileWriter("Cart.txt");//file writer that append data to file
						cartWriter.append(DataBase.getALLCartinfo());
						cartWriter.close();
						
						FileWriter processWriter = new FileWriter("process.txt");//file writer that append data to file
						processWriter.append(DataBase.getALLprocessinfo());
						processWriter.close();
						
						
						
					} catch (IOException e) { 
						System.out.println("An error occurred.");
					}
					break;
				}
				
				}
				System.out.printf(
						"1)Add a customer. \n\n2)Add a media.\n\n3)Add to cart.\n\n4)Remove from cart.\n\n5)process.\n\n6)Return Media.\n\n7)Search Media.\n\n8)Print All Customar Information.\n\n9)Print All Media Information.\n\n10)Save.\n\n0)Exit.\n\nEnter your choice:");
				choice = input.nextInt();
			}
			
		} catch (InputMismatchException e) {
			System.out.println("input erorr!");
		} catch (Exception e) {  //catching errors
			System.out.println("Error!!!");
		} 
	
	    

	}

	public static void testAddingCustomers() throws IOException {
		try {
			System.out.println("How many customer do you want to add?");
			int NumberOfCustomer = input.nextInt();
			for (int i = 0; i < NumberOfCustomer; i++) {
				System.out.println("Enter the name of the customer " + (i + 1) + " :");
				String name = input.next();
				System.out.println("Enter the address of the customer " + (i + 1) + " :");  //read the data 
				String address = input.next();
				System.out.println("Enter the plan of the customer " + (i + 1) + "(limited or unlimited) :");
				String plan = input.next();
				DataBase.addCustomer(name, address, plan);  //insert the data to the data base
			}
		} catch (InputMismatchException e) {
			System.out.println("Invaled input data.");
		} catch (IllegalArgumentException e) {  //catching the erorrs
			e.getMessage();
		} 
			catch (Exception e) {
			System.out.println("Erorr!!");
		}
	}

	public static void testAddingMedia() throws IOException {
		try {

			System.out.printf("1)Add Movie.\n2)Add Game.\n3)Add Album.\n0)Exit.");
			int choice = input.nextInt();
			while (choice != 0) {
				switch (choice) {
				case 1: {
					try {
						System.out.println("Enter the movie title:");
						String title = input.next();
						System.out.println("Enter the number of copies available:");  //read the data
						int copiesAvailable = input.nextInt();
						System.out.println("Enter the movie rating:");
						String rating = input.next();
						DataBase.addMovie(title, copiesAvailable, rating);  //insert the data on data base
						break;
					} catch (InputMismatchException e) {
						System.out.println("Invaled input data.");
					} catch (IllegalArgumentException e) {  //  catching the errors
						e.getMessage();
					} catch (Exception e) {
						e.getMessage();
					}
				}
				case 2: {

					System.out.println("Enter the game title:");
					String title = input.next();
					System.out.println("Enter the number of copies available:");  //read data
					int copiesAvailable = input.nextInt();
					System.out.println("Enter the game weight:");
					double weight = input.nextDouble();
					DataBase.addGame(title, copiesAvailable, weight);  //add the data to the data base
					break;

				}
				case 3: {
					System.out.println("Enter the album title:");
					String title = input.next();
					System.out.println("Enter the number of copies available:");
					int copiesAvailable = input.nextInt();  
					System.out.println("Enter the artist name:");  // read data 
					String artist = input.next();
					System.out.println("Enter the songs names:");
					String songs = input.next();

					DataBase.addAlbum(title, copiesAvailable, artist, songs);  //add the data to the data base 
					break;
				}
				}
				System.out.printf("1)Add Movie.\n2)Add Game.\n3)Add Album.\n0)Exit.");
				choice = input.nextInt();
			}
		} catch (InputMismatchException e) {
			System.out.println("Invaled input data.");
		} catch (IllegalArgumentException e) {
			e.getMessage();                                  ///catching the error 
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public static void testingAddingToCart() throws IOException {
		try {
			System.out.println("Enter the name of the customer:");
			String Name = input.next();
			System.out.println("Enter the media title:");    //read the data  
			String title = input.next();
			
			System.out.println(DataBase.addToCart(Name, title));   //add the data to the data base
		} catch (InputMismatchException e) {
			System.out.println("Invaled input data.");
		} catch (IllegalArgumentException e) {            //catching the errors 
			e.getMessage();
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public static void testingRemovingFromCart() throws IOException {
		try {
			System.out.println("Enter the name of the customer:");
			String Name = input.next();
			System.out.println("Enter the media title:");  //read the data  
			String title = input.next();

			System.out.println(DataBase.removeFromCart(Name, title));   //add the data to the file
		} catch (InputMismatchException e) {
			System.out.println("Invaled input data.");
		} catch (IllegalArgumentException e) {           //catching the errors  
			e.getMessage();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void testProcessingRequestsOne() {
		System.out.println(DataBase.processRequests()); 
	}

	public static void testReturnMedia() throws IOException {
		try {
			System.out.println("Enter the name of the customer:");
			String Name = input.next();
			System.out.println("Enter the media title:");   //read the data
			String title = input.next();
			
			System.out.println(DataBase.returnMedia(Name, title));   //add the data to the data base
		} catch (InputMismatchException e) {
			System.out.println("Invaled input data.");
		} catch (IllegalArgumentException e) {          //catching the errors
			e.getMessage();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void testSearchMedia() throws IOException {
		try {
			System.out.println("Enter the title:");
			String title = input.next();
			System.out.println("Enter the rating:");
			String rating = input.next();              //read the data
			System.out.println("Enter the artist:");
			String artist = input.next();
			System.out.println("Enter the songs:");
			String songs = input.next();

			ArrayList<String> STR = DataBase.searchMedia(title, rating, artist, songs);   //array list contain the data that the user search about it

			System.out.println(STR.get(STR.size() - 1));   //print the last index    

		} catch (InputMismatchException e) {
			System.out.println("Invaled input data.");
		} catch (IllegalArgumentException e) {
			e.getMessage();                               //catching the errors
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public static void printCoustmerInfo() {
		System.out.println(DataBase.getAllCustomersInfo());   //given the method that print the data od customers from the data base
	}

	public static void printMediaInfo() {
		System.out.println(DataBase.getALLMediainfo());       //given the method that print the data of media from the data base
	}
	
	public static void readFiles1() {
		try {
			File custObj = new File("Customer.txt");
			Scanner custReader = new Scanner(custObj);   //reader to read the data from file and put it in the data base
			String str = "";    
			while (custReader.hasNext()) {
				str = custReader.nextLine();
				String[] add = str.split(" "); //array of string to put the data from file in it 
					DataBase.addCustomer(add[1], add[2], add[3]);
			}
			custReader.close();
			
			File medObj = new File("Media.txt");
			Scanner medReader = new Scanner(medObj);   //reader to read the data from file and put it in the data base
			String str1 = "";    
			while (medReader.hasNext()) {
				str1 = medReader.nextLine();
				String[] Add = str1.split(" ");
				if(Add[0].equalsIgnoreCase("Movie")) {
					Integer add1 = Integer.parseInt(Add[3]);   //change the type of the string to integer
					DataBase.addMovie(Add[1], add1, Add[2]);
					}
				else if(Add[0].equalsIgnoreCase("Game")) { 
				Integer add1 = Integer.parseInt(Add[3]); //change the type of the string to integer
				Double add2 = Double.parseDouble(Add[3]);  //change the type of the string to double
				DataBase.addGame(Add[1], add1, add2);  //add the data to the data base
				}
				else if(Add[0].equalsIgnoreCase("Album")) {
				Integer add1 = Integer.parseInt(Add[4]);   //change the type of the string to integer
				DataBase.addAlbum(Add[1], add1, Add[2], Add[3]);  //add the data to the data base
				}
			}
			medReader.close();
			
			File cartObj = new File("Cart.txt");
			Scanner cartReader = new Scanner(cartObj);   //reader to read the data from file and put it in the data base
			String str2 = "";    
			while (cartReader.hasNext()) {
				str2 = cartReader.nextLine();
				String[] add = str2.split(" "); //array of string to put the data from file in it 
				DataBase.addToCart(add[1], add[3]);  //add the data to the data base
			}
			cartReader.close();
			
		} catch (FileNotFoundException e) { 
			System.out.println("An error occurred.");
		}
	} 

}


