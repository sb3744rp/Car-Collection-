/**
 * 
 * 'Scene5' JavaFx Class contains a specified layout for Scene 5 of the 'Main' JavaFx Class.
 * 	The class allows a user to enter a search key into a text field and retrieve a specific
 * 	car in the collection.
 * 
 * Source of borrowed code: --same resources as scene 3 and scene 2--
 *  
 *  URL: https://www.geeksforgeeks.org/javafx-textfield/ 
 * 
 * 
 * 
 * @author: Jon Prendergast
 * @since: 06/10/2019
 * @version: 1.0
 * 
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Scene5 {
	
	Button submitButton;
	Button returnButton;
	VBox scene5Layout;
	BorderPane holdsScene;
	Scene scene5;
	TextField field;
	Text title;
	Label label;
	Image backgroundImage;
	ImageView background;
	
	public Scene5() throws FileNotFoundException {
		//create VBox for scene 5 layout
		scene5Layout = new VBox();
		
		holdsScene = new BorderPane();
		
		//Setting size for the pane  
	    holdsScene.setMinSize(400, 200);        	
		
		//title for car customization screen
		title = new Text("Choose a Car for Customization");
		title.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
		title.setFill(Color.WHITE); 
		title.setStroke(Color.BLACK);
		
		//craete and modify label 
		label = new Label("Please enter car plate info below...");
		label.setTextFill(Color.WHITE);
       
		//create background image for scene 5
		backgroundImage = new Image(new FileInputStream((".\\bin\\application\\car_garage.jpeg")));
		background = new ImageView(backgroundImage);
		
		//create a submit button used to find a given car 
		submitButton = new Button("Find Car");
		
		//create a transition button that returns the user to scene 1
		returnButton = new Button("Return To Main Menu");
		
		//create a textfield to take user input 
		field = new TextField();
		
		scene5Layout.getChildren().addAll(label,field,submitButton,returnButton);
		scene5Layout.setMaxWidth(300);
		scene5Layout.setAlignment(Pos.CENTER);
		
		holdsScene.getChildren().add(background);
		
		holdsScene.setCenter(scene5Layout);
		holdsScene.setTop(title);
		holdsScene.setMargin(scene5Layout, new Insets(0,100,100,100));
		holdsScene.setAlignment(title, Pos.CENTER);
		holdsScene.setMargin(title, new Insets(100,0,0,0));
		
		//add scene 5 layout to Scene 5
		scene5 = new Scene(holdsScene,500,500);
		
	}

	/**
	 * Method 'getHoldsScene' returns access to scene 5 border pane
	 * 
	 * @return: holdsScene
	 */
	public BorderPane getHoldsScene() {
		return holdsScene;
	}

	/**
	 * 'getSubmitButton' method accesses the
	 *  private submitButton instance variable
	 * 
	 * @return: submitButton
	 */
	public Button getSubmitButton() {
		return submitButton;
	}
	
	
	/**
	 * 'getReturnButton' method accesses the
	 *  private returnButton instance variable
	 * 
	 * @return: returnButton
	 */
	public Button getReturnButton() {
		return returnButton;
	}

	/**
	 * 'getScene5Layout' method accesses the
	 *  private scene5Layout instance variable
	 * 
	 * @return: scene5Layout
	 */
	public VBox getScene5Layout() {
		return scene5Layout;
	}

	/**
	 * 'getScene5' method accesses the
	 *  private scene5 instance variable
	 * 
	 * @return: scene5
	 */
	public Scene getScene5() {
		return scene5;
	}

	/**
	 * 'getField' method accesses the
	 *  private field instance variable
	 * 
	 * @return: field
	 */
	public TextField getField() {
		return field;
	}

}
