package project;

import java.util.ArrayList;

public class Customer extends MediaRentalManger implements Comparable<Customer> {
	private String Name;
	private String Address;
	private String Plan;
	private int Limit;
	ArrayList<Media> Cart = new ArrayList<Media>(); //array list for cart
	ArrayList<Media> Rental = new ArrayList<Media>(); //array list for rental

	public Customer() {
		super();
	}

	public Customer(String name, String address, String plan, int limit) {  //Constructor
		Name = name;
		Address = address;
		Plan = plan;
		setLimit(limit);

	}

	public String getName() {  //setters and getters
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPlan() {
		return Plan;
	}

	public void setPlan(String plan) {
		Plan = plan;
	}

	public void addMedia(Media med) {  //to add to cart array list
		Cart.add(med);
	}

	public void removeMedia(Media med) {  //to remove from cart array list
		Cart.remove(med);
	}

	public ArrayList<Media> getRental() {
		return Rental;
	}

	public void setRental(ArrayList<Media> rental) {
		Rental = rental;
	}

	public void addRental(Media med) {  //to add to rental array list
		Rental.add(med);
	}

	public void removeRental(Media med) {  // to remove from rental array list
		Rental.remove(med);
	}

	@Override
	public int compareTo(Customer o) { //compare to method to compare the abject about there names

		return this.getName().compareTo(o.getName());
	}

	public int getLimit() {
		return Limit;
	}

	public void setLimit(int limit) {
		Limit = limit;
	}

	@Override
	public String toString() {
		return "Customer " + Name + " " + Address + " " + Plan + " " + Limit + "\n";
	}

}
