package elements;

public class StationBridgeUnderpassTrack extends Track {

	
	public StationBridgeUnderpassTrack(TrackType trackType, int xLocation, int yLocation, boolean electrified, String methodOfElectrification) {
		this.trackType = trackType;
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.electrified = electrified;
		this.methodOfElectrification = methodOfElectrification;
		this.location = false;
		this.locationName = null;

	}

}
