package com.itn.TutorialApp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "esewa_payment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EsewaPayment implements Serializable {

    @Serial
    private static final long serialVersionUid=1211L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long id;

    private Long amount;
    private Long taxAmount;
    private Long totalAmount;

    @Column(unique = true, name = "transaction_uuid")
    private String transactionUUID;

    private String productCode;
    private Long productServiceCharge;
    private Long productDeliveryCharge;
    private String successUrl;
    private String failureUrl;
    private String signedFieldNames;
    private String signature;
}