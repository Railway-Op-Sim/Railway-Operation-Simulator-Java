package elements;

public abstract class Track extends Space {
	protected String trackName; 
	protected int trackID;
	protected int trackSpeed;
	protected int trackLength;
	protected Track leftLink;
	protected Track rightLink;
	protected Track upLink;
	protected Track downLink;
	

	public Track() {
		// TODO Auto-generated constructor stub
	}


	public String getTrackName() {
		return trackName;
	}


	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}


	public int getTrackID() {
		return trackID;
	}


	public void setTrackID(int trackID) {
		this.trackID = trackID;
	}


	public int getTrackSpeed() {
		return trackSpeed;
	}


	public void setTrackSpeed(int trackSpeed) {
		this.trackSpeed = trackSpeed;
	}


	public int getTrackLength() {
		return trackLength;
	}


	public void setTrackLength(int trackLength) {
		this.trackLength = trackLength;
	}


	public Track getLeftLink() {
		return leftLink;
	}


	public void setLeftLink(Track leftLink) {
		this.leftLink = leftLink;
	}


	public Track getRightLink() {
		return rightLink;
	}


	public void setRightLink(Track rightLink) {
		this.rightLink = rightLink;
	}


	public Track getUpLink() {
		return upLink;
	}


	public void setUpLink(Track upLink) {
		this.upLink = upLink;
	}


	public Track getDownLink() {
		return downLink;
	}


	public void setDownLink(Track downLink) {
		this.downLink = downLink;
	}
	
	

}
