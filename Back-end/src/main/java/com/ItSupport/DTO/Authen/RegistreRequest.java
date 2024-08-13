package com.ItSupport.DTO.Authen;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistreRequest {
    private String email;
    private String fullname;
    private String Password;
}
