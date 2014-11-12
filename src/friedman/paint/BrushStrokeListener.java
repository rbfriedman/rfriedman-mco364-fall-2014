package friedman.paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class BrushStrokeListener implements MouseWheelListener, LogInterface {
	private Canvas canvas;

	public BrushStrokeListener(Canvas canvas) {
		super();
		this.canvas = canvas;
		System.out.println("Initialize");
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		// TODO Auto-generated method stub
		saySomething(arg0.getWheelRotation() + " ", arg0);
		if(arg0.getWheelRotation() >= 1){
			canvas.increaseStrokeWidth();
		}else{
			canvas.decreaseStrokeWidth();
		}
	}

	public void saySomething(String eventDescription, MouseEvent e) {
		System.out.println(eventDescription);
		
	}

}
