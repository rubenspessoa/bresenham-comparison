package OpenGL;

import com.jogamp.opengl.*;

/**
 * Created by rubenspessoa on 02/03/17.
 */
public class SimpleBasketBallCourtFrame implements GLEventListener {

    public void init(GLAutoDrawable glAutoDrawable) {

    }

    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    public void display(GLAutoDrawable glAutoDrawable) {
        final GL2 gl = glAutoDrawable.getGL().getGL2();

        gl.glBegin(GL2.GL_LINES);
            gl.glVertex3f(0.50f, -0.50f, 0);
            gl.glVertex3f(-0.50f, 0.50f,0);
        gl.glEnd();
    }

    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }
}
