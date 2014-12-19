
package friedman.paint.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import friedman.paint.drawing.BucketFillDrawListener;


public class BucketFillListener implements ActionListener {
	private PaintListener pl;
	private BucketFillDrawListener bucketFillDL;
	public BucketFillListener(PaintListener pl){
		this.pl = pl;
		this.bucketFillDL = new BucketFillDrawListener(pl.getCanvas());
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		pl.setDrawListener(bucketFillDL);
	}

}