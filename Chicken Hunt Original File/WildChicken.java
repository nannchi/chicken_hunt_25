
/**
 * Write a description of class chicken here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class WildChicken
{
    private double agg;
    private boolean isAgg = false;

    /**
     * Constructor for objects of class chicken
     */
    public WildChicken(int pop, int ex, boolean anger)
    {
        agg = 90;
        if (anger == true) {
            agg = ((double)(ex*(100-pop)))/50;
            if (agg > 97 || agg < 100) {
                agg = 125;
            }
            printWarning();
            isAgg = true;
        }
    }
    
    
    /**
     * decreases the aggressiveness
     */
    public void parceAgg(String choice) {
        String[] pos = {"food","friendship", "gifts"};
        String[] neg = {"insult", "throw", "roast", "Chick-fil-A"};
        
        //Search for positives
        if (choice.indexOf(pos[0]) >= 0 || choice.indexOf(pos[1]) >= 0 ) {
            agg -= 15;
            System.out.println("*It seems pleased*");
        } else if (choice.indexOf(pos[2]) >= 0) {
            agg -= 25;
            System.out.println("*It seems pleased*");
        }
        //search for negatives
        if (choice.indexOf(neg[0]) >= 0 || choice.indexOf(neg[1]) >= 0 || choice.indexOf(neg[2]) >= 0 ) {
            agg += 10;
            System.out.println("*You've managed to anger the chicken*");
        } else if (choice.indexOf(neg[3]) >=0) {
            agg += 35;
            System.out.println("*the chicken stares at you threateningly*");
        }
        
        if (agg < 100) {
            System.out.println("*You've managed to placate the chicken*");
            isAgg = false;
        } 
    }
    
    /**
     * gets aggrssion
     */
    public double getAgg() {
        return agg;
    }
    
    /**
     * is agg boolean
     */
    public boolean isAgg() {
        return isAgg;
    }
    
    /**
     * automatic notification of an aggressive chicken
     */
    private void printWarning() {
        System.out.println("!!!!Warning!!!!");
    }
}
