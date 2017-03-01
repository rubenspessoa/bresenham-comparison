package GUI;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by rubenspessoa on 01/03/17.
 */
public class GUI {

    private JFrame screen;
    private JPanel mainPanel;
    private JFrame secondScreen;
    private JPanel secondPanel;

    public void initiate() {

        prepareWindow();
        prepareMainPanel();
        prepareEquationsBtn();
        prepareBresenhamBtn();
        prepareExitBtn();
        showWindow();

    }

    private void prepareWindow() {
        screen = new JFrame("Computer Graphics First Project");
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void prepareEquationsBtn() {
        JButton equationsBtn = new JButton("Equations");

        equationsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equationsScreen();
            }
        });

        mainPanel.add(equationsBtn);
    }

    private void prepareBresenhamBtn() {
        JButton bresenhamBtn = new JButton("Bresenham");

        bresenhamBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bresenhamScreen();
            }
        });

        mainPanel.add(bresenhamBtn);
    }

    private void prepareExitBtn() {
        JButton exitBtn = new JButton("Exit");

        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        mainPanel.add(exitBtn);
    }

    private void prepareMainPanel() {
        mainPanel = new JPanel();
        screen.add(mainPanel);
    }

    private void showWindow() {
        screen.pack();
        screen.setVisible(true);
    }

    private void equationsScreen() {

        prepareButtonsOnPlottingScreen();
        secondScreen = new JFrame("Plotting w/Equations");
        prepareSecondScreen();
        showSecondScreen();

    }

    private void bresenhamScreen() {
        prepareButtonsOnPlottingScreen();
        secondScreen = new JFrame("Plotting w/Bresenham");
        prepareSecondScreen();
        showSecondScreen();
    }

    private void prepareSecondScreen() {
        secondScreen.add(secondPanel);
        secondScreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private void prepareButtonsOnPlottingScreen() {

        JButton plotEquationBtn = new JButton("Plot line with equation");
        JButton plotBresenhamBtn = new JButton("Plot line with bresenham");
        JButton goBackBtn = new JButton("Go Back!");

        goBackBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secondScreen.setVisible(false);
                screen.setVisible(true);
            }
        });

        secondPanel = new JPanel();
        secondPanel.add(plotEquationBtn);
        secondPanel.add(plotBresenhamBtn);
        secondPanel.add(goBackBtn);

    }

    private void showSecondScreen() {
        secondScreen.pack();
        secondScreen.setSize(540, 540);
        secondScreen.setVisible(true);
        screen.setVisible(false);
    }

}
