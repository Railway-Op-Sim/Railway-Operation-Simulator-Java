package elements;

public class StraightTrack extends Track {

	public StraightTrack(int xLocation, int yLocation, boolean electrified, String methodOfElectrification
			, int trackID, int trackSpeed, int trackLength) {
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		 electrified;
		protected String methodOfElectrification;

		protected int trackID;
		protected int trackSpeed;
		protected int trackLength;
		protected Track leftLink;
		protected Track rightLink;
		protected Track upLink;
		protected Track downLink;
		
	}

}
