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



class GetInfo_four extends JFrame implements ActionListener{
	JFrame frame = new JFrame();
	JPanel getinfoPanel = new JPanel();
	 
	JLabel question;
	JLabel none;   // can be removed just for checking 
	static JCheckBox[] symptomlist = new JCheckBox[6];
	
	JButton next;
	JButton prev;
	
	GetInfo_four(JFrame frame){
		
		this.frame = frame;
		
		//setting panel
		getinfoPanel.setLayout(null);
		getinfoPanel.setBackground(Color.white);
		getinfoPanel.setSize(new Dimension(1000,500));
		
		question = new JLabel("Please check applicable boxes for the symptoms");
		question.setBounds(50,80,400,20);
		
		getinfoPanel.add(question);		
		
		String[] symptoms= {"Dry Cough", "Fever", "Headaches", "Sore throat", "Fatigue", "Diarrhea"};
		
		int y = 100;
		
		for(int i=0; i<symptomlist.length; i++){
			symptomlist[i] = new JCheckBox(symptoms[i]);
			symptomlist[i].addItemListener(new MyItemListener());
			symptomlist[i].setBounds(100,y,350,20);
			y += 20;
			getinfoPanel.add(symptomlist[i]);
		}
		
		none = new JLabel("your current score is 0");
		none.setBounds(100,y+20,300,20);
		getinfoPanel.add(none);	
		
		prev = new JButton("prev");
		prev.setBounds(50,400,80,20);
		prev.addActionListener(this);
		getinfoPanel.add(prev);
		
		next = new JButton("next");
		next.setBounds(400,400,80,30);
		next.addActionListener(this);
		getinfoPanel.add(next);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(getinfoPanel);
	}
	
	class MyItemListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			int select=1;
			
			if(e.getStateChange() == ItemEvent.SELECTED) {
				select = 1;	// increment upon selection
			}
			else {
				select = -1; // decrement upon no selection
			}
			for(int i=0; i<symptomlist.length; i++) {
				if(e.getItem() == symptomlist[i]) {
					MainPanel.s+= select;
				}
			}
			//JLabel label2 = new JLabel();
			none.setText("your current score is "+MainPanel.s);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(next)) {
			getinfoPanel.setVisible(false);
			new GetResult(frame);
		}
	}
}






