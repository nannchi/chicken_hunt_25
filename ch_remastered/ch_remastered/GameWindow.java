package ch_remastered;


import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import ch_remastered.chickies.Button;
import ch_remastered.chickies.colors.*;
import ch_remastered.chickies.Dialogues;


public class GameWindow {
    /*************INSTANCE VARS**************/
        //ALL JFRAMES
            JFrame homeWindow = new JFrame(),
            wPopUp = new JFrame(), 
            gameWindow = new JFrame();

        //STYLE VARS CAN MAYBE GET RID OF
            Font defaultFont;

        //HOME WINDOW VARS
            JButton bNewG = new JButton("New Save/Load Save");
            
        //MENU VARS
            JPanel menu = new JPanel();
            JButton bToggleMenu = new JButton("Toggle Menu");
            boolean menuToggledBool = false;
            JTextArea lSaveName = new JTextArea();
            boolean saveExistedBool;
            //maybe eventually turn into jlist
            JButton bSaveButton = new JButton("Save Game"); //NOT YET IMPLEMENTED

        //GAME VARS
            JButton bCont = new Button("Continue");
            JTextArea userIn;
            boolean gameStartedBool;
            JPanel gamePanel = new JPanel();
            static JTextArea gameText = new JTextArea(4, 30);
            int pacer = 0;

        //ALL DIALOGUES

            public final String[] DIALOGUE_TS1 = { //TRAINING SCENE 1 DIALOGUE
                "*A strange shadowy figure approaches you*",
                "=Shadowy Figure:: Howdy there uhh.... um..=",
                "+Ehm  hehehhm+",
                "=Shadowy Figure:: [NAME], right! Susan told me that, haha=",
                "*Susan is the loud, buoyant old lady who lives in the farm next to yours.*",
                "*Quite the gossip*",
                "=Shadowy Figure:: I'm Joe Johnsonson!=",
                "=Farmer Joe?:: You should come chicken hunting with me!=",
                "*By the time you decide you don't trust Joe's enthusiasm, he's dragging you off into the woods*",
                "*A chicken has appeared*",
                "NOTES: {This particular chicken is nice}",
                "=Farmer Joe?:: Lookie there, it is a chicken! You gotta catch it=",
                "=Farmer Joe?:: Since you're a rookie, you have few choices:=",
                "[CHICKEN INTERACTION MENU]", //13
                "*You chose to [CHICKEN INTERACTION]*",
                "*You've befriended the chicken!*",
                "=Farmer Joe?:: Wow, [NAME] You're a natural. That little fella is gonna join your farm.=",
                "*You determine Joe is trustworthy...*",
                "*Skill recognizes skill*",
                "*And you decide he's too lovely to dislike*", 
                "=Farmer Joe<3:: Let's keep going=",
                "*A second, more scary chicken has appeared*",
                "NOTES: {This particular chicken is evil}",
                "=Farmer Joe:: Wow, it's a feisty one.=",
                "=Farmer Joe:: Evil chickens may be a little too much for a farmer of your experience=",
                "=Farmer Joe:: No matter how much innate skill you have=",
                "=Farmer Joe:: I'll totally teach you how to catch the evil chickens later=",
                "*You are entirely up for Joe teaching you how to catch the evil chickens..*",
                "*But, the prospect of having an excuse to see him makes you giddy*",
                "+You da boss Joe-man+",
                "=Farmer Joe:: ...=",
                "+...+",
                "=Farmer Joe:: Ok so, because you don't know how to catch the evil fellas, you just gotta run=",
                "[CHICKEN INTERACTION MENU]", //33
                "NOTES: {Only option here is run}",
                "=Farmer Joe:: You know what=",
                "=Farmer Joe:: Let's scram, the lil demon looks like he bites=",
                "*You and Joe run together to the safety of your farm*"
            };
            public final String[] DIALOGUE_CS2 = { //CUT SCENE 2 DIALOGUE
                "*You decide to invite Joe for brunch after being recognized for chicken farming at the county level*",
                "*The county newsletter has a little section dedicated to congratulating farmers on their accomplishments*",
                "*Joe has made himself comfortable on your ratty old armchair, looking at your spot on the section*",
                "=Farmer Joe:: You know what [NAME]...=",
                "=Farmer Joe:: I'm mighty proud of you=",
                "=Farmer Joe:: You know, Chip, the farmer who used to own this farm never made it that far=",
                "*You arrogantly asked if they quit*",
                "=Farmer Joe:: Naw... they got into a wee bit of an accident=",
                "*Joe unfortunately proceeds to, in graphic detail, describe how a gang of rogue evil chickens turned him into a buffet for its children*",
                "=Farmer Joe:: Poor Chip never had a chance=",
                "*You apologize for your earlier arrogance*",
                "=Farmer Joe:: Don't sweat it, they would have done the same=",
                "=Farmer Joe:: You're a lot nicer than they ever were...=",
                "=Farmer Joe:: That's the reason why I'm not gonna teach you how to catch them hellspawn=",
                "=Farmer Joe:: Can't lose another neighbor, especially one like you=",
                "*The look on Joe's face is devastatingly sad*",
                "*You quickly think of a way to change the subject*",
                "+SO......+",
                "+How's family Joe+",
                "=Farmer Joe:: They're peaches! Sara Mae got married a couple of weeks ago=",
                "=Farmer Joe:: You should have been there, the ceremony was beautiful=",
                "*You invite Joe to be your plus one to Frank's vow renewal*",
                "*After you two discuss semantics, Joe heads back to his farm*"
            };
            public final String[] NEW_INFO_L2 = { //LEVEL 2 DIALOGUE
                "*NEW death!! \\Death via Angry Chicken\\*",
                "*Avoid heckling angry chickens by not angering them further!*",
                "*You wouldn't want to make Joe sad, would you?*",
                "Note: {Chomp Chomp: *Death by failing to placate a chicken in what it views as a reasonable amount of attempts*}"
            };
            public final String[] DIALOGUE_CS3 = {  //CUT SCENE 3 DIALOGUE
                "*You're shocked that after three years of no contact after his wedding, you becoming recognized by the greater metropolitan area of Cityville is all it takes for your good ole pal Frank to call you to catch up*",
                "~Frank:: Look [NAME]...~",
                "~Frank:: Don't take it too personally, but...~",
                "*You tell him you will take it extremely personally*",
                "~Frank:: ...Well...~",
                "~Frank:: Have you looked at the recent headliner?~",
                "*You have no idea what he's on about*",
                "+I have no idea what you're on about+",
                "~Frank:: ...~",
                "~Frank:: It's all over the news, buddy~",
                "*You inform him that you only watch HGTV+ and the International Chicken Channel*",
                "~Frank:: *sighs*~",
                "~Frank:: Of course you do~",
                "~Frank:: Some farmer that lived on your side of the city was attacked by his own chickens~",
                "~Frank:: What was his name...~",
                "*Luckily you went over to Joe's that day, so you already know he's fine*",
                "*Maybe Susan finally kicked the bucket-*",
                "~Frank:: I think it was Chandler...~",
                "~Frank:: Yeah, I think it was reported that he was trying to get recognized by the state and forgot to take care of his chickens~",
                "~Frank:: He came back one day, and that was it for him~",
                "*You mentally apologize to Susan for wishing death upon her and knock on wood*",
                "~Frank:: I don't want that to...~",
                "*You suddenly realize the true purpose of this call*",
                "*You immediately hang up on him*",
                "*The audacity, your chickens LOVE you*"
            };
    

    


    /*************METHODS**************/

        public void homeGUI()
        {
            //panelling for centering everything
                JPanel homeGUIPanel = new JPanel(); 
                homeGUIPanel.setLayout(new BoxLayout(homeGUIPanel, BoxLayout.PAGE_AXIS));


            //setting up the bNewG button
                bNewG.setPreferredSize(new Dimension(220, 50));
                bNewG.setMaximumSize(new Dimension(220, 50));
                bNewG.setAlignmentX(Component.CENTER_ALIGNMENT);
                homeGUIPanel.add(bNewG);
                
                //adding the action listener
                    bNewG.addActionListener(new ActionListener() {
                        // clicking on the button allows the user to enter the save they want to play
                        public void actionPerformed(ActionEvent e) {
                            //setting up the textbox
                                JTextArea gameName = new JTextArea(1, 20);
                                gameName.getDocument().putProperty("filterNewlines", Boolean.TRUE);
                                gameName.setMaximumSize(new Dimension(220, 50));
                                
                            bNewG.setText("Open/Create Save"); //updates button

                            //updates the window
                                homeGUIPanel.add(gameName);
                                homeWindow.revalidate();
                                homeWindow.repaint();
            
                            //new actionlistener for the newly changed button
                                bNewG.addActionListener(new ActionListener() {
                                    // clicking on the button either loads or creates a newSave
                                    public void actionPerformed(ActionEvent e) {
                                        //check to see whether the save existed first
                                        File saveFile = new File("ch_remastered/SAVEDATA"+"/"+ gameName.getText()+".chickgfs");

                                        //updates menu text
                                            if (saveFile.exists()) saveExistedBool = true;
                                            try {
                                                lSaveName.setText(RunGame.newSave(gameName.getText()));
                                                if (saveExistedBool) lSaveName.setText(RunGame.newSave(gameName.getText()) + "\nEXISTING SAVE");
                                                else lSaveName.setText(RunGame.newSave(gameName.getText()) + "\n NEW SAVE");
                                            } catch (IOException e1) {}
                                        //updates window
                                            homeWindow.remove(gameName);
                                            bNewG.setVisible(false);
                                            homeWindow.dispose();

                                        //starts the game
                                            try {
                                                Thread.sleep(1000);
                                            } catch (InterruptedException eu) {
                                                eu.printStackTrace();
                                            }
                                            startingGUI();
                                    }
                                });
                        }
                    });

            //adding the panel to the window
                homeGUIPanel.setVisible(true);
                homeWindow.add(homeGUIPanel);
                homeWindow.revalidate();
                homeWindow.repaint();
            
            //set window things
                homeWindow.setResizable(false);
                homeWindow.setTitle("Chicken Hunt Launcher");
                homeWindow.setSize(350, 300);
                homeWindow.setLocationRelativeTo(null);
                homeWindow.setVisible(true);
                homeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        public void startingGUI() {

            // lSave Name setup
            lSaveName.setBounds(10, 10, 100, 100);
            lSaveName.setAlignmentX(SwingConstants.RIGHT);
            lSaveName.setEditable(false);
            lSaveName.setLineWrap(true);
            lSaveName.setWrapStyleWord(true);
        
            // Menu setup
            menu.add(lSaveName);
            menu.setBounds(600, 30, 100, 200);
            bToggleMenu.setBounds(600, 0, 100, 30);
        
            // Menu actions
            if (!menuToggledBool) { 
                bToggleMenu.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menu.setVisible(true);
                        gameWindow.revalidate();
                        gameWindow.repaint();
                        menuToggledBool = true;
                    }
                });
            } else {
                bToggleMenu.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menu.setVisible(false);
                        gameWindow.revalidate();
                        gameWindow.repaint();
                        menuToggledBool = false;
                    }
                });
            }
        
            // GameWindow setup
            gameWindow.setSize(700, 500);
            gameWindow.setLocationRelativeTo(null);
            gameWindow.setLayout(null); // Set the layout before adding components
            gameWindow.add(bToggleMenu);
            gameWindow.add(menu);
            menu.setVisible(false);
            
            // Only set background after all components are added
            //gameWindow.setBackground(CHColors.CH_YELLOW);
            gameWindow.getContentPane().setBackground(CHColors.CH_YELLOW);
        
            // Starting game code
            JButton bPlay = new JButton("Play");
            bPlay.setBounds(SwingConstants.CENTER + 1 / 2 * 100, 200, 100, 50);
            bPlay.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!gameStartedBool) {
                        gameStartedBool = true;
                        gameWindow.remove(bPlay);
                        gameWindow.revalidate();
                        gameWindow.repaint();
                        beginingCutSceneGui();
                    }
                }
        
            });
        
            // GameWindow initial setup
            gameWindow.add(bPlay); // Add the Play button last, to avoid unnecessary repainting
            gameWindow.setVisible(true);
            gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gameWindow.setResizable(gameStartedBool);
        }
        
    public void beginingCutSceneGui() {
        //set-up 
            //bCont.setForeground(CHColors.CH_YELLOW);
            bCont.setBounds(425,410 , 220,50);
            bCont.setPreferredSize(new Dimension(220, 50));

            //gametext
            gameText.setBounds(10, 250, 680, 150);
            //custom font for the gametext
                try {
                    //create the font to use. Specify the size!
                    Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("ch_remastered/RESOURCES/fonts/home-video-font/HomeVideo-BLG6G.ttf")).deriveFont(24f);
                    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                    //register the font
                    ge.registerFont(customFont);
                    gameText.setFont(customFont);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch(FontFormatException e) {
                    e.printStackTrace();
                }
            gameText.setLineWrap(true);
            gameText.setWrapStyleWord(true);
            gameText.setForeground(CHColors.CH_BLACK);
            gameText.setBorder(new EmptyBorder(10, 15, 10, 15));
            pacer = 0;

            typeWriter(Dialogues.DIALOGUE_CS1[pacer]);
            pacer++;

            gameText.setEditable(false);
            gameText.setVisible(true);
            gameWindow.add(gameText);
            gameWindow.add(bCont);

        //setting userIn
            userIn = new JTextArea();
            userIn.setBounds(25,410 , 220, 50);
            gameWindow.add(userIn);
            userIn.setVisible(false);

        //updating window
            gameWindow.revalidate();
            gameWindow.repaint();
        
        // Menu actions
            bToggleMenu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!menuToggledBool) {
                        menu.setVisible(true);
                        menuToggledBool = true;
                    } else {
                        menu.setVisible(false);
                        menuToggledBool = false;
                    }
                    gameWindow.revalidate();
                    gameWindow.repaint();
                }
            });

        bCont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //gameText.setText(DIALOGUE_CS1[pacer]);
                typeWriter(Dialogues.DIALOGUE_CS1[pacer]);
                gameWindow.revalidate();
                gameWindow.repaint();
                //Important bits!!!
                //2 ~ Naming the farmer
                //15 ~ picking an occupation (1. Office worker\n 2. Mechanic\n 3. IT Technician")

                if (pacer == 2) {
                    userIn.setVisible(true);
                    userIn.getDocument().putProperty("filterNewlines", Boolean.TRUE);
                    bCont. setVisible(false);
                    gameWindow.remove(bCont);
                    JButton bConfName = new Button("Confirm");
                    bConfName.setBounds(425,410 , 220, 50);
                    bConfName.setPreferredSize(new Dimension(220, 50));

                    //updating window
                        gameWindow.add(bConfName);
                        gameWindow.revalidate();
                        gameWindow.repaint();
                    
                    //on click updates the playername and resets the window to how it was
                    bConfName.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            GameData.setPlayerName(userIn.getText());
                            //resetting
                                bCont. setVisible(true);
                                userIn.setVisible(false);
                                gameWindow.add(bCont);
                                gameWindow.remove(bConfName);
                                gameWindow.revalidate();
                                gameWindow.repaint();

                            //forcing updates
                                GameWindow.forceUpdate(Dialogues.DIALOGUE_CS1);
                                GameWindow.forceUpdate(DIALOGUE_TS1);
                                GameWindow.forceUpdate(DIALOGUE_CS2);
                                GameWindow.forceUpdate(NEW_INFO_L2);
                                GameWindow.forceUpdate(DIALOGUE_CS3);
                                //more to be added later
                        }
                    });
                }
                if (pacer == 15) {
                    userIn.setText("");
                    userIn.setVisible(true);
                    userIn.getDocument().putProperty("filterNewlines", Boolean.TRUE);
                    bCont. setVisible(false);
                    gameWindow.remove(bCont);
                    JButton bConfName = new Button("Confirm");
                    bConfName.setBounds(425,410 , 220, 50);
                    bConfName.setPreferredSize(new Dimension(220, 50));

                    //updating window
                        gameWindow.add(bConfName);
                        gameWindow.revalidate();
                        gameWindow.repaint();
                    
                    //on click updates the user's old occupation and resets the window to how it was
                    bConfName.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            //forcing updates
                            if (isInteger(userIn.getText())) {
                                GameWindow.forceUpdate(Dialogues.DIALOGUE_CS1,Integer.parseInt(userIn.getText()));
                            } else {
                                GameWindow.forceUpdate(Dialogues.DIALOGUE_CS1,1000);
                            }
                            

                            //resetting
                                bCont. setVisible(true);
                                userIn.setVisible(false);
                                gameWindow.add(bCont);
                                gameWindow.remove(bConfName);
                                gameWindow.revalidate();
                                gameWindow.repaint();
                        }
                    });
                }
                if (pacer == 23) {
                    bCont. setVisible(false);
                    gameWindow.remove(bCont);
                    JButton bConfName = new Button("Tutorial");
                    bConfName.setBounds(425,410 , 220, 50);
                    bConfName.setPreferredSize(new Dimension(220, 50));

                    //updating window
                        gameWindow.add(bConfName);
                        gameWindow.revalidate();
                        gameWindow.repaint();
                    
                    //on click starts the tutorial
                    bConfName.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            tutorialGUI();
                            bCont. setVisible(true);
                            gameWindow.add(bCont);
                            gameWindow.remove(bConfName);
                            GameData.incPacer();
                        }
                    });
                }
                pacer++; // Increment the pacer each time

            }             
        });
    }

    public void tutorialGUI() {
        //bCont button stuff
        pacer = 0;
        bCont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //gameText.setText(DIALOGUE_CS1[pacer]);
                typeWriter(DIALOGUE_TS1[pacer]);
                gameWindow.revalidate();
                gameWindow.repaint();
                //Important bits!!!
                //13
                //33
                pacer++; // Increment the pacer each time

            }             
        });
        gameWindow.getContentPane().setBackground(CHColors.CH_BROWN);//tutorialbrown
        gameWindow.revalidate();
        gameWindow.repaint();
    }
    

    public static void forceUpdate(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].replace("[NAME]", GameData.getPlayerName());
        }
    }
    
    public static void forceUpdate(String[] arr, int x) {
        //(1. Office worker\n 2. Mechanic\n 3. IT Technician")
        String string;
        if (x == 1) {
            string = "OFFICE WORKER";
        } else if (x == 2) {
            string = "MECHANIC";
        } else if (x == 3) {
            string = "IT TECHNICIAN";
        } else {
            string = "PROFESSIONAL TOAD CATCHER";
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].replace("[OCCUPATION]", string);
        }
    }

    public static void typeWriter(String text) {
        Timer timer = new Timer(20, new ActionListener() {
            StringBuilder displayedText = new StringBuilder();
            int index = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (index < text.length()) {
                    displayedText.append(text.charAt(index));
                    gameText.setText(displayedText.toString());
                    index++;
                } else {
                    ((Timer) e.getSource()).stop(); // Stop timer when done
                }
            }
        });
        timer.start();
    }
    
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }



    public static void main(String args[]) {
        
        GameWindow yo = new GameWindow();
        yo.homeGUI();
    }
}
