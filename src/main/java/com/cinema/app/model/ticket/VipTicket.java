package com.cinema.app.model.ticket;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class VipTicket extends Ticket {
    private boolean hasLoungeAccess;
}
