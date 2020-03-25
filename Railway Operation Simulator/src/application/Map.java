package application;

import java.util.ArrayList;
import java.util.HashSet;

import elements.Location;
import elements.Element;
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
	
	private Track baseTrack;
	private HashSet<Element>  elementStore = new HashSet<Element>();
	
	private HashSet<Location>  locationStore = new HashSet<Location>();
	private ArrayList<Train> trainList = new ArrayList<Train>();
	private ArrayList<Object> otherList = new ArrayList<Object>();
	//private HashSet<Connection> connectionStore = new HashSet<Connection>();
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
	public HashSet<Element> getElementStore() {
		return elementStore;
	}
	
	/**
	 * A method to set Hashset of Tracks.
	 * Currently not in use as Tracks stored in ArrayList.
	 * @param trackStore
	 */
	public void setTrackStore(HashSet<Element> elementStore) {
		this.elementStore = elementStore;
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
	public void addElement(Element element) {
		elementStore.add(element);
	}

	/**
	 * A method to get Links between tracks.
	 */
	public void makeStraightTRackLinks() {
		for(Element track1 : elementStore){
			for(Element track2 : elementStore){
				if (!track1.equals(track2)) {
					
			}
		}
	}

	}

}
