
package com.example.movieticketbooking.service;

import com.example.movieticketbooking.model.MovieTicket;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieTicketService {

    private final List<MovieTicket> tickets = new ArrayList<>();
    private Long nextId = 1L;

    public MovieTicket bookTicket(MovieTicket ticket) {
        ticket.setTicketId(nextId++);
        tickets.add(ticket);
        return ticket;
    }

    public List<MovieTicket> getAllTickets() {
        return tickets;
    }

    public Optional<MovieTicket> getTicketById(Long id) {
        return tickets.stream()
                .filter(ticket -> ticket.getTicketId().equals(id))
                .findFirst();
    }

    public boolean deleteTicket(Long id) {
        return tickets.removeIf(
                ticket -> ticket.getTicketId().equals(id)
        );
    }
}
