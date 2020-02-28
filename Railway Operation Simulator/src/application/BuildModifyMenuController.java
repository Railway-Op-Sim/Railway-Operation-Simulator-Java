package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class BuildModifyMenuController {

	@FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="buildModifyMenuButton"
    private Button buildModifyMenuButton; // Value injected by FXMLLoader

    @FXML // fx:id="trackMenu"
    private GridPane trackMenu; // Value injected by FXMLLoader

    @FXML // fx:id="leftBufferToggle"
    private ToggleButton leftBufferToggle; // Value injected by FXMLLoader

    @FXML // fx:id="leftBufferImage"
    private ImageView leftBufferImage; // Value injected by FXMLLoader

    @FXML // fx:id="elementGroup"
    private ToggleGroup elementGroup; // Value injected by FXMLLoader

    @FXML // fx:id="rightBufferToggle"
    private ToggleButton rightBufferToggle; // Value injected by FXMLLoader

    @FXML // fx:id="rightBufferImage"
    private ImageView rightBufferImage; // Value injected by FXMLLoader

    @FXML // fx:id="topBufferToggle"
    private ToggleButton topBufferToggle; // Value injected by FXMLLoader

    @FXML // fx:id="topBufferImage"
    private ImageView topBufferImage; // Value injected by FXMLLoader

    @FXML // fx:id="bottomBufferToggle"
    private ToggleButton bottomBufferToggle; // Value injected by FXMLLoader

    @FXML // fx:id="bottomBufferImage"
    private ImageView bottomBufferImage; // Value injected by FXMLLoader

    @FXML // fx:id="horizontalToggle"
    private ToggleButton horizontalToggle; // Value injected by FXMLLoader

    @FXML // fx:id="horizontalTrackImage"
    private ImageView horizontalTrackImage; // Value injected by FXMLLoader

    @FXML // fx:id="verticalTrackToggle"
    private ToggleButton verticalTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="verticalTrackImage"
    private ImageView verticalTrackImage; // Value injected by FXMLLoader

    
    @FXML
    void openbuildModifyMenu(ActionEvent event) {
    	trackMenu.setDisable(false);
    	trackMenu.setVisible(true);
    	leftBufferToggle.setDisable(false);
    	leftBufferToggle.setVisible(true);
    	leftBufferImage.setDisable(false);
    	leftBufferImage.setVisible(true);
    }

    @FXML
    void selectLeftBuffer(ActionEvent event) {
    		
    		if (leftBufferToggle.isSelected()) {
    			GUIController.setItemSelected(TrackType.LEFTBUFFER);
    		} else {
    			leftBufferToggle.setSelected(false);
    			GUIController.setItemSelected(TrackType.NONE);
    		}
    		

    }
    @FXML
    void selectBottomBuffer(ActionEvent event) {
    	if (bottomBufferToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.BOTTOMBUFFER);
		} else {
			bottomBufferToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectHorizontalTrack(ActionEvent event) {
    	
    	if (horizontalToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.STRAIGHTHORIZONTAL);
		} else {
			horizontalToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}
    }

    @FXML
    void selectRightBuffer(ActionEvent event) {
    	if (rightBufferToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.RIGHTBUFFER);
		} else {
			rightBufferToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectTopBuffer(ActionEvent event) {
    	if (topBufferToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.TOPBUFFER);
		} else {
			topBufferToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}
    }

    @FXML
    void selectVerticalTrack(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert buildModifyMenuButton != null : "fx:id=\"buildModifyMenuButton\" was not injected: check your FXML file 'BuildModifyMenu.fxml'.";
        assert trackMenu != null : "fx:id=\"trackMenu\" was not injected: check your FXML file 'BuildModifyMenu.fxml'.";
        assert leftBufferToggle != null : "fx:id=\"leftBufferToggle\" was not injected: check your FXML file 'BuildModifyMenu.fxml'.";
        assert leftBufferImage != null : "fx:id=\"leftBufferImage\" was not injected: check your FXML file 'BuildModifyMenu.fxml'.";
        assert elementGroup != null : "fx:id=\"elementGroup\" was not injected: check your FXML file 'BuildModifyMenu.fxml'.";
        assert rightBufferToggle != null : "fx:id=\"rightBufferToggle\" was not injected: check your FXML file 'BuildModifyMenu.fxml'.";
        assert rightBufferImage != null : "fx:id=\"rightBufferImage\" was not injected: check your FXML file 'BuildModifyMenu.fxml'.";
        assert topBufferToggle != null : "fx:id=\"upBufferToggle\" was not injected: check your FXML file 'BuildModifyMenu.fxml'.";
        assert topBufferImage != null : "fx:id=\"upBufferImage\" was not injected: check your FXML file 'BuildModifyMenu.fxml'.";
        assert bottomBufferToggle != null : "fx:id=\"downBufferToggle\" was not injected: check your FXML file 'BuildModifyMenu.fxml'.";
        assert bottomBufferImage != null : "fx:id=\"downBufferImage\" was not injected: check your FXML file 'BuildModifyMenu.fxml'.";
        assert horizontalToggle != null : "fx:id=\"horizontalToggle\" was not injected: check your FXML file 'BuildModifyMenu.fxml'.";
        assert horizontalTrackImage != null : "fx:id=\"horizontalTrackImage\" was not injected: check your FXML file 'BuildModifyMenu.fxml'.";
        assert verticalTrackToggle != null : "fx:id=\"verticalTrackToggle\" was not injected: check your FXML file 'BuildModifyMenu.fxml'.";
        assert verticalTrackImage != null : "fx:id=\"verticalTrackImage\" was not injected: check your FXML file 'BuildModifyMenu.fxml'.";

    }

}
