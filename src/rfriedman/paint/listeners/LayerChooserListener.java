package rfriedman.paint.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class LayerChooserListener implements ActionListener {
	PaintListener pl;

	public LayerChooserListener(PaintListener pl) {
		this.pl = pl;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox<Integer> cb = (JComboBox<Integer>) e.getSource();
		Integer layerChoice = (Integer) cb.getSelectedItem();
		pl.setSelectedLayer(layerChoice - 1);

	}

}
