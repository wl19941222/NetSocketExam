package Exam33.Exam33;

import java.io.File;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreatXml {

	public static void main(String[] args) {
		
try {
			
			
			//DOM
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			Element root = document.createElement("stock");
//			root.setAttribute("cat", "it");
			
//			var hq_str_sz300170="汉得信息,
//			13.780,13.820,13.820,13.920,13.770,13.810,13.820,12987481,179762261.140,114500,13.810,222800,13.800,74800,13.790,65500,13.780,25600,13.770,32950,13.820,26400,13.830,23800,13.840,43600,13.850,83400,13.860,2016-08-19,15:05:03,00";

			Element lan1 = document.createElement("lan");
			lan1.setAttribute("id", "0");
			Element name1 = document.createElement("股票名字");
			name1.setTextContent("汉得信息");
			Element ide1 = document.createElement("今日开盘价");
			ide1.setTextContent("13.780");
			lan1.appendChild(name1);
			lan1.appendChild(ide1);
			
			Element lan2 = document.createElement("lan");
			lan2.setAttribute("id", "1");
			Element name2 = document.createElement("昨日收盘价");
			name2.setTextContent("13.820");
			Element ide2 = document.createElement("当前价");
			ide2.setTextContent("13.820");
			lan2.appendChild(name2);
			lan2.appendChild(ide2);
			
			Element lan3 = document.createElement("lan");
			lan3.setAttribute("id", "3");
			Element name3 = document.createElement("今日最高价");
			name3.setTextContent("13.770");
			Element ide3 = document.createElement("今日最低价");
			ide3.setTextContent("13.810");
			lan3.appendChild(name3);
			lan3.appendChild(ide3);
			
			root.appendChild(lan1);
			root.appendChild(lan2);
			root.appendChild(lan3);
			document.appendChild(root);
			
			//-------------
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty("encoding", "UTF-8");
			
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(document), new StreamResult(writer));
			System.out.println(writer.toString());
			
			transformer.transform(new DOMSource(document), new StreamResult(new File("newxml.xml")));
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

}
