package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class GUIController extends Application {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="RailwayHelp"
    private MenuItem RailwayHelp; // Value injected by FXMLLoader

    @FXML // fx:id="RailwayWebsite"
    private MenuItem RailwayWebsite; // Value injected by FXMLLoader

    @FXML
    void openHelpWIndow(ActionEvent event) {

    }

    @FXML
    void openRailwayWebsite(ActionEvent event) {
    	getHostServices().showDocument("https://www.railwayoperationsimulator.com/");

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert RailwayHelp != null : "fx:id=\"RailwayHelp\" was not injected: check your FXML file 'GUI.fxml'.";
        assert RailwayWebsite != null : "fx:id=\"RailwayWebsite\" was not injected: check your FXML file 'GUI.fxml'.";

    }

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
