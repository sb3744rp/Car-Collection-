/** 
 * FileMenu JavaFx Class holds JavaFx code for a predefined GUI menu bar. The menu bar comes with three menu options that allow 
 * the user to choose between creating, editing or displaying a car collection. This class mainly deals with setting up the 
 * GUI appearance for the 'Main' Java Class.
 * 
 * Source of borrowed code: 
 * GitHub --> https://github.com/buckyroberts/Source-Code-from-Tutorials/blob/master/JavaFX/024_menus/Main.java
 * YouTube Tutorial--> https://www.youtube.com/watch?v=JBJ9MIEfU3k
 * 
 * 
 * @author: Jon Prendergast
 * @since: 6/12/2019
 * @version: 1.0
 * 
 */
package application;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class FileMenu {
	
	private Menu createOption;
	private Menu editOption;
	private Menu displayOptions;
	private MenuBar menuBar;
	private MenuItem addCarToCollection;
	private MenuItem removeFromCarCollection;
	private MenuItem displayCarCollection;
	private MenuItem displayCarUsingPlateInfo;
	
	public FileMenu() {
		
		//create fileMenu tab for drop down options 
		createOption = new Menu("Create...");
		editOption = new Menu("Edit...");
		displayOptions = new Menu("Display...");
				
		//Menu drop down options 
		//creates menuItem 'addCar' option and assigns it to fileMenu object
		addCarToCollection = new MenuItem("Add a new car to collection...");
		createOption.getItems().add(addCarToCollection);
				
		//adds a separator between menu items
		createOption.getItems().add(new SeparatorMenuItem()); 
				
		//creates a menuItem 'removeCar' option and assigns it to fileMenu object
		removeFromCarCollection = new MenuItem("Remove an existing car from collection...");
		editOption.getItems().add(removeFromCarCollection);
				
		//adds a separator between menu items
		editOption.getItems().add(new SeparatorMenuItem()); 
				
		//creates a menuItem 'displayCarCollection' option and assigns it to file menu object
		displayOptions = new Menu("Display Options...");
		displayCarCollection = new MenuItem("Display, clone remove, create car collection...");
		displayOptions.getItems().add(displayCarCollection);
				
		//adds a separator between menu items
		displayOptions.getItems().add(new SeparatorMenuItem());
				
		//creates a menuItem 'displayCarUsingPlateInfo' option and assigns it to the file menu object
		displayCarUsingPlateInfo = new MenuItem("Display specified car for editing...");
		displayOptions.getItems().add(displayCarUsingPlateInfo);
				
		//adds a separator between menu items
		displayOptions.getItems().add(new SeparatorMenuItem());
				
		//create main menu bar and add menu options
		menuBar = new MenuBar();
		menuBar.getMenus().addAll(createOption,editOption,displayOptions);
	}

	/**
	 * 'getCreateOption' method returns a reference to the menu option
	 *  for initiating car collection creation.
	 * 
	 * @return: createOption
	 */
	public Menu getCreateOption() {
		return createOption;
	}

	/**
	 * 'getEditOptions' method returns a reference to the menu option
	 *  for editing current car collection.
	 * 
	 * @return: editOptions
	 */
	public Menu getEditOption() {
		return editOption;
	}

	/**
	 * 'getDisplayOptions' method returns a reference to the menu option
	 *  for displaying car collection.
	 * 
	 * @return: displayOptions
	 */
	public Menu getDisplayOptions() {
		return displayOptions;
	}

	/**
	 * 'getMenuBar' method returns a reference to the menu bar
	 *  which holds all menu options
	 * 
	 * @return: menuBar
	 */
	public MenuBar getMenuBar() {
		return menuBar;
	}

	/**
	 * 'getAddCarToCollection' method returns a reference to the drop down menu item
	 *  for adding a car to the collection. 
	 * 
	 * @return: addCarToCollection
	 */
	public MenuItem getAddCarToCollection() {
		return addCarToCollection;
	}
	
	/**
	 * 'getRemoveFromCarCollection' method returns a reference to the drop down menu item
	 *  for removing a car from the collection.
	 *  
	 * @return: removeFromCarCollection
	 */

	public MenuItem getRemoveFromCarCollection() {
		return removeFromCarCollection;
	}

	/**
	 * 'getDisplayCarCollection' method returns a reference to the drop down menu item
	 *  for displaying the entire car collection.
	 * 
	 * @return: displayCarCollection
	 */
	public MenuItem getDisplayCarCollection() {
		return displayCarCollection;
	}
	
	/**
	 * 'getDisplayCarUsingPlateInfo' method returns a reference to the drop down menu item
	 *  for displaying a car based on the search key(plate info).
	 * 
	 * @return: displayCarUsingPlaceInfo
	 */
	public MenuItem getDisplayCarUsingPlateInfo() {
		return displayCarUsingPlateInfo;
	}
}
