package com.ItSupport.Mappers;

import com.ItSupport.DTO.PanneDTO;
import com.ItSupport.Models.Panne;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PanneMapper {
    Panne toEntity(PanneDTO panneDTO);
    PanneDTO toDto(Panne panne);
    Panne partialUpdate(PanneDTO panneDTO, @MappingTarget Panne panne);
    List<Panne> toEntity(List<PanneDTO> list);
    List<PanneDTO> toDto(List<Panne> list);
}
