package strategyPattern;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.UIManager;

public class FileManager {
	
	public File  createFile(ITransformer transformer, ArrayList<Student> students){
		
		File file = null;
		/*try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}catch (Exception e) {
			System.err.println("Error: " + e.getMessage()); 
		}
		
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
		   file = fileChooser.getSelectedFile();
		}*/
		System.out.print("Enter the path of output file:");
		Scanner input = new Scanner(System.in);
		String path = input.nextLine();
		input.close();
		file = new File(path);
		transformer.writeToFile(students, file);
		
		return file;
	}
}
