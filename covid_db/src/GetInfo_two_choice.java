
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


public class GetInfo_two_choice extends JPanel implements ActionListener{
	
	JFrame frame = new JFrame();
	
	JPanel panel_two_choice = new JPanel();
	DBdata db = new DBdata();
	String[] country = null;
	
	Choice country_ch = new Choice(); // check list of country
	JButton bt1 = new JButton("Yes");
	JButton bt2 = new JButton("No"); 
	
	JLabel country_lb = new JLabel("Choose the country you visited.");
	JLabel question_lb = new JLabel("Have you ever visited a country other than the one you selected?");

	
	//country_ch setting function 
	public void setCountry_ch(Choice ch) {
		ch.setBackground(Color.white);
		
		country = db.getCountryFromCountry();
		for(int i=0;i<country.length;i++) {
			ch.addItem(country[i]);
		}
	}
	
	//creator
	public GetInfo_two_choice(JFrame frame) {
		this.frame = frame;
		
		//setting panel
		panel_two_choice.setLayout(null);
		panel_two_choice.setBackground(Color.white);
		panel_two_choice.setSize(new Dimension(1000,500));
		
		//setting labels
		country_lb.setBounds(70,60,200,70);
		question_lb.setBounds(70,200,400,70);
		
		//setting district_ch
		setCountry_ch(country_ch);
		country_ch.setBounds(70,150,120,100);

		//setting next button
		bt1.setBounds(70,250,70,50); //set button size, location
		bt2.setBounds(140,250,70,50); //set button size, location 
		bt1.addActionListener(this); //set acitonListener to button
		bt2.addActionListener(this); //set acitonListener to button
				
		//add all objects to panel
		panel_two_choice.add(country_lb);
		panel_two_choice.add(question_lb);
		panel_two_choice.add(bt1);
		panel_two_choice.add(bt2);
		panel_two_choice.add(country_ch);
		
		//add panel to frame
		frame.add(panel_two_choice);
		//frame.repaint();
	}
	
	
	//그 국가 감염자/인구수 * 10000 을 한후 10명당 1점을 부여한다.
	
	//감염자(CCCTotal)를 가져오는 함수와 
	//인구수(CPTotal)를 가져오는 함수를 DB data에 구현하고
	//가져와서 계산을 한 값을 num에 넣는다!
	
	public void calculateScore(int selected) {
		int[] CCCTotal = null;
		//int[] CPTotal = null;

		int num;
		CCCTotal = db.getCCCTotalFromArea(); //get list of confirmedCaseTotal from area
		//CPTotal = db.getCPTotalFromArea(); //get list of confirmedCaseTotal from area
		
		//get ConfirmedCaseTotal of selected district
		//num = (CCCTotal[selected] / CPTotal[selected]) * 10000;
		num = CCCTotal[selected];
		MainPanel.s += num / 10000;
		System.out.println("confirmedCaseTotal: "+num);
		
		System.out.println("Score : "+MainPanel.s);
		
	}
	
	//this is override function (this function works when you make some event (ex_button click...)
	public void actionPerformed(ActionEvent e) {
		
		//if next button clicked, calculate score. 
		if(e.getSource().equals(bt1)) {
			//calculate score
			int selected = country_ch.getSelectedIndex();
			calculateScore(selected);
			
			//go next panel
			panel_two_choice.setVisible(false);
			new GetInfo_two_choice(frame);
		}
		else if(e.getSource().equals(bt2)) {
			//calculate score
			int selected = country_ch.getSelectedIndex();
			calculateScore(selected);
			
			//go next panel
			panel_two_choice.setVisible(false);
			new GetInfo_three(frame);
		}
	}
}