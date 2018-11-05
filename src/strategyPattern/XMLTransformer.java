package strategyPattern;

import java.io.File;
import java.util.ArrayList;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XMLTransformer implements ITransformer {

	@Override
	public void writeToFile(ArrayList<Student> students, File file) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
		
			Element rootElement = doc.createElementNS("..", "Student");

			doc.appendChild(rootElement);

			for (int i = 0; i < students.size(); i++) {
				rootElement.appendChild(getStudent(doc, students.get(i).name, students.get(i).email));
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);

			StreamResult file1 = new StreamResult(file);

			transformer.transform(source, file1);
			System.out.println("DONE");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Node getStudent(Document doc, String name, String email) {
		Element studentElement = doc.createElement("Student");

		studentElement.appendChild(getStudentElements(doc, studentElement, "name", name));

		studentElement.appendChild(getStudentElements(doc, studentElement, "age", email));
		return studentElement;
	}

	private static Node getStudentElements(Document doc, Element element, String name, String email) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(email));
		return node;
	}

}