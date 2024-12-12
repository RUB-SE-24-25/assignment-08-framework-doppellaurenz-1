package structra.assignment.task.de.rub.client;

import javax.swing.*;
import java.awt.*;

public class GUI {

    private static void createAndShowGUI() {
        // Create and set up the window
        JFrame frame = new JFrame("GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the "Hello World" label to the center of the window
        JLabel label = new JLabel("Hello World", SwingConstants.CENTER);
        JButton button1 = new JButton("Next Question");
        frame.getContentPane().add(button1);


        // Adjust position of the window
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        int frameWidth = (int) (width / 2);
        int frameHeight = (int) (height / 4);
        frame.setLocation((int) (width - frameWidth) / 2, (int) (height - frameHeight) / 2);
        frame.setSize(frameWidth, frameHeight);

        // Display the window
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(structra.assignment.task.de.rub.client.GUI::createAndShowGUI);
    }
}

