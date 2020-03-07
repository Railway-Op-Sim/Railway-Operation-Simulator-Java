package elements;

public class ExitTrack extends Track {
	Direction exit;

	public ExitTrack(TrackType trackType, int xLocation, int yLocation, boolean electrified, String methodOfElectrification) {
		this.trackType = trackType;
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.electrified = electrified;
		this.methodOfElectrification = methodOfElectrification;
		this.exit = exit;
		this.station = false;
		this.stationName = null;

	}

}
