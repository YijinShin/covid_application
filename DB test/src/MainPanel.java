import javax.swing.JLabel;
import javax.swing.JPanel;

import GetInfoPanel.MyActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;

public class MainPanel extends JPanel implements ActionListener{
	
	public static int s=10;	
	
	JFrame f = new JFrame();
	
	JPanel mainPanel = new JPanel();
	JButton bt1 = new JButton("위험도 측정");
	JButton bt2 = new JButton("코로나 정보");
	
	public MainPanel(JFrame frame) {
		f = frame;
		bt1.setBounds(100,200,80,50); //set button size, location
		bt2.setBounds(300,200,80,50); //set button size, location 

		bt1.addActionListener(this); //set acitonListener to button
		bt2.addActionListener(this); //set acitonListener to button
		
		mainPanel.add(bt1);
		mainPanel.add(bt2);
		
		frame.add(mainPanel);
		frame.show();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(bt1)) {
			mainPanel.setVisible(false);
			new GetInfoPanel(f);
			//new GetInfoGui("감염 위험도 측정");
			
		}
		else if(e.getSource().equals(bt2)) {
			System.out.println("아직 미구현\n");
			
		}
	}
	
}
