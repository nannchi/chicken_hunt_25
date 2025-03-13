package ch_remastered.chickies;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;

import ch_remastered.chickies.colors.CHColors;

public class Button extends JButton{

    public Button(String text) {
        super(text);
        this.init();
    }

    private void init() {
        try {
            //create the font to use. Specify the size!
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("ch_remastered/RESOURCES/fonts/home-video-font/HomeVideo-BLG6G.ttf")).deriveFont(24f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(customFont);
            this.setFont(customFont);
        } catch (IOException e) {
            e.printStackTrace();
        } catch(FontFormatException e) {
            e.printStackTrace();
        }
        this.setForeground(CHColors.CH_YELLOW);

        this.setContentAreaFilled(false);
        this.setBorderPainted(false);

        this.setBackground(CHColors.CH_ORANGE);
        this.setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        RenderingHints hints = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON
        );
        g2d.setRenderingHints(hints);
        g2d.setColor(getBackground());
        g2d.fill(new RoundRectangle2D.Double(0, 0, super.getWidth() - 1, super.getHeight() - 1, 15, 15));
        g2d.setColor(getForeground());
        super.paintComponent(g2d);
        g2d.dispose();
    }


}
