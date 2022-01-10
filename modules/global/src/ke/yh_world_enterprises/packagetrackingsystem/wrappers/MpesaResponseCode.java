package ke.yh_world_enterprises.packagetrackingsystem.wrappers;

import java.io.Serializable;

public class MpesaResponseCode implements Serializable {
String responseCode;
String description;

    public MpesaResponseCode(String responseCode, String description) {
        this.responseCode = responseCode;
        this.description = description;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
