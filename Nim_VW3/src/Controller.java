import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Controller {

	public Rects[] rects;

	public ArrayList<Rects> rectangles;

	public ArrayList<Rects> iter;

	public ArrayList<Rects> rectsReihe;

	private View view;
	public Nim nim;
	public Button b;

	public boolean isPlaying;
	public boolean isWinner;
	public boolean isSelected;

	private int selReihe;

	private String[] moves;

	public Controller(View view) {
		rectangles = new ArrayList<Rects>();
		iter = new ArrayList<Rects>();
		rectsReihe = new ArrayList<Rects>();
		isPlaying = true;
		isWinner = false;
		isSelected = false;
		selReihe = 0;
		
		this.view = view;
		
		
		nim = Nim.of(3, 3, 3);
		b = new Button(100, 320, 100, 50);
		registerRects();
	}

	public void nextFrame() {
		if (nim.isGameOver()) {
			if (isWinner) {
				view.drawGGWinner();
			} else {
				view.drawGGLooser();
			}
		} else {
			view.drawGame();
		}
	}

	public void mouseReleased(float x, float y) {
		if (isPlaying) {
			for (Rects rect : rectangles) {
				if (rect.isPressed(x, y)) {
					if (!isSelected) {
						isSelected = true;
						selReihe = rect.reihe;
						System.out.println("Pressed " + rect.id);
						nim = nim.play(Move.of(rect.reihe, 1));
						iter.add(rect);
						System.out.println(rect.reihe);
						System.out.println(nim);
					} else {
						if (rect.reihe == selReihe) {
							System.out.println("Pressed " + rect.id);
							nim = nim.play(Move.of(rect.reihe, 1));
							iter.add(rect);
							System.out.println(rect.reihe);
							System.out.println(nim);
						}
					}
				}
			}
			rectangles.removeAll(iter);
			iter.clear();

			if (b.isPressed(x, y)) {
				if (isSelected) {
					isSelected = false;
				}
				System.out.println("Pressed");
				isPlaying = false;
				Move random = nim.randomMove();
				moves = String.valueOf(random).replace("(", "").replace(")", "").replace(" ", "").split(",");
				if (rectangles.size() == Integer.valueOf(moves[1])) {
					isWinner = true;
				}
				int i = 0;
				rectsReihe = getRectsByReihe(Integer.valueOf(moves[0]));
				Collections.reverse(rectsReihe);
				for (Rects rect : rectsReihe) {
					if (i == Integer.valueOf(moves[1])) {
						break;
					}
					iter.add(rect);
					i++;
				}
				System.out.println("Reihe: " + Integer.valueOf(moves[0]));
				System.out.println("Anzahl :" + getRectsByReihe(Integer.valueOf(moves[0])).size());
				System.out.println("Züge: " + Integer.valueOf(moves[1]));

				rectsReihe.clear();
				rectangles.removeAll(iter);
				iter.clear();
				nim = nim.play(random);
				System.out.println(nim);
				if (!nim.isGameOver()) {
					isPlaying = true;
				}
			}
		}
	}

	public Rects getRectByID(int id) {
		for (Rects rect : rects) {
			if (rect.id == id) {
				return rect;
			}
		}
		return null;
	}

	public ArrayList<Rects> getRectsByReihe(int reihe) {
		ArrayList<Rects> rectss = new ArrayList<Rects>();
		for (Rects rect : rectangles) {
			if (rect.reihe == reihe) {
				rectss.add(rect);
			}
		}
		return rectss;
	}

	private void registerRects() {
		rects = new Rects[] { new Rects(80, 80, 20, 50, 1, 0), new Rects(120, 80, 20, 50, 2, 0),
				new Rects(160, 80, 20, 50, 3, 0),

				new Rects(80, 160, 20, 50, 4, 1), new Rects(120, 160, 20, 50, 5, 1), new Rects(160, 160, 20, 50, 6, 1),

				new Rects(80, 240, 20, 50, 7, 2), new Rects(120, 240, 20, 50, 8, 2),
				new Rects(160, 240, 20, 50, 9, 2) };
		for (Rects rect : rects) {
			rectangles.add(rect);
		}
	}

}
