package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;

import elements.BufferedTrack;
import elements.StraightTrack;
import elements.Track;
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
	        
	        //Every 24 pixels draw a vertical line.
	        for (int x=0; x<railMapSizeX+1; x+=16) {
	        	railMap.strokeLine(x, 0, x, railMapSizeY);
	        }
	        
	      //Every 24 pixels draw a horizontal line.
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
			String currentTrackName = track.getTrackName();
			switch (currentTrackName) {
			case "Straight Horizontal" :
				trackImage = new File("./src/graphics/StraightH16Light.png"); //Open image file.
				break;
				
			case "Left Buffer" :
				trackImage = new File("./src/graphics/leftBuffer16Light.png"); //Open image file.
				break;
			
			case "Right Buffer" :
				trackImage = new File("./src/graphics/rightBuffer16Light.png"); //Open image file.
				break;
			
			case "Top Buffer" :
				trackImage = new File("./src/graphics/topBuffer16Light.png"); //Open image file.
				break;
				
			case "Bottom Buffer" :
				trackImage = new File("./src/graphics/bottomBuffer16Light.png"); //Open image file.
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
				StraightTrack straightHorizontal = new StraightTrack( "Straight Horizontal", placeX, placeY, false, "None");
				newTrack = straightHorizontal;
				break;
			
			case LEFTBUFFER: 
				BufferedTrack leftBuffer = new BufferedTrack("Left Buffer", placeX, placeY, false, "None");
				newTrack = leftBuffer;
				break;
			
			case RIGHTBUFFER: 
				BufferedTrack rightBuffer = new BufferedTrack("Right Buffer", placeX, placeY, false, "None");
				newTrack = rightBuffer;
				break;
				
			case TOPBUFFER: 
				BufferedTrack topBuffer = new BufferedTrack("Top Buffer", placeX, placeY, false, "None");
				newTrack = topBuffer;
				break;
				
			case BOTTOMBUFFER: 
				BufferedTrack bottomBuffer = new BufferedTrack("Bottom Buffer", placeX, placeY, false, "None");
				newTrack = bottomBuffer;
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
