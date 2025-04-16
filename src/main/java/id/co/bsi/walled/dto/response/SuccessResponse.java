package id.co.bsi.walled.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
abstract class SuccessResponse{
    private String message = "";
    private boolean status = true;
}
