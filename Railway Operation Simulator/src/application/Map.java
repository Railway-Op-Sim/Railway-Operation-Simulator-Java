package application;

import java.util.ArrayList;

import elements.Space;
import elements.StraightTrack;
import elements.Track;
import train.Train;


/**
 * The class that stores the Track elements, Connections and Trains.
 * @version 1.01
 * @author Jonathan K
 *
 */
public class Map {
	
	private ArrayList<Track> trackList = new ArrayList<Track>();
	private ArrayList<Train> trainList = new ArrayList<Train>();
	
	public Map () {
		
	}

	public ArrayList<Track> getTrackList() {
		return trackList;
	}

	public void setTrackList(ArrayList<Track> trackList) {
		this.trackList = trackList;
	}

	public ArrayList<Train> getTrainList() {
		return trainList;
	}

	public void setTrainList(ArrayList<Train> trainList) {
		this.trainList = trainList;
	}
	
	public void addTrack(StraightTrack element) {
		trackList.add(element);
	}
	
	public void makeStraightTRackLinks() {
		for(int i = 0; i<trackList.size();i++) {
			for (int j = 1; j<trackList.size();j++) {
				Track track1 = trackList.get(i);
				Track track2 = trackList.get(j);
				
		}
	}
	
	}

}
