package rfriedman.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import rfriedman.paint.listeners.ClearScreenListener;
import rfriedman.paint.listeners.ColorDialogListener;
import rfriedman.paint.listeners.LayerChooserListener;
import rfriedman.paint.listeners.PaintListener;


public class PaintBanner extends JPanel {
	private JButton jbtEditColors;
	private JButton jbtClearScreen;
	private JLabel jlbBrushStrokeColor;
	private JLabel jlbStrokeSize;

	private String editColorIcon = "icons/rainbow.jpg";
	private String jlbStrokeSizeIcon = "icons/Bucket.png";
	private JPanel shapeGrid;

	private PaintListener paintListener;


	public PaintBanner(PaintListener paintListener) {

		this.paintListener = paintListener;

		ImageIcon icon = createImageIcon(editColorIcon, "Color Palette");
		jbtEditColors = new JButton("Edit Colors", icon);
		jbtEditColors.addActionListener(new ColorDialogListener(this));

		jbtClearScreen = new JButton("Clear Screen");
		jbtClearScreen.addActionListener(new ClearScreenListener(
				this.paintListener));

		jlbBrushStrokeColor = new JLabel("Stroke Color");
		jlbBrushStrokeColor.setOpaque(true);
		setPaintColor(Color.black);
		icon = createImageIcon(jlbStrokeSizeIcon, "Stroke width");
		jlbStrokeSize = new JLabel("10", icon, 10);
		
		shapeGrid = createGridOfShapes();
		createLayerComboBox();
		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new GridLayout(1, 6, 4, 4));
		innerPanel.add(jlbStrokeSize);
		innerPanel.add(jlbBrushStrokeColor);
		innerPanel.add(jbtEditColors);
		innerPanel.add(jbtClearScreen);

		Border raisedetched = BorderFactory
				.createEtchedBorder(EtchedBorder.RAISED);
		this.setBorder(raisedetched);

		innerPanel.add(shapeGrid);
		add(innerPanel, BorderLayout.CENTER);


	}

	public JLabel getJlbStrokeSize() {
		return jlbStrokeSize;
	}

	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	public void setStrokeWidth(int width) {
		jlbStrokeSize.setText(Integer.toString(width));
		jlbStrokeSize.repaint();

	}

	public void setPaintColor(Color c) {
		paintListener.setPaintColor(c);
		jlbBrushStrokeColor.setBackground(c);
		jlbBrushStrokeColor.repaint();

	}

	private JPanel createGridOfShapes() {
		shapeGrid = new JPanel();
		shapeGrid.setLayout(new GridLayout(3, 3));
		shapeGrid.setBorder(BorderFactory.createLineBorder(Color.black));
		shapeGrid.setPreferredSize(new Dimension(200,100));
		PaintTypeButton jlb;

		for (PaintType s : PaintType.values()) {
			jlb = new PaintTypeButton(s, paintListener);
			shapeGrid.add(jlb);
		}
		
		return shapeGrid;
	}
	
	private void createLayerComboBox(){
		
		Integer[] layerChoices = {1,2,3,4};
		JComboBox<Integer> layerChooser = new JComboBox<Integer>(layerChoices);
		layerChooser.addActionListener(new LayerChooserListener(paintListener));
		shapeGrid.add(layerChooser);
		
	}

	public void decreaseStrokeWidth() {
		paintListener.decreaseStrokeWidth();
	}

	public void increaseStrokeWidth() {
		paintListener.increaseStrokeWidth();
	}

	public int getStrokeWidth() {
		return paintListener.getStrokeWidth();
	}

	public void setPaintListener(PaintListener mml) {
		paintListener.setDrawListener(mml);
	}
}
