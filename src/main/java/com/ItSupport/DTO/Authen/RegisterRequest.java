package com.ItSupport.DTO.Authen;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private  String  name;
    private String  email;
    private String password;
}
