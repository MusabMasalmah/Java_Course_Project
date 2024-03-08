package project;

public class Album extends Media implements Comparable<Media> {
	private String artist;
	private String songs;

	public Album(String title, int copiesAvailable, String artist, String songs) {
		super(title, copiesAvailable);
		this.artist = artist;
		this.songs = songs;
	}

	public String getArtist() {  //setters and getters 
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getSongs() {
		return songs;
	}

	public void setSongs(String songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {  // to string method
		return "Album " + getTitle() + " " + artist + " " + songs + " "
				+ getCopiesAvailable() + "\n";
	}

}
