package elements;

public class SignalTrack extends Track {
	SignalAspect aspect;
	Track nextSignalBlock;
	boolean state;

	public SignalTrack(TrackType trackType, int xLocation, int yLocation, boolean electrified, String methodOfElectrification, SignalAspect aspect) {
		this.trackType = trackType;
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.electrified = electrified;
		this.methodOfElectrification = methodOfElectrification;
		this.aspect = aspect;

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
