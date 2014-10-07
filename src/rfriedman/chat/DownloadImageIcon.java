package rfriedman.chat;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class DownloadImageIcon extends Thread {
	ChatFrame frame;
	private final String imageIcon;

	public DownloadImageIcon(ChatFrame frame) {
		this.frame = frame;
		this.imageIcon = frame.getAvatarFeedUrl();
	}

	public void run() {
		try {
			URL imgUrl = new URL(imageIcon);
			BufferedImage img = ImageIO.read(imgUrl);
			frame.setIconImage(new ImageIcon(img).getImage());
		} catch (MalformedURLException m) {
			m.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
