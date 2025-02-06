package com.cinema.app.model.user;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("CUSTOMER")
@Getter
@Setter
public class Customer extends User {
    private Integer loyaltyPoints;
}
