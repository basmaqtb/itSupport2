package com.ItSupport.Mappers;

import com.ItSupport.DTO.TicketDTO;
import com.ItSupport.Models.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    Ticket toEntity(TicketDTO ticketDto);
    TicketDTO toDto(Ticket ticket);
    Ticket partialUpdate(TicketDTO ticketDto, @MappingTarget Ticket ticket);
    List<Ticket> toEntity(List<TicketDTO> list);
    List<TicketDTO> toDto(List<Ticket> list);
}
