import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

/**
 * This class is responsible for handling the location nodes.
 *
 * @author Jorge A. Salamanca S. 
 * @version 1.0 (Last edited: November 28th, 2014)
 */
public class Location
{
    // Create HashMaps with exits and views for each location
    private HashMap<String, Image> views;
    private HashMap<String, Location> adjacentLocations;
    private HashMap<String, String> imagePath;
    
    // Stores the name/number of the location
    private String location;
    // Stores an image to pass it to the hashmap
    private Image image;

    /**
     * Initialises a location.
     */
    public Location(String location)
    {
        // Name and number of the location
        this.location = location;
        
        // Creates a hashmap capable of storing a given direction and associating it with its view (a
        // picture) and also, if it has one, with the next location. (See the *set* method below).
        views = new HashMap<String, Image>();
        adjacentLocations = new HashMap<String, Location>();
        imagePath = new HashMap<String, String>();
        
    }

    /**
     * This method is responsible for asociating the directions of a location with their view, a
     * picture, and with the next room in the given direction.
     * 
     * @param direction The cardinal direction
     * @param picturePath The name of the picture file
     * @param nextLocation The next room in the given direction
     */
    public void set(String direction, String picturePath, Location nextLocation)
    {
        // Create an image object with the given path
        image = new Image(picturePath);
        // Arrange the hashmaps
        views.put(direction, image);
        adjacentLocations.put(direction, nextLocation);
        imagePath.put(direction,picturePath);
    }
    
    /**
     * @param currentOrientation The current orientation in the game
     * @return The next location
     */
    public Location getNextLocation(String currentOrientation){
        // Check if it is possible to go forward with this orientation. If it is, return next room.
        return adjacentLocations.get(currentOrientation);
    }
    
    /**
     * @param currentOrientation The current orientation in the game
     * @return The picture of the current view
     */
    public Image getView(String currentOrientation){
        // Check if it is possible to look in this orientation. If it is, return picture.
        if(views.containsKey(currentOrientation)){
            return views.get(currentOrientation);
        }
        // If it is not, return a null value.
        else{
            return null;
        }
    }

        /**
     * @param currentOrientation The current orientation in the game
     * @return The picture path of the current view
     */
    public String getImagePath(String currentOrientation){
        // Check if it is possible to look in this orientation. If it is, return picture.
        if(imagePath.containsKey(currentOrientation)){
            return imagePath.get(currentOrientation);
        }
        // If it is not, return a null value.
        else{
            return null;
        }
    }
    
    /**
     * @return The brief description stored.
     */
    public String getString(){
        return location;
    }
}
