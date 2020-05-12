import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;

public class MainGui extends JFrame implements ActionListener{
	
	JFrame frame = new JFrame();
	JButton bt1 = new JButton("위험도 측정");
	JButton bt2 = new JButton("코로나 정보");

	
	public MainGui(String str) {
		super(str); // frame name
		Container cont = frame.getContentPane();
		cont.setLayout(null);
		bt1.setBounds(100,200,80,50); //set button size, location
		bt2.setBounds(300,200,80,50); //set button size, location 
		
		cont.add(bt1); //add button on container
		cont.add(bt2); //add button on container
		
		bt1.addActionListener(this); //set acitonListener to button
		bt2.addActionListener(this); //set acitonListener to button
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// exit button
		frame.setSize(500,500); //set frame size 
		frame.getContentPane().setBackground(Color.black); // set background color
		frame.setVisible(true); //프레임이 보이도록 설정
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(bt1)) {
			
			new GetInfoGui("감염 위험도 측정");
		}
		else if(e.getSource().equals(bt2)) {
			System.out.println("아직 미구현\n");
			
		}
	}
	
}