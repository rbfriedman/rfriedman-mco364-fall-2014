package friedman.paint.messages;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Stack;

import friedman.paint.Canvas;

public class BucketFillMessage implements PaintMessage {
	private int x;
	private int y;
	private int color;
	private Canvas canvas;

	// Graphics
	// Recursion, know that recursion is not going to
	// work and then resort to data structures
	// Recursion causes stackoverflow
	// stack is both how many calls made and how many variables added to each
	// stack

	// Point - holds x and y, add next point to stack
	public BucketFillMessage(int x, int y, int color, Canvas canvas) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.canvas = canvas;
	}

	@Override
	public void apply(Graphics2D g) {
		paintSurroundingPoints(g);
	}

	private void paintSurroundingPoints(Graphics2D g2) {
		Color clickedColor =  new Color(canvas.getImage().getRGB(x, y));
		if (clickedColor.equals(canvas.getPaintColor())) {
			return;
		}
		// initial point
		Point point = new Point(x, y);
		// stack
		Stack<Point> stackOfPoints = new Stack<Point>();
		stackOfPoints.push(point);
		BufferedImage image = canvas.getImage();

		Point visitedPoint;
		Color bucketFillColor = canvas.getPaintColor();
		// Points added to the stack are colore
		while (!stackOfPoints.isEmpty()) {
			visitedPoint = stackOfPoints.pop();
			image.setRGB(visitedPoint.x, visitedPoint.y,
					bucketFillColor.getRGB());
			// color point
			// Right
			if (withinCanvas(visitedPoint.x + 1, visitedPoint.y)
					&& clickedColor.equals(new Color(image.getRGB(
							visitedPoint.x + 1, visitedPoint.y)))) {
				stackOfPoints
						.push(new Point(visitedPoint.x + 1, visitedPoint.y));
			}
			// Left
			if (withinCanvas(visitedPoint.x - 1, visitedPoint.y)
					&& clickedColor.equals(new Color(image.getRGB(
							visitedPoint.x - 1, visitedPoint.y)))) {
				stackOfPoints
						.push(new Point(visitedPoint.x - 1, visitedPoint.y));
			}
			// Down
			if (withinCanvas(visitedPoint.x, visitedPoint.y + 1)
					&& clickedColor.equals(new Color(image.getRGB(
							visitedPoint.x, visitedPoint.y + 1)))) {
				stackOfPoints
						.push(new Point(visitedPoint.x, visitedPoint.y + 1));
			}
			// Up
			if (withinCanvas(visitedPoint.x, visitedPoint.y - 1)
					&& clickedColor.equals(new Color(image.getRGB(
							visitedPoint.x, visitedPoint.y - 1)))) {
				stackOfPoints
						.push(new Point(visitedPoint.x, visitedPoint.y - 1));
			}

			canvas.repaint();
		}
	}

	private boolean withinCanvas(int x, int y) {
		// TODO Auto-generated method stub
		return x > 0 && x < (canvas.getCanvasWidth() - 2) && y > 0
				&& y < (canvas.getCanvasHeight() - 2);

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "BUCKET_FILL" + " " + x + " " + y + " " + color + "\n";
	}
}