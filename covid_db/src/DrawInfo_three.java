import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.Choice;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DrawInfo_three extends JPanel {
	DBdata db = new DBdata();


	int[] confirmedCaseTotal = null;
	String[] infectionProcess = null; 
	int[] size = null; // length of rectangle
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		System.out.println("2");
		
		setGraph();				
		
		super.paintComponent(g);
		
		Font font = new Font("Dialog", Font.PLAIN, 11);
		g.setFont(font);
		
		int x = 15;
		for(int i=0;i<infectionProcess.length/5;i++) {
			g.setColor(Color.blue);
			g.fillRect(x, 150 - (size[i]*3), 30, size[i]*3);			
			x+=200;
		}
		int x2 = 15;
		for(int i= infectionProcess.length/5;i<infectionProcess.length/5*2;i++) {
			g.setColor(Color.blue);
			g.fillRect(x2, 250 - (size[i]*3), 30, size[i]*3);			
			x2+=200;
		}	
		int x3 = 15;
		for(int i= infectionProcess.length/5*2;i<infectionProcess.length/5*3;i++) {
			g.setColor(Color.blue);
			g.fillRect(x3, 350 - (size[i]*3), 30, size[i]*3);			
			x3+=200;
		}	
		
		int x4 = 15;
		for(int i= infectionProcess.length/5*3;i<infectionProcess.length/5*4;i++) {
			g.setColor(Color.blue);
			g.fillRect(x4, 450 - (size[i]*3), 30, size[i]*3);			
			x4+=200;
		}	
		
		int x5 = 15;
		for(int i= infectionProcess.length/5*4;i<infectionProcess.length;i++) {
			g.setColor(Color.blue);
			g.fillRect(x5, 550 - (size[i]*3), 30, size[i]*3);			
			x5+=200;
		}	
		
		int set = 15;
		for(int i = 0; i < infectionProcess.length/5; i++){
			g.setColor(Color.black);
			g.drawString(infectionProcess[i],set,170);
			set += 200;
		}		
		
		int set2 = 15;
		for(int i = infectionProcess.length/5; i < infectionProcess.length/5*2; i++){
			g.setColor(Color.black);
			g.drawString(infectionProcess[i],set2,270);
			set2 += 200;
		}		
		
		int set3 = 15;
		for(int i = infectionProcess.length/5*2; i < infectionProcess.length/5*3; i++){
			g.setColor(Color.black);
			g.drawString(infectionProcess[i],set3,370);
			set3 += 200;
		}		
		
		int set4 = 15;
		for(int i = infectionProcess.length/5*3; i < infectionProcess.length/5*4; i++){
			g.setColor(Color.black);
			g.drawString(infectionProcess[i],set4,470);
			set4 += 200;
		}		
		
		int set5 = 15;
		for(int i = infectionProcess.length/5*4; i < infectionProcess.length; i++){
			g.setColor(Color.black);
			g.drawString(infectionProcess[i],set5,570);
			set5 += 200;
		}		
		// determine longest bar	
	}
	
	public void setGraph() {
		//get info from DB
		
		infectionProcess = db.getProcessFromInfectionProcess();
		confirmedCaseTotal = db.getInfectionProcessTotal();
		
		// get size of each rectangle
		size = new int[infectionProcess.length];
		for(int i=0;i<infectionProcess.length;i++) {
			if(confirmedCaseTotal[i]<10) size[i] = 1;
			else {
				size[i] = confirmedCaseTotal[i]/10;
			}
		}
		
		
	}
	
}
