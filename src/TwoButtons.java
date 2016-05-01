import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TwoButtons {
	
	JFrame frame;
	JLabel label;

	public static void main(String[] args) {
		TwoButtons gui = new TwoButtons();
		gui.go();
	}
	
	public void go(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton labelButton = new JButton("Change label");
		labelButton.addActionListener(new LabelListener());
		
		JButton colorButton = new JButton("Change color");
		colorButton.addActionListener(new ColorListener());
		
		label = new JLabel("I'm a label");
		MyDrawPanel drawPanel = new MyDrawPanel();
		
		frame.getContentPane().add(colorButton, BorderLayout.SOUTH);
		frame.getContentPane().add(drawPanel, BorderLayout.CENTER);
		frame.getContentPane().add(labelButton, BorderLayout.EAST);
		frame.getContentPane().add(label, BorderLayout.WEST);
		
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	
	class LabelListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			label.setText("Ouch!");
		}
		
	}
	
	class ColorListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.repaint();
		}
		
	}

}

class MyDrawPanel extends JPanel{
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		
		int red = (int) (Math.random()*255);
		int green = (int) (Math.random()*255);
		int blue = (int) (Math.random()*255);
		
		Color color = new Color(red,green,blue);
		
		g2.setPaint(color);
		g2.fillOval(5, 5, 50, 50);
	}
}
