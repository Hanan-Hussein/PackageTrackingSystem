package ke.yh_world_enterprises.packagetrackingsystem.wrappers;

import java.io.Serializable;

public class ProcessResponseWrapper implements Serializable{
    private String ResponseCode;
    private String MerchantRequestID;

    public ProcessResponseWrapper(String responseCode, String merchantRequestID) {
        ResponseCode = responseCode;
        MerchantRequestID = merchantRequestID;
    }

    public String getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(String responseCode) {
        ResponseCode = responseCode;
    }

    public String getMerchantRequestID() {
        return MerchantRequestID;
    }

    public void setMerchantRequestID(String merchantRequestID) {
        MerchantRequestID = merchantRequestID;
    }
}
