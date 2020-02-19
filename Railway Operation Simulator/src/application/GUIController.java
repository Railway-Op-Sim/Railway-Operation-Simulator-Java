package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class GUIController extends Application {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="ExitMenuItem"
    private MenuItem ExitMenuItem; // Value injected by FXMLLoader

    @FXML // fx:id="RailwayHelpMenuItem"
    private MenuItem RailwayHelpMenuItem; // Value injected by FXMLLoader

    @FXML // fx:id="RailwayWebsiteMenuItem"
    private MenuItem RailwayWebsiteMenuItem; // Value injected by FXMLLoader

    @FXML // fx:id="AboutMenuItem"
    private MenuItem AboutMenuItem; // Value injected by FXMLLoader
    
    @FXML // fx:id="canvas"
    private Canvas canvas; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert ExitMenuItem != null : "fx:id=\"ExitMenuItem\" was not injected: check your FXML file 'GUI.fxml'.";
        assert RailwayHelpMenuItem != null : "fx:id=\"RailwayHelpMenuItem\" was not injected: check your FXML file 'GUI.fxml'.";
        assert RailwayWebsiteMenuItem != null : "fx:id=\"RailwayWebsiteMenuItem\" was not injected: check your FXML file 'GUI.fxml'.";
        assert AboutMenuItem != null : "fx:id=\"AboutMenuItem\" was not injected: check your FXML file 'GUI.fxml'.";

    }
    
    @FXML
    void exitApp(ActionEvent event) {
    	Platform.exit();
    }
    
    @FXML
    void openHelpWIndow(ActionEvent event) {

    }

    @FXML
    void openRailwayWebsite(ActionEvent event) {
    	getHostServices().showDocument("https://www.railwayoperationsimulator.com/");

    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
}


