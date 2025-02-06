package com.cinema.app.service.ticket;

import com.cinema.app.model.ticket.StandardTicket;
import com.cinema.app.repository.ticket.StandardTicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StandardTicketServiceImpl implements StandardTicketService {
    private final StandardTicketRepository standardTicketRepository;

    @Override
    public List<StandardTicket> getTicketsWithPopcorn() {
        return standardTicketRepository.findByHasPopcornIncluded(true);
    }
}
