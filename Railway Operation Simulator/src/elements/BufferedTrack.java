package elements;

import application.TrackType;

public class BufferedTrack extends Track {

	public BufferedTrack(TrackType trackType, int xLocation, int yLocation, boolean electrified,
			String methodOfElectrification) {
		this.trackType = trackType;
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.electrified = electrified;
		this.methodOfElectrification = methodOfElectrification;

	}

	public void setLinks() {

		switch (this.trackType) {

		case LEFTBUFFER:
			this.trackLinks[5] = true;
			break;
			
		case RIGHTBUFFER:
			this.trackLinks[3] = true;
			break;
			
		case UPBUFFER:
			this.trackLinks[7] = true;
			break;
			
		case DOWNBUFFER:
			this.trackLinks[1] = true;
			break;
			
		case LEFTUPBUFFER:
			this.trackLinks[0] = true;
			break;
			
		case RIGHTUPBUFFER:
			this.trackLinks[2] = true;
			break;
			
		case LEFTDOWNBUFFER:
			this.trackLinks[6] = true;
			break;
			
		case RIGHTDOWNBUFFER:
			this.trackLinks[8] = true;
			break;
			
		}
	}

}
