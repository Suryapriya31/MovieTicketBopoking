
package com.example.movieticketbooking.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movieticketbooking.model.MovieTicket;
import com.example.movieticketbooking.service.MovieTicketService;
@CrossOrigin
@RestController
@RequestMapping("/api/tickets")
public class MovieTicketController {


    private final MovieTicketService service;

    public MovieTicketController(MovieTicketService service) {
        this.service = service;
    }

    @PostMapping
    public MovieTicket bookTicket(@RequestBody MovieTicket ticket) {
        return service.bookTicket(ticket);
    }

    @GetMapping
    public List<MovieTicket> getAllTickets() {
        return service.getAllTickets();
    }

    @GetMapping("/{id}")
    public MovieTicket getTicketById(@PathVariable Long id) {
        return service.getTicketById(id)
                .orElseThrow(() ->
                    new RuntimeException("Ticket not found"));
    }

    @DeleteMapping("/{id}")
    public String deleteTicket(@PathVariable Long id) {
        return service.deleteTicket(id)
                ? "Ticket deleted successfully"
                : "Ticket not found";
    }
    
}
