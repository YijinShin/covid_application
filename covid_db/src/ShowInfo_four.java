import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.*;
import java.awt.Choice;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ShowInfo_four extends JPanel implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel title = new JLabel("Number of confirmed cases in the last month by district");
	JButton menuBtn = new JButton("Menu");
	DBdata db = new DBdata();


	int[] confirmedCaseTotal = null;
	String[] district = null; 
	int[] size = null; // length of rectangle	

	
	ShowInfo_four(JFrame frame){
		
		this.frame = frame;
		setLayout(null);
						
		System.out.println("1");
		//setting objects
		
		DrawInfo_four draw = new DrawInfo_four();
		
		title.setBounds(100,100,300,80);
		menuBtn.setBounds(700,700,100,50);
		menuBtn.addActionListener(this);

		//add objects to panel
		panel = draw;
		panel.add(menuBtn);
		panel.add(title);	
		//panel.add(draw);
		
		frame.add(panel);
	
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
		if(e.getSource().equals(menuBtn)) {
			System.out.println("clicked");
			panel.setVisible(false);
			new Menu(frame);
		}
	}	
}