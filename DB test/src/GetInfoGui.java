import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;

public class GetInfoGui extends JFrame{
	
	JFrame frame = new JFrame();

	public GetInfoGui(String str) {
		super(str); // frame name
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// exit button
		
		frame.setSize(500,500); //set frame size 
		frame.getContentPane().setBackground(Color.black); // set background color
		frame.setVisible(true); //프레임이 보이도록 설정
		
	
	}
	
}