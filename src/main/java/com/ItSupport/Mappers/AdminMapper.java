package com.ItSupport.Mappers;

import com.ItSupport.DTO.Authen.AdminDTO;
import com.ItSupport.Models.heritage.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    Admin toEntity(AdminDTO adminDTO);
    AdminDTO toDto(Admin admin);
    Admin partialUpdate(AdminDTO adminDTO, @MappingTarget Admin admin);
    List<Admin> toEntity(List<AdminDTO> list);
    List<AdminDTO> toDto(List<Admin> list);
}
