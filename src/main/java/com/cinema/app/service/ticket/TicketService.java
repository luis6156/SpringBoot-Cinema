package com.cinema.app.service.ticket;

import com.cinema.app.model.ticket.StandardTicket;
import com.cinema.app.model.ticket.Ticket;
import com.cinema.app.model.ticket.VipTicket;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    Ticket createTicket(Ticket ticket);

    Optional<Ticket> getTicketById(Long ticketId);

    List<Ticket> getAllTickets();

    StandardTicket createStandardTicket(StandardTicket standardTicket);

    VipTicket createVipTicket(VipTicket vipTicket);

    List<Ticket> getTicketsByUser(Long userId);

    List<Ticket> getTicketsByShowtime(Long showtimeId);
}
