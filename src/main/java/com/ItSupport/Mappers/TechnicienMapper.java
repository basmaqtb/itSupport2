package com.ItSupport.Mappers;

import com.ItSupport.DTO.Authen.TechnicienDTO;
import com.ItSupport.Models.heritage.Technicien;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TechnicienMapper {

    Technicien toEntity(TechnicienDTO technicienDTO);
    TechnicienDTO toDto(Technicien technicien);
    Technicien partialUpdate(TechnicienDTO technicienDTO, @MappingTarget Technicien technicien);

}
