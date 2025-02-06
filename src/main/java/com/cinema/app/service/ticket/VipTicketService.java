package com.cinema.app.service.ticket;

import com.cinema.app.model.ticket.VipTicket;

import java.util.List;

public interface VipTicketService {
    List<VipTicket> getTicketsWithLoungeAccess();
}
