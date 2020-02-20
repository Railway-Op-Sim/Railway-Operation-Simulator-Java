package application;

/**
 * The class that makes sure that there is 1 map in the game and that there are no other copies.
 * @version 1.01
 * @author Jonathan K
 *
 */
public class MapManager {
	
	
	private static MapManager onlyMapManager;
	private Map map;

	/**
	 * Empty MapManager constructor.
	 */
	private MapManager() {

	}

	/**
	 * Make a map manager.
	 * 
	 * @return a mapManager object
	 */
	public static MapManager sharedMapManager() {

		if (onlyMapManager == null) {
			onlyMapManager = new MapManager();
		}
		return onlyMapManager;
	}

	/**
	 * Return the map.
	 * 
	 * @return map
	 */
	public Map getMap() {
		return this.map;
	}

	/**
	 * Set the map.
	 * 
	 * @param map
	 */
	public void setMap(Map map) {
		this.map = map;
	}

}


