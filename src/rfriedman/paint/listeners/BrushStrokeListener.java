package rfriedman.paint.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import rfriedman.paint.LogInterface;
import rfriedman.paint.PaintBanner;

public class BrushStrokeListener implements MouseWheelListener, KeyListener,
		LogInterface {
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

	public PaintBanner getPb() {
		return pb;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		System.out.println("Key pressed");
		switch (keyCode) {
		case KeyEvent.VK_UP:
			System.out.println("Key up");
			pb.increaseStrokeWidth();
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("Key down");
			pb.decreaseStrokeWidth();
			break;
		}
		pb.setStrokeWidth(pb.getStrokeWidth());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
