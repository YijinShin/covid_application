import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.Choice;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GetInfo_one extends JPanel implements ActionListener{
	
	JFrame frame = new JFrame();
	
	JPanel getinfoPanel = new JPanel();
	DBdata db = new DBdata();
	String[] district = null;
		
	Choice district1_ch = new Choice(); // check list of district
	Choice district2_ch = new Choice(); // check list of district
	JButton nextBtn = new JButton("next"); // next button
	JLabel steps = new JLabel("Step 1/4");
	JLabel residence1_lb = new JLabel("Choose the district you live in.");
	JLabel residence2_lb = new JLabel("Choose the district you work in.");
	
	
	//district_ch setting function 
	public void setDistrict_ch(Choice ch) {
		ch.setBackground(Color.white);
		
		district = db.getDistrictFromArea();
		for(int i=0;i<district.length;i++) {
			ch.addItem(district[i]);
		}
	}
	
	// Creator
	public GetInfo_one(JFrame frame) {
		this.frame = frame;
		
		//setting panel
		getinfoPanel.setLayout(null);
		getinfoPanel.setBackground(Color.white);
		getinfoPanel.setSize(new Dimension(1000,500));
		
		//setting labels
		steps.setBounds(10, 10, 150, 50);
		residence1_lb.setBounds(70,60,250,50);
		residence2_lb.setBounds(70,140,250,50);
		
		//setting next button
		nextBtn.setBounds(100,400,250,50);
		nextBtn.addActionListener(this);
		
		//setting district_ch
		setDistrict_ch(district1_ch);
		setDistrict_ch(district2_ch);
		district1_ch.setBounds(70,110,120,50);
		district2_ch.setBounds(70,190,120,50);
		
		//add all objects to panel
		getinfoPanel.add(steps);
		getinfoPanel.add(residence1_lb);
		getinfoPanel.add(residence2_lb);
		getinfoPanel.add(district1_ch);
		getinfoPanel.add(district2_ch);
		getinfoPanel.add(nextBtn);
		
		//add panel to frame
		frame.add(getinfoPanel);
		//frame.repaint();
	}
	
	public void calculateScore(int selected1,int selected2) {
		int[] ConfirmedCaseTotal = null;
		int num;
		int score = 0;
		ConfirmedCaseTotal = db.getCCTotalFromArea(); //get list of confirmedCaseTotal from area
		
		//get ConfirmedCaseTotal of selected district
		num = ConfirmedCaseTotal[selected1];
		System.out.println("confirmedCaseTotal about living district: "+num);
		score += num/10;
		
		num = ConfirmedCaseTotal[selected2];
		System.out.println("confirmedCaseTotal about working district: "+num);
		score += num/10;

		MainPanel.s += score;

		System.out.println("Score in step 1 : " + score);
		System.out.println("Total Score : " + MainPanel.s);
		
	}
	
	//this is override function (this function works when you make some event (ex_button click...)
	public void actionPerformed(ActionEvent e) {
		
		//if next button clicked, calculate score. 
		if(e.getSource().equals(nextBtn)) {
			//calculate score
			int selected1 = district1_ch.getSelectedIndex();
			int selected2 = district2_ch.getSelectedIndex();
			calculateScore(selected1,selected2);
			
			MainPanel.userDistrict = district[selected1];
			//go next panel
			getinfoPanel.setVisible(false);
			new GetInfo_two(frame);
		}
	}
}