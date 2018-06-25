import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

/**
 * This class is responsible of loading the GUI and creating a new game.
 * This is a virtual navigation game. 
 * The user can navigate through the rooms of a virtualised flat.
 * 
 * @author Jorge A. Salamanca S. 
 * @version 1.0 (Last edited: November 28th, 2014)
 */

public class MainNavigator extends Application
{

    public void start(Stage stage) {
		
		try {
		    // Load the GUI created with Scene Builder
			FXMLLoader fxmlLoader = new FXMLLoader();
			String viewerFxml = "FlatViewer.fxml";
			AnchorPane page = (AnchorPane) fxmlLoader.load(this.getClass().getResource(viewerFxml).openStream());
			Scene scene = new Scene(page);
			stage.setScene(scene);
			
		    // Start the Flat Viewer
		    FlatViewer viewer = (FlatViewer) fxmlLoader.getController();
		    viewer.Initialise();
			
			stage.show();
        
		} catch (IOException ex) {
		   Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
		   System.exit(1);
		}
	}
	
    public static void main(String args[]) {
        launch(args);
     	System.exit(0);
    }

}
