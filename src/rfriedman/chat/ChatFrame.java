package rfriedman.chat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class ChatFrame extends JFrame implements ActionListener {
	private JTextPane jPane;
	private JScrollPane areaScrollPane;
	private JTextField jtfNewMessage;
	private JButton jbtSend;
	private StringBuilder myMessage;
	private Socket socket;
	private String title;
	
	private int HEIGHT;
	private int WIDTH;

	public ChatFrame(String title) {
		this.title = title;
		this.jPane = new JTextPane();
		this.myMessage = new StringBuilder();

		jtfNewMessage = new JTextField();
		jbtSend = new JButton("SEND");
		
		jbtSend.addActionListener(this);

		layoutFrame();
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 250);
		this.setVisible(true);

		pack();
	}


	private void layoutFrame() {
		jPane.setText(myMessage.toString());
		areaScrollPane = new JScrollPane(jPane);
		areaScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(400, 250));
		
		jtfNewMessage.setPreferredSize(new Dimension(400 * 2 / 3,
				HEIGHT * 1 / 6));
		jbtSend.setPreferredSize(new Dimension(400 * 1 / 3, 400 * 1 / 6));

		JPanel lowerPanel = new JPanel();
		lowerPanel.setLayout(new BorderLayout());
		lowerPanel.add(jtfNewMessage,BorderLayout.CENTER);
		lowerPanel.add(jbtSend,BorderLayout.EAST);
		add(areaScrollPane, BorderLayout.CENTER);
		add(lowerPanel, BorderLayout.SOUTH);

	}
	
	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public void appendMessage(String message) {
		jPane.setText(jPane.getText()+message+"\n");
		

	}

	public void send(String s) throws IOException {
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.println(s);
		out.flush();
	}

	private void sendAndAppendMessage() {
		String s = jtfNewMessage.getText();
		appendMessage(title +" : " +s);
		try {
			send(title +" : " +s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		jtfNewMessage.setText("");
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		sendAndAppendMessage();
	}

}
