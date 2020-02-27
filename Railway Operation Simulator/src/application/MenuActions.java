package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;

import elements.StraightTrack;
import elements.Track;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

public class MenuActions {
	
	private static int gridSize = 24;

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
	 public static void drawElement(GridPane railMap, MouseEvent event, String file) {
		 Node source = (Node)event.getSource() ;
	     int yLocation = GridPane.getColumnIndex(source);
	     int xLocation = GridPane.getRowIndex(source);
		 
		 File trackImage = new File(file); //Open image file.
		 Image image = null;
		try {
			image = new Image(new FileInputStream(trackImage)); //Set file as image.
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ImageView newImage = new ImageView(image);
		
		railMap.add( newImage, xLocation, yLocation); //Draw the image at that place.
	 }
	 
	
	public static void makeExistingTrackErrorBox() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Existing Track error");
		alert.setContentText("Cannot place track there as a track already exists there!");

		alert.showAndWait();
	}
	
	
	public static void addTrack(MouseEvent event,GridPane railMap, String file) {
		boolean trackExist = false;
		GridPane source = (GridPane)event.getSource() ;
		System.out.println(source.toString());
        int yLocation = GridPane.getColumnIndex(source);
        int xLocation = GridPane.getRowIndex(source);
		HashSet<Track> trackStore = MapManager.sharedMapManager().getMap().getTrackStore();
		for (Track track : trackStore) {
			 int existingTrackX = track.getxLocation();
			 int existingTrackY = track.getyLocation();
			 if (existingTrackX ==xLocation && existingTrackY == yLocation) {
				 trackExist = true;
				 MenuActions.makeExistingTrackErrorBox();
			} 
		}
		
		if (!trackExist) {
			StraightTrack newTrack = new StraightTrack( "Straight Horizontal", xLocation, yLocation, false, "None");
			trackStore.add(newTrack);
			
			drawElement(railMap, event, file);
		}
		System.out.println(trackStore.size());
	}
	
		

}
