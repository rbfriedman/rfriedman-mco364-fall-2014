package friedman.paint;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class Paint extends JFrame {

	public static void main(String[] args) {
		Paint paint = new Paint();
		paint.setVisible(true);

	}
	
	public Paint(){
		
		BorderLayout layout = new BorderLayout();
		Container container = getContentPane();
		container.setLayout(layout);
		
		Canvas canvas = new Canvas();
		add(canvas,BorderLayout.CENTER);
		setSize(800,600);
		setTitle("Paint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}

}
