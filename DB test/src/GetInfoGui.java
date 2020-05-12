import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.Choice;

public class GetInfoGui extends JFrame{
	
	DBdata db = new DBdata();
	String[] district = new String[100];
	
	JFrame frame = new JFrame();
	Choice district_ch = new Choice();
	
	//district_ch setting function 
	public void district_ch(Choice ch) {
		district_ch.setBounds(100,100,150,50);
		district_ch.setBackground(Color.white);
		
		district = db.getDistrictFromArea();
		for(int i=0;i<district.length;i++) {
			ch.addItem(district[i]);
		}
	}
	
	public GetInfoGui(String str) {
		super(str); // frame name
		Container cont = frame.getContentPane();
		cont.setLayout(null);
		
		district_ch(district_ch);
		cont.add(district_ch);
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// exit button
		frame.setSize(500,500); //set frame size 
		frame.getContentPane().setBackground(Color.black); // set background color
		frame.setVisible(true); //프레임이 보이도록 설정
		
	
	}
	
}