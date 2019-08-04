package com.solvd.sax;

public class Train {
	Integer number;
	Integer trainId;
	Integer trailerId;
	Integer trainTypeId;

	public Train(Trailer trailer, TrainType trainType) {
		this.trailerId = trailer.trailerId;
		this.trainTypeId = trainType.trainTypeId;
	}

	public Train(Integer trainId) {
		this.trainId = trainId;
	}

	public Train(Integer number, Integer trainId, Integer trailerId, Integer trainTypeId) {
		this.number = number;
		this.trainId = trainId;
		this.trailerId = trailerId;
		this.trainTypeId = trainTypeId;
	}

	@Override
	public String toString() {
		return "Train{" + "number=" + number + ", trainId=" + trainId + ", trailerId='" + trailerId + '\''
				+ ", trainTypeId=" + trainTypeId + '}';
	}
}
