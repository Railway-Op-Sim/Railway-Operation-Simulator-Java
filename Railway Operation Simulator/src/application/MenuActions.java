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


	public MenuActions() {
		// TODO Auto-generated constructor stub
	}
	
	 public static void exitProgram() {
		 Platform.exit();
	 }
	 
	 public static void drawElement(GraphicsContext railMap, MouseEvent event) {
		 int xLocation = (int) event.getX();
		 int yLocation = (int) event.getY();
		 
		 int slightlyOffX = xLocation %32;
		 int slightLyOffY = yLocation %32;
		 
		 int placeX = xLocation - slightlyOffX;
		 int placeY = yLocation - slightLyOffY;
		 
		 File trackImage = new File("./src/application/straightTrackLight.jpg");
		 Image image = null;
		try {
			image = new Image(new FileInputStream(trackImage));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		railMap.drawImage( image, placeX, placeY);
	 }
	 
	 public static void createGrid(Canvas display) {
		 	GraphicsContext railMap = display.getGraphicsContext2D();

	        double railMapSizeX = display.getWidth();
	        double railMapSizeY = display.getHeight();
	        
	        railMap.setStroke(Color.BLACK);
	        
	        //gc.setFill(Color.LIGHTGRAY);
	        //gc.fillRect(0, 0, w, h);
	        for (int x=0; x<railMapSizeX+1; x+=32) {
	        	railMap.strokeLine(x, 0, x, railMapSizeY);
	        }
	        
	        for (int y=0; y<railMapSizeY+1; y+=32) {
	        	railMap.strokeLine(0, y, railMapSizeX, y);
	        }
	        

	        //Image image = canvas.snapshot(new SnapshotParameters(), null);
	        //ImagePattern pattern = new ImagePattern(image, 0, 0, w, h, false);

	       

	    }
	 
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

	private static void removeGrid(Canvas display) {
		// TODO Auto-generated method stub
		int railMapSizeX = (int) display.getWidth();
        int railMapSizeY = (int) display.getHeight();
        
        
        
		GraphicsContext railMap = display.getGraphicsContext2D();
		railMap.clearRect(0, 0, railMapSizeX, railMapSizeY);
		Map map = MapManager.sharedMapManager().getMap();
		ArrayList<Track> trackList = map.getTrackList();
		File trackImage = new File("./src/application/straightTrackLight.jpg");
		 Image image = null;
		try {
			image = new Image(new FileInputStream(trackImage));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
