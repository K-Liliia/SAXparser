package com.solvd.sax;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class MyHandler extends DefaultHandler {
	// private static final Logger logger = Logger.getLogger(MyHandler.class);
	private Railway railway;
	private Trailer currentTrailer;
	private TrainType currentTrainType;
	private Train currentTrain;
	private Passenger currentPassenger;
	private Ticket currentTicket;
	private String currentElement;

	Railway getRailway() {
		return railway;
	}

	public void startDocument() throws SAXException {
		// logger.info("Starting XML parsing...");
		System.out.println("Starting XML parsing...");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		currentElement = qName;

		switch (currentElement) {
		case "railway": {
			railway = new Railway();
			railway.name = String.valueOf(attributes.getValue("name"));
		}
			break;

		case "trailers": {
			railway.trailerList = new ArrayList<>();
		}
			break;
		case "trainTypes": {
			railway.trainTypeList = new ArrayList<>();
		}
			break;

		case "trains": {
			railway.trainList = new ArrayList<>();
		}
			break;
		case "passengers": {
			railway.passengerList = new ArrayList<>();
		}
			break;
		case "tickets": {
			railway.ticketList = new ArrayList<>();
		}
			break;
		case "trailer": {
			currentTrailer = new Trailer();
			currentTrailer.number = Integer.valueOf(attributes.getValue("number"));
		}
			break;
		case "trainType": {
			currentTrainType = new TrainType();
			currentTrainType.number = Integer.valueOf(attributes.getValue("number"));
		}
			break;

		case "train": {
			currentTrain = new Train(new Trailer(), new TrainType());
			currentTrain.number = Integer.valueOf(attributes.getValue("number"));
		}
			break;
		case "passenger": {
			currentPassenger = new Passenger();
			currentPassenger.number = Integer.valueOf(attributes.getValue("number"));
		}
			break;
		case "ticket": {
			currentTicket = new Ticket(new Passenger(), new Train(0));
			currentTicket.number = Integer.valueOf(attributes.getValue("number"));
		}
			break;
		default: {
			// nothing to do
		}
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String text = new String(ch, start, length);

		if (text.contains("<") || currentElement == null) {
			return;
		}

		switch (currentElement) {
		case "trailerId": {
			currentTrailer.trailerId = Integer.valueOf(text);
		}
			break;

		case "trailerName": {
			currentTrailer.trailerName = text;
		}
			break;
		case "trainTypeId": {
			currentTrainType.trainTypeId = Integer.valueOf(text);
		}
			break;
		case "name": {
			currentTrainType.name = text;
		}
			break;

		case "trainId": {
			currentTrain.trainId = Integer.valueOf(text);
		}
			break;
		case "trainTrailerId": {
			Integer trailerId = null;
			currentTrain.trailerId = Integer.valueOf(text);
		}
			break;
		case "trainTrainTypeId": {
			Integer trainTypeId = null;
			currentTrain.trainTypeId = Integer.valueOf(text);
		}
			break;
		case "passengerId": {
			currentPassenger.passengerId = Integer.valueOf(text);
		}
			break;
		case "passengerName": {
			currentPassenger.passengerName = text;
		}
			break;
		case "surname": {
			currentPassenger.surname = text;
		}
			break;
		case "ticketId": {
			currentTicket.ticketId = Integer.valueOf(text);
		}
			break;
		case "price": {
			currentTicket.price = Integer.valueOf(text);
		}
			break;
		case "linens": {
			currentTicket.linens = Integer.valueOf(text);
		}
			break;
		case "ticketPassengerId": {
			currentTicket.passengerId = Integer.valueOf(text);
		}
			break;
		case "ticketTrainId": {
			currentTicket.trainId = Integer.valueOf(text);
		}
			break;
		default: {
			// nothing to do
		}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {
		case "trailer": {
			railway.trailerList.add(currentTrailer);
			currentTrailer = null;
		}
			break;
		case "trainType": {
			railway.trainTypeList.add(currentTrainType);
			currentTrainType = null;
		}
			break;

		case "train": {
			railway.trainList.add(currentTrain);
			currentTrain = null;
		}
			break;
		case "passenger": {
			railway.passengerList.add(currentPassenger);
			currentPassenger = null;
		}
			break;
		case "ticket": {
			railway.ticketList.add(currentTicket);
			currentTicket = null;
		}
			break;
		default: {
			// nothing to do
		}
		}

		currentElement = null;
	}

	public void endDocument() throws SAXException {
		// logger.info("XML parsing is completed.");
		System.out.println("XML parsing is completed.");
	}
}
