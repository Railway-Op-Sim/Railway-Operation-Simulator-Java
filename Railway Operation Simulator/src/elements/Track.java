package elements;

public abstract class Track extends Space {
	protected String trackName;
	protected boolean electrified;
	protected String methodOfElectrification;
	protected int trackSpeed = 200;
	protected int trackLength = 100;
	protected boolean[] trackLinks = new boolean[9];
	
	/*
	 * trackLink works like thus 
	 *           0 1 2
	 *            \|/ 
	 *           3---5
	 *            /|\
	 *           6 7 8
	 */
	
	

	public Track() {
		// TODO Auto-generated constructor stub
	}


	public boolean isElectrified() {
		return electrified;
	}


	public void setElectrified(boolean electrified) {
		this.electrified = electrified;
	}


	public String getMethodOfElectrification() {
		return methodOfElectrification;
	}


	public void setMethodOfElectrification(String methodOfElectrification) {
		this.methodOfElectrification = methodOfElectrification;
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


	public boolean[] getTrackLinks() {
		return trackLinks;
	}


	public void setTrackLinks(boolean[] trackLinks) {
		this.trackLinks = trackLinks;
	}
	
	public void set1TrackLink(int position) {
		this.trackLinks[position] = true;
	}
	public void remove1TrackLink(int position) {
		this.trackLinks[position] = false;
	}



	
}
