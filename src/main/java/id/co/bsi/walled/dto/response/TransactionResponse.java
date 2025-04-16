package id.co.bsi.walled.dto.response;

import lombok.Data;

@Data
public class TransactionResponse {

    private String date;
    private String type;
    private String fromTo;
    private String notes;
    private int amount;

}
