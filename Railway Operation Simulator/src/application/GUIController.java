package application;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import application.MenuActions;
import elements.SignalAspect;
import elements.StraightTrack;
import elements.Track;
import elements.TrackType;

/**
 * GUIController.java The class that interacts with the GUI.fxml to output to
 * screen. Behaviours and Actions are specified here.
 * 
 * @version 1.01
 * @author Jonathan K
 */

public class GUIController extends Application {

	private static TrackType itemSelected = TrackType.NONE;

	public static TrackType getItemSelected() {
		return itemSelected;
	}

	public static void setItemSelected(TrackType itemSelected) {
		GUIController.itemSelected = itemSelected;
	}

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;
	
	@FXML // fx:id="boarderPane"
    private BorderPane boarderPane; // Value injected by FXMLLoader
	
	@FXML // fx:id="pane"
	private Pane pane; // Value injected by FXMLLoader

	@FXML // fx:id="topVBox"
	private VBox topVBox; // Value injected by FXMLLoader

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

	@FXML // fx:id="canvasSlider"
	private Slider canvasSlider; // Value injected by FXMLLoader

	@FXML // fx:id="showHideGridButton"
	private Button showHideGridButton; // Value injected by FXMLLoader

	@FXML // fx:id="railMap"
	private Canvas railMap; // Value injected by FXMLLoader

	/**
	 * A method to exit and close the program.
	 * 
	 * @param event
	 */
	@FXML
	void exitApp(ActionEvent event) {
		MenuActions.exitProgram();
	}

	/**
	 * A method to open a Help Window.
	 * 
	 * @param event
	 */
	@FXML
	void openHelpWIndow(ActionEvent event) {

	}

	/**
	 * A method to open the Railway Homepage.
	 * 
	 * @param event
	 */
	@FXML
	void openRailwayWebsite(ActionEvent event) {
		getHostServices().showDocument("https://www.railwayoperationsimulator.com/");

	}

	/**
	 * A method to add item and graphic to the railmap.
	 * 
	 * @param event
	 */
	@FXML
	void onMouseClicked(MouseEvent event) {

		SignalAspect aspect = BuildModifyMenuController.getAspect();

		if (event.getButton() == MouseButton.PRIMARY) {

			switch (itemSelected) {
			case NONE:
				MenuActions.makeNoItemSelectedErrorBox();
				break;

			case STRAIGHTHORIZONTAL:
				MenuActions.addTrack(event, railMap, "graphics/StraightH.png", itemSelected, null);
				break;

			case STRAIGHTVERTICAL:
				MenuActions.addTrack(event, railMap, "graphics/StraightV.png", itemSelected, null);
				break;

			case STRAIGHTLEFTUP:
				MenuActions.addTrack(event, railMap, "graphics/straightLeftUp.png", itemSelected, null);
				break;

			case STRAIGHTRIGHTUP:
				MenuActions.addTrack(event, railMap, "graphics/straightRightUp.png", itemSelected, null);
				break;

			case LEFTBUFFER:
				MenuActions.addTrack(event, railMap, "graphics/leftBuffer.png", itemSelected, null);
				break;

			case RIGHTBUFFER:
				MenuActions.addTrack(event, railMap, "graphics/rightBuffer.png", itemSelected, null);
				break;

			case UPBUFFER:
				MenuActions.addTrack(event, railMap, "graphics/upBuffer.png", itemSelected, null);
				break;

			case DOWNBUFFER:
				MenuActions.addTrack(event, railMap, "graphics/downBuffer.png", itemSelected, null);
				break;

			case LEFTUPBUFFER:
				MenuActions.addTrack(event, railMap, "graphics/leftUpBuffer.png", itemSelected, null);
				break;

			case RIGHTUPBUFFER:
				MenuActions.addTrack(event, railMap, "graphics/rightUpBuffer.png", itemSelected, null);
				break;

			case LEFTDOWNBUFFER:
				MenuActions.addTrack(event, railMap, "graphics/leftDownBuffer.png", itemSelected, null);
				break;

			case RIGHTDOWNBUFFER:
				MenuActions.addTrack(event, railMap, "graphics/rightDownBuffer.png", itemSelected, null);
				break;

			case LEFTGAP:
				MenuActions.addTrack(event, railMap, "graphics/unsetLeftGap.png", itemSelected, null);
				break;

			case RIGHTGAP:
				MenuActions.addTrack(event, railMap, "graphics/unsetRightGap.png", itemSelected, null);
				break;

			case UPGAP:
				MenuActions.addTrack(event, railMap, "graphics/unsetUpGap.png", itemSelected, null);
				break;

			case DOWNGAP:
				MenuActions.addTrack(event, railMap, "graphics/unsetDownGap.png", itemSelected, null);
				break;

			case LEFTUPGAP:
				MenuActions.addTrack(event, railMap, "graphics/unsetLeftUpGap.png", itemSelected, null);
				break;

			case RIGHTUPGAP:
				MenuActions.addTrack(event, railMap, "graphics/unsetRightUpGap.png", itemSelected, null);
				break;

			case LEFTDOWNGAP:
				MenuActions.addTrack(event, railMap, "graphics/unsetLeftDownGap.png", itemSelected, null);
				break;

			case RIGHTDOWNGAP:
				MenuActions.addTrack(event, railMap, "graphics/unsetRightDownGap.png", itemSelected, null);
				break;

			case DIRECTLEFT:
				MenuActions.addTrack(event, railMap, "graphics/directLeft.png", itemSelected, null);
				break;

			case DIRECTRIGHT:
				MenuActions.addTrack(event, railMap, "graphics/directRight.png", itemSelected, null);
				break;

			case DIRECTUP:
				MenuActions.addTrack(event, railMap, "graphics/directUp.png", itemSelected, null);
				break;

			case DIRECTDOWN:
				MenuActions.addTrack(event, railMap, "graphics/directDown.png", itemSelected, null);
				break;

			case DIRECTLEFTUP:
				MenuActions.addTrack(event, railMap, "graphics/directLeftUp.png", itemSelected, null);
				break;

			case DIRECTRIGHTUP:
				MenuActions.addTrack(event, railMap, "graphics/directRightUp.png", itemSelected, null);
				break;

			case DIRECTLEFTDOWN:
				MenuActions.addTrack(event, railMap, "graphics/directLeftDown.png", itemSelected, null);
				break;

			case DIRECTRIGHTDOWN:
				MenuActions.addTrack(event, railMap, "graphics/directRightDown.png", itemSelected, null);
				break;

			case EXITLEFT:
				MenuActions.addTrack(event, railMap, "graphics/exitLeftTrack.png", itemSelected, null);
				break;

			case EXITRIGHT:
				MenuActions.addTrack(event, railMap, "graphics/exitRightTrack.png", itemSelected, null);
				break;

			case EXITUP:
				MenuActions.addTrack(event, railMap, "graphics/exitUpTrack.png", itemSelected, null);
				break;

			case EXITDOWN:
				MenuActions.addTrack(event, railMap, "graphics/exitDownTrack.png", itemSelected, null);
				break;
				
			case EXITLEFTUP:
				MenuActions.addTrack(event, railMap, "graphics/exitLeftUpTrack.png", itemSelected, null);
				break;

			case EXITRIGHTUP:
				MenuActions.addTrack(event, railMap, "graphics/exitRightUpTrack.png", itemSelected, null);
				break;

			case EXITLEFTDOWN:
				MenuActions.addTrack(event, railMap, "graphics/exitLeftDownTrack.png", itemSelected, null);
				break;

			case EXITRIGHTDOWN:
				MenuActions.addTrack(event, railMap, "graphics/exitRightDownTrack.png", itemSelected, null);
				break;
				
			case TIGHTCURVE1:
				MenuActions.addTrack(event, railMap, "graphics/tightCurve1.png", itemSelected, null);
				break;

			case TIGHTCURVE2:
				MenuActions.addTrack(event, railMap, "graphics/tightcurve2.png", itemSelected, null);
				break;

			case TIGHTCURVE3:
				MenuActions.addTrack(event, railMap, "graphics/tightCurve3.png", itemSelected, null);
				break;

			case TIGHTCURVE4:
				MenuActions.addTrack(event, railMap, "graphics/tightCurve4.png", itemSelected, null);
				break;
				
			case CURVE1:
				MenuActions.addTrack(event, railMap, "graphics/curve1.png", itemSelected, null);
				break;

			case CURVE2:
				MenuActions.addTrack(event, railMap, "graphics/curve2.png", itemSelected, null);
				break;

			case CURVE3:
				MenuActions.addTrack(event, railMap, "graphics/curve4.png", itemSelected, null);
				break;

			case CURVE4:
				MenuActions.addTrack(event, railMap, "graphics/curve4.png", itemSelected, null);
				break;
				
			case CURVE5:
				MenuActions.addTrack(event, railMap, "graphics/curve5.png", itemSelected, null);
				break;

			case CURVE6:
				MenuActions.addTrack(event, railMap, "graphics/curve6.png", itemSelected, null);
				break;

			case CURVE7:
				MenuActions.addTrack(event, railMap, "graphics/curve7.png", itemSelected, null);
				break;

			case CURVE8:
				MenuActions.addTrack(event, railMap, "graphics/curve8.png", itemSelected, null);
				break;
				
			case BRIDGE1:
				MenuActions.addTrack(event, railMap, "graphics/bridgeUnset1.png", itemSelected, null);
				break;

			case BRIDGE2:
				MenuActions.addTrack(event, railMap, "graphics/bridgeUnset2.png", itemSelected, null);
				break;

			case UNDERPASS1:
				MenuActions.addTrack(event, railMap, "graphics/underpassUnset1.png", itemSelected, null);
				break;

			case UNDERPASS2:
				MenuActions.addTrack(event, railMap, "graphics/underpassUnset2.png", itemSelected, null);
				break;
				
			case SWITCHTIGHT1:
				MenuActions.addTrack(event, railMap, "graphics/switchTight1.png", itemSelected, null);
				break;

			case SWITCHTIGHT2:
				MenuActions.addTrack(event, railMap, "graphics/switchTight2.png", itemSelected, null);
				break;

			case SWITCHTIGHT3:
				MenuActions.addTrack(event, railMap, "graphics/switchTight3.png", itemSelected, null);
				break;

			case SWITCHTIGHT4:
				MenuActions.addTrack(event, railMap, "graphics/switchTight4.png", itemSelected, null);
				break;
				
			case SWITCH1:
				MenuActions.addTrack(event, railMap, "graphics/switch1.png", itemSelected, null);
				break;

			case SWITCH2:
				MenuActions.addTrack(event, railMap, "graphics/switch2.png", itemSelected, null);
				break;

			case SWITCH3:
				MenuActions.addTrack(event, railMap, "graphics/switch3.png", itemSelected, null);
				break;

			case SWITCH4:
				MenuActions.addTrack(event, railMap, "graphics/switch4.png", itemSelected, null);
				break;

			case SIGNALLEFT:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addTrack(event, railMap, "graphics/shuntLeftRed.png", itemSelected, aspect);
				} else {
					MenuActions.addTrack(event, railMap, "graphics/signalLeft.png", itemSelected, aspect);
				}

				break;

			case SIGNALRIGHT:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addTrack(event, railMap, "graphics/shuntRightRed.png", itemSelected, aspect);
				} else {
					MenuActions.addTrack(event, railMap, "graphics/signalRight.png", itemSelected, aspect);
				}
				break;

			case SIGNALUP:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addTrack(event, railMap,"graphics/shuntUpRed.png", itemSelected, aspect);
				} else {
					MenuActions.addTrack(event, railMap,"graphics/signalUp.png", itemSelected, aspect);
				}
				break;

			case SIGNALDOWN:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addTrack(event, railMap,"graphics/shuntDownRed.png", itemSelected, aspect);
				} else {
					MenuActions.addTrack(event, railMap,"graphics/signalDown.png", itemSelected, aspect);
				}
				break;
				
			case SIGNALLEFTUP:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addTrack(event, railMap, "graphics/shuntLeftUpRed.png", itemSelected, aspect);
				} else {
					MenuActions.addTrack(event, railMap, "graphics/signalLeftUp.png", itemSelected, aspect);
				}

				break;

			case SIGNALRIGHTUP:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addTrack(event, railMap, "graphics/shuntRightUpRed.png", itemSelected, aspect);
				} else {
					MenuActions.addTrack(event, railMap, "graphics/signalRightUp.png", itemSelected, aspect);
				}
				break;
				
			case SIGNALLEFTDOWN:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addTrack(event, railMap, "graphics/shuntLeftDownRed.png", itemSelected, aspect);
				} else {
					MenuActions.addTrack(event, railMap, "graphics/signalLeftDown.png", itemSelected, aspect);
				}

				break;

			case SIGNALRIGHTDOWN:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addTrack(event, railMap, "graphics/shuntRightDownRed.png", itemSelected, aspect);
				} else {
					MenuActions.addTrack(event, railMap, "graphics/signalRightDown.png", itemSelected, aspect);
				}
				break;

			default:
				break;

			}

		} else if (event.getButton() == MouseButton.SECONDARY) {
			MenuActions.deleteTrack(event, railMap, showHideGridButton);
		}

	}

	/**
	 * A method to show the build menu.
	 * 
	 * @param event
	 */
	@FXML
	void showBuildMenu(ActionEvent event) {

	}

	/**
	 * A method to show the grid.
	 * 
	 * @param event
	 */
	@FXML
	void showGrid(ActionEvent event) {
		MenuActions.toggleGrid(railMap, showHideGridButton);
	}

	/**
	 * A method that zooms in and out of canvas.
	 * 
	 * @param event
	 */
	@FXML
	void onSliderChanged(MouseEvent event) {
		int sliderValue = (int) canvasSlider.getValue();
		railMap.setScaleX(sliderValue);
		railMap.setScaleY(sliderValue);
	}

	/**
	 * Auto-generated method t help initalize the FXML?
	 */
	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {

		try {
			VBox buildMenu = FXMLLoader.load(getClass().getResource("BuildModifyMenu.fxml"));
			topVBox.getChildren().add(buildMenu);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		railMap.widthProperty().bind(pane.widthProperty());
	    railMap.heightProperty().bind(pane.heightProperty());
		assert topVBox != null : "fx:id=\"topVBox\" was not injected: check your FXML file 'GUI.fxml'.";
		assert exitMenuItem != null : "fx:id=\"exitMenuItem\" was not injected: check your FXML file 'GUI.fxml'.";
		assert buildModifyRailway != null : "fx:id=\"buildModifyRailway\" was not injected: check your FXML file 'GUI.fxml'.";
		assert railwayHelpMenuItem != null : "fx:id=\"railwayHelpMenuItem\" was not injected: check your FXML file 'GUI.fxml'.";
		assert railwayWebsiteMenuItem != null : "fx:id=\"railwayWebsiteMenuItem\" was not injected: check your FXML file 'GUI.fxml'.";
		assert aboutMenuItem != null : "fx:id=\"aboutMenuItem\" was not injected: check your FXML file 'GUI.fxml'.";
		assert showHideGridButton != null : "fx:id=\"showHideGridButton\" was not injected: check your FXML file 'GUI.fxml'.";
		assert railMap != null : "fx:id=\"railMap\" was not injected: check your FXML file 'GUI.fxml'.";
	}

	/**
	 * 
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

	}
}