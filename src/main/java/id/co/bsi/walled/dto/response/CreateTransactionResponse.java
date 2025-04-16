package id.co.bsi.walled.dto.response;

import id.co.bsi.walled.dto.request.TransactionsRequest;
import id.co.bsi.walled.dto.request.TransferRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class CreateTransactionResponse extends Response {
    private TransactionsRequest data;
}
