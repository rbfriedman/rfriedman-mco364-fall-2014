package rfriedman.chat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIPanel extends JPanel {
	private JPanel panel;
	private JTextField chatBox;
	private JButton sendButton;
	
	public GUIPanel(){
		panel = new JPanel();
		chatBox = new JTextField();
		chatBox.setPreferredSize(new Dimension(300, 100));
		sendButton = new JButton("SEND");
		sendButton.setPreferredSize(new Dimension(100, 100));
		setMinimumSize(new Dimension(300, 150));
		panel.setMinimumSize(new Dimension(300, 100));
		add(panel);
		panel.add(chatBox);
		panel.add(sendButton);
		
		sendButton.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
			    //send data to panel
			  }
			});

	}
	
	
	

}
