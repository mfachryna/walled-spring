package id.co.bsi.walled.dto.response;

import lombok.Data;

@Data
public class Response {
    private String message = "";
    private boolean status = true;

    public void setFailure() {
        this.status = false;
    }

    public void setSuccess() {
        this.status = true;
    }
}
