package structures;

/**
 * Designed for simple structured input such as 
 * a
 * aa
 * aba
 * abac
 * 
 * reads through the input file and structures it into json
 * data library
 * @author devel
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class xmlListener implements ActionListener {

	/**
	 * Overriding the event handler and creating our own which accepts
	 * string values to compensate for the event to be a string after the 
	 * listener has received the file, called from xmlListener.
	 */
	@Override
	public void actionPerformed (ActionEvent e) {
		
		JFrame frame = new JFrame ("Save File");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		JFileChooser save = new JFileChooser();
		
		int status = save.showSaveDialog(frame);
		
		if (status != JFileChooser.CANCEL_OPTION && status == JFileChooser.APPROVE_OPTION) {

			Scanner scan = new Scanner("file");
			
			String data = scan.hasNextLine() + "\n";
			
			File out = save.getSelectedFile();
		    out.getAbsolutePath();
			save.setCurrentDirectory(out);
			
			PrintWriter outwritten = null;
			try {
				outwritten = new PrintWriter(out);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			outwritten.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n\t");
			
			while(scan.hasNextLine()) {
				
				outwritten.println("<key_val\n\t\tandroid:name=\"" + data + "\"\n\t\tandroid:value=\"" + data + "\"\n/>" + "\n");
					
				if (data == null) {
					outwritten.println("/>");
					outwritten.close();
				}
			}
		
			scan.hasNextLine();
		}
			
	}
}