package friedman.paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.BorderFactory;
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
	private JPanel shapeGrid;

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
		
		shapeGrid = createGridOfShapes();

		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new GridLayout(1, 4, 4, 4));
		innerPanel.add(jlbStrokeSize);
		innerPanel.add(jlbBrushStrokeColor);
		innerPanel.add(jbtEditColors);
		innerPanel.add(shapeGrid);
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
		BufferedImage image = new BufferedImage(100, 50, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2 = image.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setColor(c);
		drawImageIcon(g2);
	}

	private void drawImageIcon(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.drawOval(10, 10, 5, 5);
		jlbBrushStrokeColor.paint(g2);
		repaint();
	}
	
	private JPanel createGridOfShapes(){
		shapeGrid = new JPanel();
		shapeGrid.setLayout(new GridLayout(3,3));
		shapeGrid.setBorder(BorderFactory.createLineBorder(Color.black));
		BufferedImage image = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = image.createGraphics();
		PaintedButton jlb;
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(new Rectangle(10,10,10,20));
		shapes.add(new Rectangle(10,10,10,20));
		shapes.add(new Rectangle(10,10,10,20));
		shapes.add(new Rectangle(10,10,10,20));
		shapes.add(new Rectangle(10,10,10,20));
		for(Shape s:shapes){
			jlb = new PaintedButton(s);
			jlb.setText("hh");
			shapeGrid.add(jlb);
		}
		
		return shapeGrid;
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
			jd.setSize(400, 300);
			jd.setVisible(true);
		}

		@Override
		public void stateChanged(ChangeEvent arg0) {
			if ((colorChooser.getColor()) != null) {
				setStrokeColor(colorChooser.getColor());
				System.out.println("Color :" + colorChooser.getColor().getRGB());
			}

		}

	}

}
