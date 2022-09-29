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
		
		JFileChooser chooser = new JFileChooser ();
		
		int status = chooser.showOpenDialog(null);
		
		if (status != JFileChooser.APPROVE_OPTION) {
			
			frame.dispose();
			
		} else {
			
			File file = chooser.getSelectedFile();
						
			JFrame bFrame = new JFrame("Select conversion type");
			frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
			
			bFrame.getContentPane().add(new ButtonConfig());
			
			bFrame.pack();
			bFrame.setVisible(true);
		
		}
		
		frame.getContentPane();
		frame.pack();
		frame.setVisible(true);
		
	}
}