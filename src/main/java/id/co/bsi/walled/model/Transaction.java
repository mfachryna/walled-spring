package id.co.bsi.walled.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Transaction {
    private int id;
    private String recipientAccount;
    private String senderAccount;
    private TransactionType transactionType;
    private PaymentMethod paymentMethod;
    private int amount;
    private String notes;
    private String createdAt;
}
