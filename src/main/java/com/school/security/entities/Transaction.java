package com.school.security.entities;

import com.school.security.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction",nullable = false)
    private Long idTransaction;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "date_of_transaction", nullable = false)
    private LocalDateTime dateOfTransaction;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type",nullable = false)
    private TransactionType transactionType;

    @Column(name="reference",nullable = false)
    private String references ;

    @Column(name = "status_transaction", nullable = false)
    private Boolean status;
}
