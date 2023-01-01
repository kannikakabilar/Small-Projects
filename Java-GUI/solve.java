import javax.swing.event.*;
import java.util.concurrent.ThreadLocalRandom; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*; 
class solve extends JFrame implements ChangeListener, ActionListener { 
  
    // frame 
    static JFrame f; 
  
    // slider 
    static JSlider b; 
  
    // label 
    static JLabel l; 
    
    static JMenu menu;
    
    static JProgressBar bar;
    
    static JButton tickBtn3;
    static JLabel l3;
  
    // main class 
    public static void main(String[] args) 
    { 
        // create a new frame 
        f = new JFrame("frame"); 
  
        // create a object 
        solve s = new solve(); 
  
        // create label 
        l = new JLabel(); 
  
        // create a panel 
        JPanel p = new JPanel(); 
  
        // create a slider 
        b = new JSlider(0, 100, 50); 
        JButton tickBtn = new JButton("-");
        JButton tickBtn2 = new JButton("+");
        
        bar = new JProgressBar();
        JMenuBar bar2 = new JMenuBar();
        menu = new JMenu("Select");
        JMenuItem m1 = new JMenuItem("Rookie");
        JMenuItem m2 = new JMenuItem("Average");
        JMenuItem m3 = new JMenuItem("Skilled");
        JMenuItem m4 = new JMenuItem("Expert");
        JMenu submen = new JMenu("Other");
        JMenuItem s1 = new JMenuItem("Random");
        
        tickBtn3 = new JButton("Initialize");
        l3 = new JLabel("Mission Progress: Yet to Commence");
        
        menu.add(m1);
        menu.add(m2);
        menu.add(m3);
        menu.add(m4);
        submen.add(s1);
        menu.add(submen);
        bar2.add(menu);
        
        bar.setValue(0);
  
        // paint the ticks and tarcks 
        b.setPaintTrack(true); 
        b.setPaintTicks(true); 
        b.setPaintLabels(true); 
  
        // set spacing 
        b.setMajorTickSpacing(50); 
        b.setMinorTickSpacing(5); 
  
        // setChangeListener 
        b.addChangeListener(s);
        tickBtn.addActionListener(s);
        tickBtn2.addActionListener(s);
        tickBtn3.addActionListener(s);
        m1.addActionListener(s);
        m2.addActionListener(s);
        m3.addActionListener(s);
        m4.addActionListener(s);
        s1.addActionListener(s);
  
        // add slider to panel 
        p.add(b); 
        p.add(l); 
        p.add(tickBtn);
        p.add(tickBtn2);
        p.add(bar);
        p.add(bar2);
        p.add(tickBtn3);
        p.add(l3);
        
        f.setJMenuBar(bar2);
        //f.setBackground("aqua");
        f.add(p); 
  
        // set the text of label 
        l.setText("Intensity level: " + b.getValue()); 
  
        // set the size of frame 
        f.setSize(300, 300); 
  
        //f.show(); 
        f.setVisible(true);
    } 
  
    // if JSlider value is changed 
    public void stateChanged(ChangeEvent e) 
    { 
    	l.setText("Intensity level: " + b.getValue()); 
    	if(b.getValue() == 100) {
        	JOptionPane.showMessageDialog(this, "Maximum level reached!", "Notification", JOptionPane.PLAIN_MESSAGE);
        }
    	
    } 
    
    public void actionPerformed(ActionEvent e)
    {
    	String s = e.getActionCommand();
    	if(s.equals("+")) {
    		b.setValue(b.getValue()+10);
    	}
    	if(s.equals("-")) {
    		b.setValue(b.getValue()-10);
    	}
    	if(s.equals("Rookie")) {
    		menu.setText("Rookie");
    		b.setValue(25);
    	}
    	if(s.equals("Average")) {
    		b.setValue(50);
    	}
    	if(s.equals("Skilled")) {
    		b.setValue(75);
    	}
    	if(s.equals("Expert")) {
    		b.setValue(100);
    	}
    	if(s.equals("Random")) {
    		b.setValue(ThreadLocalRandom.current().nextInt(0, 101));
    	}
    	if(s.equals("Initialize")) {
    		
    		bar.setValue(10);
    		bar.setStringPainted(true);
    		bar.setString("10%");
    		l3.setText("Preparing...");
    		tickBtn3.setText("Operate");
    		
    	}
    	if(s.equals("Operate")) {
    		
    		bar.setValue(50);
    		bar.setString("50%");
    		l3.setText("Advancing...");
    		tickBtn3.setText("Implement");
    		
    	}
    	if(s.equals("Implement")) {
    		
    		bar.setValue(75);
    		bar.setString("75%");
    		l3.setText("Finalizing...");
    		tickBtn3.setText("Terminate");
    		
    	}
    	if(s.equals("Terminate")) {
    		
    		bar.setValue(100);
    		bar.setString("100%");
    		l3.setText("Ready to Execute!");
    		tickBtn3.setText("Completed");
    		tickBtn3.setEnabled(false);
    		
    	}
    }
} 