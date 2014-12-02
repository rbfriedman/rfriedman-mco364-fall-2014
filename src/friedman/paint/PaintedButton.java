package friedman.paint;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PaintedButton extends JButton implements ActionListener {

	private PaintListener pl;

	private ShapeType shapeType;
	private DrawListener dl;
	private static final long serialVersionUID = -4261049661640525300L;

	public PaintedButton(ShapeType shapeType, PaintListener paintListener) {
		this.shapeType = shapeType;
		this.pl = paintListener;
		setDrawListener();
		addActionListener(this);

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

	}

	private void setDrawListener() {

		switch (shapeType) {
		case FilledOval:
			setIcon(createImageIcon("icons/OvalS.png", "Oval"));
			dl = new FillOvalListener(pl.getCanvas());
			break;
		case FilledRectangle:
			setIcon(createImageIcon("icons/RectangleS.png", "Rectangle"));
			dl = new FillRectangleListener(pl.getCanvas());
			break;
		case Oval:
			setIcon(createImageIcon("icons/OvalS.png", "Oval"));
			dl = new DrawOvalListener(pl.getCanvas());
			break;
		case Rectangle:
			setIcon(createImageIcon("icons/RectangleS.png", "Rectangle"));
			dl = new DrawRectangleListener(pl.getCanvas());
			break;
		default:
			break;

		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		pl.setDrawListener(dl);
		System.out.println(shapeType);
	}

	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			System.out.println(imgURL.getFile());
			//Bitmap b  = new BitMap();
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}
