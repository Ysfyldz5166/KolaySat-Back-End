package com.satdegerlendir.demo.ticket;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long>{

    List<Ticket> findByUserId(Long userId);

}
