
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

public class GetInfoPanel extends JPanel implements ActionListener{
	
	JPanel getinfoPanel = new JPanel();
	DBdata db = new DBdata();
	String[] district = null;
	String[] process = null;
	
	
	Choice district_ch = new Choice();
	Choice process_ch = new Choice();
	JCheckBox visited1_cb = new JCheckBox("Yes",false);
	JCheckBox visited2_cb = new JCheckBox("No",false);
	JCheckBox[] process_cb = null;
	JLabel visited_lb = new JLabel("최근 해외에 방문한 적이 있습니까?");
	JLabel residence_lb = new JLabel("거주하고 계신 자치구를 선택해주세요");
	
	//district_ch setting function 
	public void setDistrict_ch(Choice ch) {
		district_ch.setBounds(70,100,120,50);
		district_ch.setBackground(Color.white);
		
		district = db.getDistrictFromArea();
		for(int i=0;i<district.length;i++) {
			ch.addItem(district[i]);
		}
	}
	
	//process_ch setting function 
	public JCheckBox[] setProcess_cb() {
		process = db.getProcessFromInfectionProcess();
		JCheckBox[] getProcess_cb = new JCheckBox[process.length];
		
		for(int i=0;i<process.length;i++) {
			getProcess_cb[i] = new JCheckBox(process[i],false);
		}
		return getProcess_cb;
	}
	
	//생성자   
	public GetInfoPanel(JFrame frame) {
		
		MainPanel.s = 20;
		System.out.print(MainPanel.s);
		
		//setting panel
		getinfoPanel.setLayout(null);
		getinfoPanel.setBackground(Color.white);
		getinfoPanel.setSize(new Dimension(500,500));
		
		
		//add to panel
	
		//add labels
		residence_lb.setBounds(70,60,250,50);
		visited_lb.setBounds(70,160,250,50);
		
		//add visited check box
		visited1_cb.setBounds(70,200,70,50);
		visited2_cb.setBounds(150,200,70,50);
		visited1_cb.addActionListener(this);
		
		//add district_ch
		setDistrict_ch(district_ch);
		
		getinfoPanel.add(residence_lb);
		getinfoPanel.add(visited_lb);
		getinfoPanel.add(district_ch);
		
		frame.add(getinfoPanel);
		frame.repaint();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(visited1_cb)) {
			process_cb = setProcess_cb();
			
		}
	
	}
	
}