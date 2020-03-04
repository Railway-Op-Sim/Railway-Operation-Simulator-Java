package elements;

public class DirectionalTrack extends Track {
	private Direction direction;
	

	public DirectionalTrack(TrackType trackType, int xLocation, int yLocation, boolean electrified, String methodOfElectrification, Direction direction) {
		this.trackType = trackType;
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.electrified = electrified;
		this.methodOfElectrification = methodOfElectrification;
		this.direction = direction;

	}
	
	

}
