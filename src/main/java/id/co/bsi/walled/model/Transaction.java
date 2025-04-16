package id.co.bsi.walled.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "recipient_account")
    private String recipientAccount;
    private String senderAccount;

    @ManyToOne
    private TransactionType transactionType;

    @ManyToOne
    private PaymentMethod paymentMethod;
    private int amount;
    private String notes;
    private String createdAt;
}
