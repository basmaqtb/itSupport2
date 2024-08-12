package com.ItSupport.Mappers;

import com.ItSupport.DTO.Authen.PersonneDTO;
import com.ItSupport.DTO.UserDTO;
import com.ItSupport.Models.heritage.Personne;
import com.ItSupport.Models.heritage.Utilisateur;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    Utilisateur toEntity(UserDTO userDTO);
    UserDTO toDto(User user);
    User patialUpdate(UserDTO userDTO,@MappingTarget User user);
    List<User> toEntity(List<UserDTO> list);
    List<UserDTO> toDto(List<User> list);
}
