package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import gui.IUI;

public class InitialPanel
{
    private static final int hgap = 0;
    private static final int vgap = 20;
    public static JPanel init()
    {
        JPanel toReturn = new JPanel(new CardLayout(hgap,vgap));

        /**
         * Create username field
         */
        JPanel usernamePanel = null;
        usernamePanel = new JPanel ();
        usernamePanel.setLayout(new BoxLayout(usernamePanel,BoxLayout.X_AXIS));

        JLabel usernameLabel = new JLabel("Username:");

        JTextField usernameField = new JTextField("");

        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);

        toReturn.add(usernamePanel);

        return toReturn;
    }
}