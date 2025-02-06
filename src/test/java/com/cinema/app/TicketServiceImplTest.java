package com.cinema.app;

import com.cinema.app.model.ticket.StandardTicket;
import com.cinema.app.model.ticket.Ticket;
import com.cinema.app.model.ticket.VipTicket;
import com.cinema.app.repository.ticket.StandardTicketRepository;
import com.cinema.app.repository.ticket.TicketRepository;
import com.cinema.app.repository.ticket.VipTicketRepository;
import com.cinema.app.service.ticket.TicketServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class TicketServiceImplTest {

    @Mock
    private TicketRepository ticketRepository;

    @Mock
    private StandardTicketRepository standardTicketRepository;

    @Mock
    private VipTicketRepository vipTicketRepository;

    @InjectMocks
    private TicketServiceImpl ticketService;

    private Ticket ticket;
    private StandardTicket standardTicket;
    private VipTicket vipTicket;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Create test data
        ticket = new Ticket();
        ticket.setId(1L);

        standardTicket = new StandardTicket();
        standardTicket.setId(2L);

        vipTicket = new VipTicket();
        vipTicket.setId(3L);
    }

    @Test
    public void testCreateTicket() {
        when(ticketRepository.save(ticket)).thenReturn(ticket);

        Ticket createdTicket = ticketService.createTicket(ticket);

        assertNotNull(createdTicket);
        assertEquals(ticket.getId(), createdTicket.getId());
    }

    @Test
    public void testGetTicketById() {
        when(ticketRepository.findById(1L)).thenReturn(Optional.of(ticket));

        Optional<Ticket> foundTicket = ticketService.getTicketById(1L);

        assertTrue(foundTicket.isPresent());
        assertEquals(ticket.getId(), foundTicket.get().getId());
    }

    @Test
    public void testGetAllTickets() {
        List<Ticket> tickets = Arrays.asList(ticket, standardTicket, vipTicket);
        when(ticketRepository.findAll()).thenReturn(tickets);

        List<Ticket> allTickets = ticketService.getAllTickets();

        assertNotNull(allTickets);
        assertEquals(3, allTickets.size());
    }

    @Test
    public void testCreateStandardTicket() {
        when(standardTicketRepository.save(standardTicket)).thenReturn(standardTicket);

        StandardTicket createdTicket = ticketService.createStandardTicket(standardTicket);

        assertNotNull(createdTicket);
        assertEquals(standardTicket.getId(), createdTicket.getId());
    }

    @Test
    public void testCreateVipTicket() {
        when(vipTicketRepository.save(vipTicket)).thenReturn(vipTicket);

        VipTicket createdTicket = ticketService.createVipTicket(vipTicket);

        assertNotNull(createdTicket);
        assertEquals(vipTicket.getId(), createdTicket.getId());
    }

    @Test
    public void testGetTicketsByUser() {
        when(ticketRepository.findByUser_Id(1L)).thenReturn(Arrays.asList(ticket, standardTicket));

        List<Ticket> userTickets = ticketService.getTicketsByUser(1L);

        assertNotNull(userTickets);
        assertEquals(2, userTickets.size());
    }

    @Test
    public void testGetTicketsByShowtime() {
        when(ticketRepository.findByShowtime_Id(1L)).thenReturn(Arrays.asList(ticket, vipTicket));

        List<Ticket> showtimeTickets = ticketService.getTicketsByShowtime(1L);

        assertNotNull(showtimeTickets);
        assertEquals(2, showtimeTickets.size());
    }
}
