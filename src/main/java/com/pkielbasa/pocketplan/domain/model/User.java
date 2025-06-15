package com.pkielbasa.pocketplan.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.Data;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String username;

    @Column(nullable = false)
    @NotBlank
    private String password;

    @Column(name = "email_address", nullable = false, unique = true)
    @NotBlank
    @Email
    private String email;

    @Column(name = "first_name", nullable = false)
    @NotBlank
    private String firstName;

    @Column(name = "surname", nullable = false)
    @NotBlank
    private String surname;

}
