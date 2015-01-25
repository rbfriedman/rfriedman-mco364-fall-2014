package rfriedman.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Layer {
	private BufferedImage image;
	public static BufferedImage BLANK_IMAGE;
	
	public Layer(int width, int height){
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		BLANK_IMAGE  = new BufferedImage ( width, height, BufferedImage.TYPE_INT_ARGB );
		Graphics2D g = BLANK_IMAGE.createGraphics();
		g.setColor( new Color ( 255,255,255, 0 ));
		g.fillRect(0, 0, width, height);
	}

	public BufferedImage getImage() {
		return image;
	}

	public Graphics getGraphics() {
		// TODO Auto-generated method stub
		return image.getGraphics();
	}

}
