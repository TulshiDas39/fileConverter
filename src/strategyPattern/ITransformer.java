package strategyPattern;

import java.io.File;
import java.util.ArrayList;

public interface ITransformer {
	public void writeToFile(ArrayList<Student> students, File file);
}
