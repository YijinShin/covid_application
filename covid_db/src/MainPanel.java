import javax.swing.JLabel;
import javax.swing.JPanel;

//import GetInfoPanel.MyActionListener;

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
	
	public static int s = 0;	//this is score variable.if you want to use s in other class, write "MainPanel.s"  
	public static String userDistrict = " ";
	public static int country_counter = 0;
	
	JFrame frame = new JFrame();
	
	JPanel mainPanel = new JPanel();
	JButton bt1 = new JButton("Check your probability of getting the disease.");
	JButton bt2 = new JButton("Check information on Corona in Seoul");
	
	public MainPanel(JFrame frame) {
		this.frame = frame;
		
		mainPanel.setLayout(null);

		bt1.setBounds(70,70,300,80); //set button size, location
		bt2.setBounds(70,170,300,80); //set button size, location 

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
			new GetInfo_one(frame);
			
		}
		else if(e.getSource().equals(bt2)) {
			mainPanel.setVisible(false);
			new Menu(frame);
			//new ShowInfo_one(frame);
		}
	}
	
}
