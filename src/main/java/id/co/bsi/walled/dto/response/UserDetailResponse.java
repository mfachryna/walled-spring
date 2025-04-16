package id.co.bsi.walled.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.lang.reflect.Array;
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserDetailResponse extends Response {
    private String full_name;
    private String email;
    private String mobile_phone;
    private String image_url;
}
