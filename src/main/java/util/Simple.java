package util;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.awt.GLJPanel;

import GUI.GUI;

public class Simple {
	
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

	// FIXME Definir cor da linha
	public static void drawLineWithSimple(GL2 gl, GLJPanel glJPanel, float x1, float y1, float x2, float y2, LineSettings lineSetting) {
		float d = 0;

		float dy = Math.abs(y2 - y1);
		float dx = Math.abs(x2 - x1);

		float dy2 = ((int)dy << 1); // slope scaling factors to avoid inting
		float dx2 = ((int)dx << 1); // point

		float ix = x1 < x2 ? 1 : -1; // increment direction
		float iy = y1 < y2 ? 1 : -1;

		if (dy <= dx) {
			while(true) {
				plot(gl, x1, y1, lineSetting);
				if (x1 == x2)
					break;
				x1 += ix;
				d += dy2;
				if (d > dx) {
					y1 += iy;
					d -= dx2;
				}
			}
		} else {
			while(true) {
				plot(gl, x1, y1, lineSetting); //mudar para gl.draw point
				if (y1 == y2)
					break;
				y1 += iy;
				d += dx2;
				if (d > dy) {
					x1 += ix;
					d -= dy2;
				}
			}
		}

	}
}