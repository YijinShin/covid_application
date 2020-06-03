import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.Choice;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class ShowInfo_one extends JPanel implements ActionListener{
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel title = new JLabel("Number of confirmed case Graphs by district");
	JButton nextBtn = new JButton("next");
	DBdata db = new DBdata();
	
	int[] confirmedCaseTotal = null;
	String[] district = null; 
	int[] size = null; // length of rectangle

	
	public ShowInfo_one(JFrame frame){
		this.frame = frame;
		//setting objects
		title.setBounds(50,50,100,80);
		nextBtn.setBounds(300,300,100,30);
		nextBtn.addActionListener(this);
		
		//add objects to panel
		add(nextBtn);
		add(title);
	}
	
	//draw rectangles
	public void paintComponent(Graphics g) {
		
		setGraph();
		
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		int x=50;
		System.out.println("here");
		for(int i=0;i<district.length;i++) {
			System.out.println("in for"+i);
			g.fillRect(x, 300, 16, size[i]*10);
			x+=30;
		}
	}
	
	
	//setting length of each district-rectengle
	public void setGraph() {
		//get info from DB
		confirmedCaseTotal = db.getCCTotalFromArea();
		district = db.getDistrictFromArea();
		
		// get size of each rectangle
		size = new int[district.length];
		for(int i=0;i<district.length;i++) {
			if(confirmedCaseTotal[i]<10) size[i] = 1;
			else {
				size[i] = confirmedCaseTotal[i]/10;
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(nextBtn)) {
			
		}
	}
	
}

