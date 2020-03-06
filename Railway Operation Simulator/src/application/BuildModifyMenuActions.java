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

	public static void changeToShuntSignalGraphic(ImageView leftSignal, ImageView rightSignal, ImageView upSignal, ImageView downSignal,
			ImageView leftUpSignal, ImageView rightUpSignal, ImageView leftDownSignal, ImageView rightDownSignal) {
		String leftShuntFile = new String("graphics/shuntLeftRed.png");
		String rightShuntFile = new String("graphics/shuntRightRed.png");
		String upShuntFile = new String("graphics/shuntRightRed.png");
		String downShuntFile = new String("graphics/shuntDownRed.png");
		String leftUpShuntFile = new String("graphics/shuntLeftUpRed.png");
		String rightUpShuntFile = new String("graphics/shuntRightUpRed.png");
		String leftDownShuntFile = new String("graphics/shuntLeftDownRed.png");
		String rightDownShuntFile = new String("graphics/shuntRightDownRed.png");
		
		Image leftShuntImage = new Image(MenuActions.class.getClassLoader().getResource(leftShuntFile).toString());
		Image rightShuntImage = new Image(MenuActions.class.getClassLoader().getResource(rightShuntFile).toString());
		Image upShuntImage = new Image(MenuActions.class.getClassLoader().getResource(upShuntFile).toString());
		Image downShuntImage = new Image(MenuActions.class.getClassLoader().getResource(downShuntFile).toString());
		Image leftUpShuntImage = new Image(MenuActions.class.getClassLoader().getResource(leftUpShuntFile).toString());
		Image rightUpShuntImage = new Image(MenuActions.class.getClassLoader().getResource(rightUpShuntFile).toString());
		Image leftDownShuntImage = new Image(MenuActions.class.getClassLoader().getResource(leftDownShuntFile).toString());
		Image rightDownShuntImage = new Image(MenuActions.class.getClassLoader().getResource(rightDownShuntFile).toString());
		
		leftSignal.setImage(leftShuntImage);
		rightSignal.setImage(rightShuntImage);
		upSignal.setImage(upShuntImage);
		downSignal.setImage(downShuntImage);
		leftUpSignal.setImage(leftUpShuntImage);
		rightUpSignal.setImage(rightUpShuntImage);
		leftDownSignal.setImage(leftDownShuntImage);
		rightDownSignal.setImage(rightDownShuntImage);
		
		
	}
	
	public static void changeToNormalSignalGraphic(ImageView leftSignal, ImageView rightSignal, ImageView upSignal, ImageView downSignal, 
			ImageView leftUpSignal, ImageView rightUpSignal, ImageView leftDownSignal, ImageView rightDownSignal) {
		String leftSignalFile = new String("graphics/signalLeft.png");
		String rightSignalFile = new String("graphics/signalRight.png");
		String upSignalFile = new String("graphics/signalUp.png");
		String downSignalFile = new String("graphics/signalDown.png");
		String leftUpSignalFile = new String("graphics/signalLeftUp.png");
		String rightUpSignalFile = new String("graphics/signalRightUp.png");
		String leftDownSignalFile = new String("graphics/signalLeftDown.png");
		String rightDownSignalFile = new String("graphics/signalRightDown.png");
		
		Image leftSignalImage = new Image(MenuActions.class.getClassLoader().getResource(leftSignalFile).toString());
		Image rightSignalImage = new Image(MenuActions.class.getClassLoader().getResource(rightSignalFile).toString());
		Image upSignalImage = new Image(MenuActions.class.getClassLoader().getResource(upSignalFile).toString());
		Image downSignalImage = new Image(MenuActions.class.getClassLoader().getResource(downSignalFile).toString());
		Image leftUpSignalImage = new Image(MenuActions.class.getClassLoader().getResource(leftUpSignalFile).toString());
		Image rightUpSignalImage = new Image(MenuActions.class.getClassLoader().getResource(rightUpSignalFile).toString());
		Image leftDownSignalImage = new Image(MenuActions.class.getClassLoader().getResource(leftDownSignalFile).toString());
		Image rightDownSignalImage = new Image(MenuActions.class.getClassLoader().getResource(rightDownSignalFile).toString());
		
		leftSignal.setImage(leftSignalImage);
		rightSignal.setImage(rightSignalImage);
		upSignal.setImage(upSignalImage);
		downSignal.setImage(downSignalImage);
		leftUpSignal.setImage(leftUpSignalImage);
		rightUpSignal.setImage(rightUpSignalImage);
		leftDownSignal.setImage(leftDownSignalImage);
		rightDownSignal.setImage(rightDownSignalImage);
		
		
	}
}
