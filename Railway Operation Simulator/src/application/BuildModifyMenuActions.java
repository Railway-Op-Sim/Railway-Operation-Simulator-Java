package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BuildModifyMenuActions {

	public BuildModifyMenuActions() {
		// TODO Auto-generated constructor stub
	}

	public static void changeToShuntSignalGraphic(ImageView leftSignal, ImageView rightSignal, ImageView upSignal, ImageView downSignal) {
		String leftShuntFile = new String("graphics/shuntLeftSignalRed.png");
		String rightShuntFile = new String("graphics/shuntRightSignalRed.png");
		String upShuntFile = new String("graphics/shuntUpSignalRed.png");
		String downShuntFile = new String("graphics/shuntDownSignalRed.png");
		
		Image leftShuntImage = new Image(MenuActions.class.getClassLoader().getResource(leftShuntFile).toString());
		Image rightShuntImage = new Image(MenuActions.class.getClassLoader().getResource(rightShuntFile).toString());
		Image upShuntImage = new Image(MenuActions.class.getClassLoader().getResource(upShuntFile).toString());
		Image downShuntImage = new Image(MenuActions.class.getClassLoader().getResource(downShuntFile).toString());
		
		leftSignal.setImage(leftShuntImage);
		rightSignal.setImage(rightShuntImage);
		upSignal.setImage(upShuntImage);
		downSignal.setImage(downShuntImage);
		
		
	}
	
	public static void changeToNormalSignalGraphic(ImageView leftSignal, ImageView rightSignal, ImageView upSignal, ImageView downSignal) {
		String leftSignalFile = new String("graphics/signalLeft.png");
		String rightSignalFile = new String("graphics/signalRight.png");
		String upSignalFile = new String("graphics/signalUp.png");
		String downSignalFile = new String("graphics/signalDown.png");
		
		Image leftSignalImage = new Image(MenuActions.class.getClassLoader().getResource(leftSignalFile).toString());
		Image rightSignalImage = new Image(MenuActions.class.getClassLoader().getResource(rightSignalFile).toString());
		Image upSignalImage = new Image(MenuActions.class.getClassLoader().getResource(upSignalFile).toString());
		Image downSignalImage = new Image(MenuActions.class.getClassLoader().getResource(downSignalFile).toString());
	
		
		leftSignal.setImage(leftSignalImage);
		rightSignal.setImage(rightSignalImage);
		upSignal.setImage(upSignalImage);
		downSignal.setImage(downSignalImage);
		
		
	}
}
