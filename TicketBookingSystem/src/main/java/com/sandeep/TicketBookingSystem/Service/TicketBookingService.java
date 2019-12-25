package com.sandeep.TicketBookingSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.TicketBookingSystem.Model.Ticket;
import com.sandeep.TicketBookingSystem.Repository.TicketBookingRepository;

@Service
public class TicketBookingService {

	@Autowired
	private TicketBookingRepository ticketBookingRepository;
	
	public Ticket createTicket(Ticket ticket) {
		return this.ticketBookingRepository.save(ticket);
	}
	
	public Optional<Ticket> getTicketById(Long ticketId) {
		return this.ticketBookingRepository.findById(ticketId);
	}
	
	public List<Ticket> getAllTickets(){
		return this.ticketBookingRepository.findAll();
	}
	
	public void deleteTicket(Long ticketId) {
		this.ticketBookingRepository.deleteById(ticketId);
	}
	
	public Ticket updateTicket(Ticket ticket, Long ticketId) {
		ticket.setTicketId(ticketId);
		return this.ticketBookingRepository.save(ticket);
	}
	
	public Ticket getTicketByEmail(String email) {
		return this.ticketBookingRepository.findByEmail(email);
	}
	
}
