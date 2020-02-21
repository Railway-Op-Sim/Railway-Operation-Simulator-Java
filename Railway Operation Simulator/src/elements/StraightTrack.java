package elements;

public class StraightTrack extends Track {
	
	/*
	 * trackLink works like thus 
	 *           0 1 2
	 *            \|/ 
	 *           3---5
	 *            /|\
	 *           6 7 8
	 */

	public StraightTrack(String trackName, int xLocation, int yLocation, boolean electrified, String methodOfElectrification
			, int trackID, int trackSpeed, int trackLength) {
		this.trackName = trackName;
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.electrified = electrified;
		this.methodOfElectrification = methodOfElectrification;
		this.trackID = trackID;
		this.trackSpeed = trackSpeed;
		this.trackLength = trackLength;

	}
	
	public void setLinks() {
		
		switch (this.trackName) {
		
		case "Straight Horizontal":
			
			this.trackLinks[3] = true;
			this.trackLinks[5] = true;
			break;
		
		case "Straight Vertical": 
			this.trackLinks[1] = true;
			this.trackLinks[7] = true;
            break; 
        case "Diagonal Top Right": 
        	this.trackLinks[2] = true;
			this.trackLinks[6] = true;
            break; 
        case "Diagonal Top Left": 
        	this.trackLinks[0] = true;
			this.trackLinks[8] = true;
            break;
		}
	}
	
	

}
