package friedman.paint;

import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapeTypeListener implements ActionListener {
	private ShapeType shape;
	private PaintBanner pb;
	
	public ShapeTypeListener(ShapeType shape,PaintBanner pb){
		this.shape = shape;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//pb.setDrawListener(new DrawRectangleListener());
		
	}

}
