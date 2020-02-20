package application;


import java.net.URL;

import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import application.MenuActions;

/**
 * GUIController.java
 * The class that interacts with the GUI.fxml to output to screen. Behaviours and Actions are specified here.
 * @version 1.01
 * @author Jonathan K
 */

public class GUIController extends Application {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="exitMenuItem"
    private MenuItem exitMenuItem; // Value injected by FXMLLoader

    @FXML // fx:id="buildModifyRailway"
    private MenuItem buildModifyRailway; // Value injected by FXMLLoader

    @FXML // fx:id="railwayHelpMenuItem"
    private MenuItem railwayHelpMenuItem; // Value injected by FXMLLoader

    @FXML // fx:id="railwayWebsiteMenuItem"
    private MenuItem railwayWebsiteMenuItem; // Value injected by FXMLLoader

    @FXML // fx:id="aboutMenuItem"
    private MenuItem aboutMenuItem; // Value injected by FXMLLoader
    
    @FXML // fx:id="showGridButton"
    private Button showGridButton; // Value injected by FXMLLoader

    @FXML // fx:id="railMap"
    private Canvas railMap; // Value injected by FXMLLoader
    
    /**
     * A method to exit and close the program.
     * @param event
     */
    @FXML
    void exitApp(ActionEvent event) {
    	MenuActions.exitProgram();
    }
    
    /**
     * A method to open a Help Window.
     * @param event
     */
    @FXML
    void openHelpWIndow(ActionEvent event) {

    }
    
    /**
     * A method to open the Railway Homepage.
     * @param event
     */
    @FXML
    void openRailwayWebsite(ActionEvent event) {
    	getHostServices().showDocument("https://www.railwayoperationsimulator.com/");

    }
    
    /**
     * A method to add item and graphic to the railmap.
     * @param event
     */
    @FXML
    void placeSelectItem(MouseEvent event) {
    	GraphicsContext graphic = railMap.getGraphicsContext2D();
    	MenuActions.drawElement(graphic, event);

    }
    
    /**
     * A method to show the build menu.
     * @param event
     */
    @FXML
    void showBuildMenu(ActionEvent event) {

    }
    
    /**
     * A method to show the grid.
     * @param event
     */
    @FXML
    void showGrid(ActionEvent event) {
    	MenuActions.createGrid(railMap);
    }
    
    
    /**
     * Auto-generated method t help initalize the FXML?
     */
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert exitMenuItem != null : "fx:id=\"ExitMenuItem\" was not injected: check your FXML file 'GUI.fxml'.";
        assert buildModifyRailway != null : "fx:id=\"buildModifyRailway\" was not injected: check your FXML file 'GUI.fxml'.";
        assert railwayHelpMenuItem != null : "fx:id=\"RailwayHelpMenuItem\" was not injected: check your FXML file 'GUI.fxml'.";
        assert railwayWebsiteMenuItem != null : "fx:id=\"RailwayWebsiteMenuItem\" was not injected: check your FXML file 'GUI.fxml'.";
        assert aboutMenuItem != null : "fx:id=\"AboutMenuItem\" was not injected: check your FXML file 'GUI.fxml'.";
        assert showGridButton != null : "fx:id=\"showGridButton\" was not injected: check your FXML file 'GUI.fxml'.";
        assert railMap != null : "fx:id=\"canvas\" was not injected: check your FXML file 'GUI.fxml'.";

    }
    /**
     * 
     */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
}