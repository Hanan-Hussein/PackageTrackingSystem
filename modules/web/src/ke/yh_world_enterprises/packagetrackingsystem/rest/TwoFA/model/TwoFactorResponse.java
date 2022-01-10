package ke.yh_world_enterprises.packagetrackingsystem.rest.TwoFA.model;

import java.io.Serializable;

public class TwoFactorResponse implements Serializable {
    private String correlationId;

    public TwoFactorResponse() {
    }

    public TwoFactorResponse(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }
}
