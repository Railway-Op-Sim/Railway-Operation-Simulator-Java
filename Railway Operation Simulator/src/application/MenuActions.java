package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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
		 
		 File trackImage = new File("./src/application/straightTrackLight.jpg");
		 Image image = null;
		try {
			image = new Image(new FileInputStream(trackImage));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		railMap.drawImage( image, xLocation, yLocation);
	 }
	 
	 public static void createGrid(Canvas display) {
		 	GraphicsContext railMap = display.getGraphicsContext2D();
	        double w = gridSize;
	        double h = gridSize;
	        
	        double railMapSizeX = display.getWidth();
	        double railMapSizeY = display.getHeight();
	        
	        
	        
	        railMap.setStroke(Color.BLACK);
	        //gc.setFill(Color.LIGHTGRAY);
	        //gc.fillRect(0, 0, w, h);
	        for (int x=0; x<railMapSizeX+1; x+=32) {
	        	railMap.strokeLine(x, 0, x, 416);
	        }
	        
	        for (int y=0; y<railMapSizeY+1; y+=32) {
	        	railMap.strokeLine(0, y, 640, y);
	        }
	        

	        //Image image = canvas.snapshot(new SnapshotParameters(), null);
	        //ImagePattern pattern = new ImagePattern(image, 0, 0, w, h, false);

	       

	    }
 	


}
