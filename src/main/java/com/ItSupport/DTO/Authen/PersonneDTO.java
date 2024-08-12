package com.ItSupport.DTO.Authen;

import com.ItSupport.Models.Enums.Role;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonneDTO {
    private  String  username;
    private String password;
    private Role role;
}
