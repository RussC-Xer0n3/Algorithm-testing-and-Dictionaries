package structures;

import java.awt.*;
import java.io.File;

import javax.swing.*;

@SuppressWarnings("serial")
public class ButtonConfig extends JPanel {

	private JButton jb;
	private JButton xb;
	private JButton kb;
	
	public ButtonConfig(File file) {
	
		jb = new JButton("json");
		xb = new JButton("xml");
		kb = new JButton("java kvp");
		
		jb.addActionListener(new jsonListener());
		xb.addActionListener(new xmlListener());
		kb.addActionListener(new jkvpListener());
		
		add(jb);
		add(xb);
		add(kb);
	
		setPreferredSize(new Dimension(400, 50));
		setBackground(Color.white);
	}
	
}
