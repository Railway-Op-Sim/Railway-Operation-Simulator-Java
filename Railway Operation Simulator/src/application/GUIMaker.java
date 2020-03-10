package application;

import java.util.Collection;
import java.util.Collections;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class GUIMaker {

	public GUIMaker() {
		// TODO Auto-generated constructor stub
	}
	
	private Menu makeFileMenu(){
		Menu fileMenu = new Menu("File");
		MenuItem loadRailwayMenuItem = new MenuItem("Load Railway");
		MenuItem saveRailwayMenuItem = new MenuItem("Save Railway");
		MenuItem saveRailwayAsMenuItem = new MenuItem("Save Railway As");
		SeparatorMenuItem separator = new SeparatorMenuItem();
		MenuItem exit = new MenuItem("Exit");
		fileMenu.getItems().add(loadRailwayMenuItem);
		fileMenu.getItems().add(saveRailwayMenuItem);
		fileMenu.getItems().add(saveRailwayAsMenuItem);
		fileMenu.getItems().add(separator);
		fileMenu.getItems().add(exit);
		return fileMenu;
	}
	
	private Menu makeModeMenu(){
		Menu modeMenu = new Menu("Mode");
		MenuItem buildModifyMenuItem = new MenuItem("Load Railway");
		MenuItem setPreferredDirMenuItem = new MenuItem("Save Railway");
		SeparatorMenuItem separator = new SeparatorMenuItem();
		modeMenu.getItems().add(buildModifyMenuItem);
		modeMenu.getItems().add(setPreferredDirMenuItem);
		modeMenu.getItems().add(separator);
		return modeMenu;
		
	}
	
	private MenuBar makeMenuBar() {
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().add(makeFileMenu());
		menuBar.getMenus().add(makeModeMenu());
		
		
		
		return menuBar;
	}
	
	private VBox makeTopMenu() {
		VBox topMenu = new VBox();
		topMenu.getChildren().add(makeMenuBar());
		
		return topMenu;
	}
	
	public BorderPane makeTopGUI() {
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(makeTopMenu());
		return borderPane;
		
	}

}
