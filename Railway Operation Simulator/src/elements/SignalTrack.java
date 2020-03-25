package elements;

public class SignalTrack extends Track {
	SignalAspect aspect;
	Track nextSignalBlock;
	Track nextTwoSignalBlock;
	Track nextThreeSignalBlock;
	boolean state;

	public SignalTrack(ElementType elementType, int xLocation, int yLocation, boolean electrified, String methodOfElectrification, SignalAspect aspect) {
		this.elementType = elementType;
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.electrified = electrified;
		this.methodOfElectrification = methodOfElectrification;
		this.aspect = aspect;
		this.location = false;
		this.locationName = null;

	}
	
	

	public SignalAspect getAspect() {
		return aspect;
	}



	public void setAspect(SignalAspect aspect) {
		this.aspect = aspect;
	}



	public Track getNextSignalBlock() {
		return nextSignalBlock;
	}

	public void setNextSignalBlock(Track nextSignalBlock) {
		this.nextSignalBlock = nextSignalBlock;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	

}
