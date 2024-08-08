package com.ItSupport.Services;

import com.ItSupport.Dao.TicketRepository;
import com.ItSupport.Models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    public Ticket updateTicket(Long id, Ticket updatedTicket) {
        return ticketRepository.findById(id)
                .map(ticket -> {
                    ticket.setDescription(updatedTicket.getDescription());
                    ticket.setDateCreation(updatedTicket.getDateCreation());
                    ticket.setStatut(updatedTicket.getStatut());
                    // Mettez à jour les autres champs nécessaires
                    return ticketRepository.save(ticket);
                })
                .orElseThrow(() -> new RuntimeException("Ticket non trouvé avec ID : " + id));
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}