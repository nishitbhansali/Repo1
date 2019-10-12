package com.csvconverter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class ConvertercsvtoXML {

	private	BufferedReader br = null;
	private Document xmlOutput = null;
	private Element rootElement = null;
	private String splitter;
	private String csvRecord;
	private String ipFile;
	private ArrayList<String> tagNames;

	public boolean convertToXML(String inputFile, String outputFile) {
		ipFile = inputFile;
		try {
			String extension = inputFile.substring(inputFile.lastIndexOf(".")+1,inputFile.length());
			System.out.println(extension);

			if(!(extension.equalsIgnoreCase("csv"))) {
				System.out.println("The format of the file "+inputFile+" is incorrect");
				return false;
			}

			InputStream in = getClass().getResourceAsStream("/"+inputFile);
			if(in == null) {
				throw new FileNotFoundException();
			}

			br = new BufferedReader(new InputStreamReader(in));
			String csvHeader = br.readLine();
			if(csvHeader != null) {
				addRecordToRoot(csvHeader,outputFile);
			}

		}catch (FileNotFoundException e) {
			System.out.println("Error: Input File "+inputFile+" not found. Aborted.");
			return false;
		}
		catch (IOException e) {
			System.out.println("Error: Input File "+inputFile+" corrupted. Aborted.");
			return false;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Succcess: File "+ipFile+" converted to "+outputFile);
		return true;
	}

	private void addRecordToRoot(String csvHeader, String outputFile) {
		try {
			xmlOutput = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			rootElement = xmlOutput.createElement("AdjudicationRequestPayload");
			xmlOutput.appendChild(rootElement);
			tagNames = new ArrayList<>(Arrays.asList(csvHeader.split(splitter)));
			System.out.println(tagNames);

			while((csvRecord = br.readLine()) != null) {
				addElementsToRecord(csvRecord);
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(ParserConfigurationException e) {
			e.printStackTrace();
		}

	}

	private void addElementsToRecord(String csvRecord) {
		ArrayList<String> recordNode = new ArrayList<String>(Arrays.asList(csvRecord.split(splitter)));
		Element record = xmlOutput.createElement("percust");
		rootElement.appendChild(record);
		int valueIndex = 0;
		for(String tag : tagNames) {
			Element el = xmlOutput.createElement(tag);
			String value;
			
			if(valueIndex >= recordNode.size()){
				value = "NA";
				System.out.println("Warning: Input file "+ipFile);
				System.out.println(tagNames);
				System.out.println(csvRecord);
				System.out.println("Warning: No value for header "+tag+". Assigned NA");
			}
			else {
				value = recordNode.get(valueIndex);
			}
			el.appendChild(xmlOutput.createTextNode(value));
			record.appendChild(el);
			valueIndex++;			
		}
		while(valueIndex < recordNode.size())
        {
            System.out.println("Warning: Input file "+ipFile);
            System.out.println("Warning: Dropped value "+recordNode.get(valueIndex)+" since no header");
            valueIndex++;
        }
	}
	
	private void generateXmlFile(String outputFile){
        DOMSource dom = new DOMSource(xmlOutput);
        StreamResult result = new StreamResult(new File(outputFile));
        try {
            TransformerFactory.newInstance().newTransformer().transform(dom, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
