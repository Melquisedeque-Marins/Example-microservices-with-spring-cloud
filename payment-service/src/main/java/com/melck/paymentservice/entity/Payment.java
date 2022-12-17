package com.melck.paymentservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_payment")
public class Payment {

    @Id
    @GeneratedValue
    private Long paymentId;
    private String paymentStatus;
    private String transactionId;
    
}
