package com.solvd.sax;

public class Passenger {
	Integer number;
	Integer passengerId;
	String passengerName;
	String surname;

	@Override
	public String toString() {
		return "Passenger{" + "number=" + number + ", passengerId=" + passengerId + ", passengerName='" + passengerName
				+ "', surname='" + surname + '\'' + '}';
	}
}
