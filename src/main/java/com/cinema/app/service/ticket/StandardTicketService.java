package com.cinema.app.service.ticket;

import com.cinema.app.model.ticket.StandardTicket;

import java.util.List;

public interface StandardTicketService {
    List<StandardTicket> getTicketsWithPopcorn();
}
