package id.co.bsi.walled.dto.request;

import lombok.Data;

@Data
public class TransactionsRequest {
    private int amount;
    private String notes;
    private int type;
    private String recipientAccount;
    private int method;
}
