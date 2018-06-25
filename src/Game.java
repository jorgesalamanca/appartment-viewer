import javafx.scene.image.Image;
import java.util.List;
import java.util.ArrayList;

/**
 * This class is responsible of managing the current conditions of the game.
 * 
 * @author Jorge A. Salamanca S. 
 * @version 1.0 (Last edited: November 28th, 2014)
 */

public class Game
{
    //Declare the game instances and fields
    private Location currentLocation, n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15;
    private Location n16, n17, n18, n19, n20;
    private Item trumpet, ukulele, djembe, tambourine;
    private String currentOrientation;
    private Image currentImage;
    private ArrayList<Item> itemList;
    
    /**
     * Sets up a run of the navigation program, a "game".
     */
    public Game()
    {
         createLocations();
         createItems();
         currentLocation = n1;
         currentOrientation = "north";
         currentImage = new Image("sourcePics/1-n.JPG");
    }

    /**
     * Tells the current orientation in the game
     * @return The current orientation in the game
     */
    public String getOrientation(){
        return currentOrientation;
    }

    /**
    * Changes the current orientation depending on the button pressed on the GUI. 
    * @param newOrientation The direction passed by the user
    */
    public void changeOrientation(String newOrientation){
        currentOrientation = newOrientation;
    }
    
     /**
      * Tells the current location in the game
      * @return The current location in the game
      */
    public Location getLocation(){
        return currentLocation;
    }
    
    /**
    * Changes the current location depending on the button pressed on the GUI. 
    */
    public void changeLocation(){
        // Gets next location and verifies that it is valid. If not, do nothing.
        Location newLocation = currentLocation.getNextLocation(currentOrientation);
        if(newLocation != null){currentLocation = newLocation;}
    }
    
    /**
     * Tells if there exists a neighbor location in front of the current view
     * @return A boolean value that tells the GUI if it is possible to go forward.
     */
    public boolean isForwardPossible(){
        Location trialLocation = currentLocation.getNextLocation(currentOrientation);
        if(trialLocation == null){return false;}
        else{return true;}        
    }

    /**
     * Retrieves the current view to display depending on the current location and orientation.
     * @return An image to display.
     */
    public Image getCurrentImage(){
        currentImage = currentLocation.getView(currentOrientation);
        return currentImage;
    }

    /**
     * Passes the current item list
     * @return The current item list.
     */
    public ArrayList getItemList(){
        return itemList;
    }
    
    /**
     * This method is responsible for setting up the items and adding them to the item list.
     */
    
    public void createItems(){
        trumpet = new Item("Trumpet");
        ukulele = new Item("Ukulele");
        djembe = new Item("Djembe");
        tambourine = new Item("Tambourine");
        
        trumpet.setItem("sourcePics/6-n.JPG");
        ukulele.setItem("sourcePics/11-n.JPG");
        djembe.setItem("sourcePics/14-w.JPG");
        tambourine.setItem("sourcePics/9-n.JPG");
        
        // Put the items inside a list for an easier access.
        itemList = new ArrayList<Item>();
        itemList.add(trumpet);
        itemList.add(ukulele);
        itemList.add(djembe);
        itemList.add(tambourine);
    }
    
    
    /**
    * This method is responsible for setting up the locations. 
    */
    public void createLocations(){
        // Sets the n_i location with a name, directions and adjacent locations.

        n1 = new Location("Entrance Hallway, n1");
        n2 = new Location("Entrance Hallway, n2");
        n3 = new Location("Flat Hallway, n3");
        n4 = new Location("Flat Hallway, n4");
        n5 = new Location("Living room, n5");
        n6 = new Location("Kitchen, n6");
        n7 = new Location("Kitchen, n7");
        n8 = new Location("Room 1, n8");
        n9 = new Location("Room 1, n9");
        n10 = new Location("Room 2, n10");
        n11 = new Location("Room 2, n11");
        n12 = new Location("Entrance Hallway, n12");
        n13 = new Location("Entrance Hallway, n13");        
        n14 = new Location("Garden, n14");
        n15 = new Location("Garden, n15");
        n16 = new Location("Garden, n16");
        n17 = new Location("Garden, n17");
        n18 = new Location("Garden, n18");
        n19 = new Location("Garden, n19");
        n20 = new Location("Garden, n20");
        
        n1.set("north", "sourcePics/1-n.JPG", n2);
        n1.set("south", "sourcePics/1-s.JPG", null);
        n1.set("east", "sourcePics/1-e.JPG", null);
        n1.set("west", "sourcePics/1-w.JPG", null);
        
        n2.set("north", "sourcePics/2-n.JPG", n12);
        n2.set("south", "sourcePics/2-s.JPG", n1);
        n2.set("east", "sourcePics/2-e-opened.JPG", n3);
        n2.set("west", "sourcePics/2-w.JPG", null);
        
        n3.set("north", "sourcePics/3-n-opened.JPG", null);
        n3.set("south", "sourcePics/3-s-opened.JPG", n8);
        n3.set("east", "sourcePics/3-e.JPG", n4);
        n3.set("west", "sourcePics/3-w-opened.JPG", n2);
              
        n4.set("north", "sourcePics/4-n.JPG", n5);
        n4.set("south", "sourcePics/4-s-opened.JPG", n10);
        n4.set("east", "sourcePics/4-e-0.JPG", null);
        n4.set("west", "sourcePics/4-w-closed.JPG", n3);
        
        n5.set("north", "sourcePics/5-n.JPG", null);
        n5.set("south", "sourcePics/5-s.JPG", n4);
        n5.set("east", "sourcePics/5-e.JPG", n6);
        n5.set("west", "sourcePics/5-w.JPG", null);
        
        n6.set("north", "sourcePics/6-n.JPG", n7);
        n6.set("south", "sourcePics/6-s.JPG", null);
        n6.set("east", "sourcePics/6-e.JPG", null);
        n6.set("west", "sourcePics/6-w.JPG", n5);
              
        n7.set("north", "sourcePics/7-n.JPG", null);
        n7.set("south", "sourcePics/7-s.JPG", n6);
        n7.set("east", "sourcePics/7-e.JPG", null);
        n7.set("west", "sourcePics/7-w.JPG", null);
        
        n8.set("north", "sourcePics/8-n.JPG", n3);
        n8.set("south", "sourcePics/8-s.JPG", n9);
        n8.set("east", "sourcePics/8-e.JPG", null);
        n8.set("west", "sourcePics/8-w.JPG", null);
        
        n9.set("north", "sourcePics/9-n.JPG", n8);
        n9.set("south", "sourcePics/9-s.JPG", null);
        n9.set("east", "sourcePics/9-e.JPG", null);
        n9.set("west", "sourcePics/9-w.JPG", null);
        
        n10.set("north", "sourcePics/10-n.JPG", n4);
        n10.set("south", "sourcePics/10-s.JPG", n11);
        n10.set("east", "sourcePics/10-e.JPG", null);
        n10.set("west", "sourcePics/10-w.JPG", null);

        n11.set("north", "sourcePics/11-n.JPG", n10);
        n11.set("south", "sourcePics/11-s.JPG", null);
        n11.set("east", "sourcePics/11-e.JPG", null);
        n11.set("west", "sourcePics/11-w.JPG", null);

        n12.set("north", "sourcePics/12-n.JPG", n13);
        n12.set("south", "sourcePics/12-s.JPG", n2);
        n12.set("east", "sourcePics/12-e.JPG", null);
        n12.set("west", "sourcePics/12-w.JPG", null);

        n13.set("north", "sourcePics/13-n-opened.JPG", n14);
        n13.set("south", "sourcePics/13-s.JPG", n12);
        n13.set("east", "sourcePics/13-e.JPG", null);
        n13.set("west", "sourcePics/13-w.JPG", null);
        
        n14.set("north", "sourcePics/14-n.JPG", n15);
        n14.set("south", "sourcePics/14-s.JPG", n13);
        n14.set("east", "sourcePics/14-e.JPG", n20);
        n14.set("west", "sourcePics/14-w.JPG", null);
        
        n15.set("north", "sourcePics/15-n.JPG", n16);
        n15.set("south", "sourcePics/15-s.JPG", n14);
        n15.set("east", "sourcePics/15-e.JPG", n17);
        n15.set("west", "sourcePics/15-w.JPG", null);
        
        n16.set("north", "sourcePics/16-n.JPG", null);
        n16.set("south", "sourcePics/16-s.JPG", n15);
        n16.set("east", "sourcePics/16-e.JPG", null);
        n16.set("west", "sourcePics/16-w.JPG", null);
        
        n17.set("north", "sourcePics/17-n.JPG", null);
        n17.set("south", "sourcePics/17-s.JPG", null);
        n17.set("east", "sourcePics/17-e.JPG", n18);
        n17.set("west", "sourcePics/17-w.JPG", n15);
        
        n18.set("north", "sourcePics/18-n.JPG", null);
        n18.set("south", "sourcePics/18-s.JPG", n19);
        n18.set("east", "sourcePics/18-e.JPG", null);
        n18.set("west", "sourcePics/18-w.JPG", n17);
        
        n19.set("north", "sourcePics/19-n.JPG", n18);
        n19.set("south", "sourcePics/19-s.JPG", null);
        n19.set("east", "sourcePics/19-e.JPG", null);
        n19.set("west", "sourcePics/19-w.JPG", n20);
               
        n20.set("north", "sourcePics/20-n.JPG", null);
        n20.set("south", "sourcePics/20-s.JPG", null);
        n20.set("east", "sourcePics/20-e.JPG", n19);
        n20.set("west", "sourcePics/20-w.JPG", n14);
    }
}
