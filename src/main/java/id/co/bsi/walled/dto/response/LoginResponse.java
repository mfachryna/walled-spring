package id.co.bsi.walled.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class LoginResponse extends SuccessResponse {
    private String accessToken = "";
}
