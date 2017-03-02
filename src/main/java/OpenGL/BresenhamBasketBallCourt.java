package OpenGL;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLUquadric;

/**
 * Created by rubenspessoa on 02/03/17.
 */
public class BresenhamBasketBallCourt implements GLEventListener {

    public void init(GLAutoDrawable glAutoDrawable) {

    }

    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    public void display(GLAutoDrawable glAutoDrawable) {

        final GL2 gl = glAutoDrawable.getGL().getGL2();

        //drawing top
        gl.glBegin ( GL2.GL_LINES );
        gl.glVertex3f( -0.3f, 0.3f, 0 );
        gl.glVertex3f( 0.3f,0.3f, 0 );
        gl.glEnd();

        //drawing bottom
        gl.glBegin( GL2.GL_LINES );
        gl.glVertex3f( -0.3f,-0.3f, 0 );
        gl.glVertex3f( 0.3f,-0.3f, 0 );
        gl.glEnd();

        //drawing the right edge
        gl.glBegin( GL2.GL_LINES );
        gl.glVertex3f( -0.3f,0.3f, 0 );
        gl.glVertex3f( -0.3f,-0.3f, 0 );
        gl.glEnd();

        //drawing the left edge
        gl.glBegin( GL2.GL_LINES );
        gl.glVertex3f( 0.3f,0.3f,0 );
        gl.glVertex3f( 0.3f,-0.3f,0 );
        gl.glEnd();

        //building roof
        //building lft dia
        gl.glBegin( GL2.GL_LINES );
        gl.glVertex3f( 0f,0.6f, 0 );
        gl.glVertex3f( -0.3f,0.3f, 0 );
        gl.glEnd();

        //building rt dia
        gl.glBegin( GL2.GL_LINES );
        gl.glVertex3f( 0f,0.6f, 0 );
        gl.glVertex3f( 0.3f,0.3f, 0 );
        gl.glEnd();

        //building door
        //drawing top
        gl.glBegin ( GL2.GL_LINES );
        gl.glVertex3f( -0.05f, 0.05f, 0 );
        gl.glVertex3f( 0.05f, 0.05f, 0 );
        gl.glEnd();

        //drawing the left edge
        gl.glBegin ( GL2.GL_LINES );
        gl.glVertex3f( -0.05f, 0.05f, 0 );
        gl.glVertex3f( -0.05f, -0.3f, 0 );
        gl.glEnd();

        //drawing the right edge
        gl.glBegin ( GL2.GL_LINES );
        gl.glVertex3f( 0.05f, 0.05f, 0 );
        gl.glVertex3f( 0.05f, -0.3f, 0 );
        gl.glEnd();

    }

    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }
}
