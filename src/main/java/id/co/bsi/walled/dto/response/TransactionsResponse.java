package id.co.bsi.walled.dto.response;

import id.co.bsi.walled.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class TransactionsResponse extends Response {
    private List<Transaction> data;
}
