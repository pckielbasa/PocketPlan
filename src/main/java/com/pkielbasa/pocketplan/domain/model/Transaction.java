package com.pkielbasa.pocketplan.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "budget_id", nullable = false)
    @NotNull
    private Budget budget;

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @Column
    private String description;

    @Column(name = "type", nullable = false)
    @NotBlank
    private String type;

    @Column(name = "fee", nullable = false)
    @NotBlank
    private BigDecimal fee;

    @Column(name = "date" , nullable = false)
    @NotNull
    private LocalDateTime date;
}


