package id.co.bsi.walled.dto.response;

import id.co.bsi.walled.model.Transaction;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
public class TransactionResponse {
    private String date;
    private String type;
    private String fromTo;
    private String notes;
    private int amount;
}
