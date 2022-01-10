package ke.yh_world_enterprises.packagetrackingsystem.wrappers;

import java.io.Serializable;

public class MpesaIntegrationWrapper implements Serializable {
    private String access_token;

    public MpesaIntegrationWrapper(String access_token) {
        this.access_token = access_token;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
