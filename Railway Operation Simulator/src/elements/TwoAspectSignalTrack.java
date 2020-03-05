package elements;

public class TwoAspectSignalTrack extends SignalTrack {

	public TwoAspectSignalTrack(TrackType trackType, int xLocation, int yLocation, boolean electrified, String methodOfElectrification) {
		this.trackType = trackType;
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.electrified = electrified;
		this.methodOfElectrification = methodOfElectrification;

	}

	@Override
	public String toString() {
		return "TwoAspectSignalTrack";
	}
	
	
	

}
