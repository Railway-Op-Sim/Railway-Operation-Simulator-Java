package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;

import elements.BufferedTrack;
import elements.Direction;
import elements.DirectionalTrack;
import elements.GapLinkedTrack;
import elements.StraightTrack;
import elements.Track;
import elements.TrackType;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

public class MenuActions {
	
	private static int gridSize = 16;

	/**
	 * Constructor that makes a MenuActions object.
	 * Probably won't be used.
	 */
	public MenuActions() {

	}
	/**
	 * A method to exit the Program.
	 * Used by exit button in top left menu.
	 */
	 public static void exitProgram() {
		 Platform.exit();
	 }
	 /**
	  * A method to draw the new element on the canvas.
	  * @param railMap
	  * @param event
	  */
	 public static void drawElement(GraphicsContext railMap, MouseEvent event, String file) {
		 //Get Location of mouse click and round to 0
		 int xLocation = (int) event.getX();
		 int yLocation = (int) event.getY(); 
		 // Get remiander when divided by 16 to see how close it is to the last multiple of 16.
		 int slightlyOffX = xLocation %16;
		 int slightLyOffY = yLocation %16;
		 
		 // Get the last multiple of 16 before it.
		 int placeX = xLocation - slightlyOffX;
		 int placeY = yLocation - slightLyOffY;
		 
		 File trackImage = new File(file); //Open image file.
		 Image image = null;
		try {
			image = new Image(new FileInputStream(trackImage)); //Set file as image.
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		railMap.drawImage( image, placeX, placeY); //Draw the image at that place.
	 }
	 
	 /**
	  * A method to draw the grid on the canvas.
	  * @param display
	  */
	 public static void createGrid(Canvas display) {
		 	GraphicsContext railMap = display.getGraphicsContext2D();
		 	
		 	//Get the canvas size
	        double railMapSizeX = display.getWidth();
	        double railMapSizeY = display.getHeight();
	        
	        //Set grid to Black
	        railMap.setStroke(Color.BLACK);
	        
	        //Every 16 pixels draw a vertical line.
	        for (int x=0; x<railMapSizeX+1; x+=16) {
	        	railMap.strokeLine(x, 0, x, railMapSizeY);
	        }
	        
	      //Every 16 pixels draw a horizontal line.
	        for (int y=0; y<railMapSizeY+1; y+=16) {
	        	railMap.strokeLine(0, y, railMapSizeX, y);
	        }

	    }
	 /**
	  * A method to change draw or remove the grid.
	  * Also changes text of button that activates this action.
	  * @param display
	  * @param showHideGridButton
	  */
	 public static void toggleGrid(Canvas display, Button showHideGridButton ) {
		 String showHideGridText = showHideGridButton.getText();
		 if (showHideGridText.equals("Show Grid")) {
			 createGrid(display);
			 showHideGridButton.setText("Hide Grid");
		 } else {
			 removeGrid(display);
			 showHideGridButton.setText("Show Grid");
		 }
	 }
	 /**
	  * A method to remove the grid drawn on the canvas.
	  * @param display
	  */
	private static void removeGrid(Canvas display) {
		
		int railMapSizeX = (int) display.getWidth();
        int railMapSizeY = (int) display.getHeight();

		GraphicsContext railMap = display.getGraphicsContext2D();
		railMap.clearRect(0, 0, railMapSizeX, railMapSizeY);// Clear entire display
		Map map = MapManager.sharedMapManager().getMap();
		HashSet<Track> trackStore = map.getTrackStore();
		
		// For every track in the list , redraw it.
		for (Track track :trackStore) {
			int xLocation = track.getxLocation();
			int yLocation = track.getyLocation();
			 
			int slightlyOffX = xLocation %16;
			int slightLyOffY = yLocation %16;
			 
			int placeX = xLocation - slightlyOffX;
			int placeY = yLocation - slightLyOffY;
			
			File trackImage = null;
			Image image = null;
			TrackType currentTrackType = track.getTrackType();
			switch (currentTrackType) {
			case STRAIGHTHORIZONTAL :
				trackImage = new File("./src/graphics/straightH.png"); //Open image file.
				break;
			
			case STRAIGHTVERTICAL :
				trackImage = new File("./src/graphics/straightV.png"); //Open image file.
				break;
				
			case STRAIGHTLEFTUP :
				trackImage = new File("./src/graphics/straightLeftUp.png"); //Open image file.
				break;
			
			case STRAIGHTRIGHTUP :
				trackImage = new File("./src/graphics/straightRightUp.png"); //Open image file.
				break;
				
			case LEFTBUFFER :
				trackImage = new File("./src/graphics/leftBuffer.png"); //Open image file.
				break;
			
			case RIGHTBUFFER :
				trackImage = new File("./src/graphics/rightBuffer.png"); //Open image file.
				break;
			
			case UPBUFFER :
				trackImage = new File("./src/graphics/upBuffer.png"); //Open image file.
				break;
				
			case DOWNBUFFER :
				trackImage = new File("./src/graphics/downBuffer.png"); //Open image file.
				break;
				
			case LEFTUPBUFFER :
				trackImage = new File("./src/graphics/leftUpBuffer.png"); //Open image file.
				break;
			
			case RIGHTUPBUFFER :
				trackImage = new File("./src/graphics/rightUpBuffer.png"); //Open image file.
				break;
				
			case LEFTDOWNBUFFER :
				trackImage = new File("./src/graphics/leftDownBuffer.png"); //Open image file.
				break;
			
			case RIGHTDOWNBUFFER :
				trackImage = new File("./src/graphics/rightDownBuffer.png"); //Open image file.
				break;
				
			case LEFTGAP :
				trackImage = new File("./src/graphics/unsetLeftGap.png"); //Open image file.
				break;
			
			case RIGHTGAP :
				trackImage = new File("./src/graphics/unsetRightGap.png"); //Open image file.
				break;
			
			case UPGAP :
				trackImage = new File("./src/graphics/unsetUpGap.png"); //Open image file.
				break;
				
			case DOWNGAP :
				trackImage = new File("./src/graphics/unsetDownGap.png"); //Open image file.
				break;
				
			case LEFTUPGAP :
				trackImage = new File("./src/graphics/unsetLeftUpGap.png"); //Open image file.
				break;
				
			case RIGHTUPGAP :
				trackImage = new File("./src/graphics/unsetRightUpGap.png"); //Open image file.
				break;
				
			case LEFTDOWNGAP :
				trackImage = new File("./src/graphics/unsetLeftDownGap.png"); //Open image file.
				break;
				
			case RIGHTDOWNGAP :
				trackImage = new File("./src/graphics/unsetRightDownGap.png"); //Open image file.
				break;
				
			case DIRECTLEFT :
				trackImage = new File("./src/graphics/directLeft.png"); //Open image file.
				break;
				
			case DIRECTRIGHT :
				trackImage = new File("./src/graphics/directRight.png"); //Open image file.
				break;
				
			case DIRECTUP :
				trackImage = new File("./src/graphics/directUp.png"); //Open image file.
				break;
				
			case DIRECTDOWN :
				trackImage = new File("./src/graphics/directDown.png"); //Open image file.
				break;
				
			case DIRECTLEFTUP :
				trackImage = new File("./src/graphics/directLeftUp.png"); //Open image file.
				break;
				
			case DIRECTRIGHTUP :
				trackImage = new File("./src/graphics/directRightUp.png"); //Open image file.
				break;
				
			case EXITLEFT :
				trackImage = new File("./src/graphics/exitLeftTrack.png"); //Open image file.
				break;
				
			case EXITRIGHT :
				trackImage = new File("./src/graphics/exitRightTrack.png"); //Open image file.
				break;
				
			case EXITUP :
				trackImage = new File("./src/graphics/exitUpTrack.png"); //Open image file.
				break;
				
			case EXITDOWN :
				trackImage = new File("./src/graphics/exitDownTrack.png"); //Open image file.
				break;
			
			default:
				break;
				
				
				
			}
			try {
				image = new Image(new FileInputStream(trackImage)); //Set file as image.
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			railMap.drawImage(image, placeX, placeY);
		}
		
	}
	
	public static void makeExistingTrackErrorBox() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Existing Track error");
		alert.setContentText("Cannot place track there as a track already exists there!");

		alert.showAndWait();
	}
	
	public static void makeNoItemSelectedErrorBox() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("No Item selected error");
		alert.setContentText("Cannot place anything as nothing selected!");

		alert.showAndWait();
	}
	
	public static void makeDeleteTrackErrorBox() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("No track found error");
		alert.setContentText("Cannot delete as no trackis there!");

		alert.showAndWait();
	}
	
	public static void deleteTrack (MouseEvent event,Canvas display, Button showHideGridButton)  {
    	int xLocation = (int) event.getX();
		int yLocation = (int) event.getY();
		int slightlyOffX = xLocation %16;
		int slightLyOffY = yLocation %16;
		int placeX = xLocation - slightlyOffX;
		int placeY = yLocation - slightLyOffY;
		GraphicsContext railMap = display.getGraphicsContext2D();
		HashSet<Track> trackStore = MapManager.sharedMapManager().getMap().getTrackStore();
		Track item = null;
		for (Track track : trackStore) {
			 int existingTrackX = track.getxLocation();
			 int existingTrackY = track.getyLocation();
			 if (existingTrackX ==placeX && existingTrackY == placeY) {
				 item = track;
				 railMap.clearRect(placeX, placeY, gridSize, gridSize);
				} 
			}
		if (item !=null) {
			trackStore.remove(item);
			String showHidGridButtonText = showHideGridButton.getText();
			if (showHidGridButtonText.equals("Hide Grid")){
				railMap.strokeRect(placeX, placeY, gridSize, gridSize);
			}
			
		} else {
			makeDeleteTrackErrorBox();
		}
		
			
		/*for (Iterator<Track> i = trackStore.iterator(); i.hasNext();) {
		    Track track = i.next();
		    int existingTrackX = track.getxLocation();
			int existingTrackY = track.getyLocation();
			if (existingTrackX ==placeX && existingTrackY == placeY) {
		        i.remove();
		    }
		}
		*/
	}
	
	
	public static void addTrack(MouseEvent event,Canvas railMap, String file, TrackType itemSelected) {
		boolean trackExist = false;
    	int xLocation = (int) event.getX();
		int yLocation = (int) event.getY();
		int slightlyOffX = xLocation %16;
		int slightLyOffY = yLocation %16;
		int placeX = xLocation - slightlyOffX;
		int placeY = yLocation - slightLyOffY;
		HashSet<Track> trackStore = MapManager.sharedMapManager().getMap().getTrackStore();
		for (Track track : trackStore) {
			 int existingTrackX = track.getxLocation();
			 int existingTrackY = track.getyLocation();
			 if (existingTrackX ==placeX && existingTrackY == placeY) {
				 trackExist = true;
				 MenuActions.makeExistingTrackErrorBox();
			} 
		}
		
		
		if (!trackExist) {
			Track newTrack = null;
			switch(itemSelected) {
			case STRAIGHTHORIZONTAL: 
				StraightTrack straightHorizontal = new StraightTrack( TrackType.STRAIGHTHORIZONTAL, placeX, placeY, false, "None");
				straightHorizontal.setLinks();
				newTrack = straightHorizontal;
				break;
			
			case STRAIGHTVERTICAL: 
				StraightTrack straightVertical = new StraightTrack( TrackType.STRAIGHTVERTICAL, placeX, placeY, false, "None");
				straightVertical.setLinks();
				newTrack = straightVertical;
				
				break;
				
			case STRAIGHTLEFTUP: 
				StraightTrack straightLeftUp = new StraightTrack( TrackType.STRAIGHTLEFTUP, placeX, placeY, false, "None");
				straightLeftUp.setLinks();
				newTrack = straightLeftUp;
				break;
			
			case STRAIGHTRIGHTUP: 
				StraightTrack straightRightUp = new StraightTrack( TrackType.STRAIGHTRIGHTUP, placeX, placeY, false, "None");
				straightRightUp.setLinks();
				newTrack = straightRightUp;
				
				break;
			
			case LEFTBUFFER: 
				BufferedTrack leftBuffer = new BufferedTrack(TrackType.LEFTBUFFER, placeX, placeY, false, "None");
				leftBuffer.setLinks();
				newTrack = leftBuffer;
				break;
			
			case RIGHTBUFFER: 
				BufferedTrack rightBuffer = new BufferedTrack(TrackType.RIGHTBUFFER, placeX, placeY, false, "None");
				rightBuffer.setLinks();
				newTrack = rightBuffer;
				break;
				
			case UPBUFFER: 
				BufferedTrack topBuffer = new BufferedTrack(TrackType.UPBUFFER, placeX, placeY, false, "None");
				topBuffer.setLinks();
				newTrack = topBuffer;
				break;
				
			case DOWNBUFFER: 
				BufferedTrack bottomBuffer = new BufferedTrack(TrackType.DOWNBUFFER, placeX, placeY, false, "None");
				bottomBuffer.setLinks();
				newTrack = bottomBuffer;
				break;
				
			case LEFTUPBUFFER: 
				BufferedTrack leftUpBuffer = new BufferedTrack(TrackType.LEFTUPBUFFER, placeX, placeY, false, "None");
				leftUpBuffer.setLinks();
				newTrack = leftUpBuffer;
				break;
			
			case RIGHTUPBUFFER: 
				BufferedTrack rightUpBuffer = new BufferedTrack(TrackType.RIGHTUPBUFFER, placeX, placeY, false, "None");
				newTrack = rightUpBuffer;
				break;
				
			case LEFTDOWNBUFFER: 
				BufferedTrack leftDownBuffer = new BufferedTrack(TrackType.LEFTDOWNBUFFER, placeX, placeY, false, "None");
				newTrack = leftDownBuffer;
				break;
			
			case RIGHTDOWNBUFFER: 
				BufferedTrack rightDownBuffer = new BufferedTrack(TrackType.RIGHTDOWNBUFFER, placeX, placeY, false, "None");
				newTrack = rightDownBuffer;
				break;
				
			case LEFTGAP: 
				GapLinkedTrack leftGapTrack = new GapLinkedTrack(TrackType.LEFTGAP, placeX, placeY, false, "None");
				newTrack = leftGapTrack;
				break;
				
			case RIGHTGAP: 
				GapLinkedTrack rightGapTrack = new GapLinkedTrack(TrackType.RIGHTGAP, placeX, placeY, false, "None");
				newTrack = rightGapTrack;
				break;
				
			case UPGAP: 
				GapLinkedTrack upGapTrack = new GapLinkedTrack(TrackType.UPGAP, placeX, placeY, false, "None");
				newTrack = upGapTrack;
				break;
				
			case DOWNGAP: 
				GapLinkedTrack downGapTrack = new GapLinkedTrack(TrackType.DOWNGAP, placeX, placeY, false, "None");
				newTrack = downGapTrack;
				break;
			
			case LEFTUPGAP: 
				GapLinkedTrack leftUpGapTrack = new GapLinkedTrack(TrackType.LEFTUPGAP, placeX, placeY, false, "None");
				newTrack = leftUpGapTrack;
				break;
				
			case RIGHTUPGAP: 
				GapLinkedTrack rightUpGapTrack = new GapLinkedTrack(TrackType.RIGHTUPGAP, placeX, placeY, false, "None");
				newTrack = rightUpGapTrack;
				break;
				
			case LEFTDOWNGAP: 
				GapLinkedTrack leftDownGapTrack = new GapLinkedTrack(TrackType.LEFTDOWNGAP, placeX, placeY, false, "None");
				newTrack = leftDownGapTrack;
				break;
				
			case RIGHTDOWNGAP: 
				GapLinkedTrack rightDownGapTrack = new GapLinkedTrack(TrackType.RIGHTDOWNGAP, placeX, placeY, false, "None");
				newTrack = rightDownGapTrack;
				break;
				
			case DIRECTLEFT: 
				DirectionalTrack directLeftTrack = new DirectionalTrack(TrackType.DIRECTLEFT, placeX, placeY, false, "None", Direction.LEFT);
				newTrack = directLeftTrack;
				break;
				
			case DIRECTRIGHT: 
				DirectionalTrack directRightTrack = new DirectionalTrack(TrackType.DIRECTRIGHT, placeX, placeY, false, "None", Direction.RIGHT);
				newTrack = directRightTrack;
				break;
				
			case DIRECTUP: 
				DirectionalTrack directUpTrack = new DirectionalTrack(TrackType.DIRECTUP, placeX, placeY, false, "None", Direction.UP);
				newTrack = directUpTrack;
				break;
				
			case DIRECTDOWN: 
				DirectionalTrack directDownTrack = new DirectionalTrack(TrackType.DIRECTDOWN, placeX, placeY, false, "None", Direction.DOWN);
				newTrack = directDownTrack;
				break;
				
			case DIRECTLEFTUP: 
				DirectionalTrack directLeftUpTrack = new DirectionalTrack(TrackType.DIRECTLEFTUP, placeX, placeY, false, "None", Direction.LEFTUP);
				newTrack = directLeftUpTrack;
				break;
				
			case DIRECTRIGHTUP: 
				DirectionalTrack directRightUpTrack = new DirectionalTrack(TrackType.DIRECTRIGHTUP, placeX, placeY, false, "None", Direction.RIGHTUP);
				newTrack = directRightUpTrack;
				break;
				
			case DIRECTLEFTDOWN: 
				DirectionalTrack directLeftDownTrack = new DirectionalTrack(TrackType.DIRECTLEFTDOWN, placeX, placeY, false, "None", Direction.LEFTDOWN);
				newTrack = directLeftDownTrack;
				break;
				
			case DIRECTRIGHTDOWN: 
				DirectionalTrack directRightDownTrack = new DirectionalTrack(TrackType.DIRECTRIGHT, placeX, placeY, false, "None", Direction.RIGHTDOWN);
				newTrack = directRightDownTrack;
				break;
				
			case EXITLEFT: 
				DirectionalTrack exitLeftTrack = new DirectionalTrack(TrackType.EXITLEFT, placeX, placeY, false, "None", Direction.LEFT);
				newTrack = exitLeftTrack;
				break;
				
			case EXITRIGHT: 
				DirectionalTrack exitRightTrack = new DirectionalTrack(TrackType.EXITRIGHT, placeX, placeY, false, "None", Direction.RIGHT);
				newTrack = exitRightTrack;
				break;
				
			case EXITUP: 
				DirectionalTrack exitUpTrack = new DirectionalTrack(TrackType.EXITUP, placeX, placeY, false, "None", Direction.UP);
				newTrack = exitUpTrack;
				break;
				
			case EXITDOWN: 
				DirectionalTrack exitDownTrack = new DirectionalTrack(TrackType.EXITDOWN, placeX, placeY, false, "None", Direction.DOWN);
				newTrack = exitDownTrack;
				break;
			default:
				break;
			}
			
			trackStore.add(newTrack);
			
			
			GraphicsContext graphic = railMap.getGraphicsContext2D();
			drawElement(graphic, event, file);
		}
		System.out.println(trackStore.size());
	}
	
		

}
