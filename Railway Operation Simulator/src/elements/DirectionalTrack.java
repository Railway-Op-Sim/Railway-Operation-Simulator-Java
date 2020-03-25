package elements;

public class DirectionalTrack extends Track {
	private Direction direction;
	

	public DirectionalTrack(ElementType elementType, int xLocation, int yLocation, boolean electrified, String methodOfElectrification, Direction direction) {
		this.elementType = elementType;
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.electrified = electrified;
		this.methodOfElectrification = methodOfElectrification;
		this.direction = direction;
		this.location = false;
		this.locationName = null;

	}
	
	

}
