package friedman.paint.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import friedman.paint.Client;
import friedman.paint.PaintListener;

public class NetworkListener implements ActionListener {
	private boolean connected;
	private Client client;

	public NetworkListener(Client client) {
		this.client = client;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();

		if (connected) {
			disconnect(b);
		} else {
			connect(b);
		}
	}

	private void connect(JButton b) {
		connected = true;
		b.setText("Loopback");
		
		client.connectToNetwork();
		
		client.start();
	}

	private void disconnect(JButton b) {
		connected = false;
		b.setText("Network");

		client.disconnectFromNetwork();
	}
}
