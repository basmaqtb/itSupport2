package com.ItSupport.Mappers;

import com.ItSupport.DTO.Authen.PersonneDTO;
import com.ItSupport.Models.heritage.Personne;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersoneMapper {

        Personne toEntity(PersonneDTO personneDTO);
        PersonneDTO toDto(Personne personne);
        Personne patialUpdate(PersonneDTO personneDTO,@MappingTarget Personne personne);
        List<Personne> toEntity(List<PersonneDTO> list);
        List<PersonneDTO> toDto(List<Personne> list);

}
