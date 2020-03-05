package elements;

public abstract class SignalTrack extends Track {
	Track nextSignalBlock;
	boolean state;

	public SignalTrack() {
		// TODO Auto-generated constructor stub
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
