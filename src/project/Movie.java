package project;

public class Movie extends Media implements Comparable<Media> {
	private String Rating;

	public Movie(String title, int copiesAvailable, String Rating) {
		super(title, copiesAvailable);
		this.Rating = Rating;

	}

	public String getRating() { //setters and getters 
		return Rating;
	}

	public void setRating(String rating) {
		Rating = rating;
	}

	@Override
	public String toString() {  // to string method
		return "Movie " + getTitle() + " " + Rating + " " + getCopiesAvailable()
				+ "\n"; 
	}
}
