package ch_remastered;

import java.awt.Color;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;


public class GameWindow {
    JButton bNewG;
    JFrame homeWindow = new JFrame(), wPopUp = new JFrame(), gameWindow = new JFrame();
    JLabel lSaveName = new JLabel();
    JPanel menu = new JPanel();
    public void homeGUI()
    {
        bNewG = new JButton("New Save/Load Save");


        bNewG.setBounds(150, 200, 220, 50);
        homeWindow.add(bNewG);
        bNewG.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Action 1
                JTextArea gameName = new JTextArea(1, 20);
                gameName.getDocument().putProperty("filterNewlines", Boolean.TRUE);
                gameName.setBounds(150, 260, 220, 50);
                //revalidate() and repaint()
                homeWindow.revalidate();
                homeWindow.repaint();

                homeWindow.add(gameName);
                bNewG.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            lSaveName.setText(RunGame.newSave(gameName.getText()));
                        } catch (IOException e1) {
                        }
                        homeWindow.remove(gameName);
                        bNewG.setVisible(false);
                        startingGUI();
                        homeWindow.dispose();
                        
                    }
                });
                    
                
            }
        });
        

        // 400 width and 500 height
        homeWindow.setSize(500, 600);
        homeWindow.setLocationRelativeTo(null);
        

        // using no layout managers
        homeWindow.setLayout(null);

        // making the frame visible
        homeWindow.setVisible(true);
        homeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void startingGUI(){
        lSaveName.setBounds(10, 10, 200, 20);
        menu.add(lSaveName);
        menu.setBounds(600, 0, 100, 200);
        menu.setVisible(false);
        gameWindow.setSize(700,500);
        gameWindow.setLocationRelativeTo(null);
        

        // using no layout managers
        gameWindow.setLayout(null);

        // making the frame visible
        gameWindow.setVisible(true);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setBackground(new Color(360,360,360));
        //gameWindow.addKeyListener();
    }


    public static void main(String args[]) {
        GameWindow yo = new GameWindow();
        yo.homeGUI();
    }
}
