package strategyPattern;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVTransformer implements ITransformer {

	private  String COMMA_DELIMITER = ",";
	private  String NEW_LINE_SEPARATOR = "\n";
	private  String FILE_HEADER = "Name,Email";
	
		 
	@Override
	public void writeToFile(ArrayList<Student> students, File file) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			writeRows(students, fw);
			fw.close();
			System.out.println("Done");
			
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	private void writeRows(ArrayList<Student> students, FileWriter fw) throws IOException {
		
		fw.append(FILE_HEADER.toString());
		fw.append(NEW_LINE_SEPARATOR);
		
		for (int i = 0; i < students.size(); i++) {
			fw.append(students.get(i).name);
			fw.append(COMMA_DELIMITER);
			fw.append(students.get(i).email);
			fw.append(NEW_LINE_SEPARATOR);
		}
		
	}

}
