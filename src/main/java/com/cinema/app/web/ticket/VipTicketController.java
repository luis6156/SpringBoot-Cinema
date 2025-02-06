package com.cinema.app.web.ticket;

import com.cinema.app.model.ticket.VipTicket;
import com.cinema.app.service.ticket.VipTicketServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vip-tickets")
@RequiredArgsConstructor
public class VipTicketController {
    private final VipTicketServiceImpl vipTicketService;

    @GetMapping("/lounge-access")
    public List<VipTicket> getTicketsWithLoungeAccess() {
        return vipTicketService.getTicketsWithLoungeAccess();
    }
}
