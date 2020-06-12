import java.awt.Color;
import java.sql.*;

import javax.swing.JFrame;


public class Main extends JFrame{
	

	public static void main(String[] args) {
		//DBconnect connect = new DBconnect();
		
		JFrame frame = new JFrame();
		//frame.setBackground(Color.white);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// exit button
		frame.setSize(1000,1000); //set frame size 
		//frame.getContentPane().setBackground(Color.black); // set background color
		frame.setVisible(true); //프레임이 보이도록 설정
		
		//new panel1(frame);
		new MainPanel(frame);
		//new MainGui("Main Gui");
		
	}
}