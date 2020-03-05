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
		File leftShuntFile = new File("./src/graphics/shuntLeftSignalRed.png");
		File rightShuntFile = new File("./src/graphics/shuntRightSignalRed.png");
		File upShuntFile = new File("./src/graphics/shuntUpSignalRed.png");
		File downShuntFile = new File("./src/graphics/shuntDownSignalRed.png");
		Image leftShuntImage = null;
		Image rightShuntImage =null;
		Image upShuntImage = null;
		Image downShuntImage = null;
		try {
			leftShuntImage = new Image(new FileInputStream(leftShuntFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			rightShuntImage = new Image(new FileInputStream(rightShuntFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			upShuntImage = new Image(new FileInputStream(upShuntFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			downShuntImage = new Image(new FileInputStream(downShuntFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		leftSignal.setImage(leftShuntImage);
		rightSignal.setImage(rightShuntImage);
		upSignal.setImage(upShuntImage);
		downSignal.setImage(downShuntImage);
		
		
	}
	
	public static void changeToNormalSignalGraphic(ImageView leftSignal, ImageView rightSignal, ImageView upSignal, ImageView downSignal) {
		File leftSignalFile = new File("./src/graphics/signalLeft.png");
		File rightSignalFile = new File("./src/graphics/signalRight.png");
		File upSignalFile = new File("./src/graphics/signalUp.png");
		File downSignalFile = new File("./src/graphics/signalDown.png");
		Image leftSignalImage = null;
		Image rightSignalImage =null;
		Image upSignalImage = null;
		Image downSignalImage = null;
		try {
			leftSignalImage = new Image(new FileInputStream(leftSignalFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			rightSignalImage = new Image(new FileInputStream(rightSignalFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			upSignalImage = new Image(new FileInputStream(upSignalFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			downSignalImage = new Image(new FileInputStream(downSignalFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		leftSignal.setImage(leftSignalImage);
		rightSignal.setImage(rightSignalImage);
		upSignal.setImage(upSignalImage);
		downSignal.setImage(downSignalImage);
		
		
	}
}
