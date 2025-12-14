package com.itn.TutorialApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enroll_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "enroll_date")
    private LocalDate enrollDate;

    @Column(name = "enroll_status")
    private String status;

    @Column(name = "enroll_ends")
    private LocalDate enrollEnds;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "payment_mode")
    private String paymentMode;

    @Column(name = "payment_amount")
    private String payAmount;

    @OneToOne
    @JoinColumn(name = "transaction_id")
    private EsewaPayment esewaPayment;

}