package friedman.paint.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import friedman.paint.LogInterface;
import friedman.paint.PaintBanner;

public class BrushStrokeListener implements MouseWheelListener, LogInterface {
	private PaintBanner pb;

	public BrushStrokeListener(PaintBanner pb) {
		super();
		this.pb = pb;
		System.out.println("Initialize");
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		// TODO Auto-generated method stub
		saySomething(arg0.getWheelRotation() + " ", arg0);
		if (arg0.getWheelRotation() == 1) {
			pb.decreaseStrokeWidth();
		} else {
			pb.increaseStrokeWidth();
		}
		pb.setStrokeWidth(pb.getStrokeWidth());
		pb.repaint();
	}

	public void saySomething(String eventDescription, MouseEvent e) {
		System.out.println(eventDescription);

	}

}
