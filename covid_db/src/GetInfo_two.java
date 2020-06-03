
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

// 있다면 선택하고 없으면 three 단계로 넘어가도록 한다
// 즉, 더이상 선택할 나라가 없을 때까지 선택한다.
// 잘못눌렀을 때를 대비하여 "처음으로" 버튼이 있어야 할 것 같다.

// 다른 국가에 방문했던 적이 있습니까? 네/ 아니요
// 네 누르면: 방문한 나라를 선택해주세여~ 스크롤로 국가 선택 
// 선택하신 국가 외에 다른 국가에 방문했던 적이 있습니까? 
// 아니요 누르면: three로 넘어감

public class GetInfo_two extends JPanel implements ActionListener{
	
	JFrame frame = new JFrame();
	
	JPanel panel_two = new JPanel();
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
		country_lb.setBounds(50,50,400,100);
		
		//setting buttons		
		bt1.setBounds(150,150,70,50); //set button size, location
		bt2.setBounds(300,150,70,50); //set button size, location 
		bt1.addActionListener(this); //set acitonListener to button
		bt2.addActionListener(this); //set acitonListener to button
		
		//add all objects to panel
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
	