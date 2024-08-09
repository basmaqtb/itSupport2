package com.ItSupport.Controllers;

import com.ItSupport.DTO.TicketDTO;
import com.ItSupport.Mappers.TicketMapper;
import com.ItSupport.Models.Ticket;
import com.ItSupport.Services.TicketService;
import com.ItSupport.exception.TicketNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketMapper ticketMapper;

    @GetMapping("/show")
    public ResponseEntity<List<TicketDTO>> getAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(ticketMapper.toDto(tickets));
    }

    @PostMapping("/add")
    public ResponseEntity<TicketDTO> createTicket(@RequestBody TicketDTO ticketDTO) {
        var createdTicket = ticketService.createTicket(ticketDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketMapper.toDto(createdTicket));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TicketDTO> getTicketById(@PathVariable Long id) {
        var ticket = ticketService.getTicketById(id);
        return ResponseEntity.ok(ticketMapper.toDto(ticket));
    }

    @GetMapping("/status/{statut}")
    public ResponseEntity<List<TicketDTO>> getTicketByStatut(@PathVariable String statut) {
        List<Ticket> tickets = ticketService.getTicketsByStatut(statut);
        return ResponseEntity.ok(ticketMapper.toDto(tickets));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTicket(@PathVariable Long id, @RequestBody TicketDTO updatedTicketDto) {
        try {
            var existingTicket = ticketService.getTicketById(id);
            var updatedTicket = ticketMapper.partialUpdate(updatedTicketDto, existingTicket);
            ticketService.updateTicket(id, updatedTicketDto);
            return ResponseEntity.ok(ticketMapper.toDto(updatedTicket));
        } catch (TicketNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }
}
