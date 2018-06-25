
/**
 * This class is responsible for handling item instances.
 * 
 * @author Jorge A. Salamanca S. 
 * @version 1.0 (Last edited: November 28th, 2014)
 */
public class Item
{
    // Variables that tell us if the item has been dropped, is being carried, where is its initial
    // location and its name.
    private boolean itemIsCarried;
    private boolean itemDropped;
    private String itemLocation;
    private String name;
    
    /**
     * Constructor for objects of class Item
     * @param name Name for the item
     */
    public Item(String name)
    {
       // Initialises a non-carried item
       itemIsCarried = false;
       itemLocation = null;
       itemDropped = false;
       this.name = name;
    }

    /**
     * Access the item's original location.
     * @return The item's original location.
     */
    public String getItemLocation( )
    {
        return itemLocation;
    }

    /**
     * Check if the item is carried.
     * @return Boolean value.
     */
    public boolean carried( )
    {
        return itemIsCarried;
    }
    
     /**
      * Check if the item has been dropped in the delivery location
      * @return Boolean value
      */
    public boolean dropped( )
    {
        return itemDropped;
    }
    
    /**
     * Check the item's name
     * @return The name of the item.
     */
    public String getItemName( )
    {
        return name;
    }
    
    
    /**
     * Set the original location of the item.
     * @param itemLocation Location for the item to be placed at the beginning of the program
     */
    
    public void setItem(String itemLocation)
    {
        this.itemLocation = itemLocation;
    }
    
     /**
      * Sets the field that indicates that the item has been picked up.
      *
      */
    
    public void pickUp()
    {
        itemIsCarried = true;
    }
    
    /**
     * Sets the field that indicates that the item has been dropped off.
     *
     */
    
    public void dropItem()
    {
        itemIsCarried = false;
        itemDropped = true;
    }
}
