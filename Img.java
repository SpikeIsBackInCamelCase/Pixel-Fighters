import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Img {
                                    //PASTE YOUR PATH HERE FOR IMAGE CALIBRATION
    public static String filePath = "C:\\Users\\surfd\\OneDrive\\Desktop\\PixelFighterPrimitive";
    public static void printImage(String path) {
        try {
            // Read the image from the file
            BufferedImage image = ImageIO.read(new File(filePath + "\\" + path));

            // Create a JFrame to display the image
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(image.getWidth(), image.getHeight());

            // Create a JLabel to hold the image
            JLabel label = new JLabel(new ImageIcon(image));

            // Add the JLabel to the JFrame
            frame.add(label);

            // Make the JFrame visible
            frame.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}