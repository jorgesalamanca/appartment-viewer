import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.TextField;
import javafx.scene.control.MenuItem;
import java.util.List;
import java.util.ArrayList;

/**
 * This is the main controller of the program. 
 * 
 * @author Jorge A. Salamanca S. 
 * @version 1.0 (Last edited: November 28th, 2014)
 */
public class FlatViewer
{
   // Link the corresponding variables to the GUI
   
   // Here we have the main display, the map display and the frontal arrow, which will change to red
   // when it is not possible to go forward
   @FXML
   private ImageView display, forwardArrow, mapDisplay;
   
   // The variables for holding the items in different positions and locations in the map. 
   // We have three positions: Original location, item panel and living room.
   @FXML
   private ImageView trumpet, ukulele, djembe, tambourine;
   @FXML
   private ImageView trumpetPanel, ukulelePanel, djembePanel, tambourinePanel; 
   @FXML
   private ImageView trumpetLR, ukuleleLR, djembeLR, tambourineLR;
   
   // The menu items, the ones who call a specified method when pressed.
   @FXML
   private MenuItem showMap, hideMap, whereAm, grab, drop, whatItems;
   
   // A TextField for displaying messages.
   @FXML
   private TextField message;
   
   // Declare the current run of the navigation (game) and a current image to display
   // Declare the current run of the navigation (game) and a current image to display.
   private Game game;
   private Image currentImage;
   
   // Make a list containing the existing items in the game.
   private ArrayList<Item> itemList;
   
   // Variable for holding the current orientation and location
   String currentOrientation;
   Location currentLocation;
   
   // Drop location of the items
   String dropURL = "sourcePics/5-n.JPG";
   
   //Flag useful to activate the "Drop" submenu (Item).
   boolean dropFlag = false;

    /**
     * Initialises the FlatViewer
     */
    public void Initialise(){
        // Creates a "game", a new run of the navigation
        game = new Game();
        
        // Display the first image
        currentImage = new Image("sourcePics/1-n.jpg");
        
        // Disable not yet usable menus
        hideMap.setDisable(true);
        grab.setDisable(true);
        drop.setDisable(true);
        
        //Call the function refresh display, which updates the display with almost every command.
        refreshDisplay();
    }
    
    /**
     * Method responsible of refreshing the main display everytime a change is made.
     * It also indicates if it is impossible to go forward by changing the color of the frontal arrow.
     */
    public void refreshDisplay(){
        // Sets the new image
        currentImage = game.getCurrentImage();
        display.setImage(currentImage);
        
        // Set the frontal arrow to red if its impossible to go front
        if(game.isForwardPossible()){
            forwardArrow.setImage(new Image("sourcePics/arrow.png"));
        }
        else{
            forwardArrow.setImage(new Image("sourcePics/arrow_red.png"));
        }
        
        // Check and set-up the items in the main display
        itemList = game.getItemList();
        currentOrientation = game.getOrientation();
        currentLocation = game.getLocation();
        String currentImagePath = currentLocation.getImagePath(currentOrientation);
        
        // Make sure that the items are not displayed where they shouldn't.
        trumpet.setImage(new Image("sourcePics/empty.png"));
        ukulele.setImage(new Image("sourcePics/empty.png"));
        djembe.setImage(new Image("sourcePics/empty.png"));
        tambourine.setImage(new Image("sourcePics/empty.png"));
        
        trumpetLR.setImage(new Image("sourcePics/empty.png"));
        ukuleleLR.setImage(new Image("sourcePics/empty.png"));
        djembeLR.setImage(new Image("sourcePics/empty.png"));
        tambourineLR.setImage(new Image("sourcePics/empty.png"));

        // Pre-disable these two menus unless the below conditions are met.
        grab.setDisable(true);
        drop.setDisable(true);
        
        // If we are in the item delivery location...
        if(currentImagePath==dropURL){
            // If the dropFlag is set, indicating that there's at least an item in the panel,
            // enable the drop command.
            if(dropFlag){drop.setDisable(false);}
            // Iterate through the list of items
            for(Item it : itemList){
            // If it has already been dropped, display
            if(it.dropped()){
                if(it.getItemName().equals("Trumpet")){
                            trumpetLR.setImage(new Image("sourcePics/trumpet.png"));
                        }
                        else if(it.getItemName().equals("Ukulele")){
                            ukuleleLR.setImage(new Image("sourcePics/ukulele.png"));
                        }
                        else if(it.getItemName().equals("Djembe")){
                            djembeLR.setImage(new Image("sourcePics/djembe.png"));
                        }
                        else if(it.getItemName().equals("Tambourine")){
                            tambourineLR.setImage(new Image("sourcePics/tambourine.png"));
                        }
                    }
                }
        }
        
        // Iterate again and now check if we are in the original item's location
        for(Item it : itemList){
            // If the item is not being carried or at the destination, it should be in its
            // original location
            if(it.dropped()==false){
                if(it.carried()==false){
                    if(it.getItemLocation().equals(currentImagePath)){
                        // Enable the grab command
                        grab.setDisable(false);
                        if(it.getItemName().equals("Trumpet")){
                            trumpet.setImage(new Image("sourcePics/trumpet.png"));
                        }
                        else if(it.getItemName().equals("Ukulele")){
                            ukulele.setImage(new Image("sourcePics/ukulele.png"));
                        }
                        else if(it.getItemName().equals("Djembe")){
                            djembe.setImage(new Image("sourcePics/djembe.png"));
                        }
                        else if(it.getItemName().equals("Tambourine")){
                            tambourine.setImage(new Image("sourcePics/tambourine.png"));
                        }
                    }
                }
                // If the item is being carried, display in the panel
                else{
                    if(it.getItemName().equals("Trumpet")){
                            trumpetPanel.setImage(new Image("sourcePics/trumpet.png"));
                        }
                        else if(it.getItemName().equals("Ukulele")){
                            ukulelePanel.setImage(new Image("sourcePics/ukulele.png"));
                        }
                        else if(it.getItemName().equals("Djembe")){
                            djembePanel.setImage(new Image("sourcePics/djembe.png"));
                        }
                        else if(it.getItemName().equals("Tambourine")){
                            tambourinePanel.setImage(new Image("sourcePics/tambourine.png"));
                        }               
                }
            }
            
            // If the item has been dropped, it should be in the living room 
            // Check for every item and display
            else{
                if(currentImagePath.equals(dropURL))
                {
                    if(it.getItemName().equals("Trumpet")){
                            trumpetLR.setImage(new Image("sourcePics/trumpet.png"));
                        }
                        else if(it.getItemName().equals("Ukulele")){
                            ukuleleLR.setImage(new Image("sourcePics/ukulele.png"));
                        }
                        else if(it.getItemName().equals("Djembe")){
                            djembeLR.setImage(new Image("sourcePics/djembe.png"));
                        }
                        else if(it.getItemName().equals("Tambourine")){
                            tambourineLR.setImage(new Image("sourcePics/tambourine.png"));
                        }  
                }
            }
        }
        
        // Clear the message box
        message.setText(" ");
    }
    
    /**
     * Moves the navigator one position forward
     */
    public void moveForward(ActionEvent event){
        game.changeLocation();
        refreshDisplay();
    }

    /**
     * Allows the user to grab an item.
     */
    public void grabM(ActionEvent event){
        for(Item it : itemList){
            if(it.getItemLocation().equals(currentLocation.getImagePath(currentOrientation))){
                it.pickUp();
            }
        }
        // Set the dropFlag so the next time we are at the delivery location the item can be dropped.
        dropFlag = true;
        refreshDisplay();
    }
    
    /**
     * Allows the user to drop an item in the delivery location.
     */
    public void dropM(ActionEvent event){
        // Check which items are being carried, and drop.
        for(Item it : itemList){
            if(it.carried()){
                it.dropItem();
                if(it.getItemName().equals("Trumpet")){
                    trumpetPanel.setImage(new Image("sourcePics/empty.png"));
                    trumpetLR.setImage(new Image("sourcePics/trumpet.png"));
                }
                else if(it.getItemName().equals("Ukulele")){
                    ukulelePanel.setImage(new Image("sourcePics/empty.png"));
                    ukuleleLR.setImage(new Image("sourcePics/ukulele.png"));
                }
                else if(it.getItemName().equals("Djembe")){
                    djembePanel.setImage(new Image("sourcePics/empty.png"));
                    djembeLR.setImage(new Image("sourcePics/djembe.png"));
                }
                else if(it.getItemName().equals("Tambourine")){
                    tambourinePanel.setImage(new Image("sourcePics/empty.png"));
                    tambourineLR.setImage(new Image("sourcePics/tambourine.png"));
                }
            }
        }
        // Disable the dropFlag. If we want to drop an item again, we have to pick one up first!
        dropFlag = false;
        refreshDisplay();
    }
    
    
    /**
     * Shows the user the map of the virtual world
     */
    public void showMapM(ActionEvent event){
        mapDisplay.setImage(new Image("sourcePics/flatMap.png"));
        hideMap.setDisable(false);
        showMap.setDisable(true);
    }
    
    /**
     * Hides the map of the virtual world
     */
    public void hideMapM(ActionEvent event){
        mapDisplay.setImage(new Image("sourcePics/empty.png"));
        hideMap.setDisable(true);
        showMap.setDisable(false);
    }
    
    /**
     * Prints the current location in the messagebox
     */
    public void whereAmM(ActionEvent event){
        message.setText("You are in the " + game.getLocation().getString());    
    }
    
     /**
     * Prints help for the user
     */
    public void whatItemsM(ActionEvent event){
        message.setText("Pick them up and deliver them to the living room!");    
    }
    
    
    /**
     * Changes the general orientation of the navigation by -90º
     */
    public void right(ActionEvent event){
        // Retrieve the current orientation to know where to turn
        String currentOrientation = game.getOrientation();
        // Depending on the current orientation, change to a new one
        if (currentOrientation.equals("north")){game.changeOrientation("east");}       
        else if (currentOrientation.equals("east")){game.changeOrientation("south");}        
        else if (currentOrientation.equals("south")){game.changeOrientation("west");}
        else if (currentOrientation.equals("west")){game.changeOrientation("north");}
        refreshDisplay();
    }
     
    /**
     * Changes the general orientation of the navigation by 180º
     */
    public void back(ActionEvent event){
        String currentOrientation = game.getOrientation();
        if (currentOrientation.equals("north")){game.changeOrientation("south");}       
        else if (currentOrientation.equals("east")){game.changeOrientation("west");}        
        else if (currentOrientation.equals("south")){game.changeOrientation("north");}
        else if (currentOrientation.equals("west")){game.changeOrientation("east");}
        refreshDisplay();
    }   
    
    /**
    * Changes the general orientation of the navigation by 90º
    */
    public void left(ActionEvent event){
        String currentOrientation = game.getOrientation();
        if (currentOrientation.equals("north")){game.changeOrientation("west");}       
        else if (currentOrientation.equals("east")){game.changeOrientation("north");}        
        else if (currentOrientation.equals("south")){game.changeOrientation("east");}
        else if (currentOrientation.equals("west")){game.changeOrientation("south");}
        refreshDisplay();
    }   
}
