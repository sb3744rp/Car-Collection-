/**
 * 
 * The 'Main' Java application displays a Graphical User Interface (GUI) that allows a user to 
 * create, edit, and display a collection of cars.
 * 
 * Source of borrowed code: 
 * 
 * URL: http://tutorials.jenkov.com/javafx/imageview.html 
 * URL for car_png.: https://i.pinimg.com/736x/23/73/31/237331b166d5af16d1be5244317886bf.jpg
 * 
 * @author: Jon Prendergast 
 * @since: 06/10/2019
 * @version: 1.0	
 * 
 */

package application;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import com.sun.prism.paint.Color;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application {
	
	Stage window;
	StackPane layoutScene1;
	VBox setupSceneLayout;
	VBox layoutScene2, layoutScene3;
	
	SetupScene introSceneObject;
	static CreateCarClass secondSceneObject;
	Scene3 thirdSceneObject;
	Scene4 fourthSceneObject;
	Scene5 fifthSceneObject;
	static Text identifier,identifier2;
	
	Scene setupScene,scene1, scene2, scene3, scene4,scene5;
	
	static CarCollection holdsCurrentCollection;
	static CollectionHolder holdsAllCollections = new CollectionHolder();
	
	/**
	 * 'start' method is where the stage and associated scenes are set up for the show
	 * 
	 * @param: primaryStage
	 * @throws: FileNotFoundException
	 * 
	 */
	public void start(Stage primaryStage) throws FileNotFoundException {
		window = primaryStage;
//**************************************************************************************************************
	// Scene 1 File menu 
		
		//instantiates an object from the FileMenu Class inside the application package
		//menu references a FileMenu object that holds a predefined layout for a menu 
		FileMenu menu = new FileMenu();
		MenuBar menuBar = menu.getMenuBar();
		
		//add, remove, and display menu items are assigned references to their respective private instances
		MenuItem addCarToCollection = menu.getAddCarToCollection();
		MenuItem removeFromCarCollection = menu.getRemoveFromCarCollection();
		MenuItem displayCarCollection = menu.getDisplayCarCollection();
		MenuItem displayCarFromCollection = menu.getDisplayCarUsingPlateInfo();
		
		// transition from addCarToCollection option to scene2 object
		addCarToCollection.setOnAction(e-> window.setScene(scene2));
		
		//transition from removeFromCarCollection to scene3 object
		removeFromCarCollection.setOnAction(e-> window.setScene(scene3));
		
		//transition from displayCarCollection to scene4 object
		displayCarCollection.setOnAction(e->window.setScene(scene4));
		
		//transition from displayCarFromCollection to scene5 object
		displayCarFromCollection.setOnAction(e->window.setScene(scene5));

//**************************************************************************************************************		
		// Set up scene 
		
		//create set up scene object
		introSceneObject = new SetupScene();
		setupScene = introSceneObject.getSetupScene();
		
		//create set up scene layout
		setupSceneLayout = introSceneObject.getSetupSceneLayout();
		
		//create submit and proceed button and event action handler 
		Button submitAndProceed = introSceneObject.getSubmitAndProceedButton();
		
		//action event for submit and proceed button
		submitAndProceed.setOnAction(e->	
		{
			setupCollection(introSceneObject.getSetupCapacityForm().getText(),introSceneObject.getSetUpCollectionNameForm().getText().toLowerCase());
			
			identifier = new Text("Current Car Collection: "+introSceneObject.getSetUpCollectionNameForm().getText());
			identifier.setFill(javafx.scene.paint.Color.WHITE);
			identifier.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
			identifier.setStroke(javafx.scene.paint.Color.BLACK);
			
			secondSceneObject.getScene2Layout().setTop(identifier);
			secondSceneObject.getScene2Layout().setAlignment(identifier, Pos.CENTER);
		});
		

//**************************************************************************************************************
		// Scene 1 File Menu layout set up
		
		//set up image for main screen
		Image image;
		image = new Image(new FileInputStream(".\\bin\\application\\car.png"));
		ImageView imageView = new ImageView(image); 
		
		//instantiate BorderPane Layout for scene1		
		layoutScene1 = new StackPane();
		layoutScene1.getChildren().addAll(imageView,menuBar);
		
		//set menu bar to top of BorderPane scene1
		layoutScene1.setAlignment(menuBar,Pos.TOP_LEFT);
		
		//set up scene up with layout and dimensions
		scene1 = new Scene(layoutScene1,400,600);
//*************************************************************************************************************************
		//Scene 2 car addition scene
		
		//create scene 2 object and setup reference to Scene 2
		secondSceneObject = new CreateCarClass();
		scene2 = secondSceneObject.getScene2();
		
		//borderpane reference
		BorderPane pane = secondSceneObject.getScene2Layout();
		
		//create a submit button and return button for user navigation 
		Button scene2SubmitButton = secondSceneObject.getSubmitButton();
		Button scene2ToScene1Button = secondSceneObject.getReturnButton();
		Button scene2SwitchCollectionsButton = secondSceneObject.getSelectCollectionButton();
		
		//set on action events for buttons
		scene2SubmitButton.setOnAction(e->{
			attemptToAddCar(secondSceneObject);		
		});
		
		//action event for return to menu button from scene 2
		scene2ToScene1Button.setOnAction(e->window.setScene(scene1));
		
		//action event for select current collection button
		scene2SwitchCollectionsButton.setOnAction(e->{
			switchCollections(secondSceneObject.getForm7().getText());
		});
		
	
//*************************************************************************************************************************
		//Scene 3 car removal scene
		
		//create scene 3 object and setup a reference to scene 3 layout
		thirdSceneObject = new Scene3();
		scene3 = thirdSceneObject.getScene3();
		
		//setup removal button and return to main menu button for user navigation
		Button removalButton = thirdSceneObject.getRemovalSubmitButton();
		Button scene3ToScene1Button = thirdSceneObject.getReturnButton();
		
		//set up a two part action event that attempts to remove the car and clear the textfield form
		removalButton.setOnAction(e->
		{
			attemptToRemoveCar(thirdSceneObject.getRemovalForm().getText());
			thirdSceneObject.getRemovalForm().clear();
		}
		);
		//on action event to return to main menu 
		scene3ToScene1Button.setOnAction(e->window.setScene(scene1));

//*************************************************************************************************************************

	//Scene 4
		
		Scene4 scene_4_object = new Scene4();
		scene4 = scene_4_object.getScene4();
		
		//add tables from scene4 class to scene
		TableView<Car> table = scene_4_object.getTable();
		
		//add buttons from scene 4
		Button displayCurrentCarCollectionButton = scene_4_object.getRefreshButton();
		Button createCarCollectionButton = scene_4_object.getCreateListButton();
		Button displaySpecifiedCarCollectionButton = scene_4_object.getDisplayListButton();
		Button cloneListButton = scene_4_object.getCloneListButton();
		Button removeListButton = scene_4_object.getRemoveListButton();
		Button scene4ToScene1Button = scene_4_object.getReturnButton();
			
		//holds action event for 'refresh button' from scene 4 class
		displayCurrentCarCollectionButton.setOnAction(e->
		{
			table.setItems(getCarsForDisplay());
		});
		
		//holds action event for 'create list' button from scene 4 class
		createCarCollectionButton.setOnAction(e->
		{
			attemptToAddCollectionToList(scene_4_object.getCreateListForm().getText());
			scene_4_object.getCreateListForm().clear();
		});
		
		//holds action event for displaying specific collection from scene 4 class
		displaySpecifiedCarCollectionButton.setOnAction(e->{
			switchCollections(scene_4_object.getDisplayListForm().getText());
	
			table.setItems(getCarsForDisplay());
			scene_4_object.getDisplayListForm().clear();
		});
		
		// holds action event for clone list button from scene 4 class
		cloneListButton.setOnAction(e->{
			switchCollections(scene_4_object.getNameOfClonedListForm().getText());
			
			CarCollection temp = holdsCurrentCollection.clone();
			
			try {
				if(scene_4_object.getNameOfCloneListForm().getText().trim().length()==0)throw new Exception();
				temp.setCollectionName(scene_4_object.getNameOfCloneListForm().getText());
				holdsAllCollections.add(temp);
			}
			
			catch (Exception a) {
				AlertBox.display(" ", "Invalid entry, please try again.");

			}
			scene_4_object.getNameOfCloneListForm().clear();
			scene_4_object.getNameOfClonedListForm().clear();
		});
		
		//holds action event for remove list button from scene 4 class
		removeListButton.setOnAction(e->{
			try
			{
				if(holdsAllCollections.remove(scene_4_object.getRemoveListForm().getText())==false) throw new Exception();
				else AlertBox.display(" ", "List Removed!");
			} 
				
			catch (Exception e1)
			{
				AlertBox.display("Error", "List not found, please try again.");
				scene_4_object.getRemoveListForm().clear();
			}
		});
		//holds action event for scene transition from scene 4 class
		scene4ToScene1Button.setOnAction(e->window.setScene(scene1));
		
//*************************************************************************************************************************
	//Scene5
		
		Scene5 fifthSceneObject = new Scene5();
		scene5 = fifthSceneObject.getScene5();
	
		Button findCarToDisplay = fifthSceneObject.getSubmitButton();
		Button scene5ToScene1Button = fifthSceneObject.getReturnButton();
		
		//holds action event for finding specified car for editing
		findCarToDisplay.setOnAction(e->{
			if(!(findCarInCollectionAndDisplayIt(secondSceneObject,fifthSceneObject.getField().getText())))
				window.setScene(scene5);
			else
				window.setScene(scene2);
		});
		
		scene5ToScene1Button.setOnAction(e->window.setScene(scene1));
		
	
//*************************************************************************************************************************
		//determine which scene will start up the show 
		window.setScene(setupScene);
		window.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * 'attemptToAddCar' method attempts to create a new car instance from user input, and add the car to the collection
	 * 
	 * @param: collection
	 * @param: scene2Reference
	 * @see: add() method from CarCollection Class
	 * @exception: NumberFormatException
	 * @exception: IllegalArgumentException (Car constructor)
	 *
	 */
	public void attemptToAddCar(CreateCarClass scene2Reference) {
		
		try 
		{
			if(holdsCurrentCollection.hasDuplicatePlates(scene2Reference.getForm6().getText())==0)throw new Exception();
			
			int year = Integer.parseInt(scene2Reference.getForm4().getText());//ensuring that year is only integer
			int mpg = Integer.parseInt(scene2Reference.getForm5().getText());//ensuring that mpg does not contain MPG along with integer 
			
			//uses collection.add to create a new car and add it to the collection
			holdsCurrentCollection.add(new Car(scene2Reference.getForm().getText(),
					scene2Reference.getForm2().getText(),
					scene2Reference.getForm3().getText(),
					year,
					mpg,
					scene2Reference.getForm6().getText()));
			
			//clear forms if submission is successful
			scene2Reference.getForm().clear();
			scene2Reference.getForm2().clear();
			scene2Reference.getForm3().clear();
			scene2Reference.getForm4().clear();
			scene2Reference.getForm5().clear();
			scene2Reference.getForm6().clear();
		}
		
		catch(Exception a)
		{
			//alert user of improper input
			AlertBox.display("Error", "Invalid information was entered into one or more of the fields. Please review the information"
					+ " you entered and try again.");
		}
	}
	
	/**
	 * 'attemptToRemoveCar' method attempts to remove a car from a vehicle collection
	 * 
	 * @param: target
	 * @see: remove() method from CarCollection Class
	 * @exception: IllegalArgumentException
	 */
	public void attemptToRemoveCar(String target)
	{
		try 
		{
			if(holdsCurrentCollection.remove(target)==false)
				throw new IllegalArgumentException();//will go to alert warning if remove fails
			
			AlertBox.display("Success","Search key removed!"); //prompts user of successful removal if remove returns true
		}
		catch(Exception a) 
		{
			AlertBox.display("Warning","Search key not found. List is either empty, or search key does not exist.");
		}
	}
	
	
	/**
	 * 'getCars' returns an observable list of Car objects to be added to a JavaFx table for display
	 * 
	 * 
	 * @see getCarCollection from CarCollection Class
	 * @return: list
	 * @exception: NullPointerException
	 * 
	 */
	public ObservableList<Car> getCarsForDisplay()
	{
		ObservableList<Car> list = FXCollections.observableArrayList();
		holdsCurrentCollection.resetCurrentIndex(); //resets collection index so that refresh button starts at element 0
	try 
	{
		while(holdsCurrentCollection.hasNext()) 
		{
			Car holdsCurrentCar = holdsCurrentCollection.next();
			
			list.add(new Car(
					holdsCurrentCar.getCarMake(),
					holdsCurrentCar.getCarModel(),
					holdsCurrentCar.getCarColor(),
					holdsCurrentCar.getMakeAndModelYear(),
					holdsCurrentCar.getMpg(),
					holdsCurrentCar.getLicensePlate()));
		}
	}
	
	catch(Exception a) 
		{
			window.setScene(scene4);
		}
	return list;
	}
	
	/**
	 * 'findCarInCollection' method finds a Car in the collection using plate information provided. If
	 *  the Car is found, text fields are assigned the Car's values for the user to edit.
	 * 
	 * @param: obj
	 * @param: target
	 * @see: getCarCollection method from CarCollection Class 
	 * @return: true/false
	 */
	public boolean findCarInCollectionAndDisplayIt(CreateCarClass scene2Reference,String target) {
		
		
		try 
		{
			int indexOfCar;
			indexOfCar = holdsCurrentCollection.getCarIndexInCollection(target);
			
			scene2Reference.getForm().setText(holdsCurrentCollection.getCarCollection()[indexOfCar].getCarMake());
			scene2Reference.getForm2().setText(holdsCurrentCollection.getCarCollection()[indexOfCar].getCarModel());
			scene2Reference.getForm3().setText(holdsCurrentCollection.getCarCollection()[indexOfCar].getCarColor());
			scene2Reference.getForm4().setText(""+holdsCurrentCollection.getCarCollection()[indexOfCar].getMakeAndModelYear());
			scene2Reference.getForm5().setText(""+holdsCurrentCollection.getCarCollection()[indexOfCar].getMpg());
			scene2Reference.getForm6().setText(holdsCurrentCollection.getCarCollection()[indexOfCar].getLicensePlate());
			
			return true;
		}
		
		catch(Exception a) 
			{
				AlertBox.display("Error", "Unable to find specified car.");
				window.setScene(scene5);
				return false;	
			}
	}	
	
	
	/**
	 * 'setupCollection' method allows the user to setup the initial capacity for the CarCollection
	 * 
	 * @param: input
	 */
	public void setupCollection(String capacityInput, String nameInput) {		
		try 
		{
			int capacity = Integer.parseInt(capacityInput);
			
			holdsAllCollections.add(new CarCollection(capacity,nameInput.toLowerCase()));
			holdsCurrentCollection = holdsAllCollections.getCollectionHolder()[0];
			window.setScene(scene1);
			
		}
		catch(Exception a) 
		{
			AlertBox.display("Error", "Please enter a valid capacity and list name");
		}	
	}	
	
	/**
	 * Method 'switchCollections' allows the user to switch between lists in the collection holder to allow the user to add,
	 * remove, and display vehicles based on car collection list preferences.
	 * 
	 * @param: newCollectionName
	 */
	public void switchCollections(String newCollectionName) {
		try {
			int indexOfDesiredCollection;
			indexOfDesiredCollection = holdsAllCollections.getCarCollectionIndex(newCollectionName);
			
			holdsCurrentCollection = holdsAllCollections.getCollectionHolder()[indexOfDesiredCollection];
			
			//switches title of second scene to fit show user current list being added to
			secondSceneObject.getScene2Layout().getChildren().removeAll(identifier);
			identifier = new Text("Current Car Collection being used: "+holdsCurrentCollection.getCollectionName());
			secondSceneObject.getScene2Layout().getChildren().add(identifier);
		}
		catch(Exception e) {
			AlertBox.display("Error", "Collection not found. Please enter a valid collection");
		}
		
	}
	
/**
 * Method 'attemptToAddCollectionToList' enters a new car collection to the collection holder when given
 * a collection name as a string argument 
 * 
 * @param: input
 * @throws: exception
 */
	public void attemptToAddCollectionToList(String input) {	
		try 
		{	
			//uses collection.add to create a new car and add it to the collection
			if(holdsAllCollections.hasDuplicateList(input.toLowerCase())== 0)throw new Exception();
			else if(input.trim().length()==0)throw new Exception();
			else holdsAllCollections.add(new CarCollection(10,input.toLowerCase()));
		}
		
		catch(Exception a)
		{
			//alert user of improper input
			AlertBox.display("Error", "Invalid information was entered. Please review the information"
					+ " you entered and try again.");
		}
	}
}
