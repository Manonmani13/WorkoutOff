package com.ticket.responsemodel;


public class TicketResponse {
	private long ticketId;

	private String BusNo;

	private long time;

	private long placeId;
	
	public long getPlaceId() {
		return placeId;
	}

	public void setPlaceId(long placeId) {
		this.placeId = placeId;
	}

	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	public String getBusNo() {
		return BusNo;
	}

	public void setBusNo(String busNo) {
		BusNo = busNo;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

}
