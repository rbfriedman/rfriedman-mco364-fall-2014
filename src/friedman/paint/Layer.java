package friedman.paint;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Layer {
	private BufferedImage image;
	
	public Layer(int width, int height){
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	}

	public BufferedImage getImage() {
		return image;
	}

	public Graphics getGraphics() {
		// TODO Auto-generated method stub
		return image.getGraphics();
	}

}
