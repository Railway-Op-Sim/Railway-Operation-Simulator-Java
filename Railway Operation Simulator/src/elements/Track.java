package elements;

public abstract class Track extends Space {
	protected Track leftLink;
	protected Track rightLink;
	protected Track upLink;
	protected Track downLink;
	

	public Track() {
		// TODO Auto-generated constructor stub
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
