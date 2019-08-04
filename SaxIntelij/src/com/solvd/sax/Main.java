package com.solvd.sax;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import org.apache.log4j.Logger;

public class Main {
	private static final Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser saxParser = spf.newSAXParser();
		XMLReader xmlReader = saxParser.getXMLReader();
		MyHandler handler = new MyHandler();
		xmlReader.setContentHandler(handler);
		xmlReader.parse("./src/com/solvd/resources/NewFile.xml");

		Railway railway = handler.getRailway();
		// logger.info("\nRailway name: " + railway.name);
		System.out.println("\nRailway name: " + railway.name);
		// railway.trailerList.forEach(x -> logger.info(x));
		railway.trailerList.forEach(x -> System.out.println(x));
		// railway.trainTypeList.forEach(x -> logger.info(x));
		railway.trainTypeList.forEach(x -> System.out.println(x));
		// railway.trainList.forEach(x -> logger.info(x));
		railway.trainList.forEach(x -> System.out.println(x));
		// railway.passengerList.forEach(x -> logger.info(x));
		railway.passengerList.forEach(x -> System.out.println(x));
		// railway.ticketList.forEach(x -> logger.info(x));
		railway.ticketList.forEach(x -> System.out.println(x));
	}
}
