package com.solvd.sax;

public class Ticket {
	Integer number;
	Integer ticketId;
	Integer price;
	Integer linens;
	Integer passengerId;
	Integer trainId;

	public Ticket(Passenger passenger, Train train) {
		this.passengerId = passenger.passengerId;
		this.trainId = train.trainId;
	}

	@Override
	public String toString() {
		return "Ticket{" + "number=" + number + ", ticketId=" + ticketId + ", price=" + price + '\'' + ", linens="
				+ linens + ", passengerId=" + passengerId + '\'' + ", trainId=" + trainId + '}';
	}
}
