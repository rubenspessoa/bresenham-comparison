package util;

public class LineSettings {

	private float red;
	private float green;
	private float blue;
	private float lineWidth;
	
	public LineSettings(float red, float green, float blue, float lineWidth) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.lineWidth = lineWidth;
	}

	public float getLineWidth() {
		return lineWidth;
	}

	public void setLineWidth(float lineWidth) {
		this.lineWidth = lineWidth;
	}
	
	public float getRed() {
		return red;
	}

	public void setRed(float red) {
		this.red = red;
	}

	public float getGreen() {
		return green;
	}

	public void setGreen(float green) {
		this.green = green;
	}

	public float getBlue() {
		return blue;
	}

	public void setBlue(float blue) {
		this.blue = blue;
	}
}
