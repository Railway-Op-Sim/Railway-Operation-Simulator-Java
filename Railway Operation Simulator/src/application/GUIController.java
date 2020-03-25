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
import elements.ElementType;

/**
 * GUIController.java The class that interacts with the GUI.fxml to output to
 * screen. Behaviours and Actions are specified here.
 * 
 * @version 1.01
 * @author Jonathan K
 */

public class GUIController extends Application {

	private static ElementType itemSelected = ElementType.NONE;

	public static ElementType getItemSelected() {
		return itemSelected;
	}

	public static void setItemSelected(ElementType itemSelected) {
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
	
	Boolean buildModifyMenuOn = false;

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
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case STRAIGHTV:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case STRAIGHTRIGHTUP:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case STRAIGHTLEFTUP:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case BUFFERLEFT:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case BUFFERRIGHT:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case BUFFERUP:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case BUFFERDOWN:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case BUFFERLEFTUP:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case BUFFERRIGHTUP:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case BUFFERLEFTDOWN:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case BUFFERRIGHTDOWN:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case LINKLEFT:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case LINKRIGHT:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case LINKUP:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case LINKDOWN:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case LINKLEFTUP:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case LINKRIGHTUP:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case LINKLEFTDOWN:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case LINKRIGHTDOWN:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case DIRECTLEFT:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case DIRECTRIGHT:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case DIRECTUP:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case DIRECTDOWN:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case DIRECTLEFTUP:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case DIRECTRIGHTUP:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case DIRECTLEFTDOWN:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case DIRECTRIGHTDOWN:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case EXITLEFT:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case EXITRIGHT:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case EXITUP:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case EXITDOWN:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case EXITLEFTUP:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case EXITRIGHTUP:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case EXITLEFTDOWN:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case EXITRIGHTDOWN:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case TIGHTCURVE1:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case TIGHTCURVE2:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case TIGHTCURVE3:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case TIGHTCURVE4:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case CURVE1:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case CURVE2:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case CURVE3:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case CURVE4:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case CURVE5:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case CURVE6:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case CURVE7:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case CURVE8:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case BRIDGE1:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case BRIDGE2:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case UNDERPASS1:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case UNDERPASS2:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCHTIGHT1:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCHTIGHT2:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCHTIGHT3:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCHTIGHT4:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCHTIGHT5:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCHTIGHT6:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCHTIGHT7:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCHTIGHT8:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH1:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH2:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH3:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH4:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH5:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH6:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH7:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH8:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH9:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH10:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH11:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH12:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH13:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH14:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH15:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH16:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;
				
			case SWITCH17:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH18:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH19:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;
				
			case SWITCH20:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;
				
			case SWITCH21:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH22:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH23:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case SWITCH24:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;
				
			case CROSSOVER1:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case CROSSOVER2:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case CROSSOVER3:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case CROSSOVER4:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case CROSSOVER5:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case CROSSOVER6:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;
				
			case FLYOVER1:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case FLYOVER2:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case FLYOVER3:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case FLYOVER4:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;
				
			case FLYOVER5:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case FLYOVER6:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case FLYOVER7:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case FLYOVER8:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;
				
			case FLYOVER9:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case FLYOVER10:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case FLYOVER11:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case FLYOVER12:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;
				
			case NAMEDAREA:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;

			case CONCOURSE:
				MenuActions.addElement(event, canvas, itemSelected, null, backgroundColour);
				break;
				
			case SIGNALLEFT:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addElement(event, canvas, itemSelected, aspect, backgroundColour);
				} else {
					MenuActions.addElement(event, canvas, itemSelected, aspect, backgroundColour);
				}

				break;

			case SIGNALRIGHT:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addElement(event, canvas, itemSelected, aspect, backgroundColour);
				} else {
					MenuActions.addElement(event, canvas, itemSelected, aspect, backgroundColour);
				}
				break;

			case SIGNALUP:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addElement(event, canvas, itemSelected, aspect, backgroundColour);
				} else {
					MenuActions.addElement(event, canvas, itemSelected, aspect, backgroundColour);
				}
				break;

			case SIGNALDOWN:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addElement(event, canvas, itemSelected, aspect, backgroundColour);
				} else {
					MenuActions.addElement(event, canvas, itemSelected, aspect, backgroundColour);
				}
				break;

			case SIGNALLEFTUP:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addElement(event, canvas, itemSelected, aspect, backgroundColour);
				} else {
					MenuActions.addElement(event, canvas, itemSelected, aspect, backgroundColour);
				}

				break;

			case SIGNALRIGHTUP:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addElement(event, canvas, itemSelected, aspect, backgroundColour);
				} else {
					MenuActions.addElement(event, canvas, itemSelected, aspect, backgroundColour);
				}
				break;

			case SIGNALLEFTDOWN:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addElement(event, canvas, itemSelected, aspect, backgroundColour);
				} else {
					MenuActions.addElement(event, canvas, itemSelected, aspect, backgroundColour);
				}

				break;

			case SIGNALRIGHTDOWN:
				if (aspect == SignalAspect.SHUNT) {
					MenuActions.addElement(event, canvas, itemSelected, aspect, backgroundColour);
				} else {
					MenuActions.addElement(event, canvas, itemSelected, aspect, backgroundColour);
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
		if (buildModifyMenuOn==false) {
			try {
				VBox buildMenu = FXMLLoader.load(getClass().getResource("BuildModifyMenu.fxml"));
				topVBox.getChildren().add(buildMenu);
				buildModifyMenuOn = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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