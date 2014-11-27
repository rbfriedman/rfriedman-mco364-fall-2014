package friedman.paint;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Shape;

import javax.swing.JButton;

public class PaintedButton extends JButton {

	/**
	 * 
	 */
	
	private ShapeType s;
	private static final long serialVersionUID = -4261049661640525300L;
	public PaintedButton(ShapeType s2){
		this.s = s2;
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		setFocusPainted(false);
        setMargin(new Insets(0, 0, 0, 0));
        setContentAreaFilled(false);
        setBorderPainted(false);
        setOpaque(false);
		super.paintComponent(g2);
		//g2.draw(s);
	}
	
}
