package com.cinema.app.web.ticket;

import com.cinema.app.model.ticket.StandardTicket;
import com.cinema.app.service.ticket.StandardTicketServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/standard-tickets")
@RequiredArgsConstructor
public class StandardTicketController {
    private final StandardTicketServiceImpl standardTicketService;

    @GetMapping("/popcorn")
    public List<StandardTicket> getTicketsWithPopcorn() {
        return standardTicketService.getTicketsWithPopcorn();
    }
}
