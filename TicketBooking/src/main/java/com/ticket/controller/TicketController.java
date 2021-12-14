package com.ticket.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.requestmodel.TicketRequest;
import com.ticket.responsemodel.OperationStatusModel;
import com.ticket.responsemodel.RequestOperationStatus;
import com.ticket.responsemodel.TicketResponse;
import com.ticket.service.TicketService;
import com.ticket.shared.dto.TicketDto;
@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketService ticketService;
	
	@PostMapping()
	public TicketResponse createTicket(@RequestBody TicketRequest ticket)    
	{
		TicketResponse ticketRes=new TicketResponse();
		TicketDto ticketDto=new TicketDto();
		BeanUtils.copyProperties(ticket, ticketDto);
		TicketDto tick=ticketService.createTicket(ticketDto);
		BeanUtils.copyProperties(tick, ticketRes);
		return ticketRes;
		
	}
	@GetMapping("/{id}")
	public TicketResponse getTicketById(@PathVariable ("id")long ticketId)
	{
		TicketResponse ticketResponse=new TicketResponse();
		TicketDto ticketDto = ticketService.getByTicketId(ticketId);
		BeanUtils.copyProperties(ticketDto,ticketResponse);
		return ticketResponse;
		
	}
	@PutMapping("/{id}")
	public TicketResponse updateTicket(@PathVariable("id") long ticketId, @RequestBody TicketRequest ticketRequest)
	{
		TicketResponse ticketResponse = new TicketResponse();
		TicketDto ticketDto =new TicketDto();
		BeanUtils.copyProperties(ticketRequest, ticketDto);
		TicketDto ticket=ticketService.updateTicket(ticketId, ticketDto);
		BeanUtils.copyProperties( ticket,ticketResponse);
		return ticketResponse;
	}
	@DeleteMapping("/{id}")
	public OperationStatusModel deleteTicket(@PathVariable("id")long ticketId)
	{
		OperationStatusModel opStamo=new OperationStatusModel();
		opStamo.setOperationName(RequestOperationName.DELETE.name());
		ticketService.deleteTicketById(ticketId);
		opStamo.setOperationResult(RequestOperationStatus.Success.name());
		return opStamo;
	}
	@GetMapping()
	public List<TicketResponse> getAllTicket(@RequestParam(value="page",defaultValue="1")int page,
			@RequestParam (value="limit",defaultValue="20")int limit)
	{
		List<TicketResponse> tick=new ArrayList<>();
		List<TicketDto> tickDto=ticketService.getAllTicket(page, limit);
		for(TicketDto tickt:tickDto)
		{
			TicketResponse tickRes=new TicketResponse();
			BeanUtils.copyProperties( tickt,tickRes);
			tick.add(tickRes);
			
		}
		return tick;
	}
}
