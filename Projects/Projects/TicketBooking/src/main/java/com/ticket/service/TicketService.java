package com.ticket.service;

import java.util.List;

import com.ticket.entity.Ticket;
import com.ticket.shared.dto.TicketDto;

public interface TicketService {
TicketDto createTicket(TicketDto ticketDto);
TicketDto getByTicketId(long tickId);
TicketDto updateTicket(long tickId,TicketDto ticketDto);
void deleteTicketById(long tickId);
List<TicketDto> getAllTicket(int page,int limit);
}
