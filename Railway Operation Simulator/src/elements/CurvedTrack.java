package elements;

public class CurvedTrack extends Track {

	public CurvedTrack(ElementType elementType, int xLocation, int yLocation, boolean electrified, String methodOfElectrification) {
		this.elementType = elementType;
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.electrified = electrified;
		this.methodOfElectrification = methodOfElectrification;
		this.location = false;
		this.locationName = null;
		// TODO Auto-generated constructor stub
	}

}
