
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


public class GetInfo_two extends JPanel implements ActionListener{
	
	JFrame frame = new JFrame();
	
	JPanel panel_two = new JPanel();
	JLabel steps = new JLabel("Step 2/4");
	JLabel country_lb = new JLabel("Have you been to another country in the last two weeks?");
	
	JButton bt1 = new JButton("Yes");
	JButton bt2 = new JButton("No");
	

	public GetInfo_two(JFrame frame) {
		this.frame = frame;
		
		//setting panel
		panel_two.setLayout(null);
		panel_two.setBackground(Color.white);
		panel_two.setSize(new Dimension(1000,500));
		
		//setting labels
		steps.setBounds(10, 10, 150, 50);
		country_lb.setBounds(50,50,400,100);
		
		//setting buttons		
		bt1.setBounds(150,150,70,50); //set button size, location
		bt2.setBounds(300,150,70,50); //set button size, location 
		bt1.addActionListener(this); //set acitonListener to button
		bt2.addActionListener(this); //set acitonListener to button
		
		//add all objects to panel
		panel_two.add(steps);
		panel_two.add(country_lb);
		panel_two.add(bt1);
		panel_two.add(bt2);
		
		//add panel to frame
		frame.add(panel_two);
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(bt1)) {
			panel_two.setVisible(false);
			new GetInfo_two_choice(frame);			
		}
		else if(e.getSource().equals(bt2)) {
			panel_two.setVisible(false);
			new GetInfo_three(frame);
	
		}
	}
	
}
	