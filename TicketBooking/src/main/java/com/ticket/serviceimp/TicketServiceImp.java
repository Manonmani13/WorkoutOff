package com.ticket.serviceimp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ticket.entity.Ticket;
import com.ticket.repository.TicketRepository;
import com.ticket.responsemodel.TicketResponse;
import com.ticket.service.TicketService;
import com.ticket.shared.dto.TicketDto;

@Service
public class TicketServiceImp implements TicketService{
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public TicketDto createTicket(TicketDto ticketDto) {
	Ticket ticket=new Ticket();
	BeanUtils.copyProperties(ticketDto,ticket);
	long plaId=100+ticket.getTicketId();
	ticket.setPlaceId(plaId);
	Ticket tick=ticketRepository.save(ticket);
	TicketDto tickDto=new TicketDto();
	BeanUtils.copyProperties(tick, tickDto);
		
		return tickDto;
	}

	@Override
	public TicketDto getByTicketId(long ticketId) {
		TicketDto ticketDto=new TicketDto();
		Ticket ticket= ticketRepository.getByTicketId(ticketId);
		BeanUtils.copyProperties( ticket,ticketDto);
		return ticketDto;
	}

	@Override
	public TicketDto updateTicket(long ticketId, TicketDto ticketDto) {
	
		TicketDto tickDto=new  TicketDto();
		Ticket ticket=ticketRepository.getByTicketId(ticketId);
		ticket.setBusNo(ticketDto.getBusNo());
		//ticket.setPlaceId(ticketDto.getPlaceId());
		ticket.setTime(ticketDto.getTime());
		Ticket tick=ticketRepository.save(ticket);
		BeanUtils.copyProperties( tick,tickDto);
		return tickDto;
	}

	@Override
	public void deleteTicketById(long ticketId) {
		Ticket tick=ticketRepository.getByTicketId(ticketId);
		ticketRepository.delete(tick);
		
	}

	@Override
	public List<TicketDto> getAllTicket(int page, int limit) {
		List<TicketDto> ticketResponse=new ArrayList<>();
		if(page>0)
		{
			page=page-1;
		}
		Pageable pageRequest=PageRequest.of(page, limit);
		
		Page<Ticket> ticketpage=ticketRepository.findAll(pageRequest);
		List<Ticket> tick=ticketpage.getContent();
		for(Ticket ticket:tick)
		{
			TicketDto ticketp=new TicketDto();
			BeanUtils.copyProperties(ticket, ticketp);
			ticketResponse.add(ticketp);
		}
		
		return ticketResponse;
	}

}
