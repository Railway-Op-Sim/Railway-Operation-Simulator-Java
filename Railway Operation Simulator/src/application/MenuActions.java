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
import javafx.stage.Stage;

public class MenuActions {
	
	private static final int GRID_CELL_WIDTH = 32;
	private static final int GRID_CELL_HEIGHT = 32;

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
 	


}
