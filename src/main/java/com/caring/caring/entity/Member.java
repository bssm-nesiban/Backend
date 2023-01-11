package com.caring.caring.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {

    @Id
    private String email;

    @NonNull
    private String password;

    @NonNull
    private String nickname;

    private String elder;

    private String phoneNumber;

}
