package rfriedman.paint;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import rfriedman.paint.drawing.BucketFillDrawListener;
import rfriedman.paint.drawing.DrawListener;
import rfriedman.paint.drawing.DrawOvalListener;
import rfriedman.paint.drawing.DrawRectangleListener;
import rfriedman.paint.drawing.FillOvalListener;
import rfriedman.paint.drawing.FillRectangleListener;
import rfriedman.paint.drawing.PaintLineListener;
import rfriedman.paint.listeners.PaintListener;

public class PaintTypeButton extends JButton implements ActionListener {

	private PaintListener pl;

	private PaintType paintType;
	private DrawListener dl;
	private static final long serialVersionUID = -4261049661640525300L;

	public PaintTypeButton(PaintType paintType, PaintListener paintListener) {
		this.paintType = paintType;
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

		switch (paintType) {
		case FILLED_OVAL:
			setIcon(createImageIcon("icons/OvalS.png", "Filled Oval"));
			dl = new FillOvalListener(pl.getCanvas());
			break;
		case FILLED_RECTANGLE:
			setIcon(createImageIcon("icons/RectangleS.png", "Filled Rectangle"));
			dl = new FillRectangleListener(pl.getCanvas());
			break;
		case OVAL:
			setIcon(createImageIcon("icons/OvalS.png", "Oval"));
			dl = new DrawOvalListener(pl.getCanvas());
			break;
		case RECTANGLE:
			setIcon(createImageIcon("icons/RectangleS.png", "Rectangle"));
			dl = new DrawRectangleListener(pl.getCanvas());
			break;
		case LINE:
			setIcon(createImageIcon("icons/PaintLineS.png", "Line"));
			dl = new PaintLineListener(pl.getCanvas());
			break;
		case BUCKET_FILL:
			//TODO Find Bucket Fill shape, along with filled shapes
			setIcon(createImageIcon("icons/PaintLineS.png", "Bucket Fill"));
			dl = new BucketFillDrawListener(pl.getCanvas());
			break;	
		default:	
			break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		pl.setDrawListener(dl);
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
