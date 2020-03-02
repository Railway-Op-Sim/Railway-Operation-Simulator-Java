package elements;

public class GapLinkedTrack extends Track {
	boolean[] gapLink = new boolean[9];

	public GapLinkedTrack(String trackName, int xLocation, int yLocation, boolean electrified, String methodOfElectrification) {
		this.trackName = trackName;
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.electrified = electrified;
		this.methodOfElectrification = methodOfElectrification;

	}
	
public void setLinks() {
		
		switch (this.trackName) {
		
		case "Left Gap Linked Track":
			this.trackLinks[5] = true;

			break;
		
		case "Top Left Gap Linked Track": 
			this.trackLinks[8] = true;

            break; 
        case "Top Gap Linked Track": 
        	this.trackLinks[7] = true;
        	
            break; 
        case "Top Right Linked Track": 
        	this.trackLinks[6] = true;

            break;
        case "Right Linked Track": 
        	this.trackLinks[3] = true;

            break;
        case "Down Right Linked Track": 
        	this.trackLinks[0] = true;

            break;
        case "Down Linked Track": 
        	this.trackLinks[1] = true;

            break;
            
        case "Left Down Linked Track": 
        	this.trackLinks[2] = true;

            break;
		}
	}

}
