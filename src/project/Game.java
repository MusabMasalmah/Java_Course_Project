package project;

public class Game extends Media implements Comparable<Media> {
	private double Weight;

	public Game(String title, int copiesAvailable, double weight) {
		super(title, copiesAvailable);
		Weight = weight;
	}

	public double getWeight() {//setters and getters
		return Weight;
	}

	public void setWeight(double weight) {
		Weight = weight;
	}

	@Override
	public String toString() {// to string method
		return "Game " + getTitle() + " " + Weight + " " + getCopiesAvailable()
				+ "\n";
	}

}
