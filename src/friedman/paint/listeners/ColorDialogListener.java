package friedman.paint.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import friedman.paint.PaintBanner;

public class ColorDialogListener implements ActionListener, ChangeListener {
	private JDialog jd;
	private JColorChooser colorChooser;
	private PaintBanner pb;
	
	public ColorDialogListener(PaintBanner pb){
		jd = new JDialog();
		colorChooser = new JColorChooser();
		this.pb = pb;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		jd.add(colorChooser);
		colorChooser.getSelectionModel().addChangeListener(this);
		jd.setSize(300,300);
		jd.setVisible(true);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		if((colorChooser.getColor())!=null){
			pb.setPaintColor(colorChooser.getColor());
			System.out.println("Color :" + colorChooser.getColor().getRGB());
		}
		

	}

}