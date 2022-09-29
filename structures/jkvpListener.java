package structures;

/**
 * Designed for simple structured input such as 
 * a
 * aa
 * aba
 * abac
 * 
 * reads through the input file and structures it into xml kvp
 * @author devel
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.io.IOException;

public class jkvpListener implements ActionListener {

	/**
	 * Overriding the event handler and creating our own which accepts
	 * string values to compensate for the event to be a string after the 
	 * listener has received the file, called from xmlListener.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {}
	
	/**
	 * Receive file and start to scan through the data
	 * pass the data as string through to actionPerformed 
	 * as event Listener is overridden to facilitate the 
	 * new method
	 * @param file
	 * @throws IOException 
	 */
	public jkvpListener(File file) throws IOException {
		Scanner scan = new Scanner("file");
		
		String data = scan.hasNextLine() + "\n";
		
		while(scan.hasNextLine()) {
			actionPerformed(data);
		}
		
		scan.hasNextLine();
	}
	
	/**
	 * Scan through the data and present a save dialogue for the end user
	 * to save the new structure to a file of their choosing, handle exceptions
	 * @param data
	 */
	@SuppressWarnings("finally")
	private void actionPerformed(String data) throws IOException {
		JFrame frame = new JFrame ("Save File");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		JFileChooser save = new JFileChooser();
		
		int status = save.showSaveDialog(frame);
		
		if (status != JFileChooser.APPROVE_OPTION) {
			// dispose of window and children plus memory.
			frame.dispose();
		} else {
			
			try {
				File file = save.getSelectedFile();
			    file.getAbsolutePath();
				save.setCurrentDirectory(file);
				
				PrintWriter out = new PrintWriter(file);
				out.println("import javafx.util.Pair;\n\n\n");
				out.println("public class Dictionary() {\n\t");
				out.println("public static void main(String []args) {\n\n\t");
				
				while (data != null) {
					
					JFrame waitframe = new JFrame ("Progress");
					JLabel waitlabel = new JLabel("Please wait whilst the data is written.");
					waitframe.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
					waitframe.add(waitlabel);
					waitframe.pack();
					
					try {
						
						out.println("Pair<String, String> p = new Pair <>(\"" + data + "\", \"" + data + "\");");
						
					} finally {

						if (data == null) {
							out.println("\t\t}\n\t}\n}");
							out.close();
							waitframe.dispose();
						}
					}
				}
				
			} catch (IOException e) {
				
				JLabel none = new JLabel("Cannot save: " + e + "\nCheck and try again, if you still have issues\n report to developer(s) with the error message.");
				JFrame error = new JFrame ("ERROR");
				error.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
				JLabel errorlabel = new JLabel("ERROR: " + none);
				error.add(errorlabel);
				error.pack();
				
			} finally {
				
				frame.dispose();
				
			}
		}
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		jkvpListener x;
	}
}