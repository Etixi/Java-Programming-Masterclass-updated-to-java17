/*
 * Created by Etienne KOA
 */

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class CreateXMLFileInJava {

	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;

		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();

			// add elements to Document
			Element rootElement = doc.createElement("Users");

			// append root element to document
			doc.appendChild(rootElement);

			// append first child element to root element
			rootElement.appendChild(createUserElement(doc, "1", "Ramesh", "Fadatare", "28", "Male"));

			// append second child element to root element
			rootElement.appendChild(createUserElement(doc, "2", "John", "Cena", "45", "Male"));

			// append third child element to root element
			rootElement.appendChild(createUserElement(doc, "3", "Tom", "Cruise", "40", "Male"));

			// for output to file console
			TransformerFactory transformerFactory  = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			// for pretty print
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);

			// Write to console or file
			StreamResult console = new StreamResult(System.out);
			StreamResult file = new StreamResult(new File("Extra_Information/Java-XML/java-dom-parser/xml/create_users.xml"));

			// write data
			transformer.transform(source, console);
			transformer.transform(source, file);

		} catch (Exception e){
			e.printStackTrace();
		}
	}

	private static Node createUserElement(Document doc, String id,
										  String firstName, String lastName,
										  String age, String gender){

		Element user = doc.createElement("User");

		// set id attribute
		user.setAttribute("id", id);

		// create firstName element
		user.appendChild(createUserElements(doc, user, "firstName", firstName));

		// create lastName element
		user.appendChild(createUserElements(doc, user, "lastName", lastName));

		// create age element
		user.appendChild(createUserElements(doc, user, "age", age));

		// create gender element
		user.appendChild(createUserElements(doc, user, "gender", gender));

		return user;
	}

	// utility method to create a text node
	private static Node createUserElements(Document doc, Element element, String name, String value){
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}
}
