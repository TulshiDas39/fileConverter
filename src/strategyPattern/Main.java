package strategyPattern;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.UnsupportedLookAndFeelException;

public class Main {
	public static void main(String [] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
	
		Scanner input = new Scanner(System.in);
		printUsage();
		int option = input.nextInt();
	//	input.nextLine(); //this removes the new line of the rest of integer
	//	System.out.print("Enter the name of file with derectory:");
		input.nextLine();
		Factory factory = new Factory();
		File file = new FileManager().createFile(factory.getTransformer(option), factory.getStudentList());
		try {
			Desktop.getDesktop().open(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//new Factory();
		
		input.close();
	}

	private static void printUsage() {
		System.out.println("Types of Files\n");
		System.out.println("1:csv");
		System.out.println("2:tsv");
		System.out.println("3:xml");
		System.out.print("Enter the option of file type[number]:");
		
	}
	
	
}
