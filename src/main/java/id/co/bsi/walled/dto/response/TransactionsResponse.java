package id.co.bsi.walled.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class TransactionsResponse extends SuccessResponse{

    private List<TransactionResponse> data;
}
