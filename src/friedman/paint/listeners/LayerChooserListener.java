package friedman.paint.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import friedman.paint.PaintBanner;

public class LayerChooserListener implements ActionListener {
	PaintListener pl;
	PaintBanner pb;

	public LayerChooserListener(PaintListener pl) {
		this.pl = pl;
		this.pb = pb;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox<Integer> cb = (JComboBox<Integer>) e.getSource();
		Integer layerChoice = (Integer) cb.getSelectedItem();
		pl.setSelectedLayer(layerChoice - 1);

	}

}
