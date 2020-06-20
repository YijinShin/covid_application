
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
	
	JLabel steps = new JLabel("Step 2/4");
	JLabel counter;
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
		MainPanel.country_counter += 1;
		counter = new JLabel("("+MainPanel.country_counter+"st country)");
		this.frame = frame;
		
		//setting panel
		panel_two_choice.setLayout(null);
		panel_two_choice.setBackground(Color.white);
		panel_two_choice.setSize(new Dimension(1000,500));
		
		//setting labels
		steps.setBounds(10, 10, 150, 50);
		country_lb.setBounds(70,60,200,70);
		counter.setBounds(70, 80, 100, 50);
		question_lb.setBounds(70,198,400,70);
		
		//setting district_ch
		setCountry_ch(country_ch);
		country_ch.setBounds(70,130,120,100);

		//setting next button
		bt1.setBounds(70,250,70,50); //set button size, location
		bt2.setBounds(140,250,70,50); //set button size, location 
		bt1.addActionListener(this); //set acitonListener to button
		bt2.addActionListener(this); //set acitonListener to button
				
		//add all objects to panel
		panel_two_choice.add(steps);
		panel_two_choice.add(counter);
		panel_two_choice.add(country_lb);
		panel_two_choice.add(question_lb);
		panel_two_choice.add(bt1);
		panel_two_choice.add(bt2);
		panel_two_choice.add(country_ch);
		
		//add panel to frame
		frame.add(panel_two_choice);
		//frame.repaint();
	}
	
	
	//占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙/占싸깍옙占쏙옙 * 10000 占쏙옙 占쏙옙占쏙옙 10占쏙옙占쏙옙 1占쏙옙占쏙옙 占싸울옙占싼댐옙.
	
	//占쏙옙占쏙옙占쏙옙(CCCTotal)占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쌉쇽옙占쏙옙 
	//占싸깍옙占쏙옙(CPTotal)占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쌉쇽옙占쏙옙 DB data占쏙옙 占쏙옙占쏙옙占싹곤옙
	//占쏙옙占쏙옙占싶쇽옙 占쏙옙占쏙옙占� 占쏙옙 占쏙옙占쏙옙 num占쏙옙 占쌍는댐옙!
	
	public void calculateScore(int selected) {
		int[] CCCTotal = null;
		int[] CPTotal = null;

		CCCTotal = db.getCCCTotalFromArea(); //get list of confirmedCaseTotal from country
		CPTotal = db.getCPTotalFromArea(); //get list of countryPopulation from country
		
		//get ConfirmedCaseTotal of selected district
		float num = (float)CCCTotal[selected] / (float)CPTotal[selected] * 1000;
		MainPanel.s += (int)num;
		
		System.out.println("Score in step 2 : " + (int)num); //Incidence per 1,000 people
		System.out.println("Total Score : " + MainPanel.s);
		
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