
public class Rects {

	public float x;
	public float y;
	
	public float widthr;
	public float heigthr;
	
	public int id;
	public int reihe;
	
	public Rects(float x, float y, float width, float heigth, int id, int reihe) {
		this.x = x;
		this.y = y;
		this.widthr = width;
		this.heigthr = heigth;
		this.id = id;
		this.reihe = reihe;
	}
	
	public boolean isPressed(float x, float y) {
		if (x >= this.x && x <= (this.x + widthr)) {
			if (y >= this.y && y <= (this.y + heigthr)) {
				return true;
			}
		}
		return false;
	}
	
	
}
