package com.cinema.app.repository.ticket;

import com.cinema.app.model.ticket.VipTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VipTicketRepository extends JpaRepository<VipTicket, Long> {
    List<VipTicket> findByHasLoungeAccess(boolean hasLoungeAccess);
}
