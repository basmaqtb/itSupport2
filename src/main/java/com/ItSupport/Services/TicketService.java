package com.ItSupport.Services;

import com.ITSupport.Models.Enums.StatutTicket;
import com.ItSupport.DTO.TicketDTO;
import com.ItSupport.Dao.TechnicienRepository;
import com.ItSupport.Dao.TicketRepository;
import com.ItSupport.Mappers.TicketMapper;
import com.ItSupport.Models.Ticket;
import com.ItSupport.Models.heritage.Technicien;
import com.ItSupport.exception.TechnicianNotFoundException;
import com.ItSupport.exception.TicketNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketMapper ticketMapper;
    @Autowired
    private TechnicienRepository technicienRepository;

    public Ticket createTicket(TicketDTO ticketDto) {
        var ticket = ticketMapper.toEntity(ticketDto);
        ticket.setStatut(StatutTicket.EnCours);  // or some other default status
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        var tickets = ticketRepository.findAll();
        if (tickets.isEmpty()) {
            throw new TicketNotFoundException();
        }
        return tickets;
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElseThrow(TicketNotFoundException::new);
    }

    public List<Ticket> getTicketsByStatut(String statut) {
        var statutEnum = StatutTicket.valueOf(statut);
        var tickets = ticketRepository.findTicketsByStatut(statutEnum);
        return tickets;
    }


    public Ticket updateTicket(Long id, TicketDTO ticketDto) {
        var existingTicket = ticketRepository.findById(id).orElseThrow(TicketNotFoundException::new);
        var updatedTicket = ticketMapper.partialUpdate(ticketDto, existingTicket);
        return ticketRepository.save(updatedTicket);
    }

    public void deleteTicket(Long id) {
        var ticket = ticketRepository.findById(id).orElseThrow(TicketNotFoundException::new);
        ticketRepository.delete(ticket);
    }

    public Ticket assignTicketToTechnician(Long ticketId, Long technicianId) {
        var ticket = ticketRepository.findById(ticketId).orElseThrow(TicketNotFoundException::new);
        var technician = technicienRepository.findById(technicianId).orElseThrow(TechnicianNotFoundException::new);
        ticket.setTechnicien(technician);
        ticket.setStatut(StatutTicket.EnCours);
        technicienRepository.save(technician);
        return ticketRepository.save(ticket);
    }


}
