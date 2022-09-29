package structures;

/**
 * Designed for simple structured input such as 
 * a
 * aa
 * aba
 * abac
 * 
 * reads through the input file and structures it into java
 * key to value pairs
 * data library
 * @author devel
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class jkvpListener implements ActionListener {

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
			
			outwritten.println("import javafx.util.Pair;\n\n\n");
			outwritten.println("public class Dictionary() {\n\t");
			
			while(scan.hasNextLine()) {
				
				outwritten.println("Pair<String, String> "+ data +" = new Pair <>(\"" + data + "\", \"" + data + "\");");
					
				if (data == null) {
					outwritten.println("\\**https://www.javatpoint.com/java-pair#:~:text=Java%20Pair%20class%20stores%20value%20in%20the%20key-value,two%20values%20to%20be%20returned%20from%20a%20method.*\\");
					outwritten.println("\\**public K getKey(){} \n");
					outwritten.println(" *public V getValue(){} \n");
					outwritten.println(" *public int hashCode(){} \n");
					outwritten.println(" *public boolean equals(Object o){} \n");
					outwritten.println(" *public String toString(){} \n");
					outwritten.println(" *public Pair(K key,  \r\n"
							+ "            V value){}\"\n**\\ \n");
					outwritten.println("}");
					outwritten.close();
				}
			}
		
			scan.hasNextLine();
		}
			
	}
}