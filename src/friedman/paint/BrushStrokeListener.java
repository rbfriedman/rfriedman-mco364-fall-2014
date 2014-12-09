package friedman.paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JLabel;

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
		if (arg0.getWheelRotation() >= 1) {
			pb.increaseStrokeWidth();

		} else {
			pb.decreaseStrokeWidth();
		}
		pb.setStrokeWidth(pb.getStrokeWidth());
		pb.repaint();
	}

	public void saySomething(String eventDescription, MouseEvent e) {
		System.out.println(eventDescription);

	}

}
