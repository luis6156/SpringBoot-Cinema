package com.cinema.app.service.ticket;

import com.cinema.app.model.ticket.VipTicket;
import com.cinema.app.repository.ticket.VipTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VipTicketServiceImpl implements VipTicketService {
    @Autowired
    private VipTicketRepository vipTicketRepository;

    @Override
    public List<VipTicket> getTicketsWithLoungeAccess() {
        return vipTicketRepository.findByHasLoungeAccess(true);
    }
}
