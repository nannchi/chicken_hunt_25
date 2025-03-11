package ch_remastered;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;


public class GameWindow {
    JButton bNewG, bLoadG;
    JFrame wGameWindow, wPopUp;
    public void showGUI()
    {
        // Creating instance of JFrame
        wGameWindow = new JFrame();
        bNewG = new JButton("New Game");
        bLoadG = new JButton("Load Game");

        /**
         * lines 20-75 all relate to the "home screen" buttons and loading mechanism
         */
        bNewG.setBounds(150, 200, 220, 50);
        wGameWindow.add(bNewG);
        bNewG.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Action 1
                JTextArea gameName = new JTextArea(1, 20);
                gameName.getDocument().putProperty("filterNewlines", Boolean.TRUE);
                gameName.setBounds(150, 260, 220, 50);
                bLoadG.setVisible(false);
                //revalidate() and repaint()
                wGameWindow.revalidate();
                wGameWindow.repaint();

                wGameWindow.add(gameName);
                bNewG.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            RunGame.newSave(gameName.getText());
                        } catch (IOException e1) {
                        }
                        wGameWindow.remove(gameName);
                        bNewG.setVisible(false);
                        wGameWindow.revalidate();
                        wGameWindow.repaint();
                    }
                });
                    
                
            }
        });
        bLoadG.setBounds(150, 260, 220, 50);
        wGameWindow.add(bLoadG);
        bLoadG.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextArea gameName = new JTextArea(1, 20);
                gameName.getDocument().putProperty("filterNewlines", Boolean.TRUE);
                gameName.setBounds(150, 260, 220, 50);
                bLoadG.setBounds(150, 200, 220, 50);
                bNewG.setVisible(false);
                //revalidate() and repaint()
                wGameWindow.revalidate();
                wGameWindow.repaint();

                wGameWindow.add(gameName);
                bLoadG.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        RunGame.loadSave(gameName.getText());
                        wGameWindow.remove(gameName);
                        bLoadG.setVisible(false);
                        wGameWindow.revalidate();
                        wGameWindow.repaint();
                    }
                    
                });
            }
        });


        // 400 width and 500 height
        wGameWindow.setSize(500, 600);
        wGameWindow.setLocationRelativeTo(null);
        

        // using no layout managers
        wGameWindow.setLayout(null);

        // making the frame visible
        wGameWindow.setVisible(true);
        wGameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String args[]) {
        GameWindow yo = new GameWindow();
        yo.showGUI();
    }
}
