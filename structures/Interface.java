package structures;

import java.util.Scanner;
import java.io.*;
import javax.swing.*;

public class Interface{
	
	/**
	 * Opens a file dialogue chooser loads and reads file
	 * into text area. 
	 * Lewis Loftus Java Software Solutions foundations of program design
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		JFrame frame = new JFrame ("Display File");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		JTextArea ta = new JTextArea (20, 30);
		JFileChooser chooser = new JFileChooser ();
		
		JButton jb = new JButton ("JSON");
		JButton xb = new JButton ("XML");
		JButton kb = new JButton ("java KXP");
		
		int status = chooser.showOpenDialog(null);
		
		if (status != JFileChooser.APPROVE_OPTION) {
			ta.setText("No File Chosen");
		} else {
			File file = chooser.getSelectedFile();
			
			jb.addActionListener(new jsonListener(file));
			xb.addActionListener(new xmlListener(file));
			kb.addActionListener(new jkvpListener(file));
			
			try {
				Scanner scan = new Scanner(file);
				
				String info = "";
				while (scan.hasNext()) {
					info += scan.nextLine() + "\n";
				}
				
				ta.setText(info);
			} catch (FileNotFoundException fe) {
				System.out.println("No File chosen or file not found: " + fe + ".");
			}
		}
		
		frame.getContentPane().add (ta);
		frame.add (jb);
		frame.add (xb);
		frame.add (kb);
		jb.setVisible(true);
		xb.setVisible(true);
		kb.setVisible(true);
		frame.pack();
		frame.setVisible(true);
		
	}
}