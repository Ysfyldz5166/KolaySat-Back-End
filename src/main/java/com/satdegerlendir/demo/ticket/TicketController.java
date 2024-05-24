package com.satdegerlendir.demo.ticket;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.satdegerlendir.demo.ticket.dto.createTicked;
import com.satdegerlendir.demo.ticket.dto.updateTicketDto;


@RestController
@RequestMapping("api/v1/tickets")
public class TicketController {

    @Autowired
    TicketService ticketService;


    @GetMapping
    public List<Ticket> getTickets(@RequestParam Optional<Long> userId){
        return ticketService.getTickets(userId);
    }
    
    @GetMapping("/{ticketId}")
    public Ticket getFindByTicket(@PathVariable Long ticketId){
        return ticketService.GetByIdTicket(ticketId); 
    }

    @GetMapping("/user/{userId}")
    public List<Ticket> getByIdUserTicket(@PathVariable Long userId) {
        return ticketService.getByIdUserTicket(userId);
    }

    @PostMapping
    public Ticket createTicket(@RequestBody createTicked newTicket){
        return ticketService.createTicket(newTicket);
    }


    @PutMapping("/{ticketId}")
    public Ticket updateTickets(@PathVariable Long ticketId, @RequestBody updateTicketDto updateTicketDto){
        return ticketService.updateTickets(ticketId,updateTicketDto);
    }

    @DeleteMapping("/{ticketId}")
    public void deleteTicket(@PathVariable Long ticketId){
        ticketService.deleteTicket(ticketId);
    }
    
}
