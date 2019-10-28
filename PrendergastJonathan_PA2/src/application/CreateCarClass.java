/**
 * 
 * 'Scene2' JavaFx Class holds layout information for Scene 2, which is used in the 'Main' Class. 
 * 'Scene2' allows the user to enter new car information into TextFields. The information provided
 *  by the user creates new car instances which are then added to the car collection.
 *  
 *  Source of borrowed code: 
 *  
 *  URL: https://www.geeksforgeeks.org/javafx-textfield/ 
 * 
 *  @author: Jon Prendergast
 *  @since: 06/10/2019
 *  @version: 1.0
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class CreateCarClass {
	private BorderPane scene2Layout;
	private VBox chooseListBox, carSpecsBox,logoBox1,logoBox2;
	private Scene scene2;
	private Button submitButton, returnButton, selectCollectionButton;
	private TextField form, form2, form3, form4, form5, form6, form7;
	private Label labelCarMake, labelCarModel, labelCarColor, labelCarYear, 
			labelCarMPG, labelCarPlateNumber,chooseListToUseLabel;
	private Image image,image2,image3;
	
	
	/**
	 * 'Scene2' constructor sets up Scene 2 layout and organization.
	 * @throws FileNotFoundException 
	 */
	public CreateCarClass() throws FileNotFoundException {
		
		//create a VBox for scene 2 layout
		scene2Layout = new BorderPane();
		
		//create carSpecs VBox and set alignment of nodes
		carSpecsBox = new VBox();
		carSpecsBox.setAlignment(Pos.BASELINE_CENTER);
		carSpecsBox.setSpacing(5);
		scene2Layout.setMargin(carSpecsBox, new Insets(80,0,0,0));
		
		//create chooseListBox and set alignment of nodes
		chooseListBox = new VBox();
		chooseListBox.setAlignment(Pos.BASELINE_CENTER);
		
		//create logo boxes
		logoBox1 = new VBox();
		logoBox2 = new VBox();
		
		//create buttons for submitting car info and returning to main menu(scene 1)
		submitButton = new Button("Submit");
		returnButton = new Button("Return to main menu");
		selectCollectionButton = new Button("Use this Collection");
		
		//create labels that guide the user on acceptable input for each textfield used in scene 2
		labelCarMake = new Label("Enter Car Make...(E.g. Ford, Chevrolet, Toyota, Etc.)");
		labelCarMake.setTextFill(Color.WHITE); 
	  
		labelCarModel = new Label("Enter Car Model...(E.g. Mustang, Corvette, Prius)");
		labelCarModel.setTextFill(Color.WHITE);
	
		labelCarColor = new Label("Enter Car Color...(E.g. Blue, Maroon, Purple, Etc.)");
		labelCarColor.setTextFill(Color.WHITE);

		labelCarYear = new Label("Enter Car Year...(Year must be between 1940 and 2019)");
		labelCarYear.setTextFill(Color.WHITE);

		labelCarMPG = new Label("Enter Car Miles per gallon...(can be any integer between 5 and 99)");
		labelCarMPG.setTextFill(Color.WHITE);

		labelCarPlateNumber = new Label("Enter license plate information...(used as search key)");
		labelCarPlateNumber.setTextFill(Color.WHITE);

		chooseListToUseLabel = new Label("Enter the name of the list you wish to add Cars to here...");
		chooseListToUseLabel.setTextFill(Color.WHITE);

		
		//create textfield instances used for user input
		form = new TextField();
		form2 = new TextField();
		form3 = new TextField();
		form4 = new TextField();
		form5 = new TextField();
		form6 = new TextField();
		form7 = new TextField();
		
		//add children nodes to carSpecs box
		carSpecsBox.getChildren().addAll(labelCarMake,form,
				labelCarModel,form2,
				labelCarColor,form3,
				labelCarYear,form4,
				labelCarMPG,form5,
				labelCarPlateNumber,form6,
				submitButton,returnButton);
		
		carSpecsBox.setMaxWidth(500);
		
		//add children nodes to chooseList box
		chooseListBox.getChildren().addAll(chooseListToUseLabel,form7,selectCollectionButton);
		
		
		//images for side panes
		//implement image for background photo
		image = new Image(new FileInputStream((".\\bin\\application\\logo1.png")));
		ImageView imageView1 = new ImageView(image);
			
		image2 = new Image(new FileInputStream((".\\bin\\application\\logo2.png")));
		ImageView imageView2 = new ImageView(image2);
		
		image3 = new Image(new FileInputStream((".\\bin\\application\\addScene.png")));
		ImageView imageView3 = new ImageView(image3);
		
		imageView1.setFitWidth(150);
		imageView1.setFitHeight(600);
		
		imageView2.setFitWidth(150);
		imageView2.setFitHeight(600);
		
		scene2Layout.getChildren().add(imageView3);
		
		scene2Layout.setCenter(carSpecsBox);
		scene2Layout.setRight(imageView1);
		scene2Layout.setLeft(imageView2);
		scene2Layout.setBottom(chooseListBox);
		
		//add scene2Layout to scene2 
		scene2 = new Scene(scene2Layout,700,700);	
	}
	
	/**
	 * 'returnButton' method accesses 
	 * 	private returnButton instance variable
	 * 
	 * @return: returnButton
	 */
	public Button getReturnButton() {
		return returnButton;
	}
	
	/**
	 * 'getScene2Layout' method accesses 
	 * 	private scene2Layout instance variable
	 * 
	 * @return: scene2Layout
	 */
	public BorderPane getScene2Layout() {
		return scene2Layout;
	}

	/**
	 * 'getScene2' method accesses 
	 * 	private scene2 instance variable
	 * 
	 * @return: scene2
	 */
	public Scene getScene2() {
		return scene2;
	}
	
	/**
	 * Method 'getSelectCollectionButton' returns access to select collection button
	 * 
	 * @return: selectCollectionButton
	 */
	public Button getSelectCollectionButton() {
		return selectCollectionButton;
	}

	/**
	 * Method 'getForm7' returns access to form 7 textfield 
	 * 
	 * @return: form7
	 */
	public TextField getForm7() {
		return form7;
	}

	/**
	 * 'submitButton' method accesses the 
	 * 	private submitButton instance variable
	 * 
	 * @return: submitButton
	 */
	public Button getSubmitButton() {
		return submitButton;
	}

	/**
	 * 'getForm' method accesses the 
	 * 	private form instance variable
	 * 
	 * @return: form
	 */
	public TextField getForm() {
		return form;
	}
	
	/**
	 * 'getForm2' method accesses the 
	 * 	private form2 instance variable
	 * 
	 * @return: form2
	 */
	public TextField getForm2() {
		return form2;
	}
	
	/**
	 * 'getForm3' method accesses the 
	 * 	private form3 instance variable
	 * 
	 * @return: form3
	 */
	public TextField getForm3() {
		return form3;
	}

	/**
	 * 'getForm4' method accesses the 
	 * 	private form4 instance variable
	 * 
	 * @return: form4
	 */
	public TextField getForm4() {
		return form4;
	}

	/**
	 * 'getForm5' method accesses the 
	 * 	private form5 instance variable
	 * 
	 * @return: form5
	 */
	public TextField getForm5() {
		return form5;
	}

	/**
	 * 'getForm6' method accesses the 
	 * 	private form6 instance variable
	 * 
	 * @return: form6
	 */
	public TextField getForm6() {
		return form6;
	}
}
