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

// 있다면 선택하고 없으면 three 단계로 넘어가도록 한다
// 즉, 더이상 선택할 나라가 없을 때까지 선택한다.
// 잘못눌렀을 때를 대비하여 "처음으로" 버튼이 있어야 할 것 같다.

// 다른 국가에 방문했던 적이 있습니까? 네/ 아니요
// 네 누르면: 방문한 나라를 선택해주세여~ 스크롤로 국가 선택 
// 선택하신 국가 외에 다른 국가에 방문했던 적이 있습니까? 
// 아니요 누르면: three로 넘어감

public class DrawInfo_one extends JPanel {
	
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
		
		Font font = new Font("Dialog", Font.BOLD, 9);
		g.setFont(font);
		
		int x = 15;
		for(int i=0;i<district.length;i++) {
			g.setColor(Color.blue);
			g.fillRect(x, 300 - (size[i]*10), 30, size[i]*10);			
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
		for(int i=0;i<district.length;i++) {
			if(confirmedCaseTotal[i]<10) size[i] = 1;
			else {
				size[i] = confirmedCaseTotal[i]/10;
			}
		}
	}
	
}