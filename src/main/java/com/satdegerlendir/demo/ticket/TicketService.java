package com.satdegerlendir.demo.ticket;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satdegerlendir.demo.ticket.dto.createTicked;
import com.satdegerlendir.demo.ticket.dto.updateTicketDto;
import com.satdegerlendir.demo.user.UserService;
import com.satdegerlendir.demo.user.user;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    UserService userService;
    
    public Ticket createTicket(createTicked newTicket) {
        user user= userService.GetByIdUsers(newTicket.getUserId());
        if(user==null)
            return null;
        Ticket toTicket=new Ticket();
        toTicket.setId(newTicket.getId());
        toTicket.setName(newTicket.getName());
        toTicket.setDescription(newTicket.getDescription());
        toTicket.setType(newTicket.getType());
        toTicket.setPrice(newTicket.getPrice());
        toTicket.setImage(newTicket.getImage());
        toTicket.setTicketDate(newTicket.getTicketDate());
        toTicket.setUser(user);
        return ticketRepository.save(toTicket);
    }


    public Ticket getByIdTicked(Long tickedId) {
        return ticketRepository.findById(tickedId).orElse(null);
    }


    public List<Ticket> getTickets(Optional<Long> userId) {
        if(userId.isPresent())
            return ticketRepository.findByUserId(userId.get());
        return ticketRepository.findAll();
    }


    public Ticket updateTickets(Long ticketId,updateTicketDto updateTicketDto) {
        Optional<Ticket> ticket = ticketRepository.findById(ticketId);
        if(ticket.isPresent()){
            Ticket toUpdate = ticket.get();
            toUpdate.setName(updateTicketDto.getName());
            toUpdate.setDescription(updateTicketDto.getDescription());
            toUpdate.setPrice(updateTicketDto.getPrice());
            toUpdate.setType(updateTicketDto.getType());
            toUpdate.setTicketDate(updateTicketDto.getTicketDate());
            ticketRepository.save(toUpdate);
            return toUpdate;
        }
        
     
        return null;
    }

    public void deleteTicket(Long ticketId) {
        ticketRepository.deleteById(ticketId);
    }
    
    
}
