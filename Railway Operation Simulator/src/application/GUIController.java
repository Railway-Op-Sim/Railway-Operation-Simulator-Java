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
				ErrorBox.makeNoItemSelectedErrorBox();
				break;

			case STRAIGHTH:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case STRAIGHTV:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case STRAIGHTRIGHTUP:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case STRAIGHTLEFTUP:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case BUFFERLEFT:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case BUFFERRIGHT:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case BUFFERUP:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case BUFFERDOWN:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case BUFFERLEFTUP:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case BUFFERRIGHTUP:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case BUFFERLEFTDOWN:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case BUFFERRIGHTDOWN:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case LINKLEFT:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case LINKRIGHT:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case LINKUP:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case LINKDOWN:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case LINKLEFTUP:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case LINKRIGHTUP:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case LINKLEFTDOWN:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case LINKRIGHTDOWN:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case DIRECTLEFT:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case DIRECTRIGHT:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case DIRECTUP:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case DIRECTDOWN:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case DIRECTLEFTUP:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case DIRECTRIGHTUP:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case DIRECTLEFTDOWN:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case DIRECTRIGHTDOWN:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case EXITLEFT:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case EXITRIGHT:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case EXITUP:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case EXITDOWN:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case EXITLEFTUP:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case EXITRIGHTUP:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case EXITLEFTDOWN:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case EXITRIGHTDOWN:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case TIGHTCURVE1:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case TIGHTCURVE2:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case TIGHTCURVE3:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case TIGHTCURVE4:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case CURVE1:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case CURVE2:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case CURVE3:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case CURVE4:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case CURVE5:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case CURVE6:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case CURVE7:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case CURVE8:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case BRIDGE1:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case BRIDGE2:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case UNDERPASS1:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case UNDERPASS2:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCHTIGHT1:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCHTIGHT2:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCHTIGHT3:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCHTIGHT4:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCHTIGHT5:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCHTIGHT6:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCHTIGHT7:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCHTIGHT8:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH1:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH2:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH3:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH4:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH5:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH6:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH7:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH8:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH9:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH10:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH11:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH12:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH13:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH14:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH15:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH16:
				MenuActions.addTrack(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SIGNALLEFT:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addTrack(event, canvas, itemSelected, aspect, backgroundColour);
				} else {
					MenuActions.addTrack(event, canvas, itemSelected, aspect, backgroundColour);
				}

				break;

			case SIGNALRIGHT:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addTrack(event, canvas, itemSelected, aspect, backgroundColour);
				} else {
					MenuActions.addTrack(event, canvas, itemSelected, aspect, backgroundColour);
				}
				break;

			case SIGNALUP:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addTrack(event, canvas, itemSelected, aspect, backgroundColour);
				} else {
					MenuActions.addTrack(event, canvas, itemSelected, aspect, backgroundColour);
				}
				break;

			case SIGNALDOWN:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addTrack(event, canvas, itemSelected, aspect, backgroundColour);
				} else {
					MenuActions.addTrack(event, canvas, itemSelected, aspect, backgroundColour);
				}
				break;

			case SIGNALLEFTUP:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addTrack(event, canvas, itemSelected, aspect, backgroundColour);
				} else {
					MenuActions.addTrack(event, canvas, itemSelected, aspect, backgroundColour);
				}

				break;

			case SIGNALRIGHTUP:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addTrack(event, canvas, itemSelected, aspect, backgroundColour);
				} else {
					MenuActions.addTrack(event, canvas, itemSelected, aspect, backgroundColour);
				}
				break;

			case SIGNALLEFTDOWN:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addTrack(event, canvas, itemSelected, aspect, backgroundColour);
				} else {
					MenuActions.addTrack(event, canvas, itemSelected, aspect, backgroundColour);
				}

				break;

			case SIGNALRIGHTDOWN:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addTrack(event, canvas, itemSelected, aspect, backgroundColour);
				} else {
					MenuActions.addTrack(event, canvas, itemSelected, aspect, backgroundColour);
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
		MenuActions.toggleGrid(canvas, showHideGridButton, backgroundColour);
	}

	@FXML
	void selectBlackBackground(ActionEvent event) {
		setBackgroundColour(Color.BLACK);
		colourBack = new BackgroundFill(backgroundColour, CornerRadii.EMPTY, Insets.EMPTY);
		background = new Background(colourBack);
		pane.setBackground(background);
		MenuActions.redrawEverything(canvas, backgroundColour);
		if (showHideGridButton.getText().equals("Hide Grid")) {
			MenuActions.createGrid(canvas, backgroundColour);
		}

	}

	@FXML
	void selectBlueBackground(ActionEvent event) {
		setBackgroundColour(Color.DARKBLUE);
		colourBack = new BackgroundFill(backgroundColour, CornerRadii.EMPTY, Insets.EMPTY);
		background = new Background(colourBack);
		pane.setBackground(background);
		MenuActions.redrawEverything(canvas, backgroundColour);
		if (showHideGridButton.getText().equals("Hide Grid")) {
			MenuActions.createGrid(canvas, backgroundColour);
		}
	}

	@FXML
	void selectWhiteBackground(ActionEvent event) {
		setBackgroundColour(Color.WHITE);
		colourBack = new BackgroundFill(backgroundColour, CornerRadii.EMPTY, Insets.EMPTY);
		background = new Background(colourBack);
		pane.setBackground(background);
		MenuActions.redrawEverything(canvas, backgroundColour);
		if (showHideGridButton.getText().equals("Hide Grid")) {
			MenuActions.createGrid(canvas, backgroundColour);
		}
	}
	
	public Color getBackgroundColour() {
		return backgroundColour;
	}

	public void setBackgroundColour(Color backgroundColour) {
		if (backgroundColour.equals(Color.BLACK)) {
			blackBackgroundMenuItem.setDisable(true);
			whiteBackgroundMenuItem.setDisable(false);
			blueBackgroundMenuItem.setDisable(false);
		} else if (backgroundColour.equals(Color.WHITE)) {
			blackBackgroundMenuItem.setDisable(false);
			whiteBackgroundMenuItem.setDisable(true);
			blueBackgroundMenuItem.setDisable(false);
		} else {
			blackBackgroundMenuItem.setDisable(false);
			whiteBackgroundMenuItem.setDisable(false);
			blueBackgroundMenuItem.setDisable(true);
		}
		this.backgroundColour = backgroundColour;
	}
		

	/**
	 * Auto-generated method t help initalize the FXML?
	 */
	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		canvas.widthProperty().bind(pane.widthProperty());
		canvas.heightProperty().bind(pane.heightProperty());
		setBackgroundColour(Color.BLACK);
		colourBack = new BackgroundFill(backgroundColour, CornerRadii.EMPTY, Insets.EMPTY);
		background = new Background(colourBack);
		pane.setBackground(background);
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