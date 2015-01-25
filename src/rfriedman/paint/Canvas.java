package rfriedman.paint;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import rfriedman.paint.drawing.DrawListener;
import rfriedman.paint.listeners.PaintListener;


public class Canvas extends JComponent {
	private static final long serialVersionUID = 1L;

	private int canvasHeight;
	private int canvasWidth;

	private DrawListener listener;

	private Color color;
	private Layer selectedLayer;
	private Layer[] layers;
	public static int NUM_LAYERS;

	protected static final Logger LOGGER = LogManager.getLogger(Canvas.class);

	public Canvas(int width, int height) {
		// TODO add Window Listener so canvas will be resizable
		super();
		this.canvasHeight = height;
		this.canvasWidth = width;

		this.color = Color.BLACK;
		this.NUM_LAYERS = 4;
		layers = new Layer[NUM_LAYERS];
		createLayers();
		Graphics g = selectedLayer.getGraphics();
		setPaintColor(Color.WHITE);
		g.fillRect(0, 0, canvasWidth, canvasHeight);
		setPaintColor(color);
		setDrawListener(new PaintListener(this));
		this.setFocusable(true);
	      this.requestFocus();

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color);
		for (int i = 0; i < NUM_LAYERS; i++) {
			g.drawImage(layers[i].getImage(), 0, 0, null);
		}

		listener.drawPreview((Graphics2D) g);

	}

	public BufferedImage getImage() {
		return selectedLayer.getImage();
	}

	private void createLayers() {
		for (int i = 0; i < NUM_LAYERS; i++) {
			layers[i] = new Layer(canvasWidth, canvasHeight);
		}
		selectedLayer = layers[0];
	}

	public void setDrawListener(DrawListener mml) {
		removeMouseListener(listener);
		removeMouseMotionListener(listener);
		listener = mml;
		addMouseListener(listener);
		addMouseMotionListener(listener);

	}

	public void setPaintColor(Color c) {
		// TODO Auto-generated method stub
		color = c;

	}

	public Color getPaintColor() {
		return color;
	}

	public void setSelectedLayer(int layerNum) {
		this.selectedLayer = layers[layerNum];
		LOGGER.info("selected Layer is currently " + layerNum);
	}

	public void clear() {
		Graphics2D g = getImage().createGraphics();
		if (selectedLayer.equals(layers[0])) // background layer should be white
		{
			g.setPaint(Color.WHITE);
			g.fillRect(0, 0, getImage().getWidth(), getImage().getHeight());
		} else
		// all others transparent
		{
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR));
			g.fillRect(0, 0, getImage().getWidth(), getImage().getHeight());
			// reset composite
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));

		}

		repaint();
	}

	public int getCanvasWidth() {
		// TODO Auto-generated method stub
		return canvasWidth;
	}

	public int getCanvasHeight() {
		// TODO Auto-generated method stub
		return canvasHeight;
	}

	public Layer[] getLayers() {
		return layers;
	}

}
