package com.cydeo.entity;

import com.cydeo.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name="payments")
public class Payment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(columnDefinition = "DATE")
    private LocalDate createdDate;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private Status paymentsStatus;

    @ManyToOne
    private Merchant merchant;

   // @OneToOne(cascade = CascadeType.ALL)// Causes all related data with that object to be deleted if you delete
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="payment_detail_id")
    private PaymentDetail paymentDetail;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Customer customer;

    public Payment(LocalDate createdDate, BigDecimal amount, Status paymentsStatus) {
        this.createdDate = createdDate;
        this.amount = amount;
        this.paymentsStatus = paymentsStatus;
    }
}
