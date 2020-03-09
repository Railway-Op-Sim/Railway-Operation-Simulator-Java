package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;

import elements.BufferedTrack;
import elements.CurvedTrack;
import elements.Direction;
import elements.DirectionalTrack;
import elements.ExitTrack;
import elements.GapLinkedTrack;
import elements.SignalAspect;
import elements.SignalTrack;
import elements.StationBridgeUnderpassTrack;
import elements.StraightTrack;
import elements.SwitchTrack;
import elements.Track;
import elements.TrackType;
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
	
	private static int gridSize = 16;

	/**
	 * Constructor that makes a MenuActions object.
	 * Probably won't be used.
	 */
	public MenuActions() {

	}
	/**
	 * A method to exit the Program.
	 * Used by exit button in top left menu.
	 */
	 public static void exitProgram() {
		 Platform.exit();
	 }
	 /**
	  * A method to draw the new element on the canvas.
	  * @param railMap
	  * @param event
	  */
	 public static void drawElement(GraphicsContext railMap, MouseEvent event, String file, Color canvasColour) {
		 //Get Location of mouse click and round to 0
		 int xLocation = (int) event.getX();
		 int yLocation = (int) event.getY(); 
		 // Get remiander when divided by 16 to see how close it is to the last multiple of 16.
		 int slightlyOffX = xLocation %16;
		 int slightLyOffY = yLocation %16;
		 
		 // Get the last multiple of 16 before it.
		 int placeX = xLocation - slightlyOffX;
		 int placeY = yLocation - slightLyOffY;
		 
		 File trackImage = new File(file); //Open image file.
		 Image oldImage = null;
		 oldImage = new Image(MenuActions.class.getClassLoader().getResource(file).toString()); //Set file as image.
		 int width = (int) oldImage.getWidth();
		 int height = (int) oldImage.getHeight();
		 
		 
		 
		 WritableImage newImage = editImage(oldImage, width, height, canvasColour);
		 
		 railMap.drawImage( newImage, placeX, placeY); //Draw the image at that place.
	 }
	 
	 public static WritableImage editImage(Image oldImage, int width, int height, Color canvasColour) {
		 WritableImage newImage = removeWhiteBackground(oldImage, width, height);
		 if (canvasColour.equals(Color.BLACK)) {
			 newImage = invertColour(newImage, width, height);
		 }
		 return newImage;
		 
	 }
	 public static WritableImage removeWhiteBackground(Image oldImage, int width, int height) {
		 WritableImage newImage = new WritableImage( width, height);
		 PixelWriter pixelWriter = newImage.getPixelWriter();
		 for (int y =0; y<height;y++) {
			 for (int x=0;x<width;x++) {
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
	 
	 public static WritableImage invertColour(WritableImage image, int width, int height) {
		 WritableImage currentImage = image;
		 PixelWriter pixelWriter = currentImage.getPixelWriter();
		 for (int y =0; y<height;y++) {
			 for (int x=0;x<width;x++) {
				 Color currentColor = image.getPixelReader().getColor(x, y);
				 if (currentColor.equals(Color.BLACK)) {
					 pixelWriter.setColor(x, y, Color.color(1, 1, 1, 1.0));
				 } else {
					 pixelWriter.setColor(x, y, currentColor);
				 }
				 
			 }
		 }
		return currentImage; 
	 }
	 
	 /**
	  * A method to draw the grid on the canvas.
	  * @param display
	 * @param canvasColour 
	  */
	 public static void createGrid(Canvas display, Color canvasColour) {
		 	GraphicsContext railMap = display.getGraphicsContext2D();
		 	
		 	//Get the canvas size
	        double railMapSizeX = display.getWidth();
	        double railMapSizeY = display.getHeight();
	        
	        //Set grid to Black
	        railMap.setStroke(Color.BLACK);
	        
	        //Every 16 pixels draw a vertical line.
	        for (int x=0; x<railMapSizeX+1; x+=16) {
	        	railMap.strokeLine(x, 0, x, railMapSizeY);
	        }
	        
	      //Every 16 pixels draw a horizontal line.
	        for (int y=0; y<railMapSizeY; y+=16) {
	        	railMap.strokeLine(0, y, railMapSizeX, y);
	        }

	    }
	 /**
	  * A method to change draw or remove the grid.
	  * Also changes text of button that activates this action.
	  * @param display
	  * @param showHideGridButton
	  */
	 public static void toggleGrid(Canvas display, Button showHideGridButton, Color canvasColour ) {
		 String showHideGridText = showHideGridButton.getText();
		 if (showHideGridText.equals("Show Grid")) {
			 createGrid(display, canvasColour);
			 showHideGridButton.setText("Hide Grid");
		 } else {
			 removeGrid(display,canvasColour);
			 showHideGridButton.setText("Show Grid");
		 }
	 }
	 /**
	  * A method to remove the grid drawn on the canvas.
	  * @param display
	  */
	private static void removeGrid(Canvas display, Color canvasColour) {
		
		int railMapSizeX = (int) display.getWidth();
        int railMapSizeY = (int) display.getHeight();

		GraphicsContext railMap = display.getGraphicsContext2D();
		railMap.clearRect(0, 0, railMapSizeX, railMapSizeY);// Clear entire display
		Map map = MapManager.sharedMapManager().getMap();
		HashSet<Track> trackStore = map.getTrackStore();
		
		// For every track in the list , redraw it.
		for (Track track :trackStore) {
			int xLocation = track.getxLocation();
			int yLocation = track.getyLocation();
			 
			int slightlyOffX = xLocation %16;
			int slightLyOffY = yLocation %16;
			 
			int placeX = xLocation - slightlyOffX;
			int placeY = yLocation - slightLyOffY;
			
			String trackImage = null;
			Image image = null;
			SignalTrack newSig = null;
			StationBridgeUnderpassTrack bridgeUnderPassTrack = null;
			TrackType currentTrackType = track.getTrackType();
			switch (currentTrackType) {
			case STRAIGHTH :
				trackImage = new String("graphics/straightH.png"); //Open image file.
				break;
			
			case STRAIGHTV :
				trackImage = new String("graphics/straightV.png"); //Open image file.
				break;
				
			case STRAIGHTRIGHTUP :
				trackImage = new String("graphics/straightRightUp.png"); //Open image file.
				break;
			
			case STRAIGHTLEFTUP :
				trackImage = new String("graphics/straightLeftUp.png"); //Open image file.
				break;
				
			case BUFFERLEFT :
				trackImage = new String("graphics/bufferLeft.png"); //Open image file.
				break;
			
			case BUFFERRIGHT :
				trackImage = new String("graphics/bufferRight.png"); //Open image file.
				break;
			
			case BUFFERUP :
				trackImage = new String("graphics/bufferUp.png"); //Open image file.
				break;
				
			case BUFFERDOWN :
				trackImage = new String("graphics/bufferDown.png"); //Open image file.
				break;
				
			case BUFFERLEFTUP :
				trackImage = new String("graphics/bufferLeftUp.png"); //Open image file.
				break;
			
			case BUFFERRIGHTUP :
				trackImage = new String("graphics/bufferRightUp.png"); //Open image file.
				break;
				
			case BUFFERLEFTDOWN :
				trackImage = new String("graphics/bufferLeftDown.png"); //Open image file.
				break;
			
			case BUFFERRIGHTDOWN :
				trackImage = new String("graphics/bufferRightDown.png"); //Open image file.
				break;
				
			case LINKLEFT :
				trackImage = new String("graphics/linkLeftUnset.png"); //Open image file.
				break;
			
			case LINKRIGHT :
				trackImage = new String("graphics/linkRightUnset.png"); //Open image file.
				break;
			
			case LINKUP :
				trackImage = new String("graphics/linkUpUnset.png"); //Open image file.
				break;
				
			case LINKDOWN :
				trackImage = new String("graphics/linkDownUnset.png"); //Open image file.
				break;
				
			case LINKLEFTUP :
				trackImage = new String("graphics/linkLeftUpUnset.png"); //Open image file.
				break;
				
			case LINKRIGHTUP :
				trackImage = new String("graphics/linkRightUpUnset.png"); //Open image file.
				break;
				
			case LINKLEFTDOWN :
				trackImage = new String("graphics/linkLeftDownUnset.png"); //Open image file.
				break;
				
			case LINKRIGHTDOWN :
				trackImage = new String("graphics/linkRightDownUnset.png"); //Open image file.
				break;
				
			case DIRECTLEFT :
				trackImage = new String("graphics/directLeft.png"); //Open image file.
				break;
				
			case DIRECTRIGHT :
				trackImage = new String("graphics/directRight.png"); //Open image file.
				break;
				
			case DIRECTUP :
				trackImage = new String("graphics/directUp.png"); //Open image file.
				break;
				
			case DIRECTDOWN :
				trackImage = new String("graphics/directDown.png"); //Open image file.
				break;
				
			case DIRECTLEFTUP :
				trackImage = new String("graphics/directLeftUp.png"); //Open image file.
				break;
				
			case DIRECTRIGHTUP :
				trackImage = new String("graphics/directRightUp.png"); //Open image file.
				break;
			
			case DIRECTLEFTDOWN :
				trackImage = new String("graphics/directLeftDown.png"); //Open image file.
				break;
				
			case DIRECTRIGHTDOWN :
				trackImage = new String("graphics/directRightDown.png"); //Open image file.
				break;
				
			case EXITLEFT :
				trackImage = new String("graphics/exitLeftTrack.png"); //Open image file.
				break;
				
			case EXITRIGHT :
				trackImage = new String("graphics/exitRightTrack.png"); //Open image file.
				break;
				
			case EXITUP :
				trackImage = new String("graphics/exitUpTrack.png"); //Open image file.
				break;
				
			case EXITDOWN :
				trackImage = new String("graphics/exitDownTrack.png"); //Open image file.
				break;
				
			case EXITLEFTUP :
				trackImage = new String("graphics/exitLeftUpTrack.png"); //Open image file.
				break;
				
			case EXITRIGHTUP :
				trackImage = new String("graphics/exitRightUpTrack.png"); //Open image file.
				break;
				
			case EXITLEFTDOWN :
				trackImage = new String("graphics/exitLeftDownTrack.png"); //Open image file.
				break;
				
			case EXITRIGHTDOWN :
				trackImage = new String("graphics/exitRightDownTrack.png"); //Open image file.
				break;
			
			case TIGHTCURVE1 :
				trackImage = new String("graphics/tightCurve1.png"); //Open image file.
				break;
				
			case TIGHTCURVE2 :
				trackImage = new String("graphics/tightCurve2.png"); //Open image file.
				break;
				
			case TIGHTCURVE3 :
				trackImage = new String("graphics/tightCurve3.png"); //Open image file.
				break;
				
			case TIGHTCURVE4 :
				trackImage = new String("graphics/tightCurve4.png"); //Open image file.
				break;
				
			case CURVE1 :
				trackImage = new String("graphics/curve1.png"); //Open image file.
				break;
				
			case CURVE2 :
				trackImage = new String("graphics/curve2.png"); //Open image file.
				break;
				
			case CURVE3 :
				trackImage = new String("graphics/curve3.png"); //Open image file.
				break;
				
			case CURVE4 :
				trackImage = new String("graphics/curve4.png"); //Open image file.
				break;
				
			case CURVE5 :
				trackImage = new String("graphics/curve5.png"); //Open image file.
				break;
				
			case CURVE6 :
				trackImage = new String("graphics/curve6.png"); //Open image file.
				break;
				
			case CURVE7 :
				trackImage = new String("graphics/curve7.png"); //Open image file.
				break;
				
			case CURVE8 :
				trackImage = new String("graphics/curve8.png"); //Open image file.
				break;
				
			case SWITCHTIGHT1 :
				trackImage = new String("graphics/switchTight1.png"); //Open image file.
				break;
				
			case SWITCHTIGHT2 :
				trackImage = new String("graphics/switchTight2.png"); //Open image file.
				break;
				
			case SWITCHTIGHT3 :
				trackImage = new String("graphics/switchTight3.png"); //Open image file.
				break;
				
			case SWITCHTIGHT4 :
				trackImage = new String("graphics/switchTight4.png"); //Open image file.
				break;
				
			case SWITCHTIGHT5 :
				trackImage = new String("graphics/switchTight5.png"); //Open image file.
				break;
				
			case SWITCHTIGHT6 :
				trackImage = new String("graphics/switchTight6.png"); //Open image file.
				break;
				
			case SWITCHTIGHT7 :
				trackImage = new String("graphics/switchTight7.png"); //Open image file.
				break;
				
			case SWITCHTIGHT8 :
				trackImage = new String("graphics/switchTight8.png"); //Open image file.
				break;
				
			case SWITCH1 :
				trackImage = new String("graphics/switch1.png"); //Open image file.
				break;
				
			case SWITCH2 :
				trackImage = new String("graphics/switch2.png"); //Open image file.
				break;
				
			case SWITCH3 :
				trackImage = new String("graphics/switch3.png"); //Open image file.
				break;
				
			case SWITCH4 :
				trackImage = new String("graphics/switch4.png"); //Open image file.
				break;
				
			case SWITCH5 :
				trackImage = new String("graphics/switch5.png"); //Open image file.
				break;
				
			case SWITCH6 :
				trackImage = new String("graphics/switch6.png"); //Open image file.
				break;
				
			case SWITCH7 :
				trackImage = new String("graphics/switch7.png"); //Open image file.
				break;
				
			case SWITCH8 :
				trackImage = new String("graphics/switch8.png"); //Open image file.
				break;
				
			case SWITCH9 :
				trackImage = new String("graphics/switch9.png"); //Open image file.
				break;
				
			case SWITCH10 :
				trackImage = new String("graphics/switch10.png"); //Open image file.
				break;
				
			case SWITCH11 :
				trackImage = new String("graphics/switch11.png"); //Open image file.
				break;
				
			case SWITCH12 :
				trackImage = new String("graphics/switch12.png"); //Open image file.
				break;
				
			case SWITCH13 :
				trackImage = new String("graphics/switch13.png"); //Open image file.
				break;
				
			case SWITCH14 :
				trackImage = new String("graphics/switch14.png"); //Open image file.
				break;
				
			case SWITCH15 :
				trackImage = new String("graphics/switch15.png"); //Open image file.
				break;
				
			case SWITCH16 :
				trackImage = new String("graphics/switch16.png"); //Open image file.
				break;
				
				
			case BRIDGE1 :
				bridgeUnderPassTrack = (StationBridgeUnderpassTrack) track;
				if (bridgeUnderPassTrack.isStation()) {
					trackImage = new String("graphics/bridgeSet1.png"); //Open image file.
				} else {
					trackImage = new String("graphics/bridgeUnset1.png"); //Open image file.
				}
				
				break;
				
			case BRIDGE2 :
				bridgeUnderPassTrack = (StationBridgeUnderpassTrack) track;
				if (bridgeUnderPassTrack.isStation()) {
					trackImage = new String("graphics/bridgeSet2.png"); //Open image file.
				} else {
					trackImage = new String("graphics/bridgeUnset2.png"); //Open image file.
				}
				break;
				
			case UNDERPASS1 :
				bridgeUnderPassTrack = (StationBridgeUnderpassTrack) track;
				if (bridgeUnderPassTrack.isStation()) {
					trackImage = new String("graphics/underpassSet1.png"); //Open image file.
				} else {
					trackImage = new String("graphics/underpassUnset1.png"); //Open image file.
				}
				break;
				
			case UNDERPASS2 :
				bridgeUnderPassTrack = (StationBridgeUnderpassTrack) track;
				if (bridgeUnderPassTrack.isStation()) {
					trackImage = new String("graphics/underpassSet1.png"); //Open image file.
				} else {
					trackImage = new String("graphics/underpassUnset1.png"); //Open image file.
				}
				break;
				
			case SIGNALLEFT :
				newSig = (SignalTrack) track;
				if (newSig.getAspect() == SignalAspect.SHUNT) {
					trackImage = new String("graphics/shuntLeftRed.png");
				} else {
					trackImage = new String("graphics/signalLeft.png");
				}
				break;
				
			case SIGNALRIGHT :
				newSig = (SignalTrack) track;
				if (newSig.getAspect() == SignalAspect.SHUNT) {
					trackImage = new String("graphics/shuntRightRed.png");
				} else {
					trackImage = new String("graphics/signalRight.png"); //Open image file.
				}
				break;
				
			case SIGNALUP :
				newSig = (SignalTrack) track;
				if (newSig.getAspect() == SignalAspect.SHUNT) {
					trackImage = new String("graphics/shuntUpRed.png");
				} else {
					trackImage = new String("graphics/signalUp.png"); //Open image file.
				}
				break;
				
			case SIGNALDOWN :
				newSig = (SignalTrack) track;
				if (newSig.getAspect() == SignalAspect.SHUNT) {
					trackImage = new String("graphics/shuntDownRed.png");
				} else {
					trackImage = new String("graphics/signalDown.png"); //Open image file.
				}
				break;
				
			case SIGNALLEFTUP :
				newSig = (SignalTrack) track;
				if (newSig.getAspect() == SignalAspect.SHUNT) {
					trackImage = new String("graphics/shuntLeftUpRed.png");
				} else {
					trackImage = new String("graphics/signalLeftUp.png");
				}
				break;
				
			case SIGNALRIGHTUP :
				newSig = (SignalTrack) track;
				if (newSig.getAspect() == SignalAspect.SHUNT) {
					trackImage = new String("graphics/shuntRightUpRed.png");
				} else {
					trackImage = new String("graphics/signalRightUp.png"); //Open image file.
				}
				break;
				
			case SIGNALLEFTDOWN :
				newSig = (SignalTrack) track;
				if (newSig.getAspect() == SignalAspect.SHUNT) {
					trackImage = new String("graphics/shuntLeftDownRed.png");
				} else {
					trackImage = new String("graphics/signalLeftDown.png");
				}
				break;
				
			case SIGNALRIGHTDOWN :
				newSig = (SignalTrack) track;
				if (newSig.getAspect() == SignalAspect.SHUNT) {
					trackImage = new String("graphics/shuntRightDownRed.png");
				} else {
					trackImage = new String("graphics/signalRightDown.png"); //Open image file.
				}
				break;
				
			
			default:
				break;
				
			}
				image = new Image(MenuActions.class.getClassLoader().getResource(trackImage).toString());; //Set file as image.
			
			railMap.drawImage(image, placeX, placeY);
		}
		
	}
	
	public static void makeExistingTrackErrorBox() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Existing Track error");
		alert.setContentText("Cannot place track there as a track already exists there!");

		alert.showAndWait();
	}
	
	public static void makeNoItemSelectedErrorBox() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("No Item selected error");
		alert.setContentText("Cannot place anything as nothing selected!");

		alert.showAndWait();
	}
	
	public static void makeDeleteTrackErrorBox() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("No track found error");
		alert.setContentText("Cannot delete as no trackis there!");

		alert.showAndWait();
	}
	
	public static void deleteTrack (MouseEvent event,Canvas display, Button showHideGridButton)  {
    	int xLocation = (int) event.getX();
		int yLocation = (int) event.getY();
		int slightlyOffX = xLocation %16;
		int slightLyOffY = yLocation %16;
		int placeX = xLocation - slightlyOffX;
		int placeY = yLocation - slightLyOffY;
		GraphicsContext railMap = display.getGraphicsContext2D();
		HashSet<Track> trackStore = MapManager.sharedMapManager().getMap().getTrackStore();
		Track item = null;
		for (Track track : trackStore) {
			 int existingTrackX = track.getxLocation();
			 int existingTrackY = track.getyLocation();
			 if (existingTrackX ==placeX && existingTrackY == placeY) {
				 item = track;
				 railMap.clearRect(placeX, placeY, gridSize, gridSize);
				} 
			}
		if (item !=null) {
			trackStore.remove(item);
			String showHidGridButtonText = showHideGridButton.getText();
			if (showHidGridButtonText.equals("Hide Grid")){
				railMap.strokeRect(placeX, placeY, gridSize, gridSize);
			}
			
		} else {
			makeDeleteTrackErrorBox();
		}
		
	}
	
	
	public static void addTrack(MouseEvent event,Canvas railMap, String file, TrackType itemSelected, SignalAspect aspect, Color canvasColour ) {
		boolean trackExist = false;
    	int xLocation = (int) event.getX();
		int yLocation = (int) event.getY();
		int slightlyOffX = xLocation %16;
		int slightLyOffY = yLocation %16;
		int placeX = xLocation - slightlyOffX;
		int placeY = yLocation - slightLyOffY;
		HashSet<Track> trackStore = MapManager.sharedMapManager().getMap().getTrackStore();
		for (Track track : trackStore) {
			 int existingTrackX = track.getxLocation();
			 int existingTrackY = track.getyLocation();
			 if (existingTrackX ==placeX && existingTrackY == placeY) {
				 trackExist = true;
				 MenuActions.makeExistingTrackErrorBox();
			} 
		}
		
		
		if (!trackExist) {
			Track newTrack = null;
			switch(itemSelected) {
			case STRAIGHTH: 
				StraightTrack straight1 = new StraightTrack( TrackType.STRAIGHTH, placeX, placeY, false, "None");
				straight1.setLinks();
				newTrack = straight1;
				break;
			
			case STRAIGHTV: 
				StraightTrack straight2 = new StraightTrack( TrackType.STRAIGHTV, placeX, placeY, false, "None");
				straight2.setLinks();
				newTrack = straight2;
				
				break;
				
			case STRAIGHTLEFTUP: 
				StraightTrack straight3 = new StraightTrack( TrackType.STRAIGHTLEFTUP, placeX, placeY, false, "None");
				straight3.setLinks();
				newTrack = straight3;
				break;
			
			case STRAIGHTRIGHTUP: 
				StraightTrack straight4 = new StraightTrack( TrackType.STRAIGHTRIGHTUP, placeX, placeY, false, "None");
				straight4.setLinks();
				newTrack = straight4;
				
				break;
			
			case BUFFERLEFT: 
				BufferedTrack leftBuffer = new BufferedTrack(TrackType.BUFFERLEFT, placeX, placeY, false, "None");
				leftBuffer.setLinks();
				newTrack = leftBuffer;
				break;
			
			case BUFFERRIGHT: 
				BufferedTrack rightBuffer = new BufferedTrack(TrackType.BUFFERRIGHT, placeX, placeY, false, "None");
				rightBuffer.setLinks();
				newTrack = rightBuffer;
				break;
				
			case BUFFERUP: 
				BufferedTrack topBuffer = new BufferedTrack(TrackType.BUFFERUP, placeX, placeY, false, "None");
				topBuffer.setLinks();
				newTrack = topBuffer;
				break;
				
			case BUFFERDOWN: 
				BufferedTrack bottomBuffer = new BufferedTrack(TrackType.BUFFERDOWN, placeX, placeY, false, "None");
				bottomBuffer.setLinks();
				newTrack = bottomBuffer;
				break;
				
			case BUFFERLEFTUP: 
				BufferedTrack leftUpBuffer = new BufferedTrack(TrackType.BUFFERLEFTUP, placeX, placeY, false, "None");
				leftUpBuffer.setLinks();
				newTrack = leftUpBuffer;
				break;
			
			case BUFFERRIGHTUP: 
				BufferedTrack rightUpBuffer = new BufferedTrack(TrackType.BUFFERRIGHTUP, placeX, placeY, false, "None");
				newTrack = rightUpBuffer;
				break;
				
			case BUFFERLEFTDOWN: 
				BufferedTrack leftDownBuffer = new BufferedTrack(TrackType.BUFFERLEFTDOWN, placeX, placeY, false, "None");
				newTrack = leftDownBuffer;
				break;
			
			case BUFFERRIGHTDOWN: 
				BufferedTrack rightDownBuffer = new BufferedTrack(TrackType.BUFFERRIGHTDOWN, placeX, placeY, false, "None");
				newTrack = rightDownBuffer;
				break;
				
			case LINKLEFT: 
				GapLinkedTrack linkLeft = new GapLinkedTrack(TrackType.LINKLEFT, placeX, placeY, false, "None");
				newTrack = linkLeft;
				break;
				
			case LINKRIGHT: 
				GapLinkedTrack linkRight = new GapLinkedTrack(TrackType.LINKRIGHT, placeX, placeY, false, "None");
				newTrack = linkRight;
				break;
				
			case LINKUP: 
				GapLinkedTrack linkUp = new GapLinkedTrack(TrackType.LINKUP, placeX, placeY, false, "None");
				newTrack = linkUp;
				break;
				
			case LINKDOWN: 
				GapLinkedTrack linkDown = new GapLinkedTrack(TrackType.LINKDOWN, placeX, placeY, false, "None");
				newTrack = linkDown;
				break;
			
			case LINKLEFTUP: 
				GapLinkedTrack linkLeftUp = new GapLinkedTrack(TrackType.LINKLEFTUP, placeX, placeY, false, "None");
				newTrack = linkLeftUp;
				break;
				
			case LINKRIGHTUP: 
				GapLinkedTrack linkRightUp = new GapLinkedTrack(TrackType.LINKRIGHTUP, placeX, placeY, false, "None");
				newTrack = linkRightUp;
				break;
				
			case LINKLEFTDOWN: 
				GapLinkedTrack linkLeftDown = new GapLinkedTrack(TrackType.LINKLEFTDOWN, placeX, placeY, false, "None");
				newTrack = linkLeftDown;
				break;
				
			case LINKRIGHTDOWN: 
				GapLinkedTrack linkRightDown = new GapLinkedTrack(TrackType.LINKRIGHTDOWN, placeX, placeY, false, "None");
				newTrack = linkRightDown;
				break;
				
			case DIRECTLEFT: 
				DirectionalTrack directLeftTrack = new DirectionalTrack(TrackType.DIRECTLEFT, placeX, placeY, false, "None", Direction.LEFT);
				newTrack = directLeftTrack;
				break;
				
			case DIRECTRIGHT: 
				DirectionalTrack directRightTrack = new DirectionalTrack(TrackType.DIRECTRIGHT, placeX, placeY, false, "None", Direction.RIGHT);
				newTrack = directRightTrack;
				break;
				
			case DIRECTUP: 
				DirectionalTrack directUpTrack = new DirectionalTrack(TrackType.DIRECTUP, placeX, placeY, false, "None", Direction.UP);
				newTrack = directUpTrack;
				break;
				
			case DIRECTDOWN: 
				DirectionalTrack directDownTrack = new DirectionalTrack(TrackType.DIRECTDOWN, placeX, placeY, false, "None", Direction.DOWN);
				newTrack = directDownTrack;
				break;
				
			case DIRECTLEFTUP: 
				DirectionalTrack directLeftUpTrack = new DirectionalTrack(TrackType.DIRECTLEFTUP, placeX, placeY, false, "None", Direction.LEFTUP);
				newTrack = directLeftUpTrack;
				break;
				
			case DIRECTRIGHTUP: 
				DirectionalTrack directRightUpTrack = new DirectionalTrack(TrackType.DIRECTRIGHTUP, placeX, placeY, false, "None", Direction.RIGHTUP);
				newTrack = directRightUpTrack;
				break;
				
			case DIRECTLEFTDOWN: 
				DirectionalTrack directLeftDownTrack = new DirectionalTrack(TrackType.DIRECTLEFTDOWN, placeX, placeY, false, "None", Direction.LEFTDOWN);
				newTrack = directLeftDownTrack;
				break;
				
			case DIRECTRIGHTDOWN: 
				DirectionalTrack directRightDownTrack = new DirectionalTrack(TrackType.DIRECTRIGHT, placeX, placeY, false, "None", Direction.RIGHTDOWN);
				newTrack = directRightDownTrack;
				break;
				
			case EXITLEFT: 
				ExitTrack exitLeftTrack = new ExitTrack(TrackType.EXITLEFT, placeX, placeY, false, "None");
				newTrack = exitLeftTrack;
				break;
				
			case EXITRIGHT: 
				ExitTrack exitRightTrack = new ExitTrack(TrackType.EXITRIGHT, placeX, placeY, false, "None");
				newTrack = exitRightTrack;
				break;
				
			case EXITUP: 
				ExitTrack exitUpTrack = new ExitTrack(TrackType.EXITUP, placeX, placeY, false, "None");
				newTrack = exitUpTrack;
				break;
				
			case EXITDOWN: 
				ExitTrack exitDownTrack = new ExitTrack(TrackType.EXITDOWN, placeX, placeY, false, "None");
				newTrack = exitDownTrack;
				break;
				
			case EXITLEFTUP: 
				ExitTrack exitLeftUpTrack = new ExitTrack(TrackType.EXITLEFTUP, placeX, placeY, false, "None");
				newTrack = exitLeftUpTrack;
				break;
				
			case EXITRIGHTUP: 
				ExitTrack exitRightUpTrack = new ExitTrack(TrackType.EXITRIGHTUP, placeX, placeY, false, "None");
				newTrack = exitRightUpTrack;
				break;
				
			case EXITLEFTDOWN: 
				ExitTrack exitLeftDownTrack = new ExitTrack(TrackType.EXITLEFTDOWN, placeX, placeY, false, "None");
				newTrack = exitLeftDownTrack;
				break;
				
			case EXITRIGHTDOWN: 
				ExitTrack exitRightDownTrack = new ExitTrack(TrackType.EXITRIGHTDOWN, placeX, placeY, false, "None");
				newTrack = exitRightDownTrack;
				break;
				
			case TIGHTCURVE1: 
				CurvedTrack tightCurve1 = new CurvedTrack(TrackType.TIGHTCURVE1, placeX, placeY, false, "None");
				newTrack = tightCurve1;
				break;
				
			case TIGHTCURVE2: 
				CurvedTrack tightCurve2 = new CurvedTrack(TrackType.TIGHTCURVE2, placeX, placeY, false, "None");
				newTrack = tightCurve2;
				break;
				
			case TIGHTCURVE3: 
				CurvedTrack tightCurve3 = new CurvedTrack(TrackType.TIGHTCURVE3, placeX, placeY, false, "None");
				newTrack = tightCurve3;
				break;
				
			case TIGHTCURVE4: 
				CurvedTrack tightCurve4 = new CurvedTrack(TrackType.TIGHTCURVE4, placeX, placeY, false, "None");
				newTrack = tightCurve4;
				break;
				
			case CURVE1: 
				CurvedTrack curve1 = new CurvedTrack(TrackType.CURVE1, placeX, placeY, false, "None");
				newTrack = curve1;
				break;
				
			case CURVE2: 
				CurvedTrack curve2 = new CurvedTrack(TrackType.CURVE2, placeX, placeY, false, "None");
				newTrack = curve2;
				break;
				
			case CURVE3: 
				CurvedTrack curve3 = new CurvedTrack(TrackType.CURVE3, placeX, placeY, false, "None");
				newTrack = curve3;
				break;
				
			case CURVE4: 
				CurvedTrack curve4 = new CurvedTrack(TrackType.CURVE4, placeX, placeY, false, "None");
				newTrack = curve4;
				break;
				
			case CURVE5: 
				CurvedTrack curve5 = new CurvedTrack(TrackType.CURVE5, placeX, placeY, false, "None");
				newTrack = curve5;
				break;
				
			case CURVE6: 
				CurvedTrack curve6 = new CurvedTrack(TrackType.CURVE6, placeX, placeY, false, "None");
				newTrack = curve6;
				break;
				
			case CURVE7: 
				CurvedTrack curve7 = new CurvedTrack(TrackType.CURVE7, placeX, placeY, false, "None");
				newTrack = curve7;
				break;
				
			case CURVE8: 
				CurvedTrack curve8 = new CurvedTrack(TrackType.CURVE8, placeX, placeY, false, "None");
				newTrack = curve8;
				break;
				
			case SWITCHTIGHT1: 
				SwitchTrack switchTight1 = new SwitchTrack(TrackType.SWITCHTIGHT1, placeX, placeY, false, "None");
				newTrack = switchTight1;
				break;
				
			case SWITCHTIGHT2: 
				SwitchTrack switchTight2 = new SwitchTrack(TrackType.SWITCHTIGHT2, placeX, placeY, false, "None");
				newTrack = switchTight2;
				break;
				
			case SWITCHTIGHT3: 
				SwitchTrack switchTight3 = new SwitchTrack(TrackType.SWITCHTIGHT3, placeX, placeY, false, "None");
				newTrack = switchTight3;
				break;
				
			case SWITCHTIGHT4: 
				SwitchTrack switchTight4 = new SwitchTrack(TrackType.SWITCHTIGHT4, placeX, placeY, false, "None");
				newTrack = switchTight4;
				break;
				
			case SWITCHTIGHT5: 
				SwitchTrack switchTight5 = new SwitchTrack(TrackType.SWITCHTIGHT5, placeX, placeY, false, "None");
				newTrack = switchTight5;
				break;
				
			case SWITCHTIGHT6: 
				SwitchTrack switchTight6 = new SwitchTrack(TrackType.SWITCHTIGHT6, placeX, placeY, false, "None");
				newTrack = switchTight6;
				break;
				
			case SWITCHTIGHT7: 
				SwitchTrack switchTight7 = new SwitchTrack(TrackType.SWITCHTIGHT7, placeX, placeY, false, "None");
				newTrack = switchTight7;
				break;
				
			case SWITCHTIGHT8: 
				SwitchTrack switchTight8 = new SwitchTrack(TrackType.SWITCHTIGHT8, placeX, placeY, false, "None");
				newTrack = switchTight8;
				break;
				
			case SWITCH1: 
				SwitchTrack switch1 = new SwitchTrack(TrackType.SWITCH1, placeX, placeY, false, "None");
				newTrack = switch1;
				break;
				
			case SWITCH2: 
				SwitchTrack switch2 = new SwitchTrack(TrackType.SWITCH2, placeX, placeY, false, "None");
				newTrack = switch2;
				break;
				
			case SWITCH3: 
				SwitchTrack switch3 = new SwitchTrack(TrackType.SWITCH3, placeX, placeY, false, "None");
				newTrack = switch3;
				break;
				
			case SWITCH4: 
				SwitchTrack switch4 = new SwitchTrack(TrackType.SWITCH4, placeX, placeY, false, "None");
				newTrack = switch4;
				break;
				
			case SWITCH5: 
				SwitchTrack switch5 = new SwitchTrack(TrackType.SWITCH5, placeX, placeY, false, "None");
				newTrack = switch5;
				break;
				
			case SWITCH6: 
				SwitchTrack switch6 = new SwitchTrack(TrackType.SWITCH6, placeX, placeY, false, "None");
				newTrack = switch6;
				break;
				
			case SWITCH7: 
				SwitchTrack switch7 = new SwitchTrack(TrackType.SWITCH7, placeX, placeY, false, "None");
				newTrack = switch7;
				break;
				
			case SWITCH8: 
				SwitchTrack switch8 = new SwitchTrack(TrackType.SWITCH8, placeX, placeY, false, "None");
				newTrack = switch8;
				break;
				
			case SWITCH9: 
				SwitchTrack switch9 = new SwitchTrack(TrackType.SWITCH9, placeX, placeY, false, "None");
				newTrack = switch9;
				break;
				
			case SWITCH10: 
				SwitchTrack switch10 = new SwitchTrack(TrackType.SWITCH10, placeX, placeY, false, "None");
				newTrack = switch10;
				break;
				
			case SWITCH11: 
				SwitchTrack switch11 = new SwitchTrack(TrackType.SWITCH11, placeX, placeY, false, "None");
				newTrack = switch11;
				break;
				
			case SWITCH12: 
				SwitchTrack switch12 = new SwitchTrack(TrackType.SWITCH12, placeX, placeY, false, "None");
				newTrack = switch12;
				break;
				
			case SWITCH13: 
				SwitchTrack switch13 = new SwitchTrack(TrackType.SWITCH13, placeX, placeY, false, "None");
				newTrack = switch13;
				break;
				
			case SWITCH14: 
				SwitchTrack switch14 = new SwitchTrack(TrackType.SWITCH14, placeX, placeY, false, "None");
				newTrack = switch14;
				break;
				
			case SWITCH15: 
				SwitchTrack switch15 = new SwitchTrack(TrackType.SWITCH15, placeX, placeY, false, "None");
				newTrack = switch15;
				break;
				
			case SWITCH16: 
				SwitchTrack switch16 = new SwitchTrack(TrackType.SWITCH16, placeX, placeY, false, "None");
				newTrack = switch16;
				break;
				
			case BRIDGE1: 
				StationBridgeUnderpassTrack bridge1 = new StationBridgeUnderpassTrack(TrackType.BRIDGE1, placeX, placeY, false, "None");
				newTrack = bridge1;
				break;
				
			case BRIDGE2: 
				StationBridgeUnderpassTrack bridge2 = new StationBridgeUnderpassTrack(TrackType.BRIDGE2, placeX, placeY, false, "None");
				newTrack = bridge2;
				break;
				
			case UNDERPASS1: 
				StationBridgeUnderpassTrack underpass1 = new StationBridgeUnderpassTrack(TrackType.UNDERPASS1, placeX, placeY, false, "None");
				newTrack = underpass1;
				break;
				
			case UNDERPASS2: 
				StationBridgeUnderpassTrack underpass2 = new StationBridgeUnderpassTrack(TrackType.UNDERPASS2, placeX, placeY, false, "None");
				newTrack = underpass2;
				break;
				
			case SIGNALLEFT: 
				newTrack = addsSignalTrack(placeX, placeY, itemSelected, aspect);
				
				break;
				
			case SIGNALRIGHT: 
				newTrack = addsSignalTrack(placeX, placeY, itemSelected, aspect);
				break;
				
			case SIGNALUP: 
				newTrack = addsSignalTrack(placeX, placeY, itemSelected, aspect);
				break;
				
			case SIGNALDOWN: 
				newTrack = addsSignalTrack(placeX, placeY, itemSelected, aspect);
				break;
				
			case SIGNALLEFTUP: 
				newTrack = addsSignalTrack(placeX, placeY, itemSelected, aspect);
				
				break;
				
			case SIGNALRIGHTUP: 
				newTrack = addsSignalTrack(placeX, placeY, itemSelected, aspect);
				break;
			
			case SIGNALLEFTDOWN: 
				newTrack = addsSignalTrack(placeX, placeY, itemSelected, aspect);
				
				break;
				
			case SIGNALRIGHTDOWN: 
				newTrack = addsSignalTrack(placeX, placeY, itemSelected, aspect);
				break;
			default:
				break;
			}
			
			trackStore.add(newTrack);
			
			
			GraphicsContext graphic = railMap.getGraphicsContext2D();
			drawElement(graphic, event, file, canvasColour);
		}
		System.out.println(trackStore.size());
	}
	
	public static Track addsSignalTrack( int placeX, int placeY, TrackType itemSelected, SignalAspect aspect) {
		Track newTrack = null;;
		switch(aspect) {
		
		case SHUNT: 
			SignalTrack exitLeftTrack = new SignalTrack(itemSelected, placeX, placeY, false, "None", aspect);
			newTrack = exitLeftTrack;
			break;
			
			
		case TWO: 
			SignalTrack exitRightTrack = new SignalTrack(itemSelected, placeX, placeY, false, "None", aspect);
			newTrack = exitRightTrack;
			break;
			
		case THREE: 
			SignalTrack exitUpTrack = new SignalTrack(itemSelected, placeX, placeY, false, "None", aspect);
			newTrack = exitUpTrack;
			break;
			
		case FOUR: 
			SignalTrack exitDownTrack = new SignalTrack(itemSelected, placeX, placeY, false, "None", aspect);
			newTrack = exitDownTrack;
			break;
			
			
			
		}
		return newTrack;
	}
	
	
	
		

}
