package project;

import java.util.*;

public class MediaRentalManger implements MediaRentalInt {
	private ArrayList<Customer> CST = new ArrayList<Customer>();  //Create an Array list for the customers. 
	private ArrayList<Media> MED = new ArrayList<Media>();  //Create an array list for the media.

	public MediaRentalManger() {

	}

	public MediaRentalManger(ArrayList<Customer> cST, ArrayList<Media> mED) {
		super();
		CST = cST;
		MED = mED;
	}

	@Override
	public void addCustomer(String name, String address, String plan) {  //add customer method
		if (plan.equalsIgnoreCase("limited"))  //if plan = limit set the limit 2
			CST.add(new Customer(name, address, plan, 2)); 

		else  //else put the limit = 1000000
			CST.add(new Customer(name, address, plan, 100000)); //add customer to array list of customers
	}

	@Override
	public void addMovie(String title, int copiesAvailable, String rating) {  //add movie method
		MED.add(new Movie(title, copiesAvailable, rating));  //add movie to array list of media
	}

	@Override
	public void addGame(String title, int copiesAvailable, double weight) {
		MED.add(new Game(title, copiesAvailable, weight));  //add game to array list of media
	}

	@Override
	public void addAlbum(String title, int copiesAvailable, String artist, String songs) {
		MED.add(new Album(title, copiesAvailable, artist, songs));  //add album to array list of media
	}

	@Override
	public void setLimitedPlanLimit(int value) {
		for (int i = 0; i < CST.size(); i++) {
			if (CST.get(i).getPlan().equalsIgnoreCase("limited")) { //for all customers have a plan = limit set limit = value
				CST.get(i).setLimit(value);
			}
		}
	}

	@Override
	public String getAllCustomersInfo() {
		String CstInfo = "";
		for (int i = 0; i < CST.size(); i++) {
			Customer cst = CST.get(i);
			CstInfo += cst.toString();  //for all customer add the to string method to CstInfo to return it as all customer information
		}
		return CstInfo;
	}
	
	@Override
	public String getALLMediainfo() {
		String MedInfo = "";

		for (int i = 0; i < MED.size(); i++) {
			Media med = MED.get(i);
			if (med instanceof Movie) {
				Movie Med = (Movie) MED.get(i);
				MedInfo += Med.toString();
			} else if (med instanceof Game) {
				Game Med = (Game) MED.get(i);  //for all media add the to string method to MedInfo to return it as all media information
				MedInfo += Med.toString();
			} else if (med instanceof Album) {
				Album Med = (Album) MED.get(i);
				MedInfo += Med.toString();
			}
		}
		return MedInfo;
	}
	public String getALLCartinfo() {
		String CartInfo = "";

		for (int i = 0; i < CST.size(); i++) {
			for(int j=0 ; j<CST.get(i).Cart.size() ; j++) {
			Media med = CST.get(i).Cart.get(j);
			if (med instanceof Movie) {
				Movie Med = (Movie) MED.get(i); 
				CartInfo += "Cart "+CST.get(i).getName()+" "+Med.toString();
			} else if (med instanceof Game) {
				Game Med = (Game) MED.get(i);  //for all media add the to string method to MedInfo to return it as all media information
				CartInfo += "Cart "+CST.get(i).getName()+" "+Med.toString();
			} else if (med instanceof Album) {
				Album Med = (Album) MED.get(i);
				CartInfo += "Cart "+CST.get(i).getName()+" "+Med.toString();
			}
			}
		}
		return CartInfo;
	}
	
	public String getALLprocessinfo() {
		String processInfo = "";

		for (int i = 0; i < CST.size(); i++) {
			for(int j=0 ; j<CST.get(i).Rental.size() ; j++) {
			Media med = CST.get(i).Rental.get(j);
			if (med instanceof Movie) {
				Movie Med = (Movie) MED.get(i); 
				processInfo += "process "+CST.get(i).getName()+" "+Med.toString();
			} else if (med instanceof Game) {
				Game Med = (Game) MED.get(i);  //for all media add the to string method to MedInfo to return it as all media information
				processInfo += "process "+CST.get(i).getName()+" "+Med.toString();
			} else if (med instanceof Album) {
				Album Med = (Album) MED.get(i);
				processInfo += "process "+CST.get(i).getName()+" "+Med.toString();
			}
			}
		}
		return processInfo;
	}

	@Override
	public boolean addToCart(String customerName, String mediaTitle) {

		int index = -1;
		int index1 = -1;
		int index2 = -1;
		boolean check;
		for (int i = 0; i < CST.size(); i++) {
			if (CST.get(i).getName().equalsIgnoreCase(customerName)) { //for all customer if the name of the customer in CST = customerName get the index
				index = i;
			}
		}
		for (int j = 0; j < MED.size(); j++) {
			if (MED.get(j).getTitle().equalsIgnoreCase(mediaTitle)) {//for all Media if the title of the media in MED = title get the index
				index1 = j;
			}
		}
		for (int k = 0; k < CST.get(index).Cart.size(); k++) {
			if (MED.get(index1).getTitle().equalsIgnoreCase(CST.get(index).Cart.get(k).getTitle())) { //if the media is exist in the cart set index2 = 0
				index2 = 0;
			}
		}
		if (index2 != 0) {
			CST.get(index).addMedia(MED.get(index1)); //if media does not exist add the media to cart
			check = true;
		}

		else {
			check = false;
		}
		return check;

	}

	@Override
	public boolean removeFromCart(String customerName, String mediaTitle) {
		int index = -1;
		int index1 = -1;
		int index2 = -1;
		for (int i = 0; i < CST.size(); i++) {
			if (customerName.equalsIgnoreCase(CST.get(i).getName())) {   //for all customer if the name of the customer in CST = customerName get the index
				index = i;
			}
		}
		for (int j = 0; j < MED.size(); j++) {
			if (mediaTitle.equalsIgnoreCase(MED.get(j).getTitle())) {   //for all Media if the title of the media in MED = title get the index
				index1 = j;
			}
		}

		for (int k = 0; k < CST.get(index).Cart.size(); k++) {
			if (MED.get(index1).getTitle().equals(CST.get(index).Cart.get(k).getTitle())) {   //if the media is exist in the cart set index2 = 0
				index2 = 0;
			}
		}

		if (index2 == 0) {
			CST.get(index).removeMedia(MED.get(index1));   //if media does exist remove the media to cart
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String processRequests() {
		ArrayList<Media> p = new ArrayList<Media>();
		String process = "";
		for (int i = 0; i < CST.size(); i++) {
			p = CST.get(i).Cart;//for all customer set the array list p = the card of the customer
			Collections.sort(p); 
			for (int j = 0; j < p.size(); j++) {
				if (CST.get(i).Rental.size() < CST.get(i).getLimit() && p.get(j).getCopiesAvailable() > 0) { //if the copies is available an size less the limit rent the media 
					CST.get(i).addRental(p.get(j));
					p.get(j).setCopiesAvailable(p.get(j).getCopiesAvailable() - 1); //  set the copies available -1 because there is an media rented
					process += "Sending " + p.get(j).getTitle() + " to " + CST.get(i).getName() + "\n";  // add the string to process to return it

				}
				if (CST.get(i).Rental.size() < CST.get(i).getLimit() && p.get(j).getCopiesAvailable() > 0) {
					CST.get(i).removeMedia(p.get(j));
				}
			}
		}

		return process;
	}

	@Override
	public boolean returnMedia(String customerName, String mediaTitle) {
		int index = -1;
		int index1 = -1;
		for (int i = 0; i < CST.size(); i++) {
			if (customerName.equalsIgnoreCase(CST.get(i).getName())) { //for all customer if the name of the customer in CST = customerName get the index
				index = i;
			}
		}
		for (int j = 0; j < MED.size(); j++) {
			if (mediaTitle.equalsIgnoreCase(MED.get(j).getTitle())) {  //for all Media if the title of the media in MED = title get the index
				index1 = j;
			}
		}
		for (int k = 0; k < CST.get(index).Rental.size(); k++) {
			if (CST.get(index).Cart.size() > 0
					&& MED.get(index1).getTitle().equals(CST.get(index).Rental.get(k).getTitle())) {  //if the media is exist and cart size != 0 remove the data from process
				CST.get(index).removeRental(MED.get(index1));
				MED.get(index1).setCopiesAvailable(MED.get(index1).getCopiesAvailable() + 1);
				return true;  
			}
		}
		return false;
	}

	@Override
	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs) {
		String str = "";
		ArrayList<String> STR = new ArrayList<String>();
		str += "Media with title \" " + title + " \":\n";
		for (int i = 0; i < MED.size(); i++) {
			if (MED.get(i).getTitle().equalsIgnoreCase(title)) {  //for all media if title = the title of the media add the to string method to str to return it
				str += MED.get(i).toString();
				STR.add(str);

			}
		}
		str += "Media with Rating \" " + rating + " \":\n";
		for (int i = 0; i < MED.size(); i++) {
			if (MED.get(i) instanceof Movie) {
				Movie mov = (Movie) MED.get(i);
				if (mov.getRating().equalsIgnoreCase(rating)) {   //for all media if rating = the rating of the media add the to string method to str to return it
					str += mov.toString();
					STR.add(str);
				}
			}
		}
		str += "Media with artist \" " + artist + " \":\n";
		for (int i = 0; i < MED.size(); i++) {
			if (MED.get(i) instanceof Album) {
				Album alb = (Album) MED.get(i);
				if (alb.getArtist().equalsIgnoreCase(artist)) {   //for all media if artist = the artist of the media add the to string method to str to return it
					str += alb.toString();
					STR.add(str);
				}
			}
		}
		str += "Media with songs \" " + songs + " \":\n";
		for (int i = 0; i < MED.size(); i++) {
			if (MED.get(i) instanceof Album) {
				Album alb = (Album) MED.get(i);
				if (alb.getSongs().indexOf(songs) != -1) { //for all media songs is in album songs add the to string method to str to return it
					str += alb.toString();
					STR.add(str);
				}
			}
		}
		if (title.equalsIgnoreCase("null") && rating.equalsIgnoreCase("null") && artist.equalsIgnoreCase("null")
				&& songs.equalsIgnoreCase("null")) {
			String s1 = MED.get(0).toString();
			for (int i = 1; i < MED.size(); i++) { //if all of them null return the all media data
				s1 += MED.get(i).toString();
				STR.add(s1);
			}
		}

		return STR;
	}
	public void prin() {
		System.out.println(CST.get(0).Rental.get(0).getTitle());
	}
}
