package ke.yh_world_enterprises.packagetrackingsystem.wrappers;

import java.io.Serializable;
import java.util.Date;

public class ResponseWrapper<T> implements Serializable {
    private int code;
    private String message;
    private T data;
    private Long timeStamp;

    public ResponseWrapper() {
        this.code = 200;
        this.message = "Request was successful";
        this.timeStamp = new Date().getTime();
    }

    public ResponseWrapper(int code, String message, T data, Long timeStamp) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timeStamp = timeStamp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "ResponseWrapper{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
