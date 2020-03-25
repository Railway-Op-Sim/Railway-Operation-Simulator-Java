package elements;

public class StationBridgeUnderpassTrack extends Track {

	
	public StationBridgeUnderpassTrack(ElementType elementType, int xLocation, int yLocation, boolean electrified, String methodOfElectrification) {
		this.elementType = elementType;
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.electrified = electrified;
		this.methodOfElectrification = methodOfElectrification;
		this.location = false;
		this.locationName = null;

	}

}
