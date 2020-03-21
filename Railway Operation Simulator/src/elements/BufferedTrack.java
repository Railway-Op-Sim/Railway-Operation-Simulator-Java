package elements;

public class BufferedTrack extends Track {

	public BufferedTrack(TrackType trackType, int xLocation, int yLocation, boolean electrified,
			String methodOfElectrification) {
		this.trackType = trackType;
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.electrified = electrified;
		this.methodOfElectrification = methodOfElectrification;
		this.location = false;
		this.locationName = null;

	}

	public void setLinks() {

		switch (this.trackType) {

		case BUFFERLEFT:
			this.trackLinks[5] = true;
			break;
			
		case BUFFERRIGHT:
			this.trackLinks[3] = true;
			break;
			
		case BUFFERUP:
			this.trackLinks[7] = true;
			break;
			
		case BUFFERDOWN:
			this.trackLinks[1] = true;
			break;
			
		case BUFFERLEFTUP:
			this.trackLinks[8] = true;
			break;
			
		case BUFFERRIGHTUP:
			this.trackLinks[6] = true;
			break;
			
		case BUFFERLEFTDOWN:
			this.trackLinks[2] = true;
			break;
			
		case BUFFERRIGHTDOWN:
			this.trackLinks[0] = true;
			break;
			
		}
	}

}
