package structures;

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
		
		JFileChooser chooser = new JFileChooser ();
		
		int status = chooser.showOpenDialog(null);
		
		if (status != JFileChooser.APPROVE_OPTION) {
			
			chooser.cancelSelection();
			
		} else {
			
			File file = chooser.getSelectedFile();
						
			JFrame bFrame = new JFrame("Select conversion type");
			bFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
			
			bFrame.getContentPane().add(new ButtonConfig(file));
			
			bFrame.pack();
			bFrame.setVisible(true);
		
		}
	}
}