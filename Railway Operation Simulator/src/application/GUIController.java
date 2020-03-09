package application;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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

	@FXML // fx:id="whiteBackgroundMenuItem"
	private MenuItem whiteBackgroundMenuItem; // Value injected by FXMLLoader

	@FXML // fx:id="blackBackgroundMenuItem"
	private MenuItem blackBackgroundMenuItem; // Value injected by FXMLLoader

	@FXML // fx:id="blueBackgroundMenuItem"
	private MenuItem blueBackgroundMenuItem; // Value injected by FXMLLoader

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

	@FXML // fx:id="canvas"
	private Canvas canvas; // Value injected by FXMLLoader
	
	Color backgroundColour;
	
	BackgroundFill colourBack;
	
	Background background;

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

			case STRAIGHTH:
				MenuActions.addTrack(event, canvas, "graphics/straightH.png", itemSelected, null);
				break;

			case STRAIGHTV:
				MenuActions.addTrack(event, canvas, "graphics/straightV.png", itemSelected, null);
				break;

			case STRAIGHTRIGHTUP:
				MenuActions.addTrack(event, canvas, "graphics/straightRightUp.png", itemSelected, null);
				break;

			case STRAIGHTLEFTUP:
				MenuActions.addTrack(event, canvas, "graphics/straightLeftUp.png", itemSelected, null);
				break;

			case BUFFERLEFT:
				MenuActions.addTrack(event, canvas, "graphics/bufferLeft.png", itemSelected, null);
				break;

			case BUFFERRIGHT:
				MenuActions.addTrack(event, canvas, "graphics/bufferRight.png", itemSelected, null);
				break;

			case BUFFERUP:
				MenuActions.addTrack(event, canvas, "graphics/bufferUp.png", itemSelected, null);
				break;

			case BUFFERDOWN:
				MenuActions.addTrack(event, canvas, "graphics/bufferDown.png", itemSelected, null);
				break;

			case BUFFERLEFTUP:
				MenuActions.addTrack(event, canvas, "graphics/bufferLeftUp.png", itemSelected, null);
				break;

			case BUFFERRIGHTUP:
				MenuActions.addTrack(event, canvas, "graphics/bufferRightUp.png", itemSelected, null);
				break;

			case BUFFERLEFTDOWN:
				MenuActions.addTrack(event, canvas, "graphics/bufferLeftDown.png", itemSelected, null);
				break;

			case BUFFERRIGHTDOWN:
				MenuActions.addTrack(event, canvas, "graphics/bufferRightDown.png", itemSelected, null);
				break;

			case LINKLEFT:
				MenuActions.addTrack(event, canvas, "graphics/linkLeftUnset.png", itemSelected, null);
				break;

			case LINKRIGHT:
				MenuActions.addTrack(event, canvas, "graphics/linkRightUnset.png", itemSelected, null);
				break;

			case LINKUP:
				MenuActions.addTrack(event, canvas, "graphics/linkUpUnset.png", itemSelected, null);
				break;

			case LINKDOWN:
				MenuActions.addTrack(event, canvas, "graphics/linkDownUnset.png", itemSelected, null);
				break;

			case LINKLEFTUP:
				MenuActions.addTrack(event, canvas, "graphics/linkLeftUpUnset.png", itemSelected, null);
				break;

			case LINKRIGHTUP:
				MenuActions.addTrack(event, canvas, "graphics/linkRightUpUnset.png", itemSelected, null);
				break;

			case LINKLEFTDOWN:
				MenuActions.addTrack(event, canvas, "graphics/linkLeftDownUnset.png", itemSelected, null);
				break;

			case LINKRIGHTDOWN:
				MenuActions.addTrack(event, canvas, "graphics/linkRightDownUnset.png", itemSelected, null);
				break;

			case DIRECTLEFT:
				MenuActions.addTrack(event, canvas, "graphics/directLeft.png", itemSelected, null);
				break;

			case DIRECTRIGHT:
				MenuActions.addTrack(event, canvas, "graphics/directRight.png", itemSelected, null);
				break;

			case DIRECTUP:
				MenuActions.addTrack(event, canvas, "graphics/directUp.png", itemSelected, null);
				break;

			case DIRECTDOWN:
				MenuActions.addTrack(event, canvas, "graphics/directDown.png", itemSelected, null);
				break;

			case DIRECTLEFTUP:
				MenuActions.addTrack(event, canvas, "graphics/directLeftUp.png", itemSelected, null);
				break;

			case DIRECTRIGHTUP:
				MenuActions.addTrack(event, canvas, "graphics/directRightUp.png", itemSelected, null);
				break;

			case DIRECTLEFTDOWN:
				MenuActions.addTrack(event, canvas, "graphics/directLeftDown.png", itemSelected, null);
				break;

			case DIRECTRIGHTDOWN:
				MenuActions.addTrack(event, canvas, "graphics/directRightDown.png", itemSelected, null);
				break;

			case EXITLEFT:
				MenuActions.addTrack(event, canvas, "graphics/exitLeftTrack.png", itemSelected, null);
				break;

			case EXITRIGHT:
				MenuActions.addTrack(event, canvas, "graphics/exitRightTrack.png", itemSelected, null);
				break;

			case EXITUP:
				MenuActions.addTrack(event, canvas, "graphics/exitUpTrack.png", itemSelected, null);
				break;

			case EXITDOWN:
				MenuActions.addTrack(event, canvas, "graphics/exitDownTrack.png", itemSelected, null);
				break;

			case EXITLEFTUP:
				MenuActions.addTrack(event, canvas, "graphics/exitLeftUpTrack.png", itemSelected, null);
				break;

			case EXITRIGHTUP:
				MenuActions.addTrack(event, canvas, "graphics/exitRightUpTrack.png", itemSelected, null);
				break;

			case EXITLEFTDOWN:
				MenuActions.addTrack(event, canvas, "graphics/exitLeftDownTrack.png", itemSelected, null);
				break;

			case EXITRIGHTDOWN:
				MenuActions.addTrack(event, canvas, "graphics/exitRightDownTrack.png", itemSelected, null);
				break;

			case TIGHTCURVE1:
				MenuActions.addTrack(event, canvas, "graphics/tightCurve1.png", itemSelected, null);
				break;

			case TIGHTCURVE2:
				MenuActions.addTrack(event, canvas, "graphics/tightcurve2.png", itemSelected, null);
				break;

			case TIGHTCURVE3:
				MenuActions.addTrack(event, canvas, "graphics/tightCurve3.png", itemSelected, null);
				break;

			case TIGHTCURVE4:
				MenuActions.addTrack(event, canvas, "graphics/tightCurve4.png", itemSelected, null);
				break;

			case CURVE1:
				MenuActions.addTrack(event, canvas, "graphics/curve1.png", itemSelected, null);
				break;

			case CURVE2:
				MenuActions.addTrack(event, canvas, "graphics/curve2.png", itemSelected, null);
				break;

			case CURVE3:
				MenuActions.addTrack(event, canvas, "graphics/curve4.png", itemSelected, null);
				break;

			case CURVE4:
				MenuActions.addTrack(event, canvas, "graphics/curve4.png", itemSelected, null);
				break;

			case CURVE5:
				MenuActions.addTrack(event, canvas, "graphics/curve5.png", itemSelected, null);
				break;

			case CURVE6:
				MenuActions.addTrack(event, canvas, "graphics/curve6.png", itemSelected, null);
				break;

			case CURVE7:
				MenuActions.addTrack(event, canvas, "graphics/curve7.png", itemSelected, null);
				break;

			case CURVE8:
				MenuActions.addTrack(event, canvas, "graphics/curve8.png", itemSelected, null);
				break;

			case BRIDGE1:
				MenuActions.addTrack(event, canvas, "graphics/bridgeUnset1.png", itemSelected, null);
				break;

			case BRIDGE2:
				MenuActions.addTrack(event, canvas, "graphics/bridgeUnset2.png", itemSelected, null);
				break;

			case UNDERPASS1:
				MenuActions.addTrack(event, canvas, "graphics/underpassUnset1.png", itemSelected, null);
				break;

			case UNDERPASS2:
				MenuActions.addTrack(event, canvas, "graphics/underpassUnset2.png", itemSelected, null);
				break;

			case SWITCHTIGHT1:
				MenuActions.addTrack(event, canvas, "graphics/switchTight1.png", itemSelected, null);
				break;

			case SWITCHTIGHT2:
				MenuActions.addTrack(event, canvas, "graphics/switchTight2.png", itemSelected, null);
				break;

			case SWITCHTIGHT3:
				MenuActions.addTrack(event, canvas, "graphics/switchTight3.png", itemSelected, null);
				break;

			case SWITCHTIGHT4:
				MenuActions.addTrack(event, canvas, "graphics/switchTight4.png", itemSelected, null);
				break;

			case SWITCHTIGHT5:
				MenuActions.addTrack(event, canvas, "graphics/switchTight5.png", itemSelected, null);
				break;

			case SWITCHTIGHT6:
				MenuActions.addTrack(event, canvas, "graphics/switchTight6.png", itemSelected, null);
				break;

			case SWITCHTIGHT7:
				MenuActions.addTrack(event, canvas, "graphics/switchTight7.png", itemSelected, null);
				break;

			case SWITCHTIGHT8:
				MenuActions.addTrack(event, canvas, "graphics/switchTight8.png", itemSelected, null);
				break;

			case SWITCH1:
				MenuActions.addTrack(event, canvas, "graphics/switch1.png", itemSelected, null);
				break;

			case SWITCH2:
				MenuActions.addTrack(event, canvas, "graphics/switch2.png", itemSelected, null);
				break;

			case SWITCH3:
				MenuActions.addTrack(event, canvas, "graphics/switch3.png", itemSelected, null);
				break;

			case SWITCH4:
				MenuActions.addTrack(event, canvas, "graphics/switch4.png", itemSelected, null);
				break;

			case SWITCH5:
				MenuActions.addTrack(event, canvas, "graphics/switch5.png", itemSelected, null);
				break;

			case SWITCH6:
				MenuActions.addTrack(event, canvas, "graphics/switch6.png", itemSelected, null);
				break;

			case SWITCH7:
				MenuActions.addTrack(event, canvas, "graphics/switch7.png", itemSelected, null);
				break;

			case SWITCH8:
				MenuActions.addTrack(event, canvas, "graphics/switch8.png", itemSelected, null);
				break;

			case SWITCH9:
				MenuActions.addTrack(event, canvas, "graphics/switch9.png", itemSelected, null);
				break;

			case SWITCH10:
				MenuActions.addTrack(event, canvas, "graphics/switch10.png", itemSelected, null);
				break;

			case SWITCH11:
				MenuActions.addTrack(event, canvas, "graphics/switch11.png", itemSelected, null);
				break;

			case SWITCH12:
				MenuActions.addTrack(event, canvas, "graphics/switch12.png", itemSelected, null);
				break;

			case SWITCH13:
				MenuActions.addTrack(event, canvas, "graphics/switch13.png", itemSelected, null);
				break;

			case SWITCH14:
				MenuActions.addTrack(event, canvas, "graphics/switch14.png", itemSelected, null);
				break;

			case SWITCH15:
				MenuActions.addTrack(event, canvas, "graphics/switch15.png", itemSelected, null);
				break;

			case SWITCH16:
				MenuActions.addTrack(event, canvas, "graphics/switch16.png", itemSelected, null);
				break;

			case SIGNALLEFT:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addTrack(event, canvas, "graphics/shuntLeftRed.png", itemSelected, aspect);
				} else {
					MenuActions.addTrack(event, canvas, "graphics/signalLeft.png", itemSelected, aspect);
				}

				break;

			case SIGNALRIGHT:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addTrack(event, canvas, "graphics/shuntRightRed.png", itemSelected, aspect);
				} else {
					MenuActions.addTrack(event, canvas, "graphics/signalRight.png", itemSelected, aspect);
				}
				break;

			case SIGNALUP:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addTrack(event, canvas, "graphics/shuntUpRed.png", itemSelected, aspect);
				} else {
					MenuActions.addTrack(event, canvas, "graphics/signalUp.png", itemSelected, aspect);
				}
				break;

			case SIGNALDOWN:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addTrack(event, canvas, "graphics/shuntDownRed.png", itemSelected, aspect);
				} else {
					MenuActions.addTrack(event, canvas, "graphics/signalDown.png", itemSelected, aspect);
				}
				break;

			case SIGNALLEFTUP:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addTrack(event, canvas, "graphics/shuntLeftUpRed.png", itemSelected, aspect);
				} else {
					MenuActions.addTrack(event, canvas, "graphics/signalLeftUp.png", itemSelected, aspect);
				}

				break;

			case SIGNALRIGHTUP:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addTrack(event, canvas, "graphics/shuntRightUpRed.png", itemSelected, aspect);
				} else {
					MenuActions.addTrack(event, canvas, "graphics/signalRightUp.png", itemSelected, aspect);
				}
				break;

			case SIGNALLEFTDOWN:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addTrack(event, canvas, "graphics/shuntLeftDownRed.png", itemSelected, aspect);
				} else {
					MenuActions.addTrack(event, canvas, "graphics/signalLeftDown.png", itemSelected, aspect);
				}

				break;

			case SIGNALRIGHTDOWN:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addTrack(event, canvas, "graphics/shuntRightDownRed.png", itemSelected, aspect);
				} else {
					MenuActions.addTrack(event, canvas, "graphics/signalRightDown.png", itemSelected, aspect);
				}
				break;

			default:
				break;

			}

		} else if (event.getButton() == MouseButton.SECONDARY) {
			MenuActions.deleteTrack(event, canvas, showHideGridButton);
		}

	}

	/**
	 * A method to show the build menu.
	 * 
	 * @param event
	 */
	@FXML
	void showBuildMenu(ActionEvent event) {
		try {
			VBox buildMenu = FXMLLoader.load(getClass().getResource("BuildModifyMenu.fxml"));
			topVBox.getChildren().add(buildMenu);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * A method to show the grid.
	 * 
	 * @param event
	 */
	@FXML
	void showGrid(ActionEvent event) {
		MenuActions.toggleGrid(canvas, showHideGridButton);
	}

	/**
	 * A method that zooms in and out of canvas.
	 * 
	 * @param event
	 */
	@FXML
	void onSliderChanged(MouseEvent event) {
		int sliderValue = (int) canvasSlider.getValue();
		canvas.setScaleX(sliderValue);
		canvas.setScaleY(sliderValue);
	}

	@FXML
	void selectBlackBackground(ActionEvent event) {
		backgroundColour = Color.BLACK;
		colourBack = new BackgroundFill(backgroundColour, CornerRadii.EMPTY, Insets.EMPTY);
		background = new Background(colourBack);
		pane.setBackground(background);

	}

	@FXML
	void selectBlueBackground(ActionEvent event) {
		backgroundColour = Color.DARKBLUE;
		colourBack = new BackgroundFill(backgroundColour, CornerRadii.EMPTY, Insets.EMPTY);
		background = new Background(colourBack);
		pane.setBackground(background);

	}

	@FXML
	void selectWhiteBackground(ActionEvent event) {
		backgroundColour = Color.WHITE;
		colourBack = new BackgroundFill(backgroundColour, CornerRadii.EMPTY, Insets.EMPTY);
		background = new Background(colourBack);
		pane.setBackground(background);

	}

	/**
	 * Auto-generated method t help initalize the FXML?
	 */
	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		canvas.widthProperty().bind(pane.widthProperty());
		canvas.heightProperty().bind(pane.heightProperty());
		assert topVBox != null : "fx:id=\"topVBox\" was not injected: check your FXML file 'GUI.fxml'.";
		assert exitMenuItem != null : "fx:id=\"exitMenuItem\" was not injected: check your FXML file 'GUI.fxml'.";
		assert buildModifyRailway != null : "fx:id=\"buildModifyRailway\" was not injected: check your FXML file 'GUI.fxml'.";
		assert railwayHelpMenuItem != null : "fx:id=\"railwayHelpMenuItem\" was not injected: check your FXML file 'GUI.fxml'.";
		assert railwayWebsiteMenuItem != null : "fx:id=\"railwayWebsiteMenuItem\" was not injected: check your FXML file 'GUI.fxml'.";
		assert aboutMenuItem != null : "fx:id=\"aboutMenuItem\" was not injected: check your FXML file 'GUI.fxml'.";
		assert showHideGridButton != null : "fx:id=\"showHideGridButton\" was not injected: check your FXML file 'GUI.fxml'.";
		assert canvas != null : "fx:id=\"railMap\" was not injected: check your FXML file 'GUI.fxml'.";
	}

	/**
	 * 
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

	}
}