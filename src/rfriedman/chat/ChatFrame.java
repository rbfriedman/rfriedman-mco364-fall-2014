package rfriedman.chat;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class ChatFrame extends JFrame {
	private ChatServer server;
	private GUIPanel guiPanel;
	private JTextPane jPane;
	private JPanel containerPanel;
	private JScrollPane areaScrollPane;
	private StringBuilder myMessage;

	public ChatFrame(GUIPanel guiPanel) {
		this.guiPanel = guiPanel;
		
		this.jPane = new JTextPane();
		this.myMessage = new StringBuilder();
		
		
		this.containerPanel = new JPanel();
		layoutFrame();
		this.setTitle("My Chat");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
		server = new ChatServer(this);
		new Thread(server);
		pack();
		setVisible(true);
	}

	private void layoutFrame() {
		jPane.setText(myMessage.toString());
		areaScrollPane = new JScrollPane(jPane);
		areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(400, 250));
		

		
		add(areaScrollPane,BorderLayout.CENTER);
		add(guiPanel,BorderLayout.SOUTH);
		
		
	}

	public static void main(String[] args) {
		int w =400;
		int h=400;
		ChatFrame c = new ChatFrame(new GUIPanel(w,h));
		c.setSize(w, h);
		c.setVisible(true);
	}
	
	public void appendMessage(String message){
		myMessage.append(message).append("\n");
		jPane.repaint();
		repaint();
		
	}

}
