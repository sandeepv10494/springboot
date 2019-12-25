package com.sandeep.TicketBookingSystem.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.TicketBookingSystem.Model.Ticket;
import com.sandeep.TicketBookingSystem.Service.TicketBookingService;

@RestController
public class TicketBookingController {

	@Autowired
	private TicketBookingService ticketBookingService;
	
	@GetMapping(value="/tickets", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Ticket> getAllTickets(){
		return this.ticketBookingService.getAllTickets();
	}
	
	@GetMapping(value="/tickets/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Optional<Ticket> getTicketById(@PathVariable("id") Long id) {
		return this.ticketBookingService.getTicketById(id);
	}
	
	@PostMapping(value="/createticket",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Ticket createTicket(@RequestBody Ticket ticket){
		return this.ticketBookingService.createTicket(ticket);
	}
	
	@PutMapping(value="/updateticket/{id}", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Ticket updateTicket(Ticket ticket, @PathVariable("id") Long id) {
		return this.ticketBookingService.updateTicket(ticket, id);
	}
	
	@DeleteMapping(value="/deleteticket/{id}")
	public void deleteTicket(@PathVariable("id") Long id) {
		 this.ticketBookingService.deleteTicket(id);
	}
	
	@GetMapping(value="/tickets/email/{email}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Ticket getTicketByEmail(@PathVariable("email") String email) {
		return this.ticketBookingService.getTicketByEmail(email);
	}
	
	
}
