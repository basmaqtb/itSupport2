package com.ItSupport.Dao;

import com.ItSupport.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findTicketsByTechnicien_Id(Long technicien_id);
    List<Ticket> findTicketsByStatut(com.ITSupport.Models.Enums.StatutTicket statut);


}
