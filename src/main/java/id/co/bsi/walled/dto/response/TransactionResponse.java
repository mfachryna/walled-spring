package id.co.bsi.walled.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TransactionResponse extends Response {
    private String date;
    private String type;
    private String fromTo;
    private String notes;
    private int amount;

}
