/**
 * 'Scene3' JavaFx class holds the layout information for Scene 3, which allows the user to 
 *  remove a car from the collection using the car's license plate information. 
 *  
 *  
 *  Source of borrowed code:
 *  URL:  https://www.geeksforgeeks.org/javafx-textfield/ -- same resource as scene 2
 *  URL: https://www.programcreek.com/java-api-examples/?api=javafx.scene.layout.BackgroundFill
 *  
 * 
 * @author: Jon Prendergast
 * @since: 06/10/2019
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Scene3 {
	
	VBox scene3Layout;
	BorderPane scene3LayoutHolder;
	Button removalSubmitButton, returnButton;
	Scene scene3;
	TextField removalForm;
	Image image;
	ImageView imageView;
	Text label_Car_Removal;

	
	public Scene3() throws FileNotFoundException{
		
		//create borderpane to hold layout
		scene3LayoutHolder = new BorderPane();
		
		//create VBox for scene 3 layout
		scene3Layout = new VBox();
		scene3Layout.setSpacing(5);
		
		//import image from file stream
		image = new Image(new FileInputStream(".\\bin\\application\\BMW.png"));
		
		//create imageview to hold image for background
		imageView = new ImageView(image);
				
		//Form label for scene 3 car removal
		label_Car_Removal = new Text("Enter license plate information for the car you wish to remove.");
		label_Car_Removal.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
	    label_Car_Removal.setFill(Color.WHITE); 
	    label_Car_Removal.setStroke(Color.BLACK);

		//create text 'removalForm' field for user input
		removalForm = new TextField();
				
		//create submit button for removal and return button for transition back to scene 1 
		removalSubmitButton = new Button("Execute removal");
		returnButton = new Button("return to main menu");
				
		//add children nodes to scene 3 layout
		//add layout to scene 3
		scene3Layout.getChildren().addAll(label_Car_Removal,removalForm,removalSubmitButton,returnButton);
		scene3Layout.setMaxWidth(300);
		scene3Layout.setAlignment(Pos.CENTER_LEFT);
		
		//set background color of scene3 and add backgroumd image
		scene3LayoutHolder.setBackground(new Background(new BackgroundFill(Color.BLACK, new CornerRadii(0), Insets.EMPTY)));
		scene3LayoutHolder.getChildren().add(imageView);
		scene3LayoutHolder.setTop(scene3Layout);
		
		scene3 = new Scene(scene3LayoutHolder,800,500);
	}


	/**
	 * 'getScene3Layout' method accesses the
	 * 	private scene3Layout instance variable
	 * 
	 * @return
	 */
	public VBox getScene3Layout() {
		return scene3Layout;
	}
	
	/**
	 * 'getSubmitButton' method accesses the
	 * 	private removalSubmitButton instance variable
	 * 
	 * @return: removalSubmitButton
	 */
	public Button getSubmitButton() {
		return removalSubmitButton;
	}

	/**
	 * 'getScene3' method accesses the
	 * 	private scene3 instance variable
	 * 
	 * @return: scene3
	 */
	public Scene getScene3() {
		return scene3;
	}

	/**
	 * 'getRemovalSubmitButton' method accesses the
	 * 	private removalSubmitButton instance variable
	 * 
	 * @return: removalSubmitButton
	 */
	public Button getRemovalSubmitButton() {
		return removalSubmitButton;
	}

	/**
	 * 'getRemovalForm' method accesses the
	 * 	private removalForm instance variable
	 * 
	 * @return: removalForm
	 */
	public TextField getRemovalForm() {
		return removalForm;
	}

	/**
	 * 'getReturnButton' method accesses the
	 * 	private returnButton instance variable
	 * 
	 * @return: returnButton
	 */
	public Button getReturnButton() {
		return returnButton;
	}
}
