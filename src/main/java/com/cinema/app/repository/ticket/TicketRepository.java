package com.cinema.app.repository.ticket;

import com.cinema.app.model.ticket.Ticket;
import com.cinema.app.model.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByUser_Id(Long userId);

    List<Ticket> findByShowtime_Id(Long showtimeId);

    long countByShowtime_Movie(Movie showtimeMovie);

    @Query("SELECT SUM(t.price) FROM Ticket t WHERE t.showtime.movie = :movie")
    Float getTotalRevenueForMovie(@Param("movie") Movie movie);
}
