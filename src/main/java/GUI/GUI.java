package GUI;

import OpenGL.SimpleBasketBallCourtFrame;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by rubenspessoa on 01/03/17.
 */
public class GUI {

    private JFrame screen;
    private JPanel mainPanel;
    private JFrame secondScreen;
    private JPanel secondPanel; // Stays in the top of the screen
    private GLJPanel glPanel; // Remaining space

    public void initiate() {
        prepareWindow();
        prepareMainPanel();
        prepareEquationsBtn();
        prepareBresenhamBtn();
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

    private void prepareMainPanel() {
        mainPanel = new JPanel(new GridLayout(1,1));
        screen.add(mainPanel);
    }

    private void showWindow() {
        screen.pack();
        screen.setSize(540,100);
        screen.setLayout(new CardLayout());
        screen.setVisible(true);
    }

    private void equationsScreen() {
        secondScreen = new JFrame("Basketball court w/Equations");
        //secondPanel = new JPanel(new GridLayout(2, 1));

        prepareButtonsOnPlottingScreen();
        prepareSecondScreen();
        showSecondScreen();

    }

    private void bresenhamScreen() {
        secondPanel = new JPanel(new GridLayout(5, 1));
        secondScreen = new JFrame("basketball court w/Bresenham");

        prepareButtonsOnPlottingScreen();
        prepareGLJPanel();

        SimpleBasketBallCourtFrame simpleBC = new SimpleBasketBallCourtFrame();
        glPanel.addGLEventListener(simpleBC);
        glPanel.setSize(400, 400);

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

        JPanel firstRow = new JPanel(new GridLayout(1, 3));
        firstRow.add(plotEquationBtn);
        firstRow.add(plotBresenhamBtn);
        firstRow.add(goBackBtn);
        secondPanel.add(firstRow);
    }

    private void showSecondScreen() {
        secondScreen.pack();
        secondScreen.setSize(540, 540);
        secondScreen.setVisible(true);
        screen.setVisible(false);
    }

    private void prepareGLJPanel() {
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities((profile));

        JPanel secondRow = new JPanel(new GridLayout(4, 1));
        glPanel = new GLJPanel(capabilities);
        secondRow.add(glPanel);
        secondPanel.add(secondRow);
    }
}