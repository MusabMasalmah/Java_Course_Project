package project;

public abstract class Media extends MediaRentalManger implements Comparable<Media> {
	private String title;
	private int copiesAvailable;

	public Media(String title, int copiesAvailable) {
		super();
		this.title = title;
		this.copiesAvailable = copiesAvailable;
	}

	public String getTitle() { //setters and getters
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCopiesAvailable() {
		return copiesAvailable;
	}

	public void setCopiesAvailable(int copiesAvailable) {
		this.copiesAvailable = copiesAvailable;
	}

	@Override
	public int compareTo(Media o) {  //compare to method to compare the abject about there names
		return this.getTitle().compareTo(o.getTitle());
	}
}
