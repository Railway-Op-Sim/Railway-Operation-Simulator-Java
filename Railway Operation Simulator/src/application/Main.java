package application;

	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

/**
 * Main.java
 * The class for starting the entire Program.
 * @version 1.01
 * @author Jonathan K
 *
 */
		
public class Main extends Application {
	/**
	 * The starting method to launch the GUI.
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("GUI.fxml")); //Load FXML file into BorderPane
			Scene scene = new Scene(root,1280,720); //Make the Program size 1280 x 720
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); //Apply css elements if necessary.
			MapManager.sharedMapManager();
			Map currentMap = new Map();
			MapManager.sharedMapManager().setMap(currentMap);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Starting everything.
	 * @param args
	 */
	public static void main(String[] args) {
		
		launch(args);
	}
}
