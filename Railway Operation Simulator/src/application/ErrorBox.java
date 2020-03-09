package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ErrorBox {

	public ErrorBox() {
		// TODO Auto-generated constructor stub
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

}
