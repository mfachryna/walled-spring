package id.co.bsi.walled.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Array;
@Data
@AllArgsConstructor
public class UserDetailResponse extends SuccessResponse {
    private String full_name;
    private String email;
    private String mobile_phone;
    private String image_url;

}
