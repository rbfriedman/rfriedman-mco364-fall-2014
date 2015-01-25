package rfriedman.paint.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import rfriedman.paint.PaintBanner;
/*
 * This class is meant to imitate BrushStrokeListener
 */
public class KeyBrushStrokeListener implements KeyListener {
	
	private BrushStrokeListener brushStrokeListener;
	private PaintBanner pb;
	public KeyBrushStrokeListener(BrushStrokeListener brushStrokeListener) {
	
		this.brushStrokeListener = brushStrokeListener;
		pb = this.brushStrokeListener.getPb();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.equals(KeyEvent.VK_UP)){
			pb.decreaseStrokeWidth();
		} else if (e.equals(KeyEvent.VK_DOWN)) {
			pb.decreaseStrokeWidth();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
