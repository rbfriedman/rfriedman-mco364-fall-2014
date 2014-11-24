package friedman.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearScreenListener implements ActionListener {
	
	private PaintListener pl;

	public ClearScreenListener(PaintListener pl) {
		this.pl = pl;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		pl.clearScreen();
	}

}
