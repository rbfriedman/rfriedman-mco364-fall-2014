package rfriedman.paint.drawing;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Stack;

import rfriedman.paint.Canvas;


public class BucketFillDrawListener extends DrawShapeListener {
	private Color clickedColor;

	public BucketFillDrawListener(Canvas canvas) {
		super(canvas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		super.draw(g2);
		paintSurroundingPoints(g2);

	}

	public void paintSurroundingPoints(Graphics2D g2) {
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
		//Points added to the stack are colore
		while (!stackOfPoints.isEmpty()) {
			visitedPoint = stackOfPoints.pop();
			// color point
			image.setRGB(visitedPoint.x, visitedPoint.y, bucketFillColor.getRGB());
			
			
			//Right
			if (withinCanvas(visitedPoint.x+1,visitedPoint.y) && clickedColor.equals(new Color(image.getRGB(visitedPoint.x+1,visitedPoint.y)))){
				stackOfPoints.push(new Point(visitedPoint.x +1,visitedPoint.y));
			}
			//Left
			if (withinCanvas(visitedPoint.x-1,visitedPoint.y) && clickedColor.equals(new Color(image.getRGB(visitedPoint.x-1,visitedPoint.y)))){
				stackOfPoints.push(new Point(visitedPoint.x-1,visitedPoint.y));
			}
			//Down
			if (withinCanvas(visitedPoint.x,visitedPoint.y+1) && clickedColor.equals(new Color(image.getRGB(visitedPoint.x,visitedPoint.y+1)))){
				stackOfPoints.push(new Point(visitedPoint.x,visitedPoint.y+1));
			}
			//Up
			if (withinCanvas(visitedPoint.x,visitedPoint.y-1) && clickedColor.equals(new Color(image.getRGB(visitedPoint.x,visitedPoint.y-1)))){
				stackOfPoints.push(new Point(visitedPoint.x,visitedPoint.y-1));
			}
			
			canvas.repaint();
			
		}
	}

	private boolean withinCanvas(int x, int y) {
		// TODO Auto-generated method stub
		return x > 0 &&  x <(canvas.getCanvasWidth()-2) && y > 0 && y < (canvas.getCanvasHeight()-2);
	
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		super.mouseReleased(me);
		Graphics2D g2 = (Graphics2D) canvas.getImage().getGraphics();
		g2.setColor(canvas.getPaintColor());
		clickedColor = new Color(canvas.getImage().getRGB(x, y));
		draw(g2);
		canvas.repaint();

	}
	
	@Override
	public void mousePressed(MouseEvent me) {

		System.out.println(x +" " +y);
		super.mousePressed(me);
		currentPoint = originPoint = me.getPoint();
		x = (int) currentPoint.getX();
		y = (int) currentPoint.getY();
		clickedColor = new Color(canvas.getImage().getRGB(x, y));
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		// Irrelevant method in this scenario
	}

	public Color getClickedColor() {
		return clickedColor;
	}

	public void setClickedColor(Color clickedColor) {
		this.clickedColor = clickedColor;
	}
	
}