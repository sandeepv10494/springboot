package com.sandeep.TicketBookingSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandeep.TicketBookingSystem.Model.Ticket;

@Repository
public interface TicketBookingRepository extends JpaRepository<Ticket, Long>{
	Ticket findByEmail(String email);
}
