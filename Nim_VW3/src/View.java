import processing.core.PApplet;

public class View extends PApplet{

	
	public int widthx = 300;
	public int heigthy = 400;
	
	Controller controller;
	
	public static void main(String[] args) {
		PApplet.main(View.class);
	}
	
	public void settings() {
		size(widthx, heigthy);
	}
	public void setup() {
		controller = new Controller(this);
	}
	
	public void draw() {
		controller.nextFrame();
	}
	
	public void mouseReleased() {
		controller.mouseReleased(mouseX, mouseY);
	}
	
	public void drawGame() {
		background(255,255,0);
		drawButton(controller.b);
		drawRects();
		if(controller.isPlaying) {
			fill(255,0,0);
			textSize(40);
			text("Your turn", 70, 50);
		} else {
			fill(255,0,0);
			textSize(40);
			text("Wait", 110, 50);
		}
	}
	
	public void drawGGWinner() {
		background(255);
		fill(0);
		textSize(40);
		text("Winner!", width/2-70, height/2);
	}
	
	public void drawGGLooser() {
		background(0);
		fill(255);
		textSize(40);
		text("Looser!", width/2-70, height/2);
	}
	
	public void drawButton(Button b) {
		rect(b.getX(), b.y, b.widthb, b.heigthb);
		fill(47,206,71);
		textSize(40);
		text("Fertig", b.getX(), b.y+40);
	}
	
	public void drawRects() {
		fill(255);
		for(Rects rectx : controller.rectangles) {
			rect(rectx.x, rectx.y, rectx.widthr, rectx.heigthr);
		}
		
	}
}
