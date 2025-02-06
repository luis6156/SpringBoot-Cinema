package com.cinema.app.service.ticket;

import com.cinema.app.model.ticket.StandardTicket;
import com.cinema.app.model.ticket.Ticket;
import com.cinema.app.model.ticket.VipTicket;
import com.cinema.app.repository.ticket.StandardTicketRepository;
import com.cinema.app.repository.ticket.TicketRepository;
import com.cinema.app.repository.ticket.VipTicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final StandardTicketRepository standardTicketRepository;
    private final VipTicketRepository vipTicketRepository;

    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Optional<Ticket> getTicketById(Long ticketId) {
        return ticketRepository.findById(ticketId);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public StandardTicket createStandardTicket(StandardTicket standardTicket) {
        return standardTicketRepository.save(standardTicket);
    }

    @Override
    public VipTicket createVipTicket(VipTicket vipTicket) {
        return vipTicketRepository.save(vipTicket);
    }

    @Override
    public List<Ticket> getTicketsByUser(Long userId) {
        return ticketRepository.findByUser_Id(userId);
    }

    @Override
    public List<Ticket> getTicketsByShowtime(Long showtimeId) {
        return ticketRepository.findByShowtime_Id(showtimeId);
    }
}
