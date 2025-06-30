package com.pkielbasa.pocketplan.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
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

    @ManyToMany
    @JoinTable(
            name = "user_budget",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "budget_id")
    )
    private Set<Budget> budgets = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        if (id == null || user.id == null) {
            return false;
        }
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
