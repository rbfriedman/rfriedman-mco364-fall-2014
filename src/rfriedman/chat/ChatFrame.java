package rfriedman.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import com.google.gson.Gson;

public class ChatFrame extends JFrame implements ActionListener,AvatarListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1364366119227491116L;
	private JTextPane jPane;
	private JScrollPane areaScrollPane;
	private JTextField jtfNewMessage;
	private JButton jbtSend;
	private StringBuilder myMessage;
	private Socket socket;
	private String title;

	private Color colorId;

	private int HEIGHT;
	private int WIDTH;

	private static int colorFormation = 2;
	private AvatarFeed avatarFeed;

	public ChatFrame(String title) throws IOException {
		this.title = title;
		jPane = new JTextPane();
		myMessage = new StringBuilder();
		jtfNewMessage = new JTextField();
		jbtSend = new JButton("SEND");
		HEIGHT = getToolkit().getScreenSize().getSize().height / 4;
		WIDTH = getToolkit().getScreenSize().getSize().width / 4;

		jbtSend.addActionListener(this);
		
		//this.sendGet();
		addKeyListener();
		layoutFrame();
		generateColors();
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(WIDTH, HEIGHT);
		// TODO set minumum size
		this.setVisible(true);
		pack();
		
		
	}

	private void addKeyListener() {
		// TODO Auto-generated method stub
		jtfNewMessage.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					sendAndAppendMessage();
				}
			}

			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
	}

	private void generateColors() {
		// TODO Auto-generated method stub
		int value1 = (int) (Math.random() * 60 + 100);
		int value2 = (int) (Math.random() * 30);
		int value3 = (int) (Math.random() * 30);
		int temp = 0;

		// colorFormation is used as a ceasarcipher key to shift colors
		switch (colorFormation) {
		case 1:
			// original scenario(no shift)
			break;
		case 2:
			temp = value1;
			value1 = value2;
			value2 = value3;
			value3 = temp;
			break;
		case 3:
			temp = value1;
			value1 = value3;
			value2 = temp;
			value3 = value2;
			break;
		}
		colorId = new Color(value1, value2, value3);
		colorFormation += 1;
		colorFormation %= 3;
	}

	private void layoutFrame() {
		jPane.setText(myMessage.toString());
		areaScrollPane = new JScrollPane(jPane);
		areaScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(WIDTH, HEIGHT));

		jtfNewMessage.setPreferredSize(new Dimension(WIDTH * 2 / 3,
				HEIGHT * 1 / 6));
		jbtSend.setPreferredSize(new Dimension(WIDTH * 1 / 3, HEIGHT * 1 / 6));

		JPanel lowerPanel = new JPanel();
		lowerPanel.setLayout(new BorderLayout());
		lowerPanel.add(jtfNewMessage, BorderLayout.CENTER);
		lowerPanel.add(jbtSend, BorderLayout.EAST);
		add(areaScrollPane, BorderLayout.CENTER);
		add(lowerPanel, BorderLayout.SOUTH);

	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public void appendMessage(String message) {
		appendToPane(jPane, message + "\n", Color.BLACK);

	}

	private void appendToPane(JTextPane tp, String msg, Color c) {
		StyleContext sc = StyleContext.getDefaultStyleContext();
		AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY,
				StyleConstants.Foreground, c);

		aset = sc.addAttribute(aset, StyleConstants.FontFamily,
				"Lucida Console");
		aset = sc.addAttribute(aset, StyleConstants.Alignment,
				StyleConstants.ALIGN_JUSTIFIED);

		int len = tp.getDocument().getLength();
		tp.setCaretPosition(len);
		tp.setCharacterAttributes(aset, false);
		tp.replaceSelection(msg);
	}

	public void send(String s) throws IOException {
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.println(s);
		out.flush();
	}

	private void appendNameofSender() {

		appendToPane(jPane, title + " : ", colorId);
	}

	private void sendAndAppendMessage() {
		// TODO pictures and better system for title
		try {
			String s = jtfNewMessage.getText();
			if (s.equals("")) {
				throw new EmptyTextFieldException();

			}
			appendNameofSender();
			appendMessage(s);
			send(title + " : " + s);
			jtfNewMessage.setText("");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (EmptyTextFieldException e) {
			// Do Nothing
		}

	}

	public void actionPerformed(ActionEvent arg0) {
		sendAndAppendMessage();
		
	}

	public void sendGet() throws IOException {
		// TODO Auto-generated method stub
		DownloadGoogleAvatarThread t = new DownloadGoogleAvatarThread(this);
		t.start();
		
	}

	public void setIconImage(AvatarFeed avatarFeed) {
		// TODO Auto-generated method stub
		this.avatarFeed = avatarFeed;
		DownloadImageIcon iconThread = new DownloadImageIcon(this);
		iconThread.start();
	}

	public String getAvatarFeedUrl() {
		// TODO Auto-generated method stub
		return avatarFeed.getAvatarUrl();
	}

}
