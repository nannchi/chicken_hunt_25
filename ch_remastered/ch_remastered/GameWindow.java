package ch_remastered;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;


public class GameWindow {
    JButton bNewG;
    JButton bCont = new JButton("Continue");

    JButton bToggleMenu = new JButton("Toggle Menu");
    boolean menuToggledBool = false;

    JTextArea userIn = new JTextArea(1, 20);
    JTextArea lSaveName = new JTextArea();
    //maybe eventually turn into jlist
    boolean saveExistedBool;
    boolean gameStartedBool;
    JPanel gamePanel = new JPanel();
    
    JTable gameText;

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
        String[][] gameTextUpdater = {};
        String[] speakingCur = {};
        bPlay.setBounds(SwingConstants.CENTER + 1/2 * 100, 200, 100, 50);
        bPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!gameStartedBool) {
                    gameStartedBool = true;
                    gameWindow.remove(bPlay);
                    gameWindow.revalidate();
                    gameWindow.repaint();
                }
            }
            
        });

        if (gameStartedBool) {
            //BEGINNING CUT SCENE
            bCont.setBounds(SwingConstants.CENTER + 1/2*100, SwingConstants.BOTTOM - 100, 100, 50);
            gameTextUpdater[0][0] = "*You're discussing your dream of starting a new chicken farm with your good ole pal Frank*";
            speakingCur[0] = "Narrator";
            gameText = new JTable(gameTextUpdater, speakingCur);
            gameText.setBounds(30, 40, 200, 300);
            gameText.setVisible(true);
            gameWindow.add(gameText);
            gameWindow.add(bCont);
            gameWindow.revalidate();
            gameWindow.repaint();

        }
        
        
        gameWindow.add(bToggleMenu);
        gameWindow.add(menu);
        gameWindow.add(bPlay);
        

        gameWindow.setLayout(null);

        gameWindow.setVisible(true);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public int xCenter(JFrame frame) {
        return (frame.getWidth()/2);
    }


    public static void main(String args[]) {
        GameWindow yo = new GameWindow();
        yo.homeGUI();
    }
}
