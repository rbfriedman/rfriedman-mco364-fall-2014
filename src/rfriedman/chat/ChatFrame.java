package rfriedman.chat;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class ChatFrame extends JFrame {
	private GUIPanel guiPanel;
	private JTextPane jPane;
	private JPanel containerPanel;
	private JScrollPane areaScrollPane;
	

	public ChatFrame(GUIPanel guiPanel) {
		this.guiPanel = guiPanel;
		guiPanel.setSize(getWidth(), 100);
		this.jPane = new JTextPane();
		areaScrollPane = new JScrollPane(jPane);
		areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(400, 250));

		jPane.setPreferredSize(new Dimension(400, 150));
		this.containerPanel = new JPanel();
		add(containerPanel);
		this.setTitle("My Chat");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		containerPanel.add(areaScrollPane);
		containerPanel.add(guiPanel);

	}

	public static void main(String[] args) {
		ChatFrame c = new ChatFrame(new GUIPanel());
		c.setVisible(true);
	}

}
