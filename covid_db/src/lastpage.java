import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class lastpage extends JPanel implements ActionListener{
	
	JFrame frame = new JFrame();
	
	JPanel getinfoPanel = new JPanel();
	DBdata db = new DBdata();
	
	JButton homeBtn = new JButton("home"); // next button
	
	JLabel line;
	JLabel score_avg;
	JLabel clinic;
	
	public lastpage(JFrame frame) {
		this.frame = frame;
		System.out.println("this is the last page test");
		
		getinfoPanel.setLayout(null);
	
		homeBtn.setBounds(50,400,250,50);
		homeBtn.addActionListener(this);
		getinfoPanel.add(homeBtn);
		
		line = new JLabel("Your score is: " + MainPanel.s);
		line.setBounds(50,80,400,20);
		
		getinfoPanel.add(line);		
		
		db.insertScore();
		
		int avgscore = db.getUserInfo();
		System.out.println("after getuserinfo:"+avgscore);
		
		
		score_avg = new JLabel("Overall average score of App Users is : " + avgscore);
		score_avg.setBounds(50,120,400,20);
		getinfoPanel.add(score_avg);
		
		
		int[] clinicID = db.getClinicID();
		clinic= new JLabel("recommended clinic : ");
		score_avg.setBounds(50,160,400,20);
		
		for(int i = 0; i< clinicID.length;i++) {
			System.out.println("clinicID:"+clinicID[i]);
		}

		//add panel to frame
		frame.add(getinfoPanel);
	}
	
	
	//this is override function (this function works when you make some event (ex_button click...)
	public void actionPerformed(ActionEvent e) {
		
		//if next button clicked, calculate score. 
		if(e.getSource().equals(homeBtn)) {
			//go next panel
			getinfoPanel.setVisible(false);
			new MainPanel(frame);
		}
	}
}