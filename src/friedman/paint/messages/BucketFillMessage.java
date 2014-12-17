package friedman.paint.messages;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Stack;

public class BucketFillMessage implements PaintMessage
{
	private int x;
	private int y;
	private int color;
	//Graphics
	//Recursion, know that recursion is not going to 
	//work and then resort to data structures
	//Recursion causes stackoverflow
	// stack is both how many calls made and how many variables added to each stack
	
	//Point - holds x and y, add next point to stack
	public BucketFillMessage(int x, int y, int color)
	{
		this.x = x;
		this.y = y;
		this.color = color;
	}

	@Override
	public void apply(Graphics2D g)
	{
		// TODO Auto-generated method stub
		Point point = new Point(x,y);
		Stack<Point> stackOfPoints = new Stack<Point>();
		
	}
	
	private void traverseBranch(Point p){
		
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public int getColor()
	{
		return color;
	}

	public void setColor(int color)
	{
		this.color = color;
	}

	@Override
	public String toString()
	{
		return "BUCKET_FILL " + " " + x + " " + y + " " + color;
	}
}