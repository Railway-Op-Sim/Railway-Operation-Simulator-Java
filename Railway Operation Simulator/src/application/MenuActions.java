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
	 public static void drawElement(GraphicsContext railMap, MouseEvent event, String file) {
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
		 Image image = null;
		 image = new Image(MenuActions.class.getClassLoader().getResource(file).toString()); //Set file as image.
		
		
		railMap.drawImage( image, placeX, placeY); //Draw the image at that place.
	 }
	 
	 /**
	  * A method to draw the grid on the canvas.
	  * @param display
	  */
	 public static void createGrid(Canvas display) {
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
	 public static void toggleGrid(Canvas display, Button showHideGridButton ) {
		 String showHideGridText = showHideGridButton.getText();
		 if (showHideGridText.equals("Show Grid")) {
			 createGrid(display);
			 showHideGridButton.setText("Hide Grid");
		 } else {
			 removeGrid(display);
			 showHideGridButton.setText("Show Grid");
		 }
	 }
	 /**
	  * A method to remove the grid drawn on the canvas.
	  * @param display
	  */
	private static void removeGrid(Canvas display) {
		
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
			case STRAIGHTHORIZONTAL :
				trackImage = new String("graphics/straightH.png"); //Open image file.
				break;
			
			case STRAIGHTVERTICAL :
				trackImage = new String("graphics/straightV.png"); //Open image file.
				break;
				
			case STRAIGHTLEFTUP :
				trackImage = new String("graphics/straightLeftUp.png"); //Open image file.
				break;
			
			case STRAIGHTRIGHTUP :
				trackImage = new String("graphics/straightRightUp.png"); //Open image file.
				break;
				
			case LEFTBUFFER :
				trackImage = new String("graphics/leftBuffer.png"); //Open image file.
				break;
			
			case RIGHTBUFFER :
				trackImage = new String("graphics/rightBuffer.png"); //Open image file.
				break;
			
			case UPBUFFER :
				trackImage = new String("graphics/upBuffer.png"); //Open image file.
				break;
				
			case DOWNBUFFER :
				trackImage = new String("graphics/downBuffer.png"); //Open image file.
				break;
				
			case LEFTUPBUFFER :
				trackImage = new String("graphics/leftUpBuffer.png"); //Open image file.
				break;
			
			case RIGHTUPBUFFER :
				trackImage = new String("graphics/rightUpBuffer.png"); //Open image file.
				break;
				
			case LEFTDOWNBUFFER :
				trackImage = new String("graphics/leftDownBuffer.png"); //Open image file.
				break;
			
			case RIGHTDOWNBUFFER :
				trackImage = new String("graphics/rightDownBuffer.png"); //Open image file.
				break;
				
			case LEFTGAP :
				trackImage = new String("graphics/unsetLeftGap.png"); //Open image file.
				break;
			
			case RIGHTGAP :
				trackImage = new String("graphics/unsetRightGap.png"); //Open image file.
				break;
			
			case UPGAP :
				trackImage = new String("graphics/unsetUpGap.png"); //Open image file.
				break;
				
			case DOWNGAP :
				trackImage = new String("graphics/unsetDownGap.png"); //Open image file.
				break;
				
			case LEFTUPGAP :
				trackImage = new String("graphics/unsetLeftUpGap.png"); //Open image file.
				break;
				
			case RIGHTUPGAP :
				trackImage = new String("graphics/unsetRightUpGap.png"); //Open image file.
				break;
				
			case LEFTDOWNGAP :
				trackImage = new String("graphics/unsetLeftDownGap.png"); //Open image file.
				break;
				
			case RIGHTDOWNGAP :
				trackImage = new String("graphics/unsetRightDownGap.png"); //Open image file.
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
	
	
	public static void addTrack(MouseEvent event,Canvas railMap, String file, TrackType itemSelected, SignalAspect aspect ) {
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
			case STRAIGHTHORIZONTAL: 
				StraightTrack straightHorizontal = new StraightTrack( TrackType.STRAIGHTHORIZONTAL, placeX, placeY, false, "None");
				straightHorizontal.setLinks();
				newTrack = straightHorizontal;
				break;
			
			case STRAIGHTVERTICAL: 
				StraightTrack straightVertical = new StraightTrack( TrackType.STRAIGHTVERTICAL, placeX, placeY, false, "None");
				straightVertical.setLinks();
				newTrack = straightVertical;
				
				break;
				
			case STRAIGHTLEFTUP: 
				StraightTrack straightLeftUp = new StraightTrack( TrackType.STRAIGHTLEFTUP, placeX, placeY, false, "None");
				straightLeftUp.setLinks();
				newTrack = straightLeftUp;
				break;
			
			case STRAIGHTRIGHTUP: 
				StraightTrack straightRightUp = new StraightTrack( TrackType.STRAIGHTRIGHTUP, placeX, placeY, false, "None");
				straightRightUp.setLinks();
				newTrack = straightRightUp;
				
				break;
			
			case LEFTBUFFER: 
				BufferedTrack leftBuffer = new BufferedTrack(TrackType.LEFTBUFFER, placeX, placeY, false, "None");
				leftBuffer.setLinks();
				newTrack = leftBuffer;
				break;
			
			case RIGHTBUFFER: 
				BufferedTrack rightBuffer = new BufferedTrack(TrackType.RIGHTBUFFER, placeX, placeY, false, "None");
				rightBuffer.setLinks();
				newTrack = rightBuffer;
				break;
				
			case UPBUFFER: 
				BufferedTrack topBuffer = new BufferedTrack(TrackType.UPBUFFER, placeX, placeY, false, "None");
				topBuffer.setLinks();
				newTrack = topBuffer;
				break;
				
			case DOWNBUFFER: 
				BufferedTrack bottomBuffer = new BufferedTrack(TrackType.DOWNBUFFER, placeX, placeY, false, "None");
				bottomBuffer.setLinks();
				newTrack = bottomBuffer;
				break;
				
			case LEFTUPBUFFER: 
				BufferedTrack leftUpBuffer = new BufferedTrack(TrackType.LEFTUPBUFFER, placeX, placeY, false, "None");
				leftUpBuffer.setLinks();
				newTrack = leftUpBuffer;
				break;
			
			case RIGHTUPBUFFER: 
				BufferedTrack rightUpBuffer = new BufferedTrack(TrackType.RIGHTUPBUFFER, placeX, placeY, false, "None");
				newTrack = rightUpBuffer;
				break;
				
			case LEFTDOWNBUFFER: 
				BufferedTrack leftDownBuffer = new BufferedTrack(TrackType.LEFTDOWNBUFFER, placeX, placeY, false, "None");
				newTrack = leftDownBuffer;
				break;
			
			case RIGHTDOWNBUFFER: 
				BufferedTrack rightDownBuffer = new BufferedTrack(TrackType.RIGHTDOWNBUFFER, placeX, placeY, false, "None");
				newTrack = rightDownBuffer;
				break;
				
			case LEFTGAP: 
				GapLinkedTrack leftGapTrack = new GapLinkedTrack(TrackType.LEFTGAP, placeX, placeY, false, "None");
				newTrack = leftGapTrack;
				break;
				
			case RIGHTGAP: 
				GapLinkedTrack rightGapTrack = new GapLinkedTrack(TrackType.RIGHTGAP, placeX, placeY, false, "None");
				newTrack = rightGapTrack;
				break;
				
			case UPGAP: 
				GapLinkedTrack upGapTrack = new GapLinkedTrack(TrackType.UPGAP, placeX, placeY, false, "None");
				newTrack = upGapTrack;
				break;
				
			case DOWNGAP: 
				GapLinkedTrack downGapTrack = new GapLinkedTrack(TrackType.DOWNGAP, placeX, placeY, false, "None");
				newTrack = downGapTrack;
				break;
			
			case LEFTUPGAP: 
				GapLinkedTrack leftUpGapTrack = new GapLinkedTrack(TrackType.LEFTUPGAP, placeX, placeY, false, "None");
				newTrack = leftUpGapTrack;
				break;
				
			case RIGHTUPGAP: 
				GapLinkedTrack rightUpGapTrack = new GapLinkedTrack(TrackType.RIGHTUPGAP, placeX, placeY, false, "None");
				newTrack = rightUpGapTrack;
				break;
				
			case LEFTDOWNGAP: 
				GapLinkedTrack leftDownGapTrack = new GapLinkedTrack(TrackType.LEFTDOWNGAP, placeX, placeY, false, "None");
				newTrack = leftDownGapTrack;
				break;
				
			case RIGHTDOWNGAP: 
				GapLinkedTrack rightDownGapTrack = new GapLinkedTrack(TrackType.RIGHTDOWNGAP, placeX, placeY, false, "None");
				newTrack = rightDownGapTrack;
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
			drawElement(graphic, event, file);
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
