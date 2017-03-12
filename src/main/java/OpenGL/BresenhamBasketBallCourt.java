package OpenGL;

import java.awt.Point;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLJPanel;

import GUI.GUI;
import util.Bresenham;
import util.LineSettings;
import util.Simple;

/**
 * Created by rubenspessoa on 02/03/17.
 */
public class BresenhamBasketBallCourt implements GLEventListener {

	private GUI gui;
	private Point pointOne;
	private Point pointTwo;
	private GLJPanel glJPanel;
	private LineSettings courtlineSettings;

	public BresenhamBasketBallCourt(GUI gui) {
		this.gui = gui;
		pointOne = gui.getPointOne();
		pointTwo = gui.getPointTwo();
		glJPanel = gui.getBresenhamgGlPanel();
		courtlineSettings = new LineSettings(1f, 1f, 1f, 1f);
	}

	public void init(GLAutoDrawable glAutoDrawable) {

	}

	public void dispose(GLAutoDrawable glAutoDrawable) {

	}

	public void display(GLAutoDrawable glAutoDrawable) {

		final GL2 gl = glAutoDrawable.getGL().getGL2();

		gl.glPushMatrix();
		Bresenham.drawLineWithBresenham(gl, glJPanel, convertX(-0.6f), convertY(0f), convertX(0.6f), convertY(0f), courtlineSettings);
		gl.glPushMatrix();
		
		// Desenha a linha superior da quadra;
		gl.glPushMatrix();
		gl.glTranslated(0d, 0.8d, 0d);
		Bresenham.drawLineWithBresenham(gl, glJPanel, convertX(-0.6f), convertY(0f), convertX(0.6f), convertY(0f), courtlineSettings);
		gl.glPopMatrix();

		// Desenha a linha inferior da quadra
		gl.glPushMatrix();
		gl.glTranslated(0d, -0.8d, 0d);
		Bresenham.drawLineWithBresenham(gl, glJPanel, convertX(-0.6f), convertY(0f), convertX(0.6f), convertY(0f), courtlineSettings);
		gl.glPopMatrix();

		// Desenha a linha direita da quadra
		gl.glPushMatrix();
		gl.glTranslated(0.6d, 0d, 0d);
		gl.glRotated(90, 0, 0, 1);
		Bresenham.drawLineWithBresenham(gl, glJPanel, convertX(-0.8f), convertY(0f), convertX(0.8f), convertY(0f), courtlineSettings);
		gl.glPopMatrix();

		// Desenha a linha esquerda da quadra
		gl.glPushMatrix();
		gl.glTranslated(-0.6d, 0d, 0d);
		gl.glRotated(90, 0, 0, 1);
		Bresenham.drawLineWithBresenham(gl, glJPanel, convertX(-0.8f), convertY(0f), convertX(0.8f), convertY(0f), courtlineSettings);
		gl.glPopMatrix();

		// Desenha o circulo central da quadra
		drawCircle(gl);

		// Desenha area da parte superior da quadra
		drawUpArea(gl);

		// Desenha area da parte inferior da quadra
		drawDownArea(gl);
		
		//Desenha o garrafao da area inferior
		drawInternalDownArea(gl);
		
		//Desenha o garrafao da area superior
		drawInternalUpArea(gl);
		
		if ((gui.getClicks()) != 0) {
			drawLine(gl);
		}

		gl.glFlush();
	}

	private void drawLine(GL2 gl) {
		
		if(gui.bresenhamFlag()) {
			gl.glPushMatrix();
			Bresenham.drawLineWithBresenham(gl, glJPanel, (float) pointOne.getX(), (float) pointOne.getY(),
					(float) pointTwo.getX(), (float) pointTwo.getY(), gui.getLineSettings());
			gl.glPopMatrix();
		} else {
			gl.glPushMatrix();
			Simple.drawLineWithSimple(gl, glJPanel, (float) pointOne.getX(), (float) pointOne.getY(),
					(float) pointTwo.getX(), (float) pointTwo.getY(), gui.getLineSettings());
			gl.glPopMatrix();
		}
		
	}

	private void drawDownArea(GL2 gl) {
		gl.glPushMatrix();
		gl.glScaled(0.5d, 0.5d, 0d);
		gl.glTranslated(0d, -1.603d, 0d);
		gl.glBegin(GL.GL_LINE_LOOP);
		for (int i = 0; i <= 180; i++) {
			double angle = 2 * Math.PI * i / 360;
			double x = Math.cos(angle);
			double y = Math.sin(angle);
			gl.glVertex2d(x, y);
		}
		gl.glEnd();
		gl.glPopMatrix();
	}

	private void drawUpArea(GL2 gl) {
		gl.glPushMatrix();
		gl.glScaled(0.5d, 0.5d, 0d);
		gl.glTranslated(0d, 1.6d, 0d);
		gl.glRotated(180, 0, 0, 1);
		gl.glBegin(GL.GL_LINE_LOOP);
		for (int i = 0; i <= 180; i++) {
			double angle = 2 * Math.PI * i / 360;
			double x = Math.cos(angle);
			double y = Math.sin(angle);
			gl.glVertex2d(x, y);
		}
		gl.glEnd();
		gl.glPopMatrix();
	}

	public void drawInternalDownArea(GL2 gl) {
		// Desenha area da parte inferior da quadra
		gl.glPushMatrix();
		gl.glScaled(0.1d, 0.1d, 0d);
		gl.glTranslated(0d, -5d, 0d);
		gl.glBegin(GL.GL_LINE_LOOP);
		for (int i = 0; i <= 180; i++) {
			double angle = 2 * Math.PI * i / 360;
			double x = Math.cos(angle);
			double y = Math.sin(angle);
			gl.glVertex2d(x, y);
		}
		gl.glEnd();
		gl.glPopMatrix();

		// Desenha a linha esquerda do garrafao
		gl.glPushMatrix();
		gl.glTranslated(-0.3d, -0.8d, 0d);
		Bresenham.drawLineWithBresenham(gl, glJPanel, convertX(0.1f), convertY(0f), convertX(0.2f), convertY(0.3f), courtlineSettings);
		gl.glPopMatrix();

		// Desenha a linha direita do garrafao
		gl.glPushMatrix();
		gl.glTranslated(0.3d, -0.8d, 0d);
		gl.glRotated(180, 0, 1, 0);
		Bresenham.drawLineWithBresenham(gl, glJPanel, convertX(0.1f), convertY(0f), convertX(0.2f), convertY(0.3f), courtlineSettings);
		gl.glPopMatrix();

	}

	public void drawInternalUpArea(GL2 gl) {
		// Desenha area da parte inferior da quadra
		gl.glPushMatrix();
		gl.glScaled(0.1d, 0.1d, 0d);
		gl.glTranslated(0d, 5d, 0d);
		gl.glRotated(180, 0, 0, 1);
		gl.glBegin(GL.GL_LINE_LOOP);
		for (int i = 0; i <= 180; i++) {
			double angle = 2 * Math.PI * i / 360;
			double x = Math.cos(angle);
			double y = Math.sin(angle);
			gl.glVertex2d(x, y);
		}
		gl.glEnd();
		gl.glPopMatrix();

		// Desenha a linha direita do garrafao
		gl.glPushMatrix();
		gl.glTranslated(0d, 0.5d, 0d);
		gl.glRotated(180, 0, 1, 0);
		Bresenham.drawLineWithBresenham(gl, glJPanel, convertX(0.1f), convertY(0f), convertX(0.2f), convertY(0.3f), courtlineSettings);
		gl.glPopMatrix();

		// Desenha a linha esquerda do garrafao
		gl.glPushMatrix();
		gl.glTranslated(0d, 0.5d, 0d);
		Bresenham.drawLineWithBresenham(gl, glJPanel, convertX(0.1f), convertY(0f), convertX(0.2f), convertY(0.3f), courtlineSettings);
		gl.glPopMatrix();
	}

	//Converte a cordenada em um ponto do painel, exemplo: (0,0) = (400, 400)
	private float convertX(float x) {
		return (x + 1) * GUI.WIDTH/2;
	}

	private float convertY(float y) {
		return (1 - y) * GUI.HEIGHT/2;
	}

	private void drawCircle(GL2 gl) {
		gl.glBegin(GL2.GL_LINE_LOOP);

		for (int i = 0; i <= 300; i++) {
			double angle = 2 * Math.PI * i / 300;
			double x = Math.cos(angle) * 0.2;
			double y = Math.sin(angle) * 0.2;
			gl.glVertex2d(x, y);
		}

		gl.glEnd();
	}

	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		
	}

}
