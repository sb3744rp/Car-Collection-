/**
 * 'Scene4' JavaFx Class contains specified layout information for Scene 4. The 'Scene4' JavaFx
 *  Class gives the user an organized view of cars added to the collection. 
 *  
 *  
 *  Source of borrowed code:
 *  URL: http://tutorials.jenkov.com/javafx/tableview.html
 *  GitHub: https://github.com/buckyroberts/Source-Code-from-Tutorials/blob/master/JavaFX/018_tableView/Main.java
 *  YouTube tutorial: https://www.youtube.com/watch?v=mtdlX2NMy4M
 * 
 * 
 * @author: Jon Prendergast
 * @since: 6/10/2019
 * @version: 1.0
 * 
 */
package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Scene4 {
	
	private BorderPane scene4Layout;
	private FlowPane boxHolderPane;
	private VBox buttonHolder,createListBox,cloneListBox,displayListBox,tableBox, removeBox;
	private Button refreshButton, returnButton, createListButton, cloneListButton, displayListButton, removeListButton;
	private Scene scene4;
	private TableView<Car> table;
	private TextField createListForm, nameOfClonedListForm, displayListForm, nameOfCloneListForm, removeListForm;
	private Label createListLabel, clonedListLabel, displayListLabel,cloneListLabel, removeListLabel;
	private Image image;
	private ImageView imageView;
	
	
	public Scene4() throws FileNotFoundException {
		
		//create table to hold column data for objects of type Car
		table = new TableView<Car>();
		
		//create a refresh table button so that the table reflects most recent addition, deletions, and edits
		refreshButton = new Button("Refresh Table");
		
		//transition button from scene 4 to main menu (scene 1)
		returnButton = new Button("Return to main menu");
		
		//create a 'create list' button to activate list creation
		createListButton = new Button("Create a new List");
		
		//create a clone button in order to activate cloning of specified list
		cloneListButton = new Button("Clone List");
		
		//display list button displays lists based on name provided
		displayListButton = new Button("Display List");
		
		//create a remove list button
		removeListButton = new Button("Remove List");
		
		//create an image and imageView
		image = new Image(new FileInputStream(".\\bin\\application\\tableEdit.jpg"));
		imageView = new ImageView(image);
		
		//create button holder VBox and add refresh/return to menu buttons
		buttonHolder = new VBox();
		buttonHolder.getChildren().addAll(refreshButton,returnButton);
		buttonHolder.setSpacing(10);
		
		//create box holder and set horizontal spacing for VBox children
		boxHolderPane = new FlowPane();
		boxHolderPane.setHgap(20);
		boxHolderPane.setVgap(50);
		
		//create VBoxs for each separate task: create, clone, and display specified list
		createListBox = new VBox();
		cloneListBox = new VBox();
		displayListBox = new VBox();
		tableBox = new VBox();
		removeBox = new VBox();
		
		//create forms for user to enter input
		createListForm = new TextField();
		nameOfClonedListForm = new TextField();
		displayListForm = new TextField();
		nameOfCloneListForm = new TextField();
		removeListForm = new TextField();
		
		//set width of forms to an appropriate size
		createListForm.setMaxWidth(150);
		nameOfClonedListForm.setMaxWidth(150);
		displayListForm.setMaxWidth(150);
		removeListForm.setMaxWidth(150);
		
		//create labels to guide the user on what should be entered into each text field
		createListLabel = new Label("Please enter a name to create a new list.");
		createListLabel.setTextFill(Color.WHITE);
		
		//create clonedListLabel to take user input 
		clonedListLabel = new Label("Please enter the of the list you would like to clone.");
		clonedListLabel.setTextFill(Color.WHITE);
		
		//create displayListLabel to take user input
		displayListLabel = new Label("Please enter the name of the list you would like to display");
		displayListLabel.setTextFill(Color.WHITE);
		
		//create cloneListLabel to take user input
		cloneListLabel = new Label("Please enter a name for your clone list");
		cloneListLabel.setTextFill(Color.WHITE);
		
		//create a remove list label to take user input
		removeListLabel = new Label("Please enter the name of the list you wish to remove.");
		removeListLabel.setTextFill(Color.WHITE);
		
		//add children nodes to createListBox
		createListBox.getChildren().addAll(createListLabel,createListForm,createListButton);
		createListBox.setSpacing(5);
		
		//add children nodes to cloneListBox
		cloneListBox.getChildren().addAll(clonedListLabel,nameOfClonedListForm,cloneListLabel,nameOfCloneListForm,cloneListButton);
		cloneListBox.setSpacing(5);
		
		//add children nodes to displayListBox
		displayListBox.getChildren().addAll(displayListLabel,displayListForm,displayListButton);
		displayListBox.setSpacing(5);
		
		//add children nodes to remove box
		removeBox.getChildren().addAll(removeListLabel,removeListForm,removeListButton);
		removeBox.setSpacing(5);
		
		//add table node to tableBox
		tableBox.getChildren().add(table);
		
		//column 1 set up 
		TableColumn<Car, String> column1 = new TableColumn<>("Car Make");
		column1.setCellValueFactory(new PropertyValueFactory<>("carMake"));
		column1.setMinWidth(150);

		//column 2 set up
		TableColumn<Car, String> column2 = new TableColumn<>("Car Model");
		column2.setCellValueFactory(new PropertyValueFactory<>("carModel"));
		column2.setMinWidth(150);
		  
		//column 3 set up
		TableColumn<Car, String> column3 = new TableColumn<>("Car Color");
		column3.setCellValueFactory(new PropertyValueFactory<>("carColor"));
		column3.setMinWidth(150);
		
		//column 4 set up
		TableColumn<Car, Integer> column4 = new TableColumn<>("Make and Model Year");
		column4.setCellValueFactory(new PropertyValueFactory<>("makeAndModelYear"));
		column4.setMinWidth(150);
		
		//column 5 set up
		TableColumn<Car, Integer> column5 = new TableColumn<>("Car MPG");
		column5.setCellValueFactory(new PropertyValueFactory<>("mpg"));
		column5.setMinWidth(150);
		
		//column 6 set up
		TableColumn<Car, String> column6 = new TableColumn<>("License Plate Information"); 
		column6.setCellValueFactory(new PropertyValueFactory<>("licensePlate"));
		column6.setMinWidth(200);
		  
		//add columns 1-6 to table
		table.getColumns().addAll(column1,column2,column3,column4,column5,column6);
		
		//add VBoxes to boxHolderPane and modify layout
		boxHolderPane.getChildren().addAll(cloneListBox,createListBox,displayListBox,removeBox,buttonHolder);
		boxHolderPane.setMargin(createListBox, new Insets(60,0,0,0));
		boxHolderPane.setMargin(cloneListBox, new Insets(60,0,0,0));
		boxHolderPane.setMargin(displayListBox, new Insets(60,0,0,0));
		boxHolderPane.setMargin(buttonHolder, new Insets(80,0,0,0));
		boxHolderPane.setMargin(removeBox, new Insets(60,0,0,0));
		
		//establish scene 4 border pane and add image to background
		scene4Layout = new BorderPane();
		scene4Layout.getChildren().add(imageView);
		
		//add the rest of the boxes to border pane 
		scene4Layout.setCenter(tableBox);
		scene4Layout.setTop(boxHolderPane);
		scene4Layout.setMargin(tableBox, new Insets(60,50,40,50));
		
		//add scene 4 layout to scene 4
		scene4 = new Scene(scene4Layout,1400,1000);
	}
	
	
	/**
	 * Method 'getRemoveListButton' returns access to removeListButton
	 * 
	 * @return: returnListButton
	 */
	public Button getRemoveListButton() {
		return removeListButton;
	}


	/**
	 * Method 'getRemoveListForm'returns access to the removeListForm
	 * 
	 * @return: removeListForm
	 */
	public TextField getRemoveListForm() {
		return removeListForm;
	}

	/**
	 * Method 'getButtonHolder' returns access to button holder VBox
	 * 
	 * @return: buttonHolder
	 */
	public VBox getButtonHolder() {
		return buttonHolder;
	}

	/**
	 * Method 'getCreateListBox' returns access to create list VBox
	 * 
	 * @return: createListBox
	 */
	public VBox getCreateListBox() {
		return createListBox;
	}
	
	/**
	 * Method 'getCloneListBox' returns access to clone list VBox
	 * 
	 * @return: cloneListBox
	 */
	public VBox getCloneListBox() {
		return cloneListBox;
	}
	
	/**
	 * Method 'getDisplayListBox' returns access to display list VBox
	 * 
	 * @return: displayListBox
	 */
	public VBox getDisplayListBox() {
		return displayListBox;
	}
	
	/**
	 * Method 'setNameOfClonedListForm' modifies cloned list form
	 * 
	 * @param: nameOfClonedListForm
	 */
	public void setNameOfClonedListForm(TextField nameOfClonedListForm) {
		this.nameOfClonedListForm = nameOfClonedListForm;
	}


	/**
	 * Method 'getNamedOfClonedListForm' returns access of cloned list form
	 * 
	 * @return: nameOfClonedListForm
	 */
	public TextField getNameOfClonedListForm() {
		return nameOfClonedListForm;
	}


	/**
	 * Method 'getNameOfCloneListForm' returns access to clone list form
	 * 
	 * @return: nameOfCloneListForm
	 */
	public TextField getNameOfCloneListForm() {
		return nameOfCloneListForm;
	}


	/**
	 * 'getScene4Layout' accesses the
	 * 	private instance variable scene4Layout
	 * 
	 * @return: scene4Layout
	 */
	public BorderPane getScene4Layout() {
		return scene4Layout;
	}


	/**
	 * 'getSubmitButton' accesses the
	 * 	private instance variable submitButton
	 * 
	 * @return: submitButton
	 */
	public Button getRefreshButton() {
		return refreshButton;
	}


	/**
	 * 'getReturnButton' accesses the
	 * 	private instance variable returnButton
	 * 
	 * @return: returnButton
	 */
	public Button getReturnButton() {
		return returnButton;
	}

	/**
	 * 'getScene4' accesses the
	 * 	private instance variable scene4
	 * 
	 * @return: scene4
	 */
	public Scene getScene4() {
		return scene4;
	}


	/**
	 * 'getTable' accesses the
	 * 	private instance variable table
	 * 
	 * @return: table
	 */
	public TableView<Car> getTable() {
		return table;
	}
	
	/**
	 * Method 'getCreateListButton' returns access to createListButton
	 * 
	 * @return: createListButton
	 */
	public Button getCreateListButton() {
		return createListButton;
	}

	/**
	 * Method 'getCloneListButton' returns access to cloneListButton
	 * 
	 * @return: cloneListButton
	 */
	public Button getCloneListButton() {
		return cloneListButton;
	}

	/**
	 * Method 'getDisplayListButton' returns access to displayListButton
	 * 
	 * @return: displayListButton
	 */
	public Button getDisplayListButton() {
		return displayListButton;
	}

	/**
	 * Method 'getCreateListButton' returns access to createListButton
	 * 
	 * @return: createListButton
	 */
	public TextField getCreateListForm() {
		return createListForm;
	}

	/**
	 * Method 'getDisplayListForm' returns access to the display list form
	 * 
	 * @return: displayListForm
	 */
	public TextField getDisplayListForm() {
		return displayListForm;
	}

	
}
