package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;

import elements.BufferedTrack;
import elements.Concourse;
import elements.Crossover;
import elements.CurvedTrack;
import elements.Direction;
import elements.DirectionalTrack;
import elements.Element;
import elements.ExitTrack;
import elements.Flyover;
import elements.GapLinkedTrack;
import elements.NamedArea;
import elements.SignalAspect;
import elements.SignalTrack;
import elements.StationBridgeUnderpassTrack;
import elements.StraightTrack;
import elements.SwitchTrack;
import elements.Track;
import elements.ElementType;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

public class MenuActions {

	private static final int GRID_SIZE = 16;
	private static final double INVERT_NUM = 0.85;

	/**
	 * Constructor that makes a MenuActions object. Probably won't be used.
	 */
	public MenuActions() {

	}

	/**
	 * A method to exit the Program. Used by exit button in top left menu.
	 */
	public static void exitProgram() {
		Platform.exit();
	}

	/**
	 * A method to draw the new element on the canvas.
	 * 
	 * @param railMap
	 * @param event
	 */
	public static void drawElement(GraphicsContext railMap, MouseEvent event, Color canvasColour, Element element) {
		// Get Location of mouse click and round to 0
		int xLocation = (int) event.getX();
		int yLocation = (int) event.getY();
		// Get remiander when divided by 16 to see how close it is to the last multiple
		// of 16.
		int slightlyOffX = xLocation % 16;
		int slightLyOffY = yLocation % 16;

		// Get the last multiple of 16 before it.
		int placeX = xLocation - slightlyOffX;
		int placeY = yLocation - slightLyOffY;

		String elementFile = switchTrack(element);
		Image image = null;
		image = new Image(MenuActions.class.getClassLoader().getResource(elementFile).toString()); // Set file as image.
		int size = (int) image.getWidth();

		WritableImage newImage = editImage(image, size, size, canvasColour);
		railMap.drawImage(newImage, placeX, placeY); // Draw the image at that place.
	}

	private static WritableImage editImage(Image oldImage, int width, int height, Color canvasColour) {
		WritableImage newImage = removeWhiteBackground(oldImage, width, height);
		if (canvasColour.equals(Color.BLACK)|| canvasColour.equals(Color.DARKBLUE)) {
			newImage = invertColour(newImage, width, height);
		}
		return newImage;

	}

	private static WritableImage removeWhiteBackground(Image oldImage, int width, int height) {
		WritableImage newImage = new WritableImage(width, height);
		PixelWriter pixelWriter = newImage.getPixelWriter();
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				Color currentColor = oldImage.getPixelReader().getColor(x, y);
				if (currentColor.equals(Color.WHITE)) {
					pixelWriter.setColor(x, y, Color.color(0, 0, 0, 0.0));
				} else {
					pixelWriter.setColor(x, y, currentColor);
				}

			}
		}
		return newImage;
	}

	private static WritableImage invertColour(WritableImage image, int width, int height) {
		WritableImage currentImage = image;
		PixelWriter pixelWriter = currentImage.getPixelWriter();
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				Color currentColor = image.getPixelReader().getColor(x, y);
				if (currentColor.equals(Color.BLACK)) {
					pixelWriter.setColor(x, y, Color.color(INVERT_NUM, INVERT_NUM, INVERT_NUM, 1.0));
				} else {
					pixelWriter.setColor(x, y, currentColor);
				}

			}
		}
		return currentImage;
	}

	/**
	 * A method to change draw or remove the grid. Also changes text of button that
	 * activates this action.
	 * 
	 * @param display
	 * @param showHideGridButton
	 */
	public static void toggleGrid(Canvas display, Button showHideGridButton, Color canvasColour) {
		String showHideGridText = showHideGridButton.getText();
		if (showHideGridText.equals("Show Grid")) {
			createGrid(display, canvasColour);
			showHideGridButton.setText("Hide Grid");
		} else {
			removeGrid(display, canvasColour);
			showHideGridButton.setText("Show Grid");
		}
	}

	/**
	 * A method to draw the grid on the canvas.
	 * 
	 * @param display
	 * @param canvasColour
	 */
	public static void createGrid(Canvas display, Color canvasColour) {
		GraphicsContext railMap = display.getGraphicsContext2D();

		// Get the canvas size
		double railMapSizeX = display.getWidth();
		double railMapSizeY = display.getHeight();

		// Set grid to Black
		if (canvasColour.equals(Color.WHITE)) {
			railMap.setStroke(Color.BLACK);
		} else {
			railMap.setStroke(Color.GREY);
		}
		

		// Every 16 pixels draw a vertical line.
		for (int x = 0; x < railMapSizeX + 1; x += 16) {
			railMap.strokeLine(x, 0, x, railMapSizeY);
		}

		// Every 16 pixels draw a horizontal line.
		for (int y = 0; y < railMapSizeY; y += 16) {
			railMap.strokeLine(0, y, railMapSizeX, y);
		}

	}

	/**
	 * A method to remove the grid drawn on the canvas.
	 * 
	 * @param display
	 */
	private static void removeGrid(Canvas display, Color canvasColour) {

		int railMapSizeX = (int) display.getWidth();
		int railMapSizeY = (int) display.getHeight();

		GraphicsContext railMap = display.getGraphicsContext2D();
		railMap.clearRect(0, 0, railMapSizeX, railMapSizeY);// Clear entire display
		redrawEverything(display, canvasColour);

	}

	public static void redrawEverything(Canvas display, Color canvasColour) {
		Map map = MapManager.sharedMapManager().getMap();
		HashSet<Element> elementStore = map.getElementStore();
		GraphicsContext railMap = display.getGraphicsContext2D();
		// For every track in the list , redraw it.
		for (Element element : elementStore) {
			int xLocation = element.getxLocation();
			int yLocation = element.getyLocation();

			int slightlyOffX = xLocation % 16;
			int slightLyOffY = yLocation % 16;

			int placeX = xLocation - slightlyOffX;
			int placeY = yLocation - slightLyOffY;
			String trackImage = switchTrack(element);

			Image image = new Image(MenuActions.class.getClassLoader().getResource(trackImage).toString());
			int size = (int) image.getWidth();

			WritableImage newImage = editImage(image, size, size, canvasColour);
			 // Set file as image.

			railMap.drawImage(newImage, placeX, placeY);
		}
	}

	public static void deleteTrack(MouseEvent event, Canvas display, Button showHideGridButton) {
		int xLocation = (int) event.getX();
		int yLocation = (int) event.getY();
		int slightlyOffX = xLocation % 16;
		int slightLyOffY = yLocation % 16;
		int placeX = xLocation - slightlyOffX;
		int placeY = yLocation - slightLyOffY;
		GraphicsContext railMap = display.getGraphicsContext2D();
		HashSet<Element> elementStore = MapManager.sharedMapManager().getMap().getElementStore();
		Element item = null;
		for (Element element : elementStore) {
			int existingElementX = element.getxLocation();
			int existingElementY = element.getyLocation();
			if (existingElementX == placeX && existingElementY == placeY) {
				item = element;
				railMap.clearRect(placeX, placeY, GRID_SIZE, GRID_SIZE);
			}
		}
		if (item != null) {
			elementStore.remove(item);
			String showHidGridButtonText = showHideGridButton.getText();
			if (showHidGridButtonText.equals("Hide Grid")) {
				railMap.strokeRect(placeX, placeY, GRID_SIZE, GRID_SIZE);
			}

		} else {
			ErrorBox.makeDeleteTrackErrorBox();
		}

	}

	public static String switchTrack(Element element) {
		String trackImage = null;
		Image image = null;
		SignalTrack newSig = null;
		StationBridgeUnderpassTrack bridgeUnderPassTrack = null;
		ElementType currentElementType = element.getElementType();
		switch (currentElementType) {
		case STRAIGHTH:
			trackImage = new String("graphics/straightH.png"); // Open image file.
			break;

		case STRAIGHTV:
			trackImage = new String("graphics/straightV.png"); // Open image file.
			break;

		case STRAIGHTRIGHTUP:
			trackImage = new String("graphics/straightRightUp.png"); // Open image file.
			break;

		case STRAIGHTLEFTUP:
			trackImage = new String("graphics/straightLeftUp.png"); // Open image file.
			break;

		case BUFFERLEFT:
			trackImage = new String("graphics/bufferLeft.png"); // Open image file.
			break;

		case BUFFERRIGHT:
			trackImage = new String("graphics/bufferRight.png"); // Open image file.
			break;

		case BUFFERUP:
			trackImage = new String("graphics/bufferUp.png"); // Open image file.
			break;

		case BUFFERDOWN:
			trackImage = new String("graphics/bufferDown.png"); // Open image file.
			break;

		case BUFFERLEFTUP:
			trackImage = new String("graphics/bufferLeftUp.png"); // Open image file.
			break;

		case BUFFERRIGHTUP:
			trackImage = new String("graphics/bufferRightUp.png"); // Open image file.
			break;

		case BUFFERLEFTDOWN:
			trackImage = new String("graphics/bufferLeftDown.png"); // Open image file.
			break;

		case BUFFERRIGHTDOWN:
			trackImage = new String("graphics/bufferRightDown.png"); // Open image file.
			break;

		case LINKLEFT:
			trackImage = new String("graphics/linkLeftUnset.png"); // Open image file.
			break;

		case LINKRIGHT:
			trackImage = new String("graphics/linkRightUnset.png"); // Open image file.
			break;

		case LINKUP:
			trackImage = new String("graphics/linkUpUnset.png"); // Open image file.
			break;

		case LINKDOWN:
			trackImage = new String("graphics/linkDownUnset.png"); // Open image file.
			break;

		case LINKLEFTUP:
			trackImage = new String("graphics/linkLeftUpUnset.png"); // Open image file.
			break;

		case LINKRIGHTUP:
			trackImage = new String("graphics/linkRightUpUnset.png"); // Open image file.
			break;

		case LINKLEFTDOWN:
			trackImage = new String("graphics/linkLeftDownUnset.png"); // Open image file.
			break;

		case LINKRIGHTDOWN:
			trackImage = new String("graphics/linkRightDownUnset.png"); // Open image file.
			break;

		case DIRECTLEFT:
			trackImage = new String("graphics/directLeft.png"); // Open image file.
			break;

		case DIRECTRIGHT:
			trackImage = new String("graphics/directRight.png"); // Open image file.
			break;

		case DIRECTUP:
			trackImage = new String("graphics/directUp.png"); // Open image file.
			break;

		case DIRECTDOWN:
			trackImage = new String("graphics/directDown.png"); // Open image file.
			break;

		case DIRECTLEFTUP:
			trackImage = new String("graphics/directLeftUp.png"); // Open image file.
			break;

		case DIRECTRIGHTUP:
			trackImage = new String("graphics/directRightUp.png"); // Open image file.
			break;

		case DIRECTLEFTDOWN:
			trackImage = new String("graphics/directLeftDown.png"); // Open image file.
			break;

		case DIRECTRIGHTDOWN:
			trackImage = new String("graphics/directRightDown.png"); // Open image file.
			break;

		case EXITLEFT:
			trackImage = new String("graphics/exitLeftTrack.png"); // Open image file.
			break;

		case EXITRIGHT:
			trackImage = new String("graphics/exitRightTrack.png"); // Open image file.
			break;

		case EXITUP:
			trackImage = new String("graphics/exitUpTrack.png"); // Open image file.
			break;

		case EXITDOWN:
			trackImage = new String("graphics/exitDownTrack.png"); // Open image file.
			break;

		case EXITLEFTUP:
			trackImage = new String("graphics/exitLeftUpTrack.png"); // Open image file.
			break;

		case EXITRIGHTUP:
			trackImage = new String("graphics/exitRightUpTrack.png"); // Open image file.
			break;

		case EXITLEFTDOWN:
			trackImage = new String("graphics/exitLeftDownTrack.png"); // Open image file.
			break;

		case EXITRIGHTDOWN:
			trackImage = new String("graphics/exitRightDownTrack.png"); // Open image file.
			break;

		case TIGHTCURVE1:
			trackImage = new String("graphics/tightCurve1.png"); // Open image file.
			break;

		case TIGHTCURVE2:
			trackImage = new String("graphics/tightCurve2.png"); // Open image file.
			break;

		case TIGHTCURVE3:
			trackImage = new String("graphics/tightCurve3.png"); // Open image file.
			break;

		case TIGHTCURVE4:
			trackImage = new String("graphics/tightCurve4.png"); // Open image file.
			break;

		case CURVE1:
			trackImage = new String("graphics/curve1.png"); // Open image file.
			break;

		case CURVE2:
			trackImage = new String("graphics/curve2.png"); // Open image file.
			break;

		case CURVE3:
			trackImage = new String("graphics/curve3.png"); // Open image file.
			break;

		case CURVE4:
			trackImage = new String("graphics/curve4.png"); // Open image file.
			break;

		case CURVE5:
			trackImage = new String("graphics/curve5.png"); // Open image file.
			break;

		case CURVE6:
			trackImage = new String("graphics/curve6.png"); // Open image file.
			break;

		case CURVE7:
			trackImage = new String("graphics/curve7.png"); // Open image file.
			break;

		case CURVE8:
			trackImage = new String("graphics/curve8.png"); // Open image file.
			break;
			
		case BRIDGE1:
			bridgeUnderPassTrack = (StationBridgeUnderpassTrack) element;
			if (bridgeUnderPassTrack.isStation()) {
				trackImage = new String("graphics/bridgeSet1.png"); // Open image file.
			} else {
				trackImage = new String("graphics/bridgeUnset1.png"); // Open image file.
			}

			break;

		case BRIDGE2:
			bridgeUnderPassTrack = (StationBridgeUnderpassTrack) element;
			if (bridgeUnderPassTrack.isStation()) {
				trackImage = new String("graphics/bridgeSet2.png"); // Open image file.
			} else {
				trackImage = new String("graphics/bridgeUnset2.png"); // Open image file.
			}
			break;

		case UNDERPASS1:
			bridgeUnderPassTrack = (StationBridgeUnderpassTrack) element;
			if (bridgeUnderPassTrack.isStation()) {
				trackImage = new String("graphics/underpassSet1.png"); // Open image file.
			} else {
				trackImage = new String("graphics/underpassUnset1.png"); // Open image file.
			}
			break;

		case UNDERPASS2:
			bridgeUnderPassTrack = (StationBridgeUnderpassTrack) element;
			if (bridgeUnderPassTrack.isStation()) {
				trackImage = new String("graphics/underpassSet1.png"); // Open image file.
			} else {
				trackImage = new String("graphics/underpassUnset1.png"); // Open image file.
			}
			break;

		case SWITCHTIGHT1:
			trackImage = new String("graphics/switchTight1.png"); // Open image file.
			break;

		case SWITCHTIGHT2:
			trackImage = new String("graphics/switchTight2.png"); // Open image file.
			break;

		case SWITCHTIGHT3:
			trackImage = new String("graphics/switchTight3.png"); // Open image file.
			break;

		case SWITCHTIGHT4:
			trackImage = new String("graphics/switchTight4.png"); // Open image file.
			break;

		case SWITCHTIGHT5:
			trackImage = new String("graphics/switchTight5.png"); // Open image file.
			break;

		case SWITCHTIGHT6:
			trackImage = new String("graphics/switchTight6.png"); // Open image file.
			break;

		case SWITCHTIGHT7:
			trackImage = new String("graphics/switchTight7.png"); // Open image file.
			break;

		case SWITCHTIGHT8:
			trackImage = new String("graphics/switchTight8.png"); // Open image file.
			break;

		case SWITCH1:
			trackImage = new String("graphics/switch1.png"); // Open image file.
			break;

		case SWITCH2:
			trackImage = new String("graphics/switch2.png"); // Open image file.
			break;

		case SWITCH3:
			trackImage = new String("graphics/switch3.png"); // Open image file.
			break;

		case SWITCH4:
			trackImage = new String("graphics/switch4.png"); // Open image file.
			break;

		case SWITCH5:
			trackImage = new String("graphics/switch5.png"); // Open image file.
			break;

		case SWITCH6:
			trackImage = new String("graphics/switch6.png"); // Open image file.
			break;

		case SWITCH7:
			trackImage = new String("graphics/switch7.png"); // Open image file.
			break;

		case SWITCH8:
			trackImage = new String("graphics/switch8.png"); // Open image file.
			break;

		case SWITCH9:
			trackImage = new String("graphics/switch9.png"); // Open image file.
			break;

		case SWITCH10:
			trackImage = new String("graphics/switch10.png"); // Open image file.
			break;

		case SWITCH11:
			trackImage = new String("graphics/switch11.png"); // Open image file.
			break;

		case SWITCH12:
			trackImage = new String("graphics/switch12.png"); // Open image file.
			break;

		case SWITCH13:
			trackImage = new String("graphics/switch13.png"); // Open image file.
			break;

		case SWITCH14:
			trackImage = new String("graphics/switch14.png"); // Open image file.
			break;

		case SWITCH15:
			trackImage = new String("graphics/switch15.png"); // Open image file.
			break;

		case SWITCH16:
			trackImage = new String("graphics/switch16.png"); // Open image file.
			break;
			
		case SWITCH17:
			trackImage = new String("graphics/switch17.png"); // Open image file.
			break;

		case SWITCH18:
			trackImage = new String("graphics/switch18.png"); // Open image file.
			break;

		case SWITCH19:
			trackImage = new String("graphics/switch19.png"); // Open image file.
			break;

		case SWITCH20:
			trackImage = new String("graphics/switch20.png"); // Open image file.
			break;

		case SWITCH21:
			trackImage = new String("graphics/switch21.png"); // Open image file.
			break;

		case SWITCH22:
			trackImage = new String("graphics/switch22.png"); // Open image file.
			break;

		case SWITCH23:
			trackImage = new String("graphics/switch23.png"); // Open image file.
			break;

		case SWITCH24:
			trackImage = new String("graphics/switch24.png"); // Open image file.
			break;
			
		case CROSSOVER1:
			trackImage = new String("graphics/crossover1.png"); // Open image file.
			break;

		case CROSSOVER2:
			trackImage = new String("graphics/crossover2.png"); // Open image file.
			break;

		case CROSSOVER3:
			trackImage = new String("graphics/crossover3.png"); // Open image file.
			break;

		case CROSSOVER4:
			trackImage = new String("graphics/crossover4.png"); // Open image file.
			break;

		case CROSSOVER5:
			trackImage = new String("graphics/crossover5.png"); // Open image file.
			break;

		case CROSSOVER6:
			trackImage = new String("graphics/crossover6.png"); // Open image file.
			break;
			
		case FLYOVER1:
			trackImage = new String("graphics/flyover1.png"); // Open image file.
			break;

		case FLYOVER2:
			trackImage = new String("graphics/flyover2.png"); // Open image file.
			break;

		case FLYOVER3:
			trackImage = new String("graphics/flyover3.png"); // Open image file.
			break;

		case FLYOVER4:
			trackImage = new String("graphics/flyover4.png"); // Open image file.
			break;
		
		case FLYOVER5:
			trackImage = new String("graphics/flyover5.png"); // Open image file.
			break;

		case FLYOVER6:
			trackImage = new String("graphics/flyover6.png"); // Open image file.
			break;

		case FLYOVER7:
			trackImage = new String("graphics/flyover7.png"); // Open image file.
			break;

		case FLYOVER8:
			trackImage = new String("graphics/flyover8.png"); // Open image file.
			break;
			
		case FLYOVER9:
			trackImage = new String("graphics/flyover9.png"); // Open image file.
			break;

		case FLYOVER10:
			trackImage = new String("graphics/flyover10.png"); // Open image file.
			break;

		case FLYOVER11:
			trackImage = new String("graphics/flyover11.png"); // Open image file.
			break;

		case FLYOVER12:
			trackImage = new String("graphics/flyover12.png"); // Open image file.
			break;
			
		case NAMEDAREA:
			trackImage = new String("graphics/locationUnset.png"); // Open image file.
			break;

		case CONCOURSE:
			trackImage = new String("graphics/concourseUnset.png"); // Open image file.
			break;
		

		case SIGNALLEFT:
			newSig = (SignalTrack) element;
			if (newSig.getAspect() == SignalAspect.SHUNT) {
				trackImage = new String("graphics/shuntLeftRed.png");
			} else {
				trackImage = new String("graphics/signalLeft.png");
			}
			break;

		case SIGNALRIGHT:
			newSig = (SignalTrack) element;
			if (newSig.getAspect() == SignalAspect.SHUNT) {
				trackImage = new String("graphics/shuntRightRed.png");
			} else {
				trackImage = new String("graphics/signalRight.png"); // Open image file.
			}
			break;

		case SIGNALUP:
			newSig = (SignalTrack) element;
			if (newSig.getAspect() == SignalAspect.SHUNT) {
				trackImage = new String("graphics/shuntUpRed.png");
			} else {
				trackImage = new String("graphics/signalUp.png"); // Open image file.
			}
			break;

		case SIGNALDOWN:
			newSig = (SignalTrack) element;
			if (newSig.getAspect() == SignalAspect.SHUNT) {
				trackImage = new String("graphics/shuntDownRed.png");
			} else {
				trackImage = new String("graphics/signalDown.png"); // Open image file.
			}
			break;

		case SIGNALLEFTUP:
			newSig = (SignalTrack) element;
			if (newSig.getAspect() == SignalAspect.SHUNT) {
				trackImage = new String("graphics/shuntLeftUpRed.png");
			} else {
				trackImage = new String("graphics/signalLeftUp.png");
			}
			break;

		case SIGNALRIGHTUP:
			newSig = (SignalTrack) element;
			if (newSig.getAspect() == SignalAspect.SHUNT) {
				trackImage = new String("graphics/shuntRightUpRed.png");
			} else {
				trackImage = new String("graphics/signalRightUp.png"); // Open image file.
			}
			break;

		case SIGNALLEFTDOWN:
			newSig = (SignalTrack) element;
			if (newSig.getAspect() == SignalAspect.SHUNT) {
				trackImage = new String("graphics/shuntLeftDownRed.png");
			} else {
				trackImage = new String("graphics/signalLeftDown.png");
			}
			break;

		case SIGNALRIGHTDOWN:
			newSig = (SignalTrack) element;
			if (newSig.getAspect() == SignalAspect.SHUNT) {
				trackImage = new String("graphics/shuntRightDownRed.png");
			} else {
				trackImage = new String("graphics/signalRightDown.png"); // Open image file.
			}
			break;

		default:
			break;

		}
		return trackImage;

	}

	public static void addElement(MouseEvent event, Canvas railMap, ElementType itemSelected, SignalAspect aspect,
			Color canvasColour) {
		boolean elementExist = false;
		int xLocation = (int) event.getX();
		int yLocation = (int) event.getY();
		int slightlyOffX = xLocation % 16;
		int slightLyOffY = yLocation % 16;
		int placeX = xLocation - slightlyOffX;
		int placeY = yLocation - slightLyOffY;
		HashSet<Element> elementStore = MapManager.sharedMapManager().getMap().getElementStore();
		for (Element element : elementStore) {
			int existingElementX = element.getxLocation();
			int existingElementY = element.getyLocation();
			if (existingElementX == placeX && existingElementY == placeY) {
				elementExist = true;
				ErrorBox.makeExistingTrackErrorBox();
			}
		}

		if (!elementExist) {
			Element newElement = null;
			switch (itemSelected) {
			case STRAIGHTH:
				StraightTrack straight1 = new StraightTrack(ElementType.STRAIGHTH, placeX, placeY, false, "None");
				straight1.setLinks();
				newElement = straight1;
				break;

			case STRAIGHTV:
				StraightTrack straight2 = new StraightTrack(ElementType.STRAIGHTV, placeX, placeY, false, "None");
				straight2.setLinks();
				newElement = straight2;

				break;

			case STRAIGHTLEFTUP:
				StraightTrack straight3 = new StraightTrack(ElementType.STRAIGHTLEFTUP, placeX, placeY, false, "None");
				straight3.setLinks();
				newElement = straight3;
				break;

			case STRAIGHTRIGHTUP:
				StraightTrack straight4 = new StraightTrack(ElementType.STRAIGHTRIGHTUP, placeX, placeY, false, "None");
				straight4.setLinks();
				newElement = straight4;

				break;

			case BUFFERLEFT:
				BufferedTrack leftBuffer = new BufferedTrack(ElementType.BUFFERLEFT, placeX, placeY, false, "None");
				leftBuffer.setLinks();
				newElement = leftBuffer;
				break;

			case BUFFERRIGHT:
				BufferedTrack rightBuffer = new BufferedTrack(ElementType.BUFFERRIGHT, placeX, placeY, false, "None");
				rightBuffer.setLinks();
				newElement = rightBuffer;
				break;

			case BUFFERUP:
				BufferedTrack topBuffer = new BufferedTrack(ElementType.BUFFERUP, placeX, placeY, false, "None");
				topBuffer.setLinks();
				newElement = topBuffer;
				break;

			case BUFFERDOWN:
				BufferedTrack bottomBuffer = new BufferedTrack(ElementType.BUFFERDOWN, placeX, placeY, false, "None");
				bottomBuffer.setLinks();
				newElement = bottomBuffer;
				break;

			case BUFFERLEFTUP:
				BufferedTrack leftUpBuffer = new BufferedTrack(ElementType.BUFFERLEFTUP, placeX, placeY, false, "None");
				leftUpBuffer.setLinks();
				newElement = leftUpBuffer;
				break;

			case BUFFERRIGHTUP:
				BufferedTrack rightUpBuffer = new BufferedTrack(ElementType.BUFFERRIGHTUP, placeX, placeY, false, "None");
				newElement = rightUpBuffer;
				break;

			case BUFFERLEFTDOWN:
				BufferedTrack leftDownBuffer = new BufferedTrack(ElementType.BUFFERLEFTDOWN, placeX, placeY, false,
						"None");
				newElement = leftDownBuffer;
				break;

			case BUFFERRIGHTDOWN:
				BufferedTrack rightDownBuffer = new BufferedTrack(ElementType.BUFFERRIGHTDOWN, placeX, placeY, false,
						"None");
				newElement = rightDownBuffer;
				break;

			case LINKLEFT:
				GapLinkedTrack linkLeft = new GapLinkedTrack(ElementType.LINKLEFT, placeX, placeY, false, "None");
				newElement = linkLeft;
				break;

			case LINKRIGHT:
				GapLinkedTrack linkRight = new GapLinkedTrack(ElementType.LINKRIGHT, placeX, placeY, false, "None");
				newElement = linkRight;
				break;

			case LINKUP:
				GapLinkedTrack linkUp = new GapLinkedTrack(ElementType.LINKUP, placeX, placeY, false, "None");
				newElement = linkUp;
				break;

			case LINKDOWN:
				GapLinkedTrack linkDown = new GapLinkedTrack(ElementType.LINKDOWN, placeX, placeY, false, "None");
				newElement = linkDown;
				break;

			case LINKLEFTUP:
				GapLinkedTrack linkLeftUp = new GapLinkedTrack(ElementType.LINKLEFTUP, placeX, placeY, false, "None");
				newElement = linkLeftUp;
				break;

			case LINKRIGHTUP:
				GapLinkedTrack linkRightUp = new GapLinkedTrack(ElementType.LINKRIGHTUP, placeX, placeY, false, "None");
				newElement = linkRightUp;
				break;

			case LINKLEFTDOWN:
				GapLinkedTrack linkLeftDown = new GapLinkedTrack(ElementType.LINKLEFTDOWN, placeX, placeY, false, "None");
				newElement = linkLeftDown;
				break;

			case LINKRIGHTDOWN:
				GapLinkedTrack linkRightDown = new GapLinkedTrack(ElementType.LINKRIGHTDOWN, placeX, placeY, false,
						"None");
				newElement = linkRightDown;
				break;

			case DIRECTLEFT:
				DirectionalTrack directLeftTrack = new DirectionalTrack(ElementType.DIRECTLEFT, placeX, placeY, false,
						"None", Direction.LEFT);
				newElement = directLeftTrack;
				break;

			case DIRECTRIGHT:
				DirectionalTrack directRightTrack = new DirectionalTrack(ElementType.DIRECTRIGHT, placeX, placeY, false,
						"None", Direction.RIGHT);
				newElement = directRightTrack;
				break;

			case DIRECTUP:
				DirectionalTrack directUpTrack = new DirectionalTrack(ElementType.DIRECTUP, placeX, placeY, false, "None",
						Direction.UP);
				newElement = directUpTrack;
				break;

			case DIRECTDOWN:
				DirectionalTrack directDownTrack = new DirectionalTrack(ElementType.DIRECTDOWN, placeX, placeY, false,
						"None", Direction.DOWN);
				newElement = directDownTrack;
				break;

			case DIRECTLEFTUP:
				DirectionalTrack directLeftUpTrack = new DirectionalTrack(ElementType.DIRECTLEFTUP, placeX, placeY, false,
						"None", Direction.LEFTUP);
				newElement = directLeftUpTrack;
				break;

			case DIRECTRIGHTUP:
				DirectionalTrack directRightUpTrack = new DirectionalTrack(ElementType.DIRECTRIGHTUP, placeX, placeY,
						false, "None", Direction.RIGHTUP);
				newElement = directRightUpTrack;
				break;

			case DIRECTLEFTDOWN:
				DirectionalTrack directLeftDownTrack = new DirectionalTrack(ElementType.DIRECTLEFTDOWN, placeX, placeY,
						false, "None", Direction.LEFTDOWN);
				newElement = directLeftDownTrack;
				break;

			case DIRECTRIGHTDOWN:
				DirectionalTrack directRightDownTrack = new DirectionalTrack(ElementType.DIRECTRIGHT, placeX, placeY,
						false, "None", Direction.RIGHTDOWN);
				newElement = directRightDownTrack;
				break;

			case EXITLEFT:
				ExitTrack exitLeftTrack = new ExitTrack(ElementType.EXITLEFT, placeX, placeY, false, "None");
				newElement = exitLeftTrack;
				break;

			case EXITRIGHT:
				ExitTrack exitRightTrack = new ExitTrack(ElementType.EXITRIGHT, placeX, placeY, false, "None");
				newElement = exitRightTrack;
				break;

			case EXITUP:
				ExitTrack exitUpTrack = new ExitTrack(ElementType.EXITUP, placeX, placeY, false, "None");
				newElement = exitUpTrack;
				break;

			case EXITDOWN:
				ExitTrack exitDownTrack = new ExitTrack(ElementType.EXITDOWN, placeX, placeY, false, "None");
				newElement = exitDownTrack;
				break;

			case EXITLEFTUP:
				ExitTrack exitLeftUpTrack = new ExitTrack(ElementType.EXITLEFTUP, placeX, placeY, false, "None");
				newElement = exitLeftUpTrack;
				break;

			case EXITRIGHTUP:
				ExitTrack exitRightUpTrack = new ExitTrack(ElementType.EXITRIGHTUP, placeX, placeY, false, "None");
				newElement = exitRightUpTrack;
				break;

			case EXITLEFTDOWN:
				ExitTrack exitLeftDownTrack = new ExitTrack(ElementType.EXITLEFTDOWN, placeX, placeY, false, "None");
				newElement = exitLeftDownTrack;
				break;

			case EXITRIGHTDOWN:
				ExitTrack exitRightDownTrack = new ExitTrack(ElementType.EXITRIGHTDOWN, placeX, placeY, false, "None");
				newElement = exitRightDownTrack;
				break;

			case TIGHTCURVE1:
				CurvedTrack tightCurve1 = new CurvedTrack(ElementType.TIGHTCURVE1, placeX, placeY, false, "None");
				newElement = tightCurve1;
				break;

			case TIGHTCURVE2:
				CurvedTrack tightCurve2 = new CurvedTrack(ElementType.TIGHTCURVE2, placeX, placeY, false, "None");
				newElement = tightCurve2;
				break;

			case TIGHTCURVE3:
				CurvedTrack tightCurve3 = new CurvedTrack(ElementType.TIGHTCURVE3, placeX, placeY, false, "None");
				newElement = tightCurve3;
				break;

			case TIGHTCURVE4:
				CurvedTrack tightCurve4 = new CurvedTrack(ElementType.TIGHTCURVE4, placeX, placeY, false, "None");
				newElement = tightCurve4;
				break;

			case CURVE1:
				CurvedTrack curve1 = new CurvedTrack(ElementType.CURVE1, placeX, placeY, false, "None");
				newElement = curve1;
				break;

			case CURVE2:
				CurvedTrack curve2 = new CurvedTrack(ElementType.CURVE2, placeX, placeY, false, "None");
				newElement = curve2;
				break;

			case CURVE3:
				CurvedTrack curve3 = new CurvedTrack(ElementType.CURVE3, placeX, placeY, false, "None");
				newElement = curve3;
				break;

			case CURVE4:
				CurvedTrack curve4 = new CurvedTrack(ElementType.CURVE4, placeX, placeY, false, "None");
				newElement = curve4;
				break;

			case CURVE5:
				CurvedTrack curve5 = new CurvedTrack(ElementType.CURVE5, placeX, placeY, false, "None");
				newElement = curve5;
				break;

			case CURVE6:
				CurvedTrack curve6 = new CurvedTrack(ElementType.CURVE6, placeX, placeY, false, "None");
				newElement = curve6;
				break;

			case CURVE7:
				CurvedTrack curve7 = new CurvedTrack(ElementType.CURVE7, placeX, placeY, false, "None");
				newElement = curve7;
				break;

			case CURVE8:
				CurvedTrack curve8 = new CurvedTrack(ElementType.CURVE8, placeX, placeY, false, "None");
				newElement = curve8;
				break;
				
			case BRIDGE1:
				StationBridgeUnderpassTrack bridge1 = new StationBridgeUnderpassTrack(ElementType.BRIDGE1, placeX, placeY,
						false, "None");
				newElement = bridge1;
				break;

			case BRIDGE2:
				StationBridgeUnderpassTrack bridge2 = new StationBridgeUnderpassTrack(ElementType.BRIDGE2, placeX, placeY,
						false, "None");
				newElement = bridge2;
				break;

			case UNDERPASS1:
				StationBridgeUnderpassTrack underpass1 = new StationBridgeUnderpassTrack(ElementType.UNDERPASS1, placeX,
						placeY, false, "None");
				newElement = underpass1;
				break;

			case UNDERPASS2:
				StationBridgeUnderpassTrack underpass2 = new StationBridgeUnderpassTrack(ElementType.UNDERPASS2, placeX,
						placeY, false, "None");
				newElement = underpass2;
				break;

			case SWITCHTIGHT1:
				SwitchTrack switchTight1 = new SwitchTrack(ElementType.SWITCHTIGHT1, placeX, placeY, false, "None");
				newElement = switchTight1;
				break;

			case SWITCHTIGHT2:
				SwitchTrack switchTight2 = new SwitchTrack(ElementType.SWITCHTIGHT2, placeX, placeY, false, "None");
				newElement = switchTight2;
				break;

			case SWITCHTIGHT3:
				SwitchTrack switchTight3 = new SwitchTrack(ElementType.SWITCHTIGHT3, placeX, placeY, false, "None");
				newElement = switchTight3;
				break;

			case SWITCHTIGHT4:
				SwitchTrack switchTight4 = new SwitchTrack(ElementType.SWITCHTIGHT4, placeX, placeY, false, "None");
				newElement = switchTight4;
				break;

			case SWITCHTIGHT5:
				SwitchTrack switchTight5 = new SwitchTrack(ElementType.SWITCHTIGHT5, placeX, placeY, false, "None");
				newElement = switchTight5;
				break;

			case SWITCHTIGHT6:
				SwitchTrack switchTight6 = new SwitchTrack(ElementType.SWITCHTIGHT6, placeX, placeY, false, "None");
				newElement = switchTight6;
				break;

			case SWITCHTIGHT7:
				SwitchTrack switchTight7 = new SwitchTrack(ElementType.SWITCHTIGHT7, placeX, placeY, false, "None");
				newElement = switchTight7;
				break;

			case SWITCHTIGHT8:
				SwitchTrack switchTight8 = new SwitchTrack(ElementType.SWITCHTIGHT8, placeX, placeY, false, "None");
				newElement = switchTight8;
				break;

			case SWITCH1:
				SwitchTrack switch1 = new SwitchTrack(ElementType.SWITCH1, placeX, placeY, false, "None");
				newElement = switch1;
				break;

			case SWITCH2:
				SwitchTrack switch2 = new SwitchTrack(ElementType.SWITCH2, placeX, placeY, false, "None");
				newElement = switch2;
				break;

			case SWITCH3:
				SwitchTrack switch3 = new SwitchTrack(ElementType.SWITCH3, placeX, placeY, false, "None");
				newElement = switch3;
				break;

			case SWITCH4:
				SwitchTrack switch4 = new SwitchTrack(ElementType.SWITCH4, placeX, placeY, false, "None");
				newElement = switch4;
				break;

			case SWITCH5:
				SwitchTrack switch5 = new SwitchTrack(ElementType.SWITCH5, placeX, placeY, false, "None");
				newElement = switch5;
				break;

			case SWITCH6:
				SwitchTrack switch6 = new SwitchTrack(ElementType.SWITCH6, placeX, placeY, false, "None");
				newElement = switch6;
				break;

			case SWITCH7:
				SwitchTrack switch7 = new SwitchTrack(ElementType.SWITCH7, placeX, placeY, false, "None");
				newElement = switch7;
				break;

			case SWITCH8:
				SwitchTrack switch8 = new SwitchTrack(ElementType.SWITCH8, placeX, placeY, false, "None");
				newElement = switch8;
				break;

			case SWITCH9:
				SwitchTrack switch9 = new SwitchTrack(ElementType.SWITCH9, placeX, placeY, false, "None");
				newElement = switch9;
				break;

			case SWITCH10:
				SwitchTrack switch10 = new SwitchTrack(ElementType.SWITCH10, placeX, placeY, false, "None");
				newElement = switch10;
				break;

			case SWITCH11:
				SwitchTrack switch11 = new SwitchTrack(ElementType.SWITCH11, placeX, placeY, false, "None");
				newElement = switch11;
				break;

			case SWITCH12:
				SwitchTrack switch12 = new SwitchTrack(ElementType.SWITCH12, placeX, placeY, false, "None");
				newElement = switch12;
				break;

			case SWITCH13:
				SwitchTrack switch13 = new SwitchTrack(ElementType.SWITCH13, placeX, placeY, false, "None");
				newElement = switch13;
				break;

			case SWITCH14:
				SwitchTrack switch14 = new SwitchTrack(ElementType.SWITCH14, placeX, placeY, false, "None");
				newElement = switch14;
				break;

			case SWITCH15:
				SwitchTrack switch15 = new SwitchTrack(ElementType.SWITCH15, placeX, placeY, false, "None");
				newElement = switch15;
				break;

			case SWITCH16:
				SwitchTrack switch16 = new SwitchTrack(ElementType.SWITCH16, placeX, placeY, false, "None");
				newElement = switch16;
				break;
				
			case SWITCH17:
				SwitchTrack switch17 = new SwitchTrack(ElementType.SWITCH17, placeX, placeY, false, "None");
				newElement = switch17;
				break;

			case SWITCH18:
				SwitchTrack switch18 = new SwitchTrack(ElementType.SWITCH18, placeX, placeY, false, "None");
				newElement = switch18;
				break;

			case SWITCH19:
				SwitchTrack switch19 = new SwitchTrack(ElementType.SWITCH19, placeX, placeY, false, "None");
				newElement = switch19;
				break;

			case SWITCH20:
				SwitchTrack switch20 = new SwitchTrack(ElementType.SWITCH20, placeX, placeY, false, "None");
				newElement = switch20;
				break;

			case SWITCH21:
				SwitchTrack switch21 = new SwitchTrack(ElementType.SWITCH21, placeX, placeY, false, "None");
				newElement = switch21;
				break;

			case SWITCH22:
				SwitchTrack switch22 = new SwitchTrack(ElementType.SWITCH22, placeX, placeY, false, "None");
				newElement = switch22;
				break;

			case SWITCH23:
				SwitchTrack switch23 = new SwitchTrack(ElementType.SWITCH23, placeX, placeY, false, "None");
				newElement = switch23;
				break;

			case SWITCH24:
				SwitchTrack switch24 = new SwitchTrack(ElementType.SWITCH24, placeX, placeY, false, "None");
				newElement = switch24;
				break;
				
			case CROSSOVER1:
				Crossover crossover1 = new Crossover(ElementType.CROSSOVER1, placeX, placeY, false, "None");
				newElement = crossover1;
				break;

			case CROSSOVER2:
				Crossover crossover2 = new Crossover(ElementType.CROSSOVER2, placeX, placeY, false, "None");
				newElement = crossover2;
				break;

			case CROSSOVER3:
				Crossover crossover3 = new Crossover(ElementType.CROSSOVER3, placeX, placeY, false, "None");
				newElement = crossover3;
				break;

			case CROSSOVER4:
				Crossover crossover4 = new Crossover(ElementType.CROSSOVER4, placeX, placeY, false, "None");
				newElement = crossover4;
				break;

			case CROSSOVER5:
				Crossover crossover5 = new Crossover(ElementType.CROSSOVER5, placeX, placeY, false, "None");
				newElement = crossover5;
				break;

			case CROSSOVER6:
				Crossover crossover6 = new Crossover(ElementType.CROSSOVER6, placeX, placeY, false, "None");
				newElement = crossover6;
				break;
				
			case FLYOVER1:
				Flyover flyover1 = new Flyover(ElementType.FLYOVER1, placeX, placeY, false, "None");
				newElement = flyover1;
				break;

			case FLYOVER2:
				Flyover flyover2 = new Flyover(ElementType.FLYOVER2, placeX, placeY, false, "None");
				newElement = flyover2;
				break;

			case FLYOVER3:
				Flyover flyover3 = new Flyover(ElementType.FLYOVER3, placeX, placeY, false, "None");
				newElement = flyover3;
				break;

			case FLYOVER4:
				Flyover flyover4 = new Flyover(ElementType.FLYOVER4, placeX, placeY, false, "None");
				newElement = flyover4;
				break;	
			
			case FLYOVER5:
				Flyover flyover5 = new Flyover(ElementType.FLYOVER5, placeX, placeY, false, "None");
				newElement = flyover5;
				break;

			case FLYOVER6:
				Flyover flyover6 = new Flyover(ElementType.FLYOVER6, placeX, placeY, false, "None");
				newElement = flyover6;
				break;

			case FLYOVER7:
				Flyover flyover7 = new Flyover(ElementType.FLYOVER7, placeX, placeY, false, "None");
				newElement = flyover7;
				break;

			case FLYOVER8:
				Flyover flyover8 = new Flyover(ElementType.FLYOVER8, placeX, placeY, false, "None");
				newElement = flyover8;
				break;	
			
			case FLYOVER9:
				Flyover flyover9 = new Flyover(ElementType.FLYOVER9, placeX, placeY, false, "None");
				newElement = flyover9;
				break;

			case FLYOVER10:
				Flyover flyover10 = new Flyover(ElementType.FLYOVER10, placeX, placeY, false, "None");
				newElement = flyover10;
				break;

			case FLYOVER11:
				Flyover flyover11 = new Flyover(ElementType.FLYOVER11, placeX, placeY, false, "None");
				newElement = flyover11;
				break;

			case FLYOVER12:
				Flyover flyover12 = new Flyover(ElementType.FLYOVER12, placeX, placeY, false, "None");
				newElement = flyover12;
				break;	
				
			case NAMEDAREA:
				NamedArea namedArea = new NamedArea(ElementType.NAMEDAREA, placeX, placeY);
				newElement = namedArea;
				break;

			case CONCOURSE:
				Concourse concourse = new Concourse(ElementType.CONCOURSE, placeX, placeY);
				newElement = concourse;
				break;

			case SIGNALLEFT:
				newElement = addsSignalTrack(placeX, placeY, itemSelected, aspect);

				break;

			case SIGNALRIGHT:
				newElement = addsSignalTrack(placeX, placeY, itemSelected, aspect);
				break;

			case SIGNALUP:
				newElement = addsSignalTrack(placeX, placeY, itemSelected, aspect);
				break;

			case SIGNALDOWN:
				newElement = addsSignalTrack(placeX, placeY, itemSelected, aspect);
				break;

			case SIGNALLEFTUP:
				newElement = addsSignalTrack(placeX, placeY, itemSelected, aspect);

				break;

			case SIGNALRIGHTUP:
				newElement = addsSignalTrack(placeX, placeY, itemSelected, aspect);
				break;

			case SIGNALLEFTDOWN:
				newElement = addsSignalTrack(placeX, placeY, itemSelected, aspect);

				break;

			case SIGNALRIGHTDOWN:
				newElement = addsSignalTrack(placeX, placeY, itemSelected, aspect);
				break;
			default:
				break;
			}

			elementStore.add(newElement);

			GraphicsContext graphic = railMap.getGraphicsContext2D();
			drawElement(graphic, event, canvasColour, newElement);
		}
		System.out.println(elementStore.size());
	}

	public static Track addsSignalTrack(int placeX, int placeY, ElementType itemSelected, SignalAspect aspect) {
		Track newElement = null;
		;
		switch (aspect) {

		case SHUNT:
			SignalTrack exitLeftTrack = new SignalTrack(itemSelected, placeX, placeY, false, "None", aspect);
			newElement = exitLeftTrack;
			break;

		case TWO:
			SignalTrack exitRightTrack = new SignalTrack(itemSelected, placeX, placeY, false, "None", aspect);
			newElement = exitRightTrack;
			break;

		case THREE:
			SignalTrack exitUpTrack = new SignalTrack(itemSelected, placeX, placeY, false, "None", aspect);
			newElement = exitUpTrack;
			break;

		case FOUR:
			SignalTrack exitDownTrack = new SignalTrack(itemSelected, placeX, placeY, false, "None", aspect);
			newElement = exitDownTrack;
			break;

		}
		return newElement;
	}

}
