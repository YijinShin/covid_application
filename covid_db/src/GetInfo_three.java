import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.event.*;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GetInfo_three extends JFrame implements ActionListener {
	
	 JFrame frame = new JFrame();
	
	 JPanel getinfoPanel = new JPanel();
	 
	 DBdata db = new DBdata();
	 String[] infectionProcess = db.getProcessFromInfectionProcess();
	
	 JLabel steps = new JLabel("Step 3/4");
	 JLabel question;	
	 JCheckBox q[] = new JCheckBox[30];	 
	 JLabel none;
	 
	 CardLayout cd = null;
	 
	 JButton next;
	 
	 GetInfo_three(JFrame frame)
	 {
		 this.frame = frame;		 
		 
		 getinfoPanel.setLayout(null);
		 getinfoPanel.setBackground(Color.white);
		 getinfoPanel.setSize(new Dimension(1000,500));
		 
		 question = new JLabel("Please check the items below that relate to you.");
		 question.setBounds(50,80,300,20);
		 steps.setBounds(10, 10, 150, 50);

		 none = new JLabel("If none of the following are related to you, please do not check.");
		 none.setBounds(50,100,400,20);		 
		 
		 int y = 120;
		 
		 for(int i = 0; i< infectionProcess.length;i++) {
			 		 
			 q[i] = new JCheckBox(infectionProcess[i]);		 
		 
			 q[i].setBounds(100,y,350,20);
			 
			 y += 20;
		 
		 }		
		 
		 y += 40;

		 next = new JButton("next");
		 next.setBounds(200,y,80,30);
		 next.addActionListener(this);
		
		 getinfoPanel.add(steps);
		 getinfoPanel.add(question); 
		 getinfoPanel.add(none); 
		 //getinfoPanel.add(end);
		 getinfoPanel.add(next);
		 
		 for(int i = 0; i<infectionProcess.length;i++) {
			 getinfoPanel.add(q[i]);
		 }
		
			
		 frame.add(getinfoPanel);			
		 
	 }
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int amount = 0;				
		
		if(e.getSource().equals(next)) {
			
			for(int i = 0; i < infectionProcess.length ; i++) {
				if(q[i].isSelected())
					amount += 1;
			}
			
			MainPanel.s += amount;
			
			getinfoPanel.setVisible(false);
			new GetInfo_four(frame);
		}
		
		System.out.println("Score in step 3 : " + amount);
		System.out.println("Total Score : " + MainPanel.s);
		
	} 

}