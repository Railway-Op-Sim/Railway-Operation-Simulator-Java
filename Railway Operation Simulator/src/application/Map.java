package application;

import java.util.ArrayList;
import java.util.HashSet;

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
	
	private HashSet<Track>  trackStore = new HashSet<Track>(); 
	private ArrayList<Track> trackList = new ArrayList<Track>();
	private ArrayList<Train> trainList = new ArrayList<Train>();
	private ArrayList<Object> otherList = new ArrayList<Object>();
	
	public Map () {
		
	}
	
	public HashSet<Track> getTrackStore() {
		return trackStore;
	}

	public void setTrackStore(HashSet<Track> trackStore) {
		this.trackStore = trackStore;
	}

	public ArrayList<Object> getOtherList() {
		return otherList;
	}

	public void setOtherList(ArrayList<Object> otherList) {
		this.otherList = otherList;
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
