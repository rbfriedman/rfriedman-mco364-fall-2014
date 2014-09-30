package rfriedman.chat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIPanel extends JPanel {
	private JTextField chatBox;
	private JButton sendButton;
	private JPanel panel;
	
	private int WIDTH =300;
	private int HEIGHT =100;
	public GUIPanel(int width, int height){
		setWIDTH(width-50);
		setHEIGHT(height-20);
		panel = new JPanel();
		chatBox = new JTextField();
		chatBox.setText("JJJ");
		sendButton = new JButton("SEND");
		chatBox.setPreferredSize(new Dimension(WIDTH*2/3,HEIGHT*1/6));
		sendButton.setPreferredSize(new Dimension(WIDTH*1/3,HEIGHT*1/6));
		add(chatBox);
		add(sendButton);
		sendButton.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
			    //send data to panel
			  }
			});
	

	}
	
	public int getWIDTH() {
		return WIDTH;
	}

	public void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}

	public static void main(String[] args){
		JFrame f = new JFrame();
		GUIPanel g = new GUIPanel(400,100);
		g.setPreferredSize(new Dimension(400, 200));
		f.getContentPane().add(g);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}
	
	
	

}
