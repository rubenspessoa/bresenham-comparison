package GUI;

import OpenGL.BresenhamBasketBallCourt;
import OpenGL.SimpleBasketBallCourt;
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
        screen.setSize(400, 65);
        screen.setLayout(new GridBagLayout());
        screen.setVisible(true);

    }

    private void equationsScreen() {

        secondPanel = new JPanel(new BorderLayout());

        // First Row

        JPanel firstRow = new JPanel();

        JButton plotEquationBtn = new JButton("Plot line with equation");
        JButton plotBresenhamBtn = new JButton("Plot line with bresenham");

        firstRow.add(plotEquationBtn);
        firstRow.add(plotBresenhamBtn);
        secondPanel.add(firstRow, BorderLayout.NORTH);

        // Second Row

        JPanel secondRow = new JPanel();

        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities((profile));

        glPanel = new GLJPanel(capabilities);
        SimpleBasketBallCourt simpleBC = new SimpleBasketBallCourt();
        glPanel.addGLEventListener(simpleBC);
        glPanel.setPreferredSize(new Dimension(400, 400));

        secondRow.add(glPanel);
        secondRow.setPreferredSize(new Dimension(400, 400));
        secondPanel.add(secondRow, BorderLayout.CENTER);

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
        secondPanel.add(thirdRow, BorderLayout.SOUTH);

        secondScreen = new JFrame("Basketball court w/Equations");
        secondScreen.add(secondPanel);
        secondScreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        secondScreen.pack();
        secondScreen.setVisible(true);
        screen.setVisible(false);

    }

    private void bresenhamScreen() {

        secondPanel = new JPanel(new BorderLayout());

        // First Row

        JPanel firstRow = new JPanel();

        JButton plotEquationBtn = new JButton("Plot line with equation");
        JButton plotBresenhamBtn = new JButton("Plot line with bresenham");

        firstRow.add(plotEquationBtn);
        firstRow.add(plotBresenhamBtn);
        secondPanel.add(firstRow, BorderLayout.NORTH);

        // Second Row

        JPanel secondRow = new JPanel();

        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities((profile));

        glPanel = new GLJPanel(capabilities);
        BresenhamBasketBallCourt simpleBC = new BresenhamBasketBallCourt();
        glPanel.addGLEventListener(simpleBC);
        glPanel.setPreferredSize(new Dimension(400, 400));

        secondRow.add(glPanel);
        secondRow.setPreferredSize(new Dimension(400, 400));
        secondPanel.add(secondRow, BorderLayout.CENTER);

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
        secondPanel.add(thirdRow, BorderLayout.SOUTH);

        secondScreen = new JFrame("Basketball court w/Bresenham");
        secondScreen.add(secondPanel);
        secondScreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        secondScreen.pack();
        secondScreen.setVisible(true);
        screen.setVisible(false);
    }

}