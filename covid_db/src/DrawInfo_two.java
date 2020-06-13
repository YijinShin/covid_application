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

public class DrawInfo_two extends JPanel{
	DBdata db = new DBdata();


	int[] confirmedCaseTotal = null;
	String[] district = null; 
	int[] size = null; // length of rectangle
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		System.out.println("2");
		
		setGraph();				
		
		super.paintComponent(g);
		
		Font font = new Font("Dialog", Font.PLAIN, 9);
		g.setFont(font);
		
		int x = 15;
		for(int i=0;i<district.length;i++) {
			g.setColor(Color.blue);
			g.fillRect(x, 300 - (size[i]), 30, size[i]);			
			x+=37;
		}	
		
		int set = 15;
		for(int i = 0; i < district.length; i++){
			g.setColor(Color.black);
			g.drawString(district[i],set,320);
			set += 37;
		}		
		// determine longest bar	
	}
	
	public void setGraph() {
		//get info from DB
		confirmedCaseTotal = db.getCCTotalFromArea();
		district = db.getDistrictFromArea();
		
		// get size of each rectangle
		size = new int[district.length];
		
		size[0] = confirmedCaseTotal[0]/5;
		size[1] = confirmedCaseTotal[0]/5;
		size[2] = confirmedCaseTotal[0]/3;
		size[3] = confirmedCaseTotal[0]/6;
		size[4] = confirmedCaseTotal[0]/5;
		size[5] = confirmedCaseTotal[0]/4;
		size[6] = confirmedCaseTotal[0]/4;
		size[7] = confirmedCaseTotal[0]/3;
		size[8] = confirmedCaseTotal[0]/4;
		size[9] = confirmedCaseTotal[0]/5;
		size[10] = confirmedCaseTotal[0]/3;
		size[11] = confirmedCaseTotal[0]/4;
		size[12] = confirmedCaseTotal[0]/4;
		size[13] = confirmedCaseTotal[0]/4;
		size[14] = confirmedCaseTotal[0]/3;
		size[15] = confirmedCaseTotal[0]/4;
		size[16] = confirmedCaseTotal[0]/3;
		size[17] = confirmedCaseTotal[0]/5;
		size[18] = confirmedCaseTotal[0]/7;
		size[19] = confirmedCaseTotal[0]/5;
		size[20] = confirmedCaseTotal[0]/4;
		size[21] = confirmedCaseTotal[0]/2;
		size[22] = confirmedCaseTotal[0]/5;
		size[23] = confirmedCaseTotal[0]/2;
		size[24] = confirmedCaseTotal[0]/1;
		size[25] = confirmedCaseTotal[0]/4;
		
	}
	
}