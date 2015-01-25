package friedman.paint.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import friedman.paint.Canvas;
import friedman.paint.PaintListener;
import friedman.paint.messages.ClearMessage;

public class ClearScreenListener implements ActionListener {

	private PaintListener pl;
	private Canvas canvas;

	public ClearScreenListener(PaintListener pl, Canvas canvas) {
		this.canvas = canvas;
		this.pl = pl;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		// pl.clearScreen();

		pl.getNetworkModule().sendMessage(new ClearMessage(canvas));
	}

}