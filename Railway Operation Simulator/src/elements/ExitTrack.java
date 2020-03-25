package elements;

public class ExitTrack extends Track {
	Direction exit;

	public ExitTrack(ElementType elementType, int xLocation, int yLocation, boolean electrified, String methodOfElectrification) {
		this.elementType = elementType;
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.electrified = electrified;
		this.methodOfElectrification = methodOfElectrification;
		this.exit = exit;
		this.location = false;
		this.locationName = null;

	}

}
