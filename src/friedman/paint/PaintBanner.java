package friedman.paint;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class PaintBanner extends JPanel {
	private JButton jbtEditColors;
	private JLabel jlbBrushStrokeColor;
	private JLabel jlbStrokeSize;

	private String editColorIcon = "icons/rainbow.jpg";
	private String jlbStrokeSizeIcon = "icons/Bucket.png";

	private Canvas canvas;

	public PaintBanner(Canvas canvas) {

		this.canvas = canvas;
		setLayout(new FlowLayout(FlowLayout.RIGHT));

		ImageIcon icon = createImageIcon(editColorIcon, "Color Palette");
		jbtEditColors = new JButton("Edit Colors", icon);
		jbtEditColors.addActionListener(new ColorDialogListener(this));

		jlbBrushStrokeColor = new JLabel("Stroke Color");
		jlbBrushStrokeColor.setOpaque(true);
		setStrokeColor(Color.black);
		icon = createImageIcon(jlbStrokeSizeIcon, "Stroke width");

		jlbStrokeSize = new JLabel("10",icon,10);

		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new GridLayout(1, 3, 4, 4));
		innerPanel.add(jlbStrokeSize);
		innerPanel.add(jlbBrushStrokeColor);
		innerPanel.add(jbtEditColors);
		
		Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		this.setBorder(raisedetched);
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

	public void setStrokeColor(Color c) {
		canvas.setColor(c);
		jlbBrushStrokeColor.setBackground(c);
		jlbBrushStrokeColor.repaint();

	}


	

}
