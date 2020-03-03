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
    
    @FXML // fx:id="elementGroup"
    private ToggleGroup elementGroup; // Value injected by FXMLLoader

    @FXML // fx:id="buildModifyMenuButton"
    private Button buildModifyMenuButton; // Value injected by FXMLLoader

    @FXML // fx:id="trackMenu"
    private GridPane trackMenu; // Value injected by FXMLLoader

    // ** Buffer toggles and images. **
    
    @FXML // fx:id="leftBufferToggle"
    private ToggleButton leftBufferToggle; // Value injected by FXMLLoader

    @FXML // fx:id="leftBufferImage"
    private ImageView leftBufferImage; // Value injected by FXMLLoader

    @FXML // fx:id="rightBufferToggle"
    private ToggleButton rightBufferToggle; // Value injected by FXMLLoader

    @FXML // fx:id="rightBufferImage"
    private ImageView rightBufferImage; // Value injected by FXMLLoader

    @FXML // fx:id="upBufferToggle"
    private ToggleButton upBufferToggle; // Value injected by FXMLLoader

    @FXML // fx:id="upBufferImage"
    private ImageView upBufferImage; // Value injected by FXMLLoader

    @FXML // fx:id="downBufferToggle"
    private ToggleButton downBufferToggle; // Value injected by FXMLLoader

    @FXML // fx:id="downBufferImage"
    private ImageView downBufferImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="leftUpBufferToggle"
    private ToggleButton leftUpBufferToggle; // Value injected by FXMLLoader

    @FXML // fx:id="leftUpBufferImage"
    private ImageView leftUpBufferImage; // Value injected by FXMLLoader

    @FXML // fx:id="rightUpBufferToggle"
    private ToggleButton rightUpBufferToggle; // Value injected by FXMLLoader

    @FXML // fx:id="rightUpBufferImage"
    private ImageView rightUpBufferImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="rightDownBufferToggle"
    private ToggleButton rightDownBufferToggle; // Value injected by FXMLLoader

    @FXML // fx:id="rightDownBufferImage"
    private ImageView rightDownBufferImage; // Value injected by FXMLLoader

    @FXML // fx:id="leftDownBufferToggle"
    private ToggleButton leftDownBufferToggle; // Value injected by FXMLLoader

    @FXML // fx:id="leftDownBufferImage"
    private ImageView leftDownBufferImage; // Value injected by FXMLLoader
    
    //  ** Straight Track toggles and images. **

    @FXML // fx:id="horizontalTrackToggle"
    private ToggleButton horizontalTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="horizontalTrackImage"
    private ImageView horizontalTrackImage; // Value injected by FXMLLoader

    @FXML // fx:id="verticalTrackToggle"
    private ToggleButton verticalTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="verticalTrackImage"
    private ImageView verticalTrackImage; // Value injected by FXMLLoader
    
    // ** Gap link track toggle and images **
    
    @FXML // fx:id="leftGapTrackToggle"
    private ToggleButton leftGapTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="leftGapTrackImage"
    private ImageView leftGapTrackImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="upGapTrackToggle"
    private ToggleButton upGapTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="upGapTrackImage"
    private ImageView upGapTrackImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="rightGapTrackToggle"
    private ToggleButton rightGapTrackToggle; // Value injected by FXMLLoader
    
    @FXML // fx:id="rightGapTrackImage"
    private ImageView rightGapTrackImage; // Value injected by FXMLLoader

    @FXML // fx:id="downGapTrackToggle"
    private ToggleButton downGapTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="downGapTrackImage"
    private ImageView downGapTrackImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="leftUpGapTrackToggle"
    private ToggleButton leftUpGapTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="leftUpGapTrackImage"
    private ImageView leftUpGapTrackImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="rightUpGapTrackToggle"
    private ToggleButton rightUpGapTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="rightUpGapTrackImage"
    private ImageView rightUpGapTrackImage; // Value injected by FXMLLoader
   

    
    @FXML
    void openbuildModifyMenu(ActionEvent event) {
    	trackMenu.setDisable(false);
    	trackMenu.setVisible(true);
    	leftBufferToggle.setDisable(false);
    	leftBufferToggle.setVisible(true);
    	leftBufferImage.setDisable(false);
    	leftBufferImage.setVisible(true);
    }
    
    // Select Straight Track Actions.
    
    @FXML
    void selectHorizontalTrack(ActionEvent event) {
    	
    	if (horizontalTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.STRAIGHTHORIZONTAL);
		} else {
			horizontalTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}
    }
    
    @FXML
    void selectVerticalTrack(ActionEvent event) {
    	if (verticalTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.STRAIGHTVERTICAL);
		} else {
			verticalTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    //Select Buffer Actions.

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
    void selectDownBuffer(ActionEvent event) {
    	if (downBufferToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.DOWNBUFFER);
		} else {
			downBufferToggle.setSelected(false);
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
    void selectUpBuffer(ActionEvent event) {
    	if (upBufferToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.UPBUFFER);
		} else {
			upBufferToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}
    }
    
    @FXML
    void selectLeftUpBuffer(ActionEvent event) {
    	if (leftUpBufferToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.LEFTUPBUFFER);
		} else {
			leftUpBufferToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}
    }

    @FXML
    void selectRightUpBuffer(ActionEvent event) {
    	if (rightUpBufferToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.RIGHTUPBUFFER);
		} else {
			rightUpBufferToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}
    }
    
    @FXML
    void selectLeftDownBuffer(ActionEvent event) {
    	if (leftDownBufferToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.LEFTDOWNBUFFER);
		} else {
			leftDownBufferToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectRightDownBuffer(ActionEvent event) {
    	if (rightDownBufferToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.RIGHTDOWNBUFFER);
		} else {
			rightDownBufferToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    //Select Gap Link Track actions
    
    @FXML
    void selectLeftGapTrack(ActionEvent event) {
    	if (leftGapTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.LEFTGAP);
		} else {
			leftGapTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectRightGapTrack(ActionEvent event) {
    	if (rightGapTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.RIGHTGAP);
		} else {
			rightGapTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectDownGapTrack(ActionEvent event) {
    	if (downGapTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.DOWNGAP);
		} else {
			downGapTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectUpGapTrack(ActionEvent event) {
    	if (upGapTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.UPGAP);
		} else {
			upGapTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectLeftUpGapTrack(ActionEvent event) {
    	if (leftUpGapTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.LEFTUPGAP);
		} else {
			leftUpGapTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectRightUpGapTrack(ActionEvent event) {
    	if (rightUpGapTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.RIGHTUPGAP);
		} else {
			rightUpGapTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        
    }

}
