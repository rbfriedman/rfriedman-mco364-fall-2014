package friedman.paint;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import friedman.paint.drawing.DrawListener;
import friedman.paint.drawing.DrawOvalListener;
import friedman.paint.drawing.DrawRectangleListener;
import friedman.paint.drawing.FillOvalListener;
import friedman.paint.drawing.FillRectangleListener;
import friedman.paint.drawing.PaintLineListener;

public class PaintedButton extends JButton implements ActionListener {

	private PaintListener pl;

	private Shape shapeType;
	private DrawListener dl;
	private static final long serialVersionUID = -4261049661640525300L;

	public PaintedButton(Shape shapeType, PaintListener paintListener) {
		this.shapeType = shapeType;
		this.pl = paintListener;
		setDrawListener();
		setToolTipText(getText());
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
			setIcon(createImageIcon("icons/OvalS.png", "Filled Oval"));
			dl = new FillOvalListener(pl.getCanvas());
			break;
		case FilledRectangle:
			setIcon(createImageIcon("icons/RectangleS.png", "Filled Rectangle"));
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
		case Line:
			setIcon(createImageIcon("icons/PaintLineS.png", "Line"));
			dl = new PaintLineListener(pl.getCanvas());
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
			setToolTipText(description);
			return new ImageIcon(imgURL, description);

		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}
