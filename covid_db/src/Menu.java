
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

public class Menu extends JPanel implements ActionListener{
	
	JFrame frame = new JFrame();
	
	JPanel panel = new JPanel();
	
	JButton info1 = new JButton("info1");
	JButton info2 = new JButton("info2");
	JButton info3 = new JButton("info3");
	JButton info4 = new JButton("info3");
	JButton home = new JButton("home");

	public Menu(JFrame frame) {
		this.frame = frame;
		
		//setting panel
		panel.setLayout(null);

		int y=100;
		int x=100;
		
		info1.setBounds(x,y,100,50); 
		info2.setBounds(x+200,y,100,50); 
		info3.setBounds(x,y+100,100,50); 
		info4.setBounds(x+200,y+100,100,50); 
		home.setBounds(700,700,100,50); 
		
		info1.addActionListener(this); 
		info2.addActionListener(this); 
		info3.addActionListener(this); 
		home.addActionListener(this);
	
		panel.add(info1);
		panel.add(info2);
		panel.add(info3);
		panel.add(info4);
		panel.add(home);
		
		//add panel to frame
		frame.add(panel);
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(info1)) {
			panel.setVisible(false);
			new ShowInfo_one(frame);			
		}
		if(e.getSource().equals(info2)) {
			panel.setVisible(false);
			new ShowInfo_two(frame);			
		}
		if(e.getSource().equals(info3)) {
			panel.setVisible(false);
			new ShowInfo_three(frame);			
		}
		if(e.getSource().equals(info4)) {
			panel.setVisible(false);
			new ShowInfo_three(frame);			
		}
		if(e.getSource().equals(home)) {
			panel.setVisible(false);
			new MainPanel(frame);			
		}
	}
	
}
	