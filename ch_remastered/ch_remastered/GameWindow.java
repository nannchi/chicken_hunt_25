package ch_remastered;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;


public class GameWindow {
    Font defaultFont = new Font("Monospace", Font.PLAIN, 18);

    JButton bNewG;
    JButton bCont = new JButton("Continue");

    JButton bToggleMenu = new JButton("Toggle Menu");
    boolean menuToggledBool = false;
    JButton bSaveButton = new JButton("Save Game");

    JTextArea userIn = new JTextArea(1, 20);
    JTextArea lSaveName = new JTextArea();
    //maybe eventually turn into jlist
    boolean saveExistedBool;
    boolean gameStartedBool;
    JPanel gamePanel = new JPanel();
    
    JTextArea gameText = new JTextArea(4, 30);
    int pacer = 0;
    private final String[] DIALOGUECS1 = {
        "*You're discussing your dream of starting a new chicken farm with your good ole pal Frank*",
        "~Frank:: Say there....~",
        "[NAMING YOUR FARMER]",
        "+...+",
        "+...+",
        "+...+",
        "+...Its [NAME]...+",
        "+Frank, we've known each other for decades....+",
        "+You were my best man at all 5 of my weddings?*",
        "~Frank:: Right.....~",
        "+You're my best friend?????????????????+",
        "~Frank:: And I don't doubt that, [NAME]~",
        "~Frank:: Anyways buddy, you've been a....~",
        "~Frank:: A......~",
        "~Frank:: A-~",
        "[CHOOSE FORMER OCCUPATION]",
        "+FRANK I'VE BEEN A [OCCUPATION] FOR THE PAST TWENTY YEARS+",
        "+WE WORK TOGETHER??????+",
        "~Frank:: Oh...~",
        "~Frank:: RIGHT!~",
        "~Frank:: So why throw it all away?~",
        "*You begin to tell him all the reasons why, but before you can get to the climax, Frank interrupts you*",
        "~Frank:: I can respect that~",
        "*You decide to quit your job to be a chicken farmer despite Frank's vehement objections*"
    };
    

    JFrame homeWindow = new JFrame(), wPopUp = new JFrame(), gameWindow = new JFrame();
    
    JPanel menu = new JPanel();




    public void homeGUI()
    {
        JPanel homeGUIPanel = new JPanel();
        homeGUIPanel.setLayout(new BoxLayout(homeGUIPanel, BoxLayout.PAGE_AXIS));
        bNewG = new JButton("New Save/Load Save");


        bNewG.setPreferredSize(new Dimension(220, 50));
        bNewG.setMaximumSize(new Dimension(220, 50));


        bNewG.setAlignmentX(Component.CENTER_ALIGNMENT);
        homeGUIPanel.add(bNewG);
        homeWindow.add(homeGUIPanel);
        homeWindow.revalidate();
        homeWindow.repaint();
        

        homeGUIPanel.setVisible(true);
        bNewG.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Action 1
                JTextArea gameName = new JTextArea(1, 20);
                gameName.getDocument().putProperty("filterNewlines", Boolean.TRUE);
                gameName.setMaximumSize(new Dimension(220, 50));
                bNewG.setText("Open/Create Save");
                //revalidate() and repaint()
                homeGUIPanel.add(gameName);
                
                homeWindow.revalidate();
                homeWindow.repaint();

                
                bNewG.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        //check to see whether the save existed first
                        File saveFile = new File("ch_remastered/SAVEDATA"+"/"+ gameName.getText()+".txt");
                        if (saveFile.exists()) saveExistedBool = true;
                        try {
                            lSaveName.setText(RunGame.newSave(gameName.getText()));
                            if (saveExistedBool) lSaveName.setText(RunGame.newSave(gameName.getText()) + "\nEXISTING SAVE");
                            else lSaveName.setText(RunGame.newSave(gameName.getText()) + "\n NEW SAVE");
                        } catch (IOException e1) {
                        }
                        homeWindow.remove(gameName);
                        bNewG.setVisible(false);
                        homeWindow.dispose();
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException eu) {
                            eu.printStackTrace();
                        }
                        startingGUI();
                    }
                });
                    
                
            }
        });
        

        homeWindow.setSize(500, 600);
        homeWindow.setLocationRelativeTo(null);
        

        homeWindow.setVisible(true);
        homeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void startingGUI(){

        //lSave Name setup
        lSaveName.setBounds(10, 10, 100, 100);
        lSaveName.setAlignmentX(SwingConstants.RIGHT);
        lSaveName.setEditable(false);
        lSaveName.setLineWrap(true);
        lSaveName.setWrapStyleWord(true);


        //menu setup
        menu.add(lSaveName);
        menu.setBounds(600, 30, 100, 200);
        menu.setVisible(false);
        bToggleMenu.setBounds(600, 0, 100, 30);
        if (!menuToggledBool) { //menu actions
            bToggleMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(true);
                gameWindow.revalidate();
                gameWindow.repaint();
                menuToggledBool = true;
                bToggleMenu.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        menu.setVisible(false);
                        gameWindow.revalidate();
                        gameWindow.repaint();
                        menuToggledBool = false;
                        
                        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
                    }
                    
                });
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        }

        //gameWindow setup
        gameWindow.setSize(700,500);
        gameWindow.setLocationRelativeTo(null);

        
        ////////GAME CODE/////////////
        //should be a button start play:
        JButton bPlay = new JButton("Play");
        bPlay.setBounds(SwingConstants.CENTER + 1/2 * 100, 200, 100, 50);
        bPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!gameStartedBool) {
                    gameStartedBool = true;
                    gameWindow.remove(bPlay);
                    gameWindow.revalidate();
                    gameWindow.repaint();
                    beginingCutSceneGui();
                }
            }
            
        });

        
        
        
        gameWindow.add(bToggleMenu);
        gameWindow.add(menu);
        gameWindow.add(bPlay);
        

        gameWindow.setLayout(null);

        gameWindow.setVisible(true);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void beginingCutSceneGui() {
        
        //set-up 
        bCont.setBounds(425,410 , 220, 50);
        gameText.setBounds(10, 250, 680, 150);
        gameText.setFont(defaultFont);
        gameText.setLineWrap(true);
        gameText.setWrapStyleWord(true);
        pacer = 0;

        gameText.setText(DIALOGUECS1[pacer]);
        pacer++;

        gameText.setEditable(false);
        gameText.setVisible(true);
        gameWindow.add(gameText);
        gameWindow.add(bCont);
        gameWindow.revalidate();
        gameWindow.repaint();

        
        bCont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameText.setText(DIALOGUECS1[pacer]);
                pacer++; // Increment the pacer each time
                gameWindow.revalidate();
                gameWindow.repaint();
            }             
        });
    }

    public void tutorialGUI() {

    }
    

    public int xCenter(JFrame frame) {
        return (frame.getWidth()/2);
    }


    public static void main(String args[]) {
        GameWindow yo = new GameWindow();
        yo.homeGUI();
    }
}
