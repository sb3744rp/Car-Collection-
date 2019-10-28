/**
 * 'AlertBox' JavaFx Class contains a predefined layout for AlertBox instances in the GUI
 * 'AlertBox' allows the program to continue when user inadvertently causes an error at some point in the 
 *  application 
 *  
 *  Source of borrowed code: 
 *  
 *  YouTube Tutorial: https://www.youtube.com/watch?v=SpL3EToqaXA&list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG&index=5
 *  GitHub: https://github.com/buckyroberts/Source-Code-from-Tutorials/blob/master/JavaFX/005_creatingAlertBoxes/AlertBox.java
 * 
 * 
 * @author: Jon Prendergast
 * @since: 06/12/2019
 * @version: 1.0 
 */
package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

	public static void display(String title, String message) {
		Stage window = new Stage();
		Scene scene;
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(300);
		window.setMinHeight(300);
		
		Label label = new Label();
		label.setText(message);
		
		Button closeButton = new Button("Close Window");
		closeButton.setOnAction(e->window.close());
		
		VBox layout = new VBox();
		layout.getChildren().addAll(label,closeButton);
		layout.setAlignment(Pos.CENTER);
		
		scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();	
	}
}



