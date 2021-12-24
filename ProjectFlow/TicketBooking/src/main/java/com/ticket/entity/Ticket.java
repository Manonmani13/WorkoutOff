package com.ticket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Ticket")
public class Ticket {
@Id
//@GeneratedValue(strategy=GenerationType.AUTO)
@Column (name="TicketId")
private long ticketId;
@Column(name="BusNo")
private String BusNo;
@Column(name="Time")
private long time;
@Column(name="placeId")
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
