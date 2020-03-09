package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import elements.SignalAspect;
import elements.TrackType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
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
    
    @FXML // fx:id="aspectChangerButton"
    private Button aspectChangerButton; // Value injected by FXMLLoader

    @FXML // fx:id="aspectChangerImage"
    private ImageView aspectChangerImage; // Value injected by FXMLLoader
    
    private static SignalAspect aspect;

    // ** Buffer toggles and images. **
    
    @FXML // fx:id="bufferLeftToggle"
    private ToggleButton bufferLeftToggle; // Value injected by FXMLLoader

    @FXML // fx:id="bufferLeftImage"
    private ImageView bufferLeftImage; // Value injected by FXMLLoader

    @FXML // fx:id="bufferRightToggle"
    private ToggleButton bufferRightToggle; // Value injected by FXMLLoader

    @FXML // fx:id="bufferRightImage"
    private ImageView bufferRightImage; // Value injected by FXMLLoader

    @FXML // fx:id="bufferUpToggle"
    private ToggleButton bufferUpToggle; // Value injected by FXMLLoader

    @FXML // fx:id="bufferUpImage"
    private ImageView bufferUpImage; // Value injected by FXMLLoader

    @FXML // fx:id="bufferDownToggle"
    private ToggleButton bufferDownToggle; // Value injected by FXMLLoader

    @FXML // fx:id="bufferDownImage"
    private ImageView bufferDownImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="bufferLeftUpToggle"
    private ToggleButton bufferLeftUpToggle; // Value injected by FXMLLoader

    @FXML // fx:id="bufferLeftUpImage"
    private ImageView bufferLeftUpImage; // Value injected by FXMLLoader

    @FXML // fx:id="bufferRightUpToggle"
    private ToggleButton bufferRightUpToggle; // Value injected by FXMLLoader

    @FXML // fx:id="bufferRightUpImage"
    private ImageView bufferRightUpImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="bufferLeftDownToggle"
    private ToggleButton bufferLeftDownToggle; // Value injected by FXMLLoader

    @FXML // fx:id="bufferLeftDownImage"
    private ImageView bufferLeftDownImage; // Value injected by FXMLLoader

    @FXML // fx:id="bufferRightDownToggle"
    private ToggleButton bufferRightDownToggle; // Value injected by FXMLLoader

    @FXML // fx:id="bufferRightDownImage"
    private ImageView bufferRightDownImage; // Value injected by FXMLLoader
    
    //  ** Straight Track toggles and images. **

    @FXML // fx:id="straightHorizontalToggle"
    private ToggleButton straightHorizontalToggle; // Value injected by FXMLLoader

    @FXML // fx:id="straightHorizontalImage"
    private ImageView straightHorizontalImage; // Value injected by FXMLLoader

    @FXML // fx:id="straightVerticalToggle"
    private ToggleButton straightVerticalToggle; // Value injected by FXMLLoader

    @FXML // fx:id="straightVerticalImage"
    private ImageView straightVerticalImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="straightRightUpToggle"
    private ToggleButton straightRightUpToggle; // Value injected by FXMLLoader

    @FXML // fx:id="straightRightUpImage"
    private ImageView straightRightUpImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="straightLeftUpToggle"
    private ToggleButton straightLeftUpToggle; // Value injected by FXMLLoader

    @FXML // fx:id="straightLeftUpImage"
    private ImageView straightLeftUpImage; // Value injected by FXMLLoader
    
    // ** Link track toggle and images **
    
    @FXML // fx:id="linkLeftToggle"
    private ToggleButton linkLeftToggle; // Value injected by FXMLLoader

    @FXML // fx:id="linkLeftImage"
    private ImageView linkLeftImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="linkUpToggle"
    private ToggleButton linkUpToggle; // Value injected by FXMLLoader

    @FXML // fx:id="linkUpImage"
    private ImageView linkUpImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="linkRightToggle"
    private ToggleButton linkRightToggle; // Value injected by FXMLLoader

    @FXML // fx:id="linkRightImage"
    private ImageView linkRightImage; // Value injected by FXMLLoader

    @FXML // fx:id="linkDownToggle"
    private ToggleButton linkDownToggle; // Value injected by FXMLLoader

    @FXML // fx:id="linkDownImage"
    private ImageView linkDownImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="linkLeftUpToggle"
    private ToggleButton linkLeftUpToggle; // Value injected by FXMLLoader

    @FXML // fx:id="linkLeftUpImage"
    private ImageView linkLeftUpImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="linkRightUpToggle"
    private ToggleButton linkRightUpToggle; // Value injected by FXMLLoader

    @FXML // fx:id="linkRightUpImage"
    private ImageView linkRightUpImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="linkLeftDownToggle"
    private ToggleButton linkLeftDownToggle; // Value injected by FXMLLoader

    @FXML // fx:id="linkLeftDownImage"
    private ImageView linkLeftDownImage; // Value injected by FXMLLoader

    @FXML // fx:id="linkRightDownToggle"
    private ToggleButton linkRightDownToggle; // Value injected by FXMLLoader

    @FXML // fx:id="linkRightDownImage"
    private ImageView linkRightDownImage; // Value injected by FXMLLoader
    
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
    
    @FXML // fx:id="exitLeftUpTrackToggle"
    private ToggleButton exitLeftUpTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="exitLeftUpTrackImage"
    private ImageView exitLeftUpTrackImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="exitRightUpTrackToggle"
    private ToggleButton exitRightUpTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="exitRightUpTrackImage"
    private ImageView exitRightUpTrackImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="exitLeftDownTrackToggle"
    private ToggleButton exitLeftDownTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="exitLeftDownTrackImage"
    private ImageView exitLeftDownTrackImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="exitRightDownTrackToggle"
    private ToggleButton exitRightDownTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="exitRightDownImage"
    private ImageView exitRightDownImage; // Value injected by FXMLLoader
    
    //** Signal Track toggles and images. **
    
    @FXML // fx:id="signalLeftTrackToggle"
    private ToggleButton signalLeftTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="signalLeftTrackImage"
    private ImageView signalLeftTrackImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="signalRightTrackToggle"
    private ToggleButton signalRightTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="signalRightTrackImage"
    private ImageView signalRightTrackImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="signalUpTrackToggle"
    private ToggleButton signalUpTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="signalUpTrackImage"
    private ImageView signalUpTrackImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="signalDownTrackToggle"
    private ToggleButton signalDownTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="signalDownTrackImage"
    private ImageView signalDownTrackImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="signalLeftUpTrackToggle"
    private ToggleButton signalLeftUpTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="signalLeftUpTrackImage"
    private ImageView signalLeftUpTrackImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="signalRightUpTrackToggle"
    private ToggleButton signalRightUpTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="signalRightUpTrackImage"
    private ImageView signalRightUpTrackImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="signalLeftDownTrackToggle"
    private ToggleButton signalLeftDownTrackToggle; // Value injected by FXMLLoader
    
    @FXML // fx:id="signalRightDownTrackImage"
    private ImageView signalLeftDownTrackImage; // Value injected by FXMLLoader
    
    @FXML // fx:id="signalRightDownTrackToggle"
    private ToggleButton signalRightDownTrackToggle; // Value injected by FXMLLoader

    @FXML // fx:id="signalRightDownTrackImage"
    private ImageView signalRightDownTrackImage; // Value injected by FXMLLoader

    
    // ** Tight curve toggles and images **
    
    @FXML // fx:id="tightCurve1Toggle"
    private ToggleButton tightCurve1Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="tightCurve1Image"
    private ImageView tightCurve1Image; // Value injected by FXMLLoader

    @FXML // fx:id="tightCurve2Toggle"
    private ToggleButton tightCurve2Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="tightCurve1Image2"
    private ImageView tightCurve1Image2; // Value injected by FXMLLoader

    @FXML // fx:id="tightCurve3Toggle"
    private ToggleButton tightCurve3Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="tightCurve3Image"
    private ImageView tightCurve3Image; // Value injected by FXMLLoader

    @FXML // fx:id="tightCurve4Toggle"
    private ToggleButton tightCurve4Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="tightCurve4Image"
    private ImageView tightCurve4Image; // Value injected by FXMLLoader
    
 // ** Curve toggles and images **
    
    @FXML // fx:id="curve1Toggle"
    private ToggleButton curve1Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="curve1Image"
    private ImageView curve1Image; // Value injected by FXMLLoader

    @FXML // fx:id="curve2Toggle"
    private ToggleButton curve2Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="curve2Image"
    private ImageView curve2Image; // Value injected by FXMLLoader

    @FXML // fx:id="curve3Toggle"
    private ToggleButton curve3Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="curve3Image"
    private ImageView curve3Image; // Value injected by FXMLLoader

    @FXML // fx:id="curve4Toggle"
    private ToggleButton curve4Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="curve4Image"
    private ImageView curve4Image; // Value injected by FXMLLoader
    
    @FXML // fx:id="curve5Toggle"
    private ToggleButton curve5Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="curve5Image"
    private ImageView curve5Image; // Value injected by FXMLLoader

    @FXML // fx:id="curve6Toggle"
    private ToggleButton curve6Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="curve6Image"
    private ImageView curve6Image; // Value injected by FXMLLoader

    @FXML // fx:id="curve7Toggle"
    private ToggleButton curve7Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="curve7Image"
    private ImageView curve7Image; // Value injected by FXMLLoader

    @FXML // fx:id="curve8Toggle"
    private ToggleButton curve8Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="curve8Image"
    private ImageView curve8Image; // Value injected by FXMLLoader

// ** Bridge and Underpass Toggles and Images**
    
    @FXML // fx:id="bridge1Toggle"
    private ToggleButton bridge1Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="bridge1Image"
    private ImageView bridge1Image; // Value injected by FXMLLoader

    @FXML // fx:id="bridge2Toggle"
    private ToggleButton bridge2Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="bridge2Image"
    private ImageView bridge2Image; // Value injected by FXMLLoader

    @FXML // fx:id="underpass1Toggle"
    private ToggleButton underpass1Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="underpass1Image"
    private ImageView underpass1Image; // Value injected by FXMLLoader

    @FXML // fx:id="underpass2Toggle"
    private ToggleButton underpass2Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="underpass2Image"
    private ImageView underpass2Image; // Value injected by FXMLLoader
    
  //** Tight switch toggles and images **
    
    @FXML // fx:id="switchTight1Toggle"
    private ToggleButton switchTight1Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="switchTight1Image"
    private ImageView switchTight1Image; // Value injected by FXMLLoader

    @FXML // fx:id="switchTight2Toggle"
    private ToggleButton switchTight2Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="switchTight2Image"
    private ImageView switchTight2Image; // Value injected by FXMLLoader

    @FXML // fx:id="switchTight3Toggle"
    private ToggleButton switchTight3Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="switchTight3Image"
    private ImageView switchTight3Image; // Value injected by FXMLLoader

    @FXML // fx:id="switchTight4Toggle"
    private ToggleButton switchTight4Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="switchTight4Image"
    private ImageView switchTight4Image; // Value injected by FXMLLoader
    
    @FXML // fx:id="switchTight5Toggle"
    private ToggleButton switchTight5Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="switchTight5Image"
    private ImageView switchTight5Image; // Value injected by FXMLLoader

    @FXML // fx:id="switchTight6Toggle"
    private ToggleButton switchTight6Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="switchTight6Image"
    private ImageView switchTight6Image; // Value injected by FXMLLoader

    @FXML // fx:id="switchTight7Toggle"
    private ToggleButton switchTight7Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="switchTight7Image"
    private ImageView switchTight7Image; // Value injected by FXMLLoader

    @FXML // fx:id="switchTight8Toggle"
    private ToggleButton switchTight8Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="switchTight8Image"
    private ImageView switchTight8Image; // Value injected by FXMLLoader
    
    //** Switch toggles and images **
    
    @FXML // fx:id="switch1Toggle"
    private ToggleButton switch1Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="switch1Image"
    private ImageView switch1Image; // Value injected by FXMLLoader

    @FXML // fx:id="switch2Toggle"
    private ToggleButton switch2Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="switch2Image"
    private ImageView switch2Image; // Value injected by FXMLLoader

    @FXML // fx:id="switch3Toggle"
    private ToggleButton switch3Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="switch3Image"
    private ImageView switch3Image; // Value injected by FXMLLoader

    @FXML // fx:id="switch4Toggle"
    private ToggleButton switch4Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="switch4Image"
    private ImageView switch4Image; // Value injected by FXMLLoader

    @FXML // fx:id="switch5Toggle"
    private ToggleButton switch5Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="switch5Image"
    private ImageView switch5Image; // Value injected by FXMLLoader

    @FXML // fx:id="switch6Toggle"
    private ToggleButton switch6Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="switch6Image"
    private ImageView switch6Image; // Value injected by FXMLLoader

    @FXML // fx:id="switch7Toggle"
    private ToggleButton switch7Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="switch7Image"
    private ImageView switch7Image; // Value injected by FXMLLoader

    @FXML // fx:id="switch8Toggle"
    private ToggleButton switch8Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="switch8Image"
    private ImageView switch8Image; // Value injected by FXMLLoader
    
    @FXML // fx:id="switch9Toggle"
    private ToggleButton switch9Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="switch9Image"
    private ImageView switch9Image; // Value injected by FXMLLoader

    @FXML // fx:id="switch10Toggle"
    private ToggleButton switch10Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="switch10Image"
    private ImageView switch10Image; // Value injected by FXMLLoader

    @FXML // fx:id="switch11Toggle"
    private ToggleButton switch11Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="switch11Image"
    private ImageView switch11Image; // Value injected by FXMLLoader

    @FXML // fx:id="switch12Toggle"
    private ToggleButton switch12Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="switch12Image"
    private ImageView switch12Image; // Value injected by FXMLLoader

    @FXML // fx:id="switch13Toggle"
    private ToggleButton switch13Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="switch13Image"
    private ImageView switch13Image; // Value injected by FXMLLoader

    @FXML // fx:id="switch14Toggle"
    private ToggleButton switch14Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="switch14Image"
    private ImageView switch14Image; // Value injected by FXMLLoader

    @FXML // fx:id="switch15Toggle"
    private ToggleButton switch15Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="switch15Image"
    private ImageView switch15Image; // Value injected by FXMLLoader

    @FXML // fx:id="switch16Toggle"
    private ToggleButton switch16Toggle; // Value injected by FXMLLoader

    @FXML // fx:id="switch16Image"
    private ImageView switch16Image; // Value injected by FXMLLoader
   

    
    public static SignalAspect getAspect() {
		return aspect;
	}


	@FXML
    void openbuildModifyMenu(ActionEvent event) {
    	trackMenu.setDisable(false);
    	trackMenu.setVisible(true);
    	//leftBufferToggle.setDisable(false);
    	//leftBufferToggle.setVisible(true);
    	//leftBufferImage.setDisable(false);
    	//leftBufferImage.setVisible(true);
    }
    
    @FXML
    void changeAspect(ActionEvent event) {
    	String aspectImage = null;
		Image image = null;
		
    	switch (aspect) {
    		case FOUR: 
    			aspect = SignalAspect.THREE; 
    			aspectImage = new String("graphics/threeIcon.png");
    			System.out.println(3);
    			break;
    			
    		case THREE: 
    			aspect = SignalAspect.TWO; 
    			aspectImage = new String("graphics/twoIcon.png");
    			System.out.println(2);
    			break;
    			
    		case TWO: 
    			aspect = SignalAspect.SHUNT; 
    			aspectImage = new String("graphics/shuntIcon.png");
    			BuildModifyMenuActions.changeToShuntSignalGraphic(signalLeftTrackImage, signalRightTrackImage, signalUpTrackImage,
    					signalDownTrackImage, signalLeftUpTrackImage, signalRightUpTrackImage, signalLeftDownTrackImage, signalRightDownTrackImage);
    			System.out.println(1);
    			break;
    			
    		case SHUNT: 
    			aspect = SignalAspect.FOUR; 
    			aspectImage = new String("graphics/fourIcon.png");
    			BuildModifyMenuActions.changeToNormalSignalGraphic(signalLeftTrackImage, signalRightTrackImage, signalUpTrackImage, signalDownTrackImage,
    					signalLeftUpTrackImage, signalRightUpTrackImage, signalLeftDownTrackImage, signalRightDownTrackImage);
    			System.out.println(4);
    			break;
    		
    		default:
    			break;
    		}
    		
    		image = new Image(MenuActions.class.getClassLoader().getResource(aspectImage).toString());
    		aspectChangerImage.setImage(image);
    		
    }
    
    
    // Select Straight Track Actions.
    
    @FXML
    void selectStraightHorizontal(ActionEvent event) {
    	
    	if (straightHorizontalToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.STRAIGHTH);
		} else {
			straightHorizontalToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}
    }
    
    @FXML
    void selectStraightVertical(ActionEvent event) {
    	if (straightVerticalToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.STRAIGHTV);
		} else {
			straightVerticalToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectStraightLeftUp(ActionEvent event) {
    	if (straightLeftUpToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.STRAIGHTLEFTUP);
		} else {
			straightLeftUpToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectStraightRightUp(ActionEvent event) {
    	if (straightRightUpToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.STRAIGHTRIGHTUP);
		} else {
			straightRightUpToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    //Select Buffer Actions.

    @FXML
    void selectBufferLeft(ActionEvent event) {
    		
    		if (bufferLeftToggle.isSelected()) {
    			GUIController.setItemSelected(TrackType.BUFFERLEFT);
    		} else {
    			bufferLeftToggle.setSelected(false);
    			GUIController.setItemSelected(TrackType.NONE);
    		}
    		

    }
    @FXML
    void selectBufferDown(ActionEvent event) {
    	if (bufferDownToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.BUFFERDOWN);
		} else {
			bufferDownToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    

    @FXML
    void selectBufferRight(ActionEvent event) {
    	if (bufferRightToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.BUFFERRIGHT);
		} else {
			bufferRightToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectBufferUp(ActionEvent event) {
    	if (bufferUpToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.BUFFERUP);
		} else {
			bufferUpToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}
    }
    
    @FXML
    void selectBufferLeftUp(ActionEvent event) {
    	if (bufferLeftUpToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.BUFFERLEFTUP);
		} else {
			bufferLeftUpToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}
    }

    @FXML
    void selectBufferRightUp(ActionEvent event) {
    	if (bufferRightUpToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.BUFFERRIGHTUP);
		} else {
			bufferRightUpToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}
    }
    
    @FXML
    void selectBufferLeftDown(ActionEvent event) {
    	if (bufferLeftDownToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.BUFFERLEFTDOWN);
		} else {
			bufferLeftDownToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectBufferRightDown(ActionEvent event) {
    	if (bufferRightDownToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.BUFFERRIGHTDOWN);
		} else {
			bufferRightDownToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    //Select Gap Link Track actions
    
    @FXML
    void selectLinkLeft(ActionEvent event) {
    	if (linkLeftToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.LINKLEFT);
		} else {
			linkLeftToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectLinkRight(ActionEvent event) {
    	if (linkRightToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.LINKRIGHT);
		} else {
			linkRightToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectLinkDown(ActionEvent event) {
    	if (linkDownToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.LINKDOWN);
		} else {
			linkDownToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectLinkUp(ActionEvent event) {
    	if (linkUpToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.LINKUP);
		} else {
			linkUpToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectLinkLeftUp(ActionEvent event) {
    	if (linkLeftUpToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.LINKLEFTUP);
		} else {
			linkLeftUpToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectLinkRightUp(ActionEvent event) {
    	if (linkRightUpToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.LINKRIGHTUP);
		} else {
			linkRightUpToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectLinkLeftDown(ActionEvent event) {
    	if (linkLeftDownToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.LINKLEFTDOWN);
		} else {
			linkLeftDownToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectLinkRightDown(ActionEvent event) {
    	if (linkRightDownToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.LINKRIGHTDOWN);
		} else {
			linkRightDownToggle.setSelected(false);
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
    
    @FXML
    void selectExitLeftUpTrack(ActionEvent event) {
    	if (exitLeftUpTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.EXITLEFTUP);
		} else {
			exitLeftTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectExitRightUpTrack(ActionEvent event) {
    	if (exitRightUpTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.EXITRIGHTUP);
		} else {
			exitRightUpTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectExitLeftDownTrack(ActionEvent event) {
    	if (exitLeftDownTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.EXITLEFTDOWN);
		} else {
			exitLeftDownTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectExitRightDownTrack(ActionEvent event) {
    	if (exitRightDownTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.EXITRIGHTDOWN);
		} else {
			exitRightDownTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    // Select Signal Track actions
    
    @FXML
    void selectSignalLeftTrack(ActionEvent event) {
    	if (signalLeftTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SIGNALLEFT);
		} else {
			signalLeftTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectSignalRightTrack(ActionEvent event) {
    	if (signalRightTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SIGNALRIGHT);
		} else {
			signalRightTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectSignalUpTrack(ActionEvent event) {
    	if (signalUpTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SIGNALUP);
		} else {
			signalUpTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectSignalDownTrack(ActionEvent event) {
    	if (signalDownTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SIGNALDOWN);
		} else {
			signalDownTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectSignalLeftUpTrack(ActionEvent event) {
    	if (signalLeftUpTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SIGNALLEFTUP);
		} else {
			signalLeftUpTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectSignalRightUpTrack(ActionEvent event) {
    	if (signalRightUpTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SIGNALRIGHTUP);
		} else {
			signalRightUpTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectSignalLeftDownTrack(ActionEvent event) {
    	if (signalLeftDownTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SIGNALLEFTDOWN);
		} else {
			signalLeftDownTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectSignalRightDownTrack(ActionEvent event) {
    	if (signalRightDownTrackToggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SIGNALRIGHTDOWN);
		} else {
			signalRightDownTrackToggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    // Select Tight Curve Actions
    
    @FXML
    void selectTightCurve1(ActionEvent event) {
    	if (tightCurve1Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.TIGHTCURVE1);
		} else {
			tightCurve1Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}
    }

    @FXML
    void selectTightCurve2(ActionEvent event) {
    	if (tightCurve2Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.TIGHTCURVE2);
		} else {
			tightCurve2Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectTightCurve3(ActionEvent event) {
    	if (tightCurve3Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.TIGHTCURVE3);
		} else {
			tightCurve3Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectTightCurve4(ActionEvent event) {
    	if (tightCurve4Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.TIGHTCURVE4);
		} else {
			tightCurve4Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}
    }
    
    // Select Curve Actions
    
    @FXML
    void selectCurve1(ActionEvent event) {
    	if (curve1Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.CURVE1);
		} else {
			curve1Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectCurve2(ActionEvent event) {
    	if (curve2Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.CURVE2);
		} else {
			curve2Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectCurve3(ActionEvent event) {
    	if (curve3Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.CURVE3);
		} else {
			curve3Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectCurve4(ActionEvent event) {
    	if (curve4Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.CURVE4);
		} else {
			curve4Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectCurve5(ActionEvent event) {
    	if (curve5Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.CURVE5);
		} else {
			curve5Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectCurve6(ActionEvent event) {
    	if (curve6Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.CURVE6);
		} else {
			curve6Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectCurve7(ActionEvent event) {
    	if (curve7Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.CURVE7);
		} else {
			curve7Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectCurve8(ActionEvent event) {
    	if (curve8Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.CURVE8);
		} else {
			curve8Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    //Select Bridge and Underpass tracks
    
    @FXML
    void selectBridge1(ActionEvent event) {
    	if (bridge1Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.BRIDGE1);
		} else {
			bridge1Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}
    }

    @FXML
    void selectBridge2(ActionEvent event) {
    	if (bridge2Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.BRIDGE2);
		} else {
			bridge2Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    @FXML
    void selectUnderpass1(ActionEvent event) {
    	if (underpass1Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.UNDERPASS1);
		} else {
			underpass1Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectUnderpass2(ActionEvent event) {
    	if (underpass2Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.UNDERPASS2);
		} else {
			underpass2Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    // Select tight switch actions
    
    @FXML
    void selectSwitchTight1(ActionEvent event) {
    	if (switchTight1Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SWITCHTIGHT1);
		} else {
			switchTight1Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectSwitchTight2(ActionEvent event) {
    	if (switchTight2Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SWITCHTIGHT2);
		} else {
			switchTight2Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectSwitchTight3(ActionEvent event) {
    	if (switchTight3Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SWITCHTIGHT3);
		} else {
			switchTight3Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectSwitchTight4(ActionEvent event) {
    	if (switchTight4Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SWITCHTIGHT4);
		} else {
			switchTight4Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    @FXML
    void selectSwitchTight5(ActionEvent event) {
    	if (switchTight5Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SWITCHTIGHT5);
		} else {
			switchTight5Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectSwitchTight6(ActionEvent event) {
    	if (switchTight6Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SWITCHTIGHT6);
		} else {
			switchTight6Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectSwitchTight7(ActionEvent event) {
    	if (switchTight7Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SWITCHTIGHT7);
		} else {
			switchTight7Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectSwitchTight8(ActionEvent event) {
    	if (switchTight8Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SWITCHTIGHT8);
		} else {
			switchTight8Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    
    
    @FXML
    void selectSwitch9(ActionEvent event) {
    	if (switch9Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SWITCH9);
		} else {
			switch9Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectSwitch10(ActionEvent event) {
    	if (switch10Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SWITCH10);
		} else {
			switch10Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectSwitch11(ActionEvent event) {
    	if (switch11Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SWITCH11);
		} else {
			switch11Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectSwitch12(ActionEvent event) {
    	if (switch12Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SWITCH12);
		} else {
			switch12Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    @FXML
    void selectSwitch13(ActionEvent event) {
    	if (switch13Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SWITCH13);
		} else {
			switch13Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectSwitch14(ActionEvent event) {
    	if (switch14Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SWITCH14);
		} else {
			switch14Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectSwitch15(ActionEvent event) {
    	if (switch15Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SWITCH15);
		} else {
			switch15Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectSwitch16(ActionEvent event) {
    	if (switch16Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SWITCH16);
		} else {
			switch16Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    @FXML
    void selectSwitch1(ActionEvent event) {
    	if (switch1Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SWITCH1);
		} else {
			switch1Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectSwitch2(ActionEvent event) {
    	if (switch2Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SWITCH2);
		} else {
			switch2Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectSwitch3(ActionEvent event) {
    	if (switch3Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SWITCH3);
		} else {
			switch3Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectSwitch4(ActionEvent event) {
    	if (switch4Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SWITCH4);
		} else {
			switch4Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }
    @FXML
    void selectSwitch5(ActionEvent event) {
    	if (switch5Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SWITCH5);
		} else {
			switch5Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectSwitch6(ActionEvent event) {
    	if (switch6Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SWITCH6);
		} else {
			switch6Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectSwitch7(ActionEvent event) {
    	if (switch7Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SWITCH7);
		} else {
			switch7Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    @FXML
    void selectSwitch8(ActionEvent event) {
    	if (switch8Toggle.isSelected()) {
    		GUIController.setItemSelected(TrackType.SWITCH8);
		} else {
			switch8Toggle.setSelected(false);
			GUIController.setItemSelected(TrackType.NONE);
		}

    }

    
   
    
    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	 aspect = SignalAspect.FOUR;
    }

}

