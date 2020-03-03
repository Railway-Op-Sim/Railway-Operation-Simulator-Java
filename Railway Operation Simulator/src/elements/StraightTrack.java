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
	
	// Straight Horizontal, Straight Vertical, Diagonal Top Right, Diagonal Top Left

	public StraightTrack(TrackType trackType, int xLocation, int yLocation, boolean electrified, String methodOfElectrification) {
		this.trackType = trackType;
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.electrified = electrified;
		this.methodOfElectrification = methodOfElectrification;

	}
	
	public void setLinks() {
		
		switch (this.trackType) {
		
		case STRAIGHTHORIZONTAL:
			
			this.trackLinks[3] = true;
			this.trackLinks[5] = true;
			break;
		
		case STRAIGHTVERTICAL: 
			this.trackLinks[1] = true;
			this.trackLinks[7] = true;
            break; 
        case STRAIGHTRIGHTUP : 
        	this.trackLinks[2] = true;
			this.trackLinks[6] = true;
            break; 
        case STRAIGHTLEFTUP : 
        	this.trackLinks[0] = true;
			this.trackLinks[8] = true;
            break;
            
		}
	}
	
	

}
