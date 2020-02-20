package application;

import java.util.ArrayList;

import elements.StraightTrack;
import train.Train;


/**
 * The class that stores the Track elements, Connections and Trains.
 * @version 1.01
 * @author Jonathan K
 *
 */
public class Map {
	
	private ArrayList<StraightTrack> straightTrackList = new ArrayList<StraightTrack>();
	private ArrayList<Train> trainList = new ArrayList<Train>();
	
	public Map () {
		
	}

	public ArrayList<StraightTrack> getTrackList() {
		return straightTrackList;
	}

	public void setTrackList(ArrayList<StraightTrack> trackList) {
		this.straightTrackList = straightTrackList;
	}

	public ArrayList<Train> getTrainList() {
		return trainList;
	}

	public void setTrainList(ArrayList<Train> trainList) {
		this.trainList = trainList;
	}
	
	public void addElement(Space element) {
		if (element.equals("Straight Track")) {
			straightTrackList.add(arg0)
		}
		
	}
	
	

}
