package com.csvconverter;

public class MainDemo {

	public static void main(String[] args) {
		/*ConvertercsvtoXML con = new ConvertercsvtoXML();
		con.convertToXML("sample.csv","finalXML.xml");
*/
		Converter con = new Converter();
		con.convertToXML("sample.csv","finalXML.xml");

	}

}
