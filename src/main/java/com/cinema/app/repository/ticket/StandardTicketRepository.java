package com.cinema.app.repository.ticket;

import com.cinema.app.model.ticket.StandardTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StandardTicketRepository extends JpaRepository<StandardTicket, Long> {
    List<StandardTicket> findByHasPopcornIncluded(boolean hasPopcornIncluded);
}
