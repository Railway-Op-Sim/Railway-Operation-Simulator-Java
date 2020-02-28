package elements;

public class BufferedTrack extends Track {

	public BufferedTrack(String trackName, int xLocation, int yLocation, boolean electrified,
			String methodOfElectrification) {
		this.trackName = trackName;
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.electrified = electrified;
		this.methodOfElectrification = methodOfElectrification;

	}

	public void setLinks() {

		switch (this.trackName) {

		case "Left Buffer":
			this.trackLinks[5] = true;
			break;
			
		case "Right Buffer":
			this.trackLinks[3] = true;
			break;
			
		case "Top Buffer":
			this.trackLinks[7] = true;
			break;
			
		case "Bottom Buffer":
			this.trackLinks[1] = true;
			break;
			
		case "Top Left Buffer":
			this.trackLinks[0] = true;
			break;
			
		case "Top Right Buffer":
			this.trackLinks[2] = true;
			break;
			
		case "Bottom Left Buffer":
			this.trackLinks[6] = true;
			break;
			
		case "Bottom Right Buffer":
			this.trackLinks[8] = true;
			break;
			
		}
	}

}
