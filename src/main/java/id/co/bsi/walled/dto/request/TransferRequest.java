package id.co.bsi.walled.dto.request;

import lombok.Data;

@Data
public class TransferRequest extends TransactionsRequest{
    private String recipientAccount;
}
