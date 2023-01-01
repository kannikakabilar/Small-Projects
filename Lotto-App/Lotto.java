import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Lotto extends JFrame implements ActionListener{
	ClassLoader ldr = this.getClass().getClassLoader();
	java.net.URL iconURL = ldr.getResource("Lotto.png");
	ImageIcon icon = new ImageIcon(iconURL);
	JLabel img = new JLabel(icon);
	
	JTextField txt = new JTextField("", 18);
	JButton btn = new JButton("Get My Lucky Numbers");
	JPanel pnl = new JPanel();
	Container contentPane = getContentPane();
	
	public Lotto() {
		super("Lotto App"); setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		txt.setEditable(false);
		pnl.add(img); pnl.add(txt); pnl.add(btn);
		contentPane.add("North", img);
		//((JFrame) contentPane).getContentPane().setBackground("blue");
		//contentPane.add("Center", txt);
		contentPane.add("South", btn);
		this.setLocationRelativeTo(null);
		btn.addActionListener(this); add(pnl); setVisible(true);
	}
	
	public void  actionPerformed(ActionEvent event) {
		
		if(event.getSource() == btn) {
			int[] nums = new int[10]; String str = "";
			for(int i = 1; i<10; i++) { nums[i] = i; }
			for(int i = 1; i<10; i++)
			{
				int r = (int)(9*Math.random()+1);
				int t = nums[i]; nums[i]=nums[r]; nums[r]=t;
			}
			for(int i = 1; i<7; i++) {
				str += " " + Integer.toString(nums[i])+" ";
			}
			txt.setText(str);
			btn.setEnabled(false);
		}
	}
	
	public static void main(String[] args) {
		Lotto lotto = new Lotto();
	}

}
