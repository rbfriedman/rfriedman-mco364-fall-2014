package friedman.paint;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
		setLayout(new FlowLayout(FlowLayout.RIGHT));

		ImageIcon icon = createImageIcon(editColorIcon, "Color Palette");
		jbtEditColors = new JButton("Edit Colors", icon);
		jbtEditColors.addActionListener(new ColorDialogListener(this));
		
		jbtClearScreen = new JButton("Clear Screen");
		jbtClearScreen.addActionListener(new ClearScreenListener(this.paintListener));

		jlbBrushStrokeColor = new JLabel("Stroke Color");
		jlbBrushStrokeColor.setOpaque(true);
		setStrokeColor(Color.black);
		icon = createImageIcon(jlbStrokeSizeIcon, "Stroke width");
		jlbStrokeSize = new JLabel("10",icon,10);
	shapeGrid = createGridOfShapes();

		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new GridLayout(1, 5, 4, 4));
		innerPanel.add(jlbStrokeSize);
		innerPanel.add(jlbBrushStrokeColor);
		innerPanel.add(jbtEditColors);
		innerPanel.add(jbtClearScreen);
		
		Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
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

	public void setStrokeColor(Color c) {
		paintListener.setColor(c);
		jlbBrushStrokeColor.setBackground(c);
		jlbBrushStrokeColor.repaint();


	}
	
	private JPanel createGridOfShapes(){
		shapeGrid = new JPanel();
		shapeGrid.setLayout(new GridLayout(2,2));
		shapeGrid.setBorder(BorderFactory.createLineBorder(Color.black));
		PaintedButton jlb;
	
		for(ShapeType s:ShapeType.values()){
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
	
	public void setPaintListener(PaintListener mml){
		//paintListener.setDrawListener(mml);
	}


	

}
