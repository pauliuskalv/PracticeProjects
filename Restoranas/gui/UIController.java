package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class UIController
{
    private static final int sizeX = 500;
    private static final int sizeY = 500;
    private static JFrame mainFrame;
    public static void main (String[] args)
    {
        mainFrame = new JFrame("RestaurantManagement");
        mainFrame.setSize(sizeX,sizeY);
        updateWindow(InitialPanel.init());
        mainFrame.setVisible(true);
    }
    public static void updateWindow(JPanel panel)
    {
        mainFrame.removeAll();

        mainFrame.add(panel);

        mainFrame.validate();
        mainFrame.repaint();
    }
}