package GUI;

import OpenGL.SimpleBasketBallCourtFrame;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;

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
        screen = new JFrame("Computer Graphics First Project");
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel(new GridLayout(1, 1));
        screen.add(mainPanel);

        JButton equationsBtn = new JButton("Equations");
        equationsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                equationsScreen();
            }
        });
        mainPanel.add(equationsBtn);

        JButton bresenhamBtn = new JButton("Bresenham");
        bresenhamBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bresenhamScreen();
            }
        });
        mainPanel.add(bresenhamBtn);

        screen.pack();
        screen.setSize(540, 65);
        screen.setLayout(new GridBagLayout());
        screen.setVisible(true);

    }

    private void equationsScreen() {
        //secondScreen = new JFrame("Basketball court w/Equations");
        //secondPanel = new JPanel(new GridLayout(2, 1));

    }

    private void bresenhamScreen() {

        secondPanel = new JPanel();

        // First Row

        JPanel firstRow = new JPanel();

        JButton plotEquationBtn = new JButton("Plot line with equation");
        JButton plotBresenhamBtn = new JButton("Plot line with bresenham");

        firstRow.add(plotEquationBtn);
        firstRow.add(plotBresenhamBtn);
        secondPanel.add(firstRow);

        // Second Row

        JPanel secondRow = new JPanel();

        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities((profile));

        glPanel = new GLJPanel(capabilities);
        SimpleBasketBallCourtFrame simpleBC = new SimpleBasketBallCourtFrame();
        glPanel.addGLEventListener(simpleBC);
        //glPanel.setSize(400, 400);

        secondRow.add(glPanel);
        secondPanel.add(secondRow);

        // Third Row

        JPanel thirdRow = new JPanel();

        JButton goBackBtn = new JButton("Go Back!");

        goBackBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secondScreen.setVisible(false);
                screen.setVisible(true);
            }
        });

        thirdRow.add(goBackBtn);
        secondPanel.add(thirdRow);

        secondScreen = new JFrame("Basketball court w/Bresenham");
        secondScreen.add(secondPanel);
        secondScreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        secondScreen.pack();
        //secondScreen.setSize(540, 540);
        secondScreen.setVisible(true);
        screen.setVisible(false);
    }

}