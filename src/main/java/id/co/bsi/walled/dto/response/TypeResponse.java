package id.co.bsi.walled.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TypeResponse extends Response {
    private int id;
    private String type;
}
