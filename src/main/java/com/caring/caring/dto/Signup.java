package com.caring.caring.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Signup {

    @NotNull
    private String email;

    @NotNull
    private String nickname;

    @NotNull
    private String password;

}
