package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import elements.StraightTrack;
import elements.Track;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

public class MenuActions {
	
	private static int gridSize = 32;

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
	 public static void drawElement(GraphicsContext railMap, MouseEvent event) {
		 //Get Location of mouse click and round to 0
		 int xLocation = (int) event.getX();
		 int yLocation = (int) event.getY(); 
		 // Get remiander when divided by 32 to see how close it is to the last multiple of 32
		 int slightlyOffX = xLocation %32;
		 int slightLyOffY = yLocation %32;
		 
		 // Get the last multiple of 32 before it.
		 int placeX = xLocation - slightlyOffX;
		 int placeY = yLocation - slightLyOffY;
		 
		 File trackImage = new File("./src/application/straightTrackLight.jpg"); //Open image file.
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
	        
	        //Every 32 pixels draw a vertical line.
	        for (int x=0; x<railMapSizeX+1; x+=32) {
	        	railMap.strokeLine(x, 0, x, railMapSizeY);
	        }
	        
	      //Every 32 pixels draw a horizontal line.
	        for (int y=0; y<railMapSizeY+1; y+=32) {
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
		ArrayList<Track> trackList = map.getTrackList();
		File trackImage = new File("./src/application/straightTrackLight.jpg");
		 Image image = null;
		try {
			image = new Image(new FileInputStream(trackImage));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		// For every track in the list , redraw it.
		for (Track track :trackList) {
			int xLocation = track.getxLocation();
			int yLocation = track.getyLocation();
			 
			int slightlyOffX = xLocation %32;
			int slightLyOffY = yLocation %32;
			 
			int placeX = xLocation - slightlyOffX;
			int placeY = yLocation - slightLyOffY;
			railMap.drawImage(image, placeX, placeY);
		}
		
	}
	
		

}
