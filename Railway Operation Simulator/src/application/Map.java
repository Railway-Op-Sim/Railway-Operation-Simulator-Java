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
	/**
	*Constructor to make a new Map.
	*
	*/
	public Map () {

	}
	/**
	* A method to return the Tracks in hashset.
	* Currently not in use as Tracks stored in ArrayList.
	*
	*/
	public HashSet<Track> getTrackStore() {
		return trackStore;
	}
	
	/**
	 * A method to set Hashset of Tracks.
	 * Currently not in use as Tracks stored in ArrayList.
	 * @param trackStore
	 */
	public void setTrackStore(HashSet<Track> trackStore) {
		this.trackStore = trackStore;
	}
	
	/**
	 * A method to get ArrayList of Objects.
	 * Could be platforms and miscellaneous items.
	 * @return ArrayList of others
	 */
	public ArrayList<Object> getOtherList() {
		return otherList;
	}
	
	/**
	 * A method to set a new ArrayList of Objects.
	 * @param otherList
	 */
	public void setOtherList(ArrayList<Object> otherList) {
		this.otherList = otherList;
	}
	
	/**
	 * A method to get current list of track pieces.
	 * @return
	 */
	public ArrayList<Track> getTrackList() {
		return trackList;
	}
	
	/**
	 * A mehtod to set a new list of tracks pieces.
	 * @param trackList
	 */
	public void setTrackList(ArrayList<Track> trackList) {
		this.trackList = trackList;
	}
	
	/**
	 * A method that gets the  list of trains/services.
	 * @return trainList
	 */
	public ArrayList<Train> getTrainList() {
		return trainList;
	}
	
	/**
	 * A method that sets a list of trains/services.
	 * @param trainList
	 */
	public void setTrainList(ArrayList<Train> trainList) {
		this.trainList = trainList;
	}
	
	/**
	 * A method to add a new track piece to the ArrayList of tracks.
	 * Could be modified to add tracks/trains to hashset.
	 * @param element
	 */
	public void addTrack(StraightTrack element) {
		trackList.add(element);
	}

	/**
	 * A method to get Links between tracks.
	 */
	public void makeStraightTRackLinks() {
		for(int i = 0; i<trackList.size();i++) {
			for (int j = 1; j<trackList.size();j++) {
				Track track1 = trackList.get(i);
				Track track2 = trackList.get(j);
			

		}
	}

	}

}
