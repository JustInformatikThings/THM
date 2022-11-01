
public class Button {

	private float x;

	public float y;

	public float widthb, heigthb;

	public Button(float x, float y, float widthb, float heigthb) {
		this.setX(x);
		this.y = y;
		this.heigthb = heigthb;
		this.widthb = widthb;
	}

	public boolean isPressed(float x, float y) {
		if (x >= this.getX() && x <= (this.getX() + widthb)) {
			if (y >= this.y && y <= (this.y + heigthb)) {
				return true;
			}
		}
		return false;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

}
