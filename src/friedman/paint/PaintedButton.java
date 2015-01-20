package friedman.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import friedman.paint.drawing.BucketFillDrawListener;
import friedman.paint.drawing.DrawOvalListener;
import friedman.paint.drawing.DrawRectangleListener;
import friedman.paint.drawing.DrawShapeListener;
import friedman.paint.drawing.FillOvalListener;
import friedman.paint.drawing.FillRectangleListener;
import friedman.paint.drawing.PaintLineListener;
import friedman.paint.listeners.ClearScreenListener;

public class PaintedButton extends JButton implements ActionListener {

	private PaintListener pl;

	private PaintType paintType;
	private DrawShapeListener dl;
	private static final long serialVersionUID = -4261049661640525300L;

	public PaintedButton(PaintType paintType, PaintListener paintListener) {
		this.paintType = paintType;
		this.pl = paintListener;
		setDrawListener();
		setNetworkModule();
		setToolTipText(getText());
		addActionListener(this);

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
			setIcon(createImageIcon("icons/PaintLineS.png", "Bucket Fill"));
			dl = new BucketFillDrawListener(pl.getCanvas());
			break; 
		case CLEAR:
			setText("Clear");
			addActionListener(new ClearScreenListener(pl,pl.getCanvas()));
		default:
			
			
			dl = new PaintLineListener(pl.getCanvas());
			break;
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		pl.setDrawListener(dl);
		System.out.println(paintType);
	}
	private void setNetworkModule() {
		dl.setNetworkModule(pl.getNetworkModule());
		
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
