package com.cinema.app.web.ticket;

import com.cinema.app.model.ticket.StandardTicket;
import com.cinema.app.model.ticket.Ticket;
import com.cinema.app.model.ticket.VipTicket;
import com.cinema.app.service.ticket.TicketServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketServiceImpl ticketService;

    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @GetMapping("/{ticketId}")
    public Optional<Ticket> getTicketById(@PathVariable Long ticketId) {
        return ticketService.getTicketById(ticketId);
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @PostMapping("/standard")
    public StandardTicket createStandardTicket(@RequestBody StandardTicket standardTicket) {
        return ticketService.createStandardTicket(standardTicket);
    }

    @PostMapping("/vip")
    public VipTicket createVipTicket(@RequestBody VipTicket vipTicket) {
        return ticketService.createVipTicket(vipTicket);
    }

    @GetMapping("/user/{userId}")
    public List<Ticket> getTicketsByUser(@PathVariable Long userId) {
        return ticketService.getTicketsByUser(userId);
    }

    @GetMapping("/showtime/{showtimeId}")
    public List<Ticket> getTicketsByShowtime(@PathVariable Long showtimeId) {
        return ticketService.getTicketsByShowtime(showtimeId);
    }
}
