package GUI;

import OpenGL.BresenhamBasketBallCourt;
import OpenGL.SimpleBasketBallCourt;
import util.LineSettings;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;

import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit.Parser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/**
 * Created by rubenspessoa on 01/03/17.
 */
public class GUI {

	private JFrame screen;
	private JPanel mainPanel;
	private JFrame secondScreen;
	private JPanel secondPanel; // Stays in the top of the screen
	private GLJPanel bresenhamgGlPanel;
	private GLJPanel simpleGlPanel;
	private GLJPanel glPanel;
	private SimpleBasketBallCourt simpleBC;
	private BresenhamBasketBallCourt bresenhamBC;

	private LineSettings lineSettings;
	private JButton saveLineSettingButon;
	private JPanel lineSettingPanel;

	private JLabel redInputLabel;
	private JTextField redField;
	private JLabel greenInputLabel;
	private JTextField greenField;
	private JLabel blueInputLabel;
	private JTextField blueField;
	private JLabel lineWidthInputLabel;
	private JTextField lineWidthField;

	private Point pointOne;
	private Point pointTwo;
	private int clicks = 0;
	
	private String secondScreenTitle = "Basketball Court";

	private boolean bresenhamFlag = false;

	public final static int WIDTH = 800;
	public final static int HEIGHT = 800;

	public GUI() {
		pointOne = new Point();
		pointTwo = new Point();
		lineSettings = new LineSettings(1f, 1f, 1f, 1);
	}

	public void initiate() {

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		screen = new JFrame("Computer Graphics First Project");
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel(new GridLayout(1, 1));
		screen.add(mainPanel);

		JButton equationsBtn = new JButton("Equations");
		equationsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secondScreenTitle = "Basketball Court w/Equation";
				firstScreenRow();
				generalScreen(false);
				// equationsScreen();
				thirdScreenRow();
				clicks = 0;				
			}
		});
		mainPanel.add(equationsBtn);

		JButton bresenhamBtn = new JButton("Bresenham");
		bresenhamBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secondScreenTitle = "Basketball Court w/Bresenham";
				firstScreenRow();
				generalScreen(true);
				// bresenhamScreen();
				thirdScreenRow();
				clicks = 0;
			}
		});
		mainPanel.add(bresenhamBtn);

		screen.pack();
		screen.setSize(WIDTH, 80);
		screen.setLocation(dim.width / 2 - screen.getSize().width / 2, dim.height / 2 - screen.getSize().height / 2);
		screen.setLayout(new GridBagLayout());
		screen.setVisible(true);

	}

	private void generalScreen(boolean bresenhamFlag) {

		// Second Row for Equation Screen

		JPanel secondRow = new JPanel();

		GLProfile profile = GLProfile.getDefault();
		GLCapabilities capabilities = new GLCapabilities(profile);

		glPanel = new GLJPanel(capabilities);
		glPanel.setOpaque(false);
		if (bresenhamFlag) {
			bresenhamBC = new BresenhamBasketBallCourt(this);
			glPanel.addGLEventListener(bresenhamBC);
		} else {
			simpleBC = new SimpleBasketBallCourt(this);
			glPanel.addGLEventListener(simpleBC);
		}
		
		glPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));

		glPanel.addMouseListener(new java.awt.event.MouseListener() {

			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				clicks++;

				if ((clicks % 2) != 0) {
					pointOne.x = e.getX();
					pointOne.y = e.getY();
				} else if ((clicks % 2) == 0) {
					pointTwo.x = e.getX();
					pointTwo.y = e.getY();

					glPanel.repaint();
				}

			}
		});

		secondRow.add(glPanel);
		secondRow.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		secondPanel.add(secondRow, BorderLayout.CENTER);

	}

	private void firstScreenRow() {

		secondPanel = new JPanel(new BorderLayout());

		// First Row

		JPanel firstRow = new JPanel();

		createLineDialog();

		final JButton plotEquationBtn = new JButton("Plot line with equation");
		final JButton plotBresenhamBtn = new JButton("Plot line with bresenham");

		plotEquationBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bresenhamFlag = false;
				plotEquationBtn.setEnabled(false);
				plotBresenhamBtn.setEnabled(true);
			}
		});

		plotBresenhamBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bresenhamFlag = true;
				plotBresenhamBtn.setEnabled(false);
				plotEquationBtn.setEnabled(true);
			}
		});

		firstRow.add(plotEquationBtn);
		firstRow.add(plotBresenhamBtn);
		firstRow.add(createLineDialog(), BorderLayout.SOUTH);

		if (bresenhamFlag) {
			plotEquationBtn.setEnabled(true);
			plotBresenhamBtn.setEnabled(false);
		} else {
			plotEquationBtn.setEnabled(false);
			plotBresenhamBtn.setEnabled(true);
		}

		secondPanel.add(firstRow, BorderLayout.NORTH);

	}

	private JPanel createLineDialog() {
		lineSettingPanel = new JPanel();

		redInputLabel = new JLabel("Red");
		redField = new JTextField(5);
		redField.setText(Float.toString(lineSettings.getRed()));

		greenInputLabel = new JLabel("Green");
		greenField = new JTextField(5);
		greenField.setText(Float.toString(lineSettings.getGreen()));
		
		blueInputLabel = new JLabel("Blue");
		blueField = new JTextField(5);
		blueField.setText(Float.toString(lineSettings.getBlue()));

		lineWidthInputLabel = new JLabel("LineWidth");
		lineWidthField = new JTextField(5);
		lineWidthField.setText(Float.toString(lineSettings.getLineWidth()));

		saveLineSettingButon = new JButton("Apply");
		saveLineSettingButon.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				lineSettings.setRed(Float.parseFloat(redField.getText()));
				lineSettings.setGreen(Float.parseFloat(greenField.getText()));
				lineSettings.setBlue(Float.parseFloat(blueField.getText()));
				lineSettings.setLineWidth(Float.parseFloat(lineWidthField.getText()));
				
				System.out.println(lineSettings.getLineWidth());
			}
		});

		lineSettingPanel.add(redInputLabel);
		lineSettingPanel.add(redField);
		lineSettingPanel.add(greenInputLabel);
		lineSettingPanel.add(greenField);
		lineSettingPanel.add(blueInputLabel);
		lineSettingPanel.add(blueField);
		lineSettingPanel.add(lineWidthInputLabel);
		lineSettingPanel.add(lineWidthField);
		lineSettingPanel.add(saveLineSettingButon);

		return lineSettingPanel;
	}

	private void thirdScreenRow() {

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

		secondScreen = new JFrame(secondScreenTitle);
		secondScreen.add(secondPanel);
		secondScreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		secondScreen.pack();
		secondScreen.setVisible(true);
		secondScreen.setLocationRelativeTo(screen);
		screen.setVisible(false);

	}

	public Point getPointOne() {
		return pointOne;
	}

	public Point getPointTwo() {
		return pointTwo;
	}

	public int getClicks() {
		return clicks;
	}

	public GLJPanel getBresenhamgGlPanel() {
		return bresenhamgGlPanel;
	}

	public GLJPanel getSimpleGlPanel() {
		return simpleGlPanel;
	}

	public LineSettings getLineSettings() {
		return lineSettings;
	}

	public boolean bresenhamFlag() {
		return bresenhamFlag;
	}
}