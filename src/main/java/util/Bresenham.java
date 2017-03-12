package util;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLJPanel;

import GUI.GUI;
 
public class Bresenham {
	
    public static void plot(GL2 gl, float x, float y, LineSettings lineSetting) {
    	float r = lineSetting.getRed();
    	float g = lineSetting.getGreen();
    	float b = lineSetting.getBlue();
    	
        gl.glColor3f(r, g, b);

        //Calcular coordenadas no GLJpanel, pq a coordenada (0,0) fica no centro do painel
        x = (x/ (GUI.WIDTH/2) )-1;
        y = 1-(y/ (GUI.HEIGHT/2) ); 
        
        gl.glPointSize(lineSetting.getLineWidth());
        gl.glBegin(GL2.GL_POINTS);
        gl.glVertex2f(x, y);
        gl.glEnd();
    }
 
    public static void drawLineWithBresenham(GL2 gl, GLJPanel glJPanel, float x1, float y1, float x2, float y2, LineSettings lineSetting) {

        float dx, dy, incX, incY, incE, incNE, d;

        dx = Math.abs(x2 - x1);
        dy = Math.abs(y2 - y1);

        if (x1 > x2) {
            incX = -1;
        } else {
            incX = 1;
        }
        if (y1 > y2) {
            incY = -1;
        } else {
            incY = 1;
        }

        if (dx >= dy) {
            incE = 2 * dy;
            incNE = incE - (2 * dx);
            d = incE - dx;
            while (dx >= 0) {
                plot(gl, x1, y1, lineSetting);
                if (d > 0) {
                    x1 += incX;
                    y1 += incY;
                    d += incNE;
                } else {
                    x1 += incX;
                    d += incE;
                }
                dx--;
            }
        } else {
            incE = 2 * dx;
            incNE = incE - (2 * dy);
            d = incE - dy;
            while (dy >= 0) {
                plot(gl, x1, y1, lineSetting);
                if (d > 0) {
                    x1 += incX;
                    y1 += incY;
                    d += incNE;
                } else {
                    y1 += incY;
                    d += incE;
                }
                dy--;
            }
        }
    }
}