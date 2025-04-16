package id.co.bsi.walled.dto.response;

import id.co.bsi.walled.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.lang.reflect.Array;
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserDetailResponse extends Response {
    private User data;
}
