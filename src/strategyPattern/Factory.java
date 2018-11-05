package strategyPattern;

import java.util.ArrayList;

public class Factory {
	ArrayList<ITransformer> transformerList;

	public Factory() {
		//FileManager fc = new FileManager();
		init();
	//	fc.createFile(map.get(getChoice()), getStudentList(), getPath());
	}

	private void init() {  
		transformerList = new ArrayList<>();
		transformerList.add(new CSVTransformer());
		transformerList.add(new TSVTransformer());
		transformerList.add(new XMLTransformer());
	}
	
	public ArrayList<Student> getStudentList(){
		ArrayList<Student>	listOfStudents = new ArrayList<Student>();
		listOfStudents.add(new Student("Chinmoy Acharjee", "chinmoyacharjee15@gmail.com"));
		/*listOfStudents.add(new Student("Sabik Abtahee", "bsse0829@iit.du.ac.bd.com"));
		listOfStudents.add(new Student("Rafiul Islam Ratul", "bsse0831@iit.du.ac.bd.com"));
		listOfStudents.add(new Student("Shahla Shaan Ahmed", "bsse0810@iit.du.ac.bd.com"));
		listOfStudents.add(new Student("Chinmoy Acharjee", "bsse0819@iit.du.ac.bd"));*/
		return listOfStudents;
	}
	/*private String getChoice(){
		System.out.println("Choice: ");	
		return (new Scanner(System.in)).nextLine().toLowerCase();
	}
	private String getPath(){
		System.out.println("File name:");
		return  (new Scanner(System.in)).nextLine();
	}	*/
	
	public ITransformer getTransformer(int option){
		return transformerList.get(option-1);
	}
}
