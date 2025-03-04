import java.util.Scanner;
import java.util.Arrays;

/**
Name:               Chimamanda Ndu-Onyeaso
Class:              APCS-A Section 1
Program Name:       Module Sixteen Lesson Two Assignment (Final project Demo)
Date:               10.5.22


Description: This program is a text-based adventure game, in which a new farmer cares after and befriends chickens.
What I learned: I learned how to apply all the concepts I learned throughout this course in a game.
Difficulties encountered and how they were solved:
 * One difficulty that I encountered was how to account for dying in game.
     * To solve this I extended the Exception class to create a Death subclass, which stops the code and prints the death text.
 */

public class ChickenHunt //Top of page
{
    /********************INSTANCE VARIABLES***********/
    //for the player
    private static String name;
    private static Farm myFarm = new Farm();
    private static int exper;
    private static int popul;
    private static int money;
    
    //menus
    private static String[] modeMenu = new String[] {"Were you a farmer(more experience, less money)", "business man(less experience, more money)"};
    private static String[] catChicksL1 = new String[] {"offer friendship", "offer food", "roast his plummage"};
    private static String[] mainMenu = new String[] {"hunting", "tending to the chickens", "QUIT: WARNING PROGRESS WILL NOT BE SAVED"};
    private static String[] returnMenu = new String[] {"continue?", "return to your farmhouse"};
    private static String[] feedMenu = new String[] {"Yes (-$3 per chicken)", "No"};
    private static String[] catChicksL2 = new String[] {"offer friendship", "offer food", "roast his plummage", "offer gifts", "throw a rock at him"};
    private static String[] catChicksL3 = new String[] {"offer friendship", "offer food", "roast his plummage", "offer gifts", "throw a rock at him", "offer him Chick-fil-A"};
    
    
    public static void main(String[] args) throws Death {
        Scanner ui = new Scanner(System.in);
        String keepS;
        int keepI;
        int experSt; 
        
        /*******create your character**********/
        
        System.out.println("*You're discussing your dream of starting a new chicken farm with your good ole pal Frank*");
        System.out.println("-Frank:: Say there....");
        
        //name your farmer
        System.out.print("|Enter your name|");
        name = ui.nextLine();
        
        System.out.println("-Frank:: "+name+"...");
        System.out.println("-Frank:: I've known you for years. You're making...");
        
        printMenu(modeMenu);
        System.out.print("|Choose a number|");
        keepI = ui.nextInt();
        ui.nextLine(); //clears scanner
        
        //farmer or business man //defaults business man
        if (keepI == 0) {
            System.out.println("-Frank:: an honest living as a respectable cow farmer.");
            exper = 400;
            popul = 75;
            money = 200;
        }
        else {
            System.out.println("-Frank:: it in the business world.");
            exper = 10;
            popul = 50;
            money = 1000;
        }
        
        experSt = exper; 
        
        
        
        System.out.println("-Frank:: Why throw it all away?");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("*You told him why not*");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("-Frank:: I can respect that");
        
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        
        
        
        /*******time skip***********/
        
        

        System.out.println("\n\n\n=====2 years later=====\n\n\n");
        System.out.println("*You decide to quit your job to be a chicken farmer despite Frank's objections*");
        myFarm = new Farm();
        System.out.println(stats());
        
        
        System.out.print("|Enter to continue to the Tutorial|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        
        
        /******tutorial************/
        
        
        
        
        System.out.println("\n\n\n=====TUTORIAL MODE=====\n\n\n");
        System.out.println("*A strange shadowy figure approaches you*");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));

        System.out.println("-Shadowy Figure:: Howdy there uhh.... um..");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("*You cough out your name*");
        System.out.println("-Shadowy Figure:: " + name+"! I knew that...");
        System.out.println("-Shadowy Figure:: Anyways... I'm Joe! I own the farm near the bank");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("-Farmer Joe?:: You should come chicken hunting with me!");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("*By the time you decide you don't trust Joe's enthusiam, he's dragging you into the woods*");

        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        
        /*chicken 1*******************/
        
        
        WildChicken tut = new WildChicken(popul, exper, false);
        System.out.println("*A chicken has appeared*");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("-Farmer Joe?:: Lookie there, it is a chicken! You gotta catch it");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("-Farmer Joe?:: Since you're a rookie, you have few choices:");
        
        //pick an option
        printMenu(catChicksL1);
       
        System.out.print("|Choose a number|");
        keepI = ui.nextInt();
        ui.nextLine(); //clears the scanner
        System.out.println("*You chose to " + catChicksL1[keepI] +"*");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("*You've befriended the chicken!*");
        myFarm.chicksInc();
        populAdjust(tut.getAgg());
        
        
        /*++++++++++++++++++++++++++++++++*/
        
        
        System.out.println("-Farmer Joe?:: Wow, " + name + "! You're a natural. That little fella is gonna join your farm");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("*You determine Joe is trustworthy...*");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("-Farmer Joe<3:: Let's keep going");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        
        /*chicken 2*******************/
        
        
        tut = new WildChicken(75,300 , true); //produces a chicken that is aggressive
        System.out.println("*A chicken has appeared*");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("-Farmer Joe:: Wow, its a feisty one.");
        System.out.println("-Farmer Joe:: Aggressive chickens may take more effort");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        //pick an option
        
        do { //placating the chicken
            printMenu(catChicksL1);

            System.out.print("|Choose a number|");
            keepI = ui.nextInt();
            ui.nextLine(); //clears the scanner
            
            System.out.println("*You chose to " + catChicksL1[keepI] +"*");
            tut.parceAgg(catChicksL1[keepI]);
        } while (tut.isAgg() == true);
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("*You've befriended the chicken!*");
        myFarm.chicksInc();
        populAdjust(tut.getAgg());
        
        
        /*++++++++++++++++++++++++++++++++*/
        
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("-Farmer Joe:: You're a natural!");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("-Farmer Joe:: Let's head back");
        
        System.out.print("|Enter to exit the tutorial|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        
        System.out.println("\n\n\n=====TUTORIAL MODE END=====\n\n\n");
        
        System.out.println("*You are back at your farm*");
        System.out.println(stats());
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        
        
        
        /*****************level 1********************/
        
        
        
        
        System.out.println("\n\n\n=====YOU HAVE STARTED LEVEL ONE=====\n\n\n");
        
        System.out.println("*You are still at your farm*");
        

        myFarm.levelInc();
        int aggChicksAllotted = 2; //the amount of aggressive chickens allotted is 2
        WildChicken currentChick;
        do {
            
            
            /*main menu*******************/
            
            
            System.out.println(stats() + "\n   "+ ((experSt + 100) - exper) + "XP left to next Level");

                    
            System.out.print("|Enter to continue|");
            do { keepS = ui.nextLine(); } while (!keepS.equals(""));
            
            System.out.println("*You ponder where you should go...*");
            printMenu(mainMenu);
            
            System.out.print("|Choose a number|");
            keepI = ui.nextInt();
            ui.nextLine(); //clears the scanner
            
            
            /*level 1 hunting*******************/
            
            
            if (keepI == 0) { 
                
                do {
                    System.out.println("*You chose " + mainMenu[keepI] +"*");
                    
                    System.out.print("|Enter to continue|");
                    do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                    
                    //wandering
                    int timesWandered = (int)(Math.random() * 10);
                    for (int x = 0; x < timesWandered; x++) {
                        System.out.println("*You wander deeper into the forest*");

                        System.out.print("|Enter to continue|");
                        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                    }
                    
                    
                    /*chicken sequence*******************/
                    
                    
                    if ((int)Math.random() * 2 + 1 < 2 && aggChicksAllotted > 0) { //angry chickens based on random method and allotted amount
                        currentChick = new WildChicken(popul, exper,true);
                        aggChicksAllotted--;
                    } else currentChick = new WildChicken(popul, exper,false);
                     
                    System.out.println("*A chicken has appeared*");
                    //pick an option
                    
                    do {
                        System.out.println("Current Aggressiveness: " +currentChick.getAgg());

                        printMenu(catChicksL1);
                       
                        System.out.print("|Choose a number|");
                        keepI = ui.nextInt();
                        ui.nextLine(); //clears the scanner
                        
                        System.out.println("*You chose to " + catChicksL1[keepI] +"*");
                        currentChick.parceAgg(catChicksL1[keepI]);
                    } while (!currentChick.isAgg() == false);
    
                    System.out.print("|Enter to continue|");
                    do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                    
                    System.out.println("*You've befriended the chicken!*");
                    myFarm.chicksInc();
                    populAdjust(currentChick.getAgg());
                    xpInc(currentChick.getAgg());
                    money += 15;
                    System.out.println("*The National Chicken Union rewarded you $15 for taking yet another chicken off the street*");
                    
                    
                    /*++++++++++++++++++++++++++++*/
                    
                    
                    System.out.print("|Enter to continue|");
                    do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                    
                    System.out.println("*You ponder heading home...*");
                    
                    System.out.print("|Enter to continue|");
                    do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                    
                    if ((popul >=90  && exper >= (100 + experSt))) System.out.println("Notice: You are elegible to level up");
                    printMenu(returnMenu);
                    
                    System.out.print("|Choose a number|");
                    keepI = ui.nextInt();
                    ui.nextLine(); //clears the scanner
                } while (keepI == 0);
                
                
                
                 if (keepI == 2) {
                     System.out.println ("Enter QUIT to quit");
                     keepS=ui.nextLine();
                } else {};
                
                
            /*level 1 tending*******************/
            
            
            } else if (keepI == 1) { //caring for a chicken
                System.out.println("*You chose " + mainMenu[keepI] +"*");
                System.out.println(stats());
                
                System.out.print("|Enter to continue|");
                do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                
                System.out.println("*While takinging care of you chickens, it seems as if they want to be fed*");
                printMenu(feedMenu);
                
                System.out.print("|Choose a number|");
                keepI = ui.nextInt();
                ui.nextLine(); //clears the scanner

                
                /*feeds the chickens******/
                
                
                if (keepI == 0) {
                    System.out.print("|Enter to feed the Chickens|");
                    do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                    
                    System.out.println("*Your chickens adore you for this*");
                    money -= 3*myFarm.getChicks();
                    popul += myFarm.getChicks();
                    System.out.println(stats());
                    
                    System.out.print("|Enter to continue|");
                    do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                    
                    
                /*starve the chickens******/
                
                
                } else {
                    System.out.println("*You see the price tag on the bag of feed and start to wonder why you even came here*");
                    popul -= myFarm.getChicks();
                    
                    System.out.print("|Enter to continue|");
                    do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                
                    System.out.println("*and so do your chickens; they're incredibly displeased*");
                    
                    System.out.print("|Enter to continue|");
                    do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                    
                    System.out.println("*they squawk and nip at you as you leave them hungry and alone*");
                    
                    System.out.print("|Enter to continue|");
                    do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                }
                
            } else System.out.println("Number not present");
            
            
        } while ((!keepS.toUpperCase().equals("QUIT")) && (popul <=90 || exper <= (100 + experSt)));
        
        
        if(!keepS.toUpperCase().equals("QUIT")) {
            
            
            
        /*************** to level 2 cut scene***************/
        
        
        
        
        System.out.println("\n\n\n=====YOU HAVE COMPLETED LEVEL ONE=====\n\n\n");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("*You decide to meet up with Farmer Joe for lunch after being recognized for chicken farming at the county level*");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("-Farmer Joe:: I'm mighty proud of you");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("-Farmer Joe:: You know, the farmer who used to own your farm never made it that far");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("*You arrogantly asked if they quit*");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("-Farmer Joe:: Naw... she got into a wee bit of an accident");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("-Farmer Joe:: While she was chicken hunting, she got into a scuff with an aggressive chicken");

        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("-Farmer Joe:: Poor Bertha never had a chance");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("*You apologize for your earlier arrogance*");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("-Farmer Joe:: Don't sweat it, she would have done the same");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("*After you abruptly change the topic back to your acheivement, you head home*");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("*You are back at your farm*");
        System.out.println(stats());
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        
        
        /*************** level 2***************/
        
        myFarm.levelInc();
        System.out.println("\n\n\n=====YOU HAVE STARTED LEVEL TWO=====\n\n\n");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("NEW death!! \"Death via Angry Chicken\"");
        System.out.println("    Avoid heckling angry chickens by not angering them further! ");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("NEW hunt option!! \"offer gift\"");
        System.out.println("    Giving gifts to them makes them happier than offering friendship or food");

        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("NEW hunt option!! \"throw a rock at him\"");
        System.out.println("    *You've discovered Bertha kept a rock collection*");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("*The National Chicken Union has granted you a small amount of" + ((int)Math.pow(myFarm.getChicks(),2) + 60) + "*");
        money += (int)Math.pow(myFarm.getChicks(),2) + 60;
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));

        
        
        
        
        experSt = exper; //updates the saver for the XP
        aggChicksAllotted = 6; //the amount of aggressive chickens allotted is 6
        do {
            
            
            /*main menu*******************/
            
            
            System.out.println(stats() + "\n   "+ ((experSt + 100) - exper) + "XP left to next Level");

                    
            System.out.print("|Enter to continue|");
            do { keepS = ui.nextLine(); } while (!keepS.equals(""));
            
            System.out.println("*You ponder where you should go...*");
            printMenu(mainMenu);
            
            System.out.print("|Choose a number|");
            keepI = ui.nextInt();
            ui.nextLine(); //clears the scanner
            
            
            /*level 2 hunting*******************/
            
            
            if (keepI == 0) { 
                
                do {
                    System.out.println("*You chose " + mainMenu[keepI] +"*");
                    System.out.println(stats());
                    
                    System.out.print("|Enter to continue|");
                    do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                    
                    //wandering
                    int timesWandered = (int)(Math.random() * 10);
                    for (int x = 0; x < timesWandered; x++) {
                        System.out.println("*You wander deeper into the forest*");

                        System.out.print("|Enter to continue|");
                        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                    }
                    
                    
                    /*chicken sequence*******************/
                    
                    
                    if ((int)Math.random() * 4 + 1 < 3 && aggChicksAllotted > 0) { //angry chickens more likely this level 
                        currentChick = new WildChicken(popul, exper,true);
                        aggChicksAllotted--;
                    } else currentChick = new WildChicken(popul, exper,false);
                     
                    System.out.println("*A chicken has appeared*");
                    
                    
                    //pick an option
                    int count = (int)((currentChick.getAgg() - 100)/20) + 1;
                    do {
                        System.out.println("Current Aggressiveness: " +currentChick.getAgg());

                        printMenu(catChicksL2);
                        System.out.println("Choices left: " + (count));
                       
                        System.out.print("|Choose a number|");
                        keepI = ui.nextInt();
                        ui.nextLine(); //clears the scanner
                        
                        currentChick.parceAgg(catChicksL2[keepI]);
                        count--;
                    }  while (count > 0 && currentChick.isAgg());
                    
                    if (currentChick.isAgg())  {
                        throw new Death("Death by failing to placate a chicken in what is viewed as a reasonable amount of attempts");
                    }
                    System.out.print("|Enter to continue|");
                    do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                    
                    System.out.println("*You've befriended the chicken!*");
                    myFarm.chicksInc();
                    populAdjust(currentChick.getAgg());
                    xpInc(currentChick.getAgg());
                    money += 30;
                    System.out.println("*The National Chicken Union rewarded you $30 for taking yet another chicken off the street*");
                    
                    
                    /*++++++++++++++++++++++++++++*/
                    
                    
                    System.out.print("|Enter to continue|");
                    do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                    
                    System.out.println("*You ponder heading home...*");
                    
                    System.out.print("|Enter to continue|");
                    do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                    
                    if ((popul >= 90 && exper >= (100 + experSt))) System.out.println("Notice: You are elegible to level up");
                    printMenu(returnMenu);
                    
                    System.out.print("|Choose a number|");
                    keepI = ui.nextInt();
                    ui.nextLine(); //clears the scanner
                    
                } while (keepI == 0);
                 
                
                 
                if (keepI == 2) {
                     System.out.println ("Enter QUIT to quit");
                     keepS=ui.nextLine();
                } else {}
                
            
                
                
            /*level 3 tending*******************/
            
            
            } else if (keepI == 1) { //caring for a chicken
                System.out.println("*You chose " + mainMenu[keepI] +"*");
                System.out.println(stats());
                
                System.out.print("|Enter to continue|");
                do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                
                System.out.println("*While takinging care of you chickens, it seems as if they want to be fed*");
                printMenu(feedMenu);
                
                System.out.print("|Choose a number|");
                keepI = ui.nextInt();
                ui.nextLine(); //clears the scanner

                
                /*feeds the chickens******/
                
                
                if (keepI == 0) {
                    System.out.print("|Enter to feed the Chickens|");
                    do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                    
                    System.out.println("*Your chickens adore you for this*");
                    money -= 3*myFarm.getChicks();
                    
                    if (popul + (int)myFarm.getChicks()/3 < 100) popul += (int)myFarm.getChicks()/3;
                    else popul = 100;
                    
                    System.out.println(stats());
                    
                    System.out.print("|Enter to continue|");
                    do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                    
                    
                /*starve the chickens******/
                
                
                } else {
                    System.out.println("*You see the price tag on the bag of feed and start to wonder why you even came here*");
                    popul -= (int)(myFarm.getChicks()*1.5);
                    
                    System.out.print("|Enter to continue|");
                    do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                
                    System.out.println("*and so do your chickens; they're incredibly displeased*");
                    
                    System.out.print("|Enter to continue|");
                    do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                    
                    System.out.println("*they squawk and nip at you at you leave them hungry and alone*");
                    
                    System.out.print("|Enter to continue|");
                    do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                }
                
            } else System.out.println("Number not present");
            
            
        } while ((!keepS.toUpperCase().equals("QUIT")) && (popul <=90 || exper <= (100 + experSt)));
        
        
        if(!keepS.toUpperCase().equals("QUIT")) {
        
        System.out.println("\n\n\n=====YOU HAVE COMPLETED LEVEL TWO=====\n\n\n");
        
        
        /*********************level 3 cut scene************************/
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("*You're shocked that after three years of no contact and you becoming recognized by the county and now the state, that your good ole pal Frank called you to catch up*");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("-Frank:: Look "+ name +"...");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("-Frank:: Don't take it too personally, but...");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("*You tell him you will take it extremely personally*");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("-Frank:: ...");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("-Frank:: Anyways, have you looked at the recent headliner...");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("-Frank:: Its all over the news...");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("*You inform him that you only watch HGTV+ and the International Chicken Channel*");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("-Frank:: Some farmer that lived close to you was attacked by his chickens");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("-Frank:: What was his name...");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("*You suddenly realize the true purpose of this call*");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("-Frank:: I think it was Chandler..."); 
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("-Frank:: I don't want that to...");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("*You immediately hang up on him*");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("*the audacity*");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        
        
        /*************** level 3***************/
        
        
        
        myFarm.levelInc();
        System.out.println("\n\n\n=====YOU HAVE STARTED LEVEL THREE=====\n\n\n");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("NEW death!! \"Death via Unpopular Farm\"");
        System.out.println("    Avoid angering your farm! Hunting instead of tending to your farm now harms your popularrity ");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("NEW hunt option!! \"offer him Chick-fil-A\"");
        System.out.println("    *Frank's daughter always gives you free sandwiches (sans pickle) because you helped her with her calculus homework*");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println("*The National Chicken Union has granted you a small amount of" + ((int)Math.pow(myFarm.getChicks(),2) + 60) + "*");
        money += (int)Math.pow(myFarm.getChicks(),2) + 60;
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        
        
        
        experSt = exper; //updates the saver for the XP
        aggChicksAllotted = 10; //the amount of aggressive chickens allotted is 10
        do {
            
            
            /*main menu*******************/
            
            
            System.out.println(stats() + "\n   "+ ((experSt + 100) - exper) + "XP left to next Level");

                    
            System.out.print("|Enter to continue|");
            do { keepS = ui.nextLine(); } while (!keepS.equals(""));
            
            System.out.println("*You ponder where you should go...*");
            printMenu(mainMenu);
            
            System.out.print("|Choose a number|");
            keepI = ui.nextInt();
            ui.nextLine(); //clears the scanner
            
            if (popul < 75) System.out.println("\n  WARNING: moderate popularity");
            if (popul < 65) System.out.println("\n  WARNING: low popularity! Perhaps you should tend to your chickens.");
            if (popul < 55) System.out.println("\n  WARNING: critical popularity!! Tend to your chickens");
            if (popul < 50) throw new Death("Angry Birdies: \n   *Your chickens decided that they hate you since you clearly hate them and have revolted*");
            
           /*level 3 hunting*******************/
            
            
            if (keepI == 0) { 
                
                do {
                    System.out.println("*You chose " + mainMenu[keepI] +"*");
                    
                    System.out.print("|Enter to continue|");
                    do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                    
                    //wandering
                    int timesWandered = (int)(Math.random() * 10);
                    for (int x = 0; x < timesWandered; x++) {
                        System.out.println("*You wander deeper into the forest*");

                        System.out.print("|Enter to continue|");
                        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                    }
                    
                    
                    /*chicken sequence*******************/
                    
                    
                    if ((int)Math.random()*100%3 < 0 && aggChicksAllotted > 0) { //angry chickens more likely this level 
                        currentChick = new WildChicken(popul, exper,true);
                        aggChicksAllotted--;
                    } else currentChick = new WildChicken(popul, exper,false);
                     
                    System.out.println("*A chicken has appeared*");
                    //pick an option
                    
                    int count = (int)((currentChick.getAgg() - 100)/20) + 1;
                    do {
                        System.out.println("Current Aggressiveness: " +currentChick.getAgg());
                        printMenu(catChicksL3);
                        System.out.println("Choices left: " + (count));
                       
                        System.out.print("|Choose a number|");
                        keepI = ui.nextInt();
                        ui.nextLine(); //clears the scanner
                        
                        System.out.println("*You chose to " + catChicksL3[keepI] +"*");
                        currentChick.parceAgg(catChicksL3[keepI]);
                        count--;
                    }  while (count > 0 && currentChick.isAgg());
                    
                    if (currentChick.isAgg())  {
                        throw new Death("Death by failing to placate a chicken in what is viewed as a reasonable amount of attempts");
                    }
                    System.out.print("|Enter to continue|");
                    do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                    
                    System.out.println("*You've befriended the chicken!*");
                    myFarm.chicksInc();
                    populAdjust(currentChick.getAgg());
                    xpInc(currentChick.getAgg());
                    money += 35;
                    System.out.println("*The National Chicken Union rewarded you $35 for taking yet another chicken off the street*");
                    
                    
                    /*++++++++++++++++++++++++++++*/
                    
                    
                    System.out.print("|Enter to continue|");
                    do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                    
                    System.out.println("*You ponder heading home...*");
                    
                    System.out.print("|Enter to continue|");
                    do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                    
                    if ((popul >=90 && exper >= (100 + experSt))) System.out.println("Notice: You are elegible to level up");
                    if (popul <80   && popul - (int)(myFarm.getChicks()*.5) > 20) System.out.println("Notice: You're becoming dangerously unpopular");
                    printMenu(returnMenu);
                    
                    System.out.print("|Choose a number|");
                    keepI = ui.nextInt();
                    ui.nextLine(); //clears the scanner
                    
                    if (keepI == 0) popul -= (int)(myFarm.getChicks()*.5);
                    
                 } while (keepI == 0);
                 

                 if (keepI == 2) {
                     System.out.println ("Enter QUIT to quit");
                     keepS=ui.nextLine();
                } else {}
                
            
                
                
            /*level 3 tending*******************/
            
            
            } else if (keepI == 1) { //caring for a chicken
                System.out.println("*You chose " + mainMenu[keepI] +"*");
                System.out.println(stats());
                
                System.out.print("|Enter to continue|");
                do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                
                System.out.println("*While takinging care of you chickens, it seems as if they want to be fed*");
                printMenu(feedMenu);
                
                System.out.print("|Choose a number|");
                keepI = ui.nextInt();
                ui.nextLine(); //clears the scanner

                
                /*feeds the chickens******/
                
                
                if (keepI == 0) {
                    System.out.print("|Enter to feed the Chickens|");
                    do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                    
                    System.out.println("*Your chickens adore you for this*");
                    money -= 3*myFarm.getChicks();
                    
                    if (popul + (int)myFarm.getChicks()/3 < 100) popul += (int)myFarm.getChicks()/3;
                    else popul =100;
                    System.out.println(stats());
                    
                    System.out.print("|Enter to continue|");
                    do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                    
                    
                /*starve the chickens******/
                
                
                } else {
                    System.out.println("*You see the price tag on the bag of feed and start to wonder why you even came here*");
                    popul -= (int)(myFarm.getChicks()*2.5);
                    
                    System.out.print("|Enter to continue|");
                    do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                
                    System.out.println("*and so do your chickens; they're incredibly displeased*");
                    
                    System.out.print("|Enter to continue|");
                    do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                    
                    System.out.println("*they squawk and nip at you at you leave them hungry and alone*");
                    
                    System.out.print("|Enter to continue|");
                    do { keepS = ui.nextLine(); } while (!keepS.equals(""));
                }
                
            } else System.out.println("Number not present");
            
            
        } while ((!keepS.toUpperCase().equals("QUIT")) && (popul <=90 || exper <= (100 + experSt)));
        
        
        if(!keepS.toUpperCase().equals("QUIT")) {
        
        System.out.println("\n\n\n=====YOU HAVE COMPLETED LEVEL THREE=====\n\n\n");
    
        
        
        /********************final cut scene*********************/
        
        System.out.println("*5 years ago, you wouldn't have imagined yourself here, accomplishing your dreams*");
        
        System.out.print("|Enter to continue|");
        do { keepS = ui.nextLine(); } while (!keepS.equals(""));
        
        System.out.println(stats());
        
        }
        else System.out.println("*You decided chicken farming is not for you*");    
        }
        else System.out.println("*You decided chicken farming is not for you*");
        }
        else System.out.println("*You decided chicken farming is not for you*");
    }
    
    
    
    
    /** 
     * gets the happy level
     */
    public int getPopularity() {
        return popul;
    }
    //experience methods
    
    /**
     * increasing experience*/
    public static void xpInc(double agg) {
        exper += (int)agg/10 + 10;
    }
    
    /**
     * gets the current stats as a string
     */
    static String stats() {
        return ("Farmer " + name + "\n -  Level: " + myFarm.getLevel() + "\n -  XP: " + exper + "\n -  Popularity: " + popul+"\n -  Chickens: " + myFarm.getChicks() +"\n -  $$: " + money );
    }
    /**
     * prints a given menu
     */
    static void printMenu(String[] menu) {
        int x = 0;
        for (String i : menu) {
            System.out.println("  "+ x+ ": " + i);
            x++;
        }
    }
    /**
     * adjusts the farm based on the agressiveness of teh chicken
     */
    public static void populAdjust(double aggr) {
        if (popul < 100) {
            if (aggr < 100) {
            popul += 2; //not aggressive happy increases
            if (popul==100) popul = 100;
            System.out.println("Your popularity increased! \n-  Popularity: " + popul);
            }
            else if (aggr >= 100) {
                popul --; 
                System.out.println("Your popularity has decreased! \n-  Popularity: " + popul);
            } 
        } else System.out.println("Max popularity");
        
    }
}
