package elements;

public class Flyover extends Track {

	public Flyover(ElementType elementType, int xLocation, int yLocation, boolean electrified, String methodOfElectrification) {
		this.elementType = elementType;
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.electrified = electrified;
		this.methodOfElectrification = methodOfElectrification;

	}

}
