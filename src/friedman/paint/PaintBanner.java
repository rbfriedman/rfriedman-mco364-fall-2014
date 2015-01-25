package friedman.paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import friedman.paint.listeners.ClearScreenListener;
import friedman.paint.listeners.ColorDialogListener;
import friedman.paint.listeners.NetworkListener;

public class PaintBanner extends JPanel {
	private JButton jbtEditColors;
	private JLabel jlbBrushStrokeColor;
	private JLabel jlbStrokeSize;
	private JButton jbtNetwork;
	private Client client;

	private String editColorIcon = "icons/rainbow.jpg";
	private String jlbStrokeSizeIcon = "icons/Bucket.png";
	private JPanel shapeGrid;

	private PaintListener paintListener;

	public PaintBanner(PaintListener paintListener, Client client) {

		this.paintListener = paintListener;
		this.client = client;
		setLayout(new FlowLayout(FlowLayout.RIGHT));

		ImageIcon icon = createImageIcon(editColorIcon, "Color Palette");
		jbtEditColors = new JButton("Edit Colors", icon);
		jbtEditColors.addActionListener(new ColorDialogListener(this));
		
		jbtNetwork = new JButton("Network");
		jbtNetwork.addActionListener(new NetworkListener(client));
		

		jlbBrushStrokeColor = new JLabel("Stroke Color");
		jlbBrushStrokeColor.setOpaque(true);
		setPaintColor(Color.black);
		icon = createImageIcon(jlbStrokeSizeIcon, "Stroke width");
		jlbStrokeSize = new JLabel("10", icon, 10);
		shapeGrid = createGridOfShapes();

		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new GridLayout(1, 6, 4, 4));
		innerPanel.add(jlbStrokeSize);
		innerPanel.add(jlbBrushStrokeColor);
		innerPanel.add(jbtEditColors);
		innerPanel.add(jbtNetwork);
		Border raisedetched = BorderFactory
				.createEtchedBorder(EtchedBorder.RAISED);
		this.setBorder(raisedetched);

		innerPanel.add(shapeGrid);
		add(innerPanel);

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
		paintListener.setColor(c);
		jlbBrushStrokeColor.setBackground(c);
		jlbBrushStrokeColor.repaint();

	}

	private JPanel createGridOfShapes() {
		shapeGrid = new JPanel();
		shapeGrid.setLayout(new GridLayout(3, 3));
		shapeGrid.setBorder(BorderFactory.createLineBorder(Color.black));
		shapeGrid.setPreferredSize(new Dimension(200,100));
		PaintedButton jlb;

		for (PaintType s : PaintType.values()) {
			jlb = new PaintedButton(s, paintListener);
			shapeGrid.add(jlb);
		}

		return shapeGrid;
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
