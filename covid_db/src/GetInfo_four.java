// package database;

import java.awt.FlowLayout; 
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.*;
import javax.swing.event.*;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

public class GetInfo_four {
	JFrame frame = new JFrame();
	JLabel b;
	JPanel getinfoPanel = new JPanel();

	static JCheckBox[] c = new JCheckBox[6];
	
	public GetInfo_four(JFrame frame) {
		this.frame = frame;
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(200, 100, 320, 240);  
		frame.setLayout(new FlowLayout());
		
		
		JLabel label = new JLabel("			Please check applicable boxes for the symptoms\n");
		
		frame.add(label);		
		
		String[] symptoms= {"Dry Cough", "Fever", "Headaches", "Sore throat", "Fatigue", "Diarrhea"};
		
		for(int i=0; i<c.length; i++){
			c[i] = new JCheckBox(symptoms[i]);
			c[i].addItemListener(new MyItemListener());
			frame.add(c[i]);
		}
		
		b = new JLabel("your current score is 0");
		frame.add(b);
		
		JButton Submit = new JButton("Submit");
		frame.add(Submit);
		
		//setting panel
		getinfoPanel.setLayout(null);
		getinfoPanel.setBackground(Color.white);
		getinfoPanel.setSize(new Dimension(1000,500));
		
		frame.add(getinfoPanel);
		//frame.pack();
		frame.setVisible(true);
	}
	
	class MyItemListener implements ItemListener{
		
		public void itemStateChanged(ItemEvent e) {
			int select=1;
			
			if(e.getStateChange() == ItemEvent.SELECTED) {
				select = 1;	// increment upon selection
			}
			else {
				select = -1; // decrement upon no selection
			}
			for(int i=0; i<c.length; i++) {
				if(e.getItem() == c[i]) {
					MainPanel.s+= select;
				}
			}
			//JLabel label2 = new JLabel();
			b.setText("your current score is "+MainPanel.s);
		}
	}
}

