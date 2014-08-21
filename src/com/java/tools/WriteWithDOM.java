package com.java.tools;

import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


public class WriteWithDOM {
	private static Document doc;
	
	public static void main(String[] args) {
		createDoc();
		
		createElements();
		
		createXmlString();
	}
	
	public static void createDoc(){
		try{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		doc = db.newDocument();
		
		doc.setXmlStandalone(true);
		
		
		}catch(ParserConfigurationException e){
			
		}
		
	}
	
	public static void createElements(){
		
		
		Element ele = doc.createElement("Book");
		ele.setAttribute("isbn", Book.getIsbn());
		ele.setAttribute("name", Book.getName());
		
		for(String lines:Book.getLine()){
			Element line = doc.createElement("line");
			
			Text txt = doc.createTextNode(lines);
			
			line.appendChild(txt);
			ele.appendChild(line);
		}
		
		doc.appendChild(ele);
	}
	
	public static void createXmlString(){
		StringWriter sw = new StringWriter();
		
		try{
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer tran = tf.newTransformer();
		tran.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		
		tran.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		DOMSource dom = new DOMSource(doc);
		
		
		StreamResult sr = new StreamResult(sw);
		
		tran.transform(dom, sr);
		}
		catch(TransformerException e){
			
		}
		
		
		System.out.println(sw.toString());
	}
}
