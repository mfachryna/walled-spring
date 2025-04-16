package id.co.bsi.walled.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserAccountsResponse extends SuccessResponse{
    private int id;
    private String account_number;
    private String balance;
}
