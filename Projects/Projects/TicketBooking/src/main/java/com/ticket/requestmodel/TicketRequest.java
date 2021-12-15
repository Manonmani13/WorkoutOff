package com.ticket.requestmodel;

public class TicketRequest {
	private long ticketId;
	
	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	private String BusNo;
	
	private long time;

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
