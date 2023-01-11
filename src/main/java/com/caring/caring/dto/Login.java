package com.caring.caring.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Login {

    @NotNull
    private String email;

    @NotNull
    private String password;

}
