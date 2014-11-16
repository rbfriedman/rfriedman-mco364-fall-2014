package friedman.paint;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
		jbtEditColors.addActionListener(new ColorDialogListener());

		jlbBrushStrokeColor = new JLabel("Stroke Color");
		icon = createImageIcon(jlbStrokeSizeIcon, "Stroke width");

		jlbStrokeSize = new JLabel(icon);

		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new GridLayout(1, 3, 4, 4));
		innerPanel.add(jlbStrokeSize);
		innerPanel.add(jlbBrushStrokeColor);
		innerPanel.add(jbtEditColors);

		add(innerPanel);

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
	}

	public void setStrokeColor(Color c) {
		canvas.setColor(c);
		BufferedImage image = new BufferedImage(100, 50,
				BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2 = image.createGraphics();
		g2.setColor(c);
		drawImageIcon(g2);
	}

	private void drawImageIcon(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.drawOval(10, 10, 5, 5);
		jlbBrushStrokeColor.paint(g2);
		repaint();
	}

	private class ColorDialogListener implements ActionListener, ChangeListener {
		private JColorChooser colorChooser;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			JDialog jd = new JDialog();
			colorChooser = new JColorChooser();
			jd.add(colorChooser);
			colorChooser.getSelectionModel().addChangeListener(this);
			jd.setSize(200,200);
			jd.setVisible(true);
		}

		@Override
		public void stateChanged(ChangeEvent arg0) {
			if((colorChooser.getColor())!=null){
				setStrokeColor(colorChooser.getColor());
				System.out.println("Color :" + colorChooser.getColor().getRGB());
			}
			

		}

	}

}
