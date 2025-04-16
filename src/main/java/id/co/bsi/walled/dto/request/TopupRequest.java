package id.co.bsi.walled.dto.request;

import lombok.Data;

@Data
public class TopupRequest extends TransactionsRequest{
    private String recipientAccount;
}
