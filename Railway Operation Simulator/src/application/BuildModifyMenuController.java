package application;

import java.net.URL;
import java.util.ResourceBundle;

import elements.TrackType;
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

    @FXML // fx:id="straightHorizontalTrackToggle"
    private ToggleButton straightHorizontalTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="straightHorizontalTrackImage"
    private ImageView straightHorizontalTrackImage; // Value injected by FXMLLoader

    @FXML // fx:id="straightVerticalTrackToggle"
    private ToggleButton straightVerticalTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="straightVerticalTrackImage"
    private ImageView straightVerticalTrackImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="straightRightUpToggle"
    private ToggleButton straightRightUpToggle; // Value injected by FXMLLoader

    @FXML // fx:id="straightRightUpImage"
    private ImageView straightRightUpImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="straightLeftUpToggle"
    private ToggleButton straightLeftUpToggle; // Value injected by FXMLLoader

    @FXML // fx:id="straightLeftUpImage"
    private ImageView straightLeftUpImage; // Value injected by FXMLLoader
    
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
    
    @FXML // fx:id="leftDownGapTrackToggle"
    private ToggleButton leftDownGapTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="leftDownGapTrackImage"
    private ImageView leftDownGapTrackImage; // Value injected by FXMLLoader

    @FXML // fx:id="rightDownGapTrackToggle"
    private ToggleButton rightDownGapTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="rightDownGapTrackImage"
    private ImageView rightDownGapTrackImage; // Value injected by FXMLLoader
    
    //** Directional Track toggles and images. **
    
    @FXML // fx:id="directLeftTrackToggle"
    private ToggleButton directLeftTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="directLeftTrackImage"
    private ImageView directLeftTrackImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="directRightTrackToggle"
    private ToggleButton directRightTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="directRightTrackImage"
    private ImageView directRightTrackImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="directUpTrackToggle"
    private ToggleButton directUpTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="directUpTrackImage"
    private ImageView directUpTrackImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="directDownTrackToggle"
    private ToggleButton directDownTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="directDownTrackImage"
    private ImageView directDownTrackImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="directRightUpToggle"
    private ToggleButton directRightUpToggle; // Value injected by FXMLLoader

    @FXML // fx:id="directRightUpTrackImage"
    private ImageView directRightUpTrackImage; // Value injected by FXMLLoader

    @FXML // fx:id="directLeftUpToggle"
    private ToggleButton directLeftUpToggle; // Value injected by FXMLLoader

    @FXML // fx:id="directLeftUpTrackImage"
    private ImageView directLeftUpTrackImage; // Value injected by FXMLLoader

    @FXML // fx:id="directRightDownToggle"
    private ToggleButton directRightDownToggle; // Value injected by FXMLLoader

    @FXML // fx:id="directRightDownTrackImage"
    private ImageView directRightDownTrackImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="directLeftDownToggle"
    private ToggleButton directLeftDownToggle; // Value injected by FXMLLoader

    @FXML // fx:id="directLeftDownTrackImage"
    private ImageView directLeftDownTrackImage; // Value injected by FXMLLoader
    
    //** Exit Track toggles and images. **
    
    @FXML // fx:id="exitLeftTrackToggle"
    private ToggleButton exitLeftTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="exitLeftTrackImage"
    private ImageView exitLeftTrackImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="exitRightTrackToggle"
    private ToggleButton exitRightTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="exitRightTrackImage"
    private ImageView exitRightTrackImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="exitDownTrackToggle"
    private ToggleButton exitDownTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="exitDownTrackImage"
    private ImageView exitDownTrackImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="exitUpTrackToggle"
    private ToggleButton exitUpTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="exitUpTrackImage"
    private ImageView exitUpTrackImage; // Value injected by FXMLLoader

   

    
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
    void selectStraightHorizontalTrack(ActionEvent event) {
    	
    	if (straightHorizontalTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.STRAIGHTHORIZONTAL);
		} else {
			straightHorizontalTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}
    }
    
    @FXML
    void selectStraightVerticalTrack(ActionEvent event) {
    	if (straightVerticalTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.STRAIGHTVERTICAL);
		} else {
			straightVerticalTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectStraightLeftUpTrack(ActionEvent event) {
    	if (straightLeftUpToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.STRAIGHTLEFTUP);
		} else {
			straightLeftUpToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectStraightRightUpTrack(ActionEvent event) {
    	if (straightRightUpToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.STRAIGHTRIGHTUP);
		} else {
			straightRightUpToggle.setSelected(false);
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
    
    @FXML
    void selectLeftDownGapTrack(ActionEvent event) {
    	if (leftDownGapTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.LEFTDOWNGAP);
		} else {
			leftDownGapTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectRightDownGapTrack(ActionEvent event) {
    	if (rightDownGapTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.RIGHTDOWNGAP);
		} else {
			rightDownGapTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    // Select directional track actions
    
    @FXML
    void selectDirectLeftTrack(ActionEvent event) {
    	if (directLeftTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.DIRECTLEFT);
		} else {
			directLeftTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectDirectRightTrack(ActionEvent event) {
    	if (directRightTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.DIRECTRIGHT);
		} else {
			directRightTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectDirectUpTrack(ActionEvent event) {
    	if (directUpTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.DIRECTUP);
		} else {
			directUpTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectDirectDownTrack(ActionEvent event) {
    	if (directDownTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.DIRECTDOWN);
		} else {
			directDownTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectDirectRightUpTrack(ActionEvent event) {
    	if (directRightUpToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.DIRECTRIGHTUP);
		} else {
			directRightUpToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectDirectLeftUpTrack(ActionEvent event) {
    	if (directLeftUpToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.DIRECTLEFTUP);
		} else {
			directLeftUpToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectDirectRightDownTrack(ActionEvent event) {
    	if (directRightDownToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.DIRECTRIGHTDOWN);
		} else {
			directRightDownToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectDirectLeftDownTrack(ActionEvent event) {
    	if (directLeftDownToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.DIRECTLEFTDOWN);
		} else {
			directLeftDownToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    //Select Exit Track actions
    
    @FXML
    void selectExitLeftTrack(ActionEvent event) {
    	if (exitLeftTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.EXITLEFT);
		} else {
			exitLeftTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectExitRightTrack(ActionEvent event) {
    	if (exitRightTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.EXITRIGHT);
		} else {
			exitRightTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectExitDownTrack(ActionEvent event) {
    	if (exitDownTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.EXITDOWN);
		} else {
			exitDownTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectExitUpTrack(ActionEvent event) {
    	if (exitUpTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.EXITUP);
		} else {
			exitUpTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}
    	
    }
    
   
    
    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        
    }

}
