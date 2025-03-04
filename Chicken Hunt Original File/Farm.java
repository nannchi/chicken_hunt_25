
/**
 * Write a description of class Farm here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Farm
{
    private int level;
    private int chickens;
 
        
    public Farm() {
        level = 0;
        chickens = 10;
    }

    /** 
     * gets the level
     */
    public int getLevel() {
        return level;
    }
    /** 
     * gets the chicken amount
     */
    public int getChicks() {
        return chickens;
    }
    
    //levels methods
    /**
     * going up a level
     */
    public void levelInc() {
            level++;
    }
    
    //chicken methods
    /**
     * adds chickens to farm
     */
    public void chicksInc() {
        chickens++;
    }
}
