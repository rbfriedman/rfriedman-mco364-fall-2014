package friedman.paint;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

import javax.swing.JButton;

public class PaintedButton extends JButton {

	/**
	 * 
	 */
	
	private Shape s;
	private static final long serialVersionUID = -4261049661640525300L;
	public PaintedButton(Shape s){
		this.s = s;
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);
		g2.draw(s);
	}
	
}
