/**
 * 
 * 'SetupScene' JavaFx Class creates a set up scene for the user to initialize a car collection 
 *  
 *  Source of borrowed code:
 *  URL: https://www.tutorialspoint.com/javafx/javafx_text.htm
 *  URL: https://www.dummies.com/programming/java/use-vbox-layout-javafx/
 *  URL: https://stackoverflow.com/questions/9738146/javafx-how-to-set-scene-background-image
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class SetupScene {
	
	VBox setupSceneLayout;
	Scene setupScene;
	TextField setUpCapacityForm, setUpCollectionNameForm;
	Button submitAndProceedButton;
	Text capacityPrompt, namePrompt, welcomeTitle;
	
	
	public SetupScene() throws FileNotFoundException {
		//create a border pane layout 
		setupSceneLayout = new VBox();
		
		//create a text field for user input 
		setUpCapacityForm = new TextField();
		setUpCapacityForm.setMaxWidth(300);
		
		//create a text field for user input
		setUpCollectionNameForm = new TextField();
		setUpCollectionNameForm.setMaxWidth(300);
		
		//create a button for submit and proceed 
		submitAndProceedButton = new Button("Submit and Proceed");
		
		//implement image for background photo
		Image image2;
		image2 = new Image(new FileInputStream((".\\bin\\application\\car2.jpg")));
		
		//creating a Text object 
	    capacityPrompt = new Text(); 
	    
	    //creating a second Text object
	    namePrompt = new Text();
	    
	    //create a welcome title
	    welcomeTitle = new Text();
	   
	    //Setting font for capacity prompt
	    capacityPrompt.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));
	    capacityPrompt.setFill(Color.BLANCHEDALMOND); 
	    capacityPrompt.setStroke(Color.BLACK);
	    capacityPrompt.setText("\n\n\n\n\nEnter car collection capacity below");
	    
	    //set up font for name prompt text
	    namePrompt.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));
	    namePrompt.setFill(Color.BLANCHEDALMOND); 
	    namePrompt.setStroke(Color.BLACK);
	    namePrompt.setText("Enter car collection name below");
	    
	    //setup welcome title for intro scene
	    welcomeTitle.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
	    welcomeTitle.setFill(Color.BLANCHEDALMOND); 
	    welcomeTitle.setStroke(Color.BLACK);
	    welcomeTitle.setText("Welcome to Car Collector");
	    
	   
	    //add image to background of border pane
	    BackgroundImage bgImg = new BackgroundImage(image2, 
	    BackgroundRepeat.NO_REPEAT,
	    BackgroundRepeat.NO_REPEAT,
	    BackgroundPosition.DEFAULT,
	    BackgroundSize.DEFAULT);
	    
	      
	    //adding nodes to setup scene layout 
		setupSceneLayout.getChildren().addAll(welcomeTitle,capacityPrompt,setUpCapacityForm,namePrompt,setUpCollectionNameForm,submitAndProceedButton);
		setupSceneLayout.setMargin(welcomeTitle, new Insets(80,100,0,100));
		
		//assign background image and spacing of nodes
		setupSceneLayout.setSpacing(10);
		setupSceneLayout.setBackground(new Background(bgImg));
		setupSceneLayout.setAlignment(Pos.TOP_CENTER);
		
		
		//add layout to set up scene
		setupScene = new Scene(setupSceneLayout,500,650);
	}
	
	public TextField getSetUpCollectionNameForm() {
		return setUpCollectionNameForm;
	}

	/**
	 * 'getSetupSceneLayout' method accesses the 
	 *  private setupSceneLayout instance variable 
	 * 
	 * @return: setupSceneLayout
	 */
	public VBox getSetupSceneLayout() {
		return setupSceneLayout;
	}

	/**
	 * 'setupScene' method accesses the 
	 *  private setupScene instance variable 
	 * 
	 * @return: setupScene
	 */
	public Scene getSetupScene() {
		return setupScene;
	}

	/**
	 * 'getSetupCapacityForm' method accesses the 
	 *  private setupCapacityForm instance variable 
	 * 
	 * @return: setupCapacityForm
	 */
	public TextField getSetupCapacityForm() {
		return setUpCapacityForm;
	}
	
	/**
	 * 'getSubmitAndProceedButton' method accesses the 
	 *  private submitAndProceed instance variable 
	 * 
	 * @return: submitAndProceedButton
	 */
	public Button getSubmitAndProceedButton() {
		return submitAndProceedButton;
	}
	
}
