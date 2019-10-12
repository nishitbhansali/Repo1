
public class MainClass {

	public static void main(String[] args) {
		XMLCreators xml = new XMLCreators();
		xml.convertFile("Sample.csv", "123.xml", ",");
	}
}
